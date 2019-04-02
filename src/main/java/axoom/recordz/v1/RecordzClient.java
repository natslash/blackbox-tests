package axoom.recordz.v1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.MetadataUtils;
import com.axoom.constants.ContentType;
import com.axoom.drs.utils.RestUtils;
import axoom.recordz.v1.Recordz.Record;
import axoom.recordz.v1.RecordzService.RecordStreamRequest;

public class RecordzClient {

  private static final Logger logger = Logger.getLogger(RecordzClient.class.getName());

  private final ManagedChannel channel;
  private final RecordzGrpc.RecordzBlockingStub blockingStub;


  /* Construct client connecting to Qrecords server at {@code host:port}. */
  public RecordzClient(String host, int port) {
    //Instantiate client and connect to server
    this(ManagedChannelBuilder.forAddress(host, port).build());

  }

  /* Construct client for accessing Qrecords server using the existing channel. */
  RecordzClient(ManagedChannel channel) {
    this.channel = channel;

    Map<String, String> requestParams = new HashMap<String, String>();
    requestParams.put("baseUrl", "https://account.dev.myaxoom.com/connect/token");
    requestParams.put("scope", "https://apis.axoom.com/scopes/qrecords.read");
    requestParams.put("clientId", "records-query-api-test-client");
    requestParams.put("clientSecret", System.getenv("QREC_SECRET"));
    requestParams.put("contentType", ContentType.FORM_URL_ENCODED);

    //Get Access token from client creds flow from CIS
    String accessToken = RestUtils.getAccessTokenFromClientCredsFlow(requestParams);
    logger.log(Level.INFO, "Access Token: " + accessToken);

    //Put access token in auth headers for gRPC 
    Metadata authHeaders = new Metadata();
    authHeaders.put(Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER), accessToken);

    //Attach headers
    blockingStub = MetadataUtils.attachHeaders(RecordzGrpc.newBlockingStub(channel), authHeaders);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }


  public Iterator<Record> getRecordStream(String subscriptionId) {
    RecordStreamRequest request = RecordStreamRequest.newBuilder()
        .setSubscriptionId(subscriptionId).build();

    try {
      return blockingStub.getStream(request);
      
    } catch (StatusRuntimeException e) {
      logger.log(Level.SEVERE, "RPC failed: {0}", e.getStatus());
      return null;
    }
  }
}
