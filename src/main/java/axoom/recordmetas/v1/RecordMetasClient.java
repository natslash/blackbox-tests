package axoom.recordmetas.v1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.axoom.constants.ContentType;
import com.axoom.drs.utils.RestUtils;
import axoom.recordmetas.v1.Recordmetas.RecordMeta;
import axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest;
import axoom.recordmetas.v1.RecordmetasService.RecordMetaStreamRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.MetadataUtils;

public class RecordMetasClient {
  private static final Logger logger = Logger.getLogger(RecordMetasClient.class.getName());

  private final ManagedChannel channel;
  private final RecordMetasGrpc.RecordMetasBlockingStub blockingStub;


  /* Construct client connecting to RecordMetas server at {@code name:port}. */
  public RecordMetasClient(String name, int port) {
    this(ManagedChannelBuilder.forAddress(name, port).build());
  }
  
  public RecordMetasClient(ManagedChannel channel) {
    this.channel = channel;
    Map<String, String> requestParams = new HashMap<String, String>();
    requestParams.put("baseUrl", "https://account.dev.myaxoom.com/connect/token");
    requestParams.put("scope", "https://apis.axoom.com/scopes/qrecords.read");
    requestParams.put("clientId", "records-query-api-test-client");
    requestParams.put("clientSecret", System.getenv("QREC_SECRET"));
    requestParams.put("contentType", ContentType.FORM_URL_ENCODED);

    String accessToken = RestUtils.getAccessTokenFromClientCredsFlow(requestParams);
    logger.log(Level.INFO, "Access Token: " + accessToken);
    Metadata authHeaders = new Metadata();
    authHeaders.put(Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER), accessToken);

    blockingStub = MetadataUtils.attachHeaders(RecordMetasGrpc.newBlockingStub(channel), authHeaders);
  }
  
  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  } 
  
  public Iterator<RecordMeta> getRecordMetaStream(String subscriptionId) {
    RecordMetaStreamRequest request = RecordMetaStreamRequest.newBuilder().setSubscriptionId(subscriptionId).build();

    try {      
      return blockingStub.getStream(request);
      
    } catch (StatusRuntimeException e) {
      logger.log(Level.SEVERE, "RPC failed: {0}", e.getStatus());
      return null;
    }
  }
  
  public RecordMeta getLatestRecordMeta(String subjectId) {
    RecordMetaRequest request = RecordMetaRequest.newBuilder().setSubjectId(subjectId).build();

    try {      
      return blockingStub.getLatest(request);
      
    } catch (StatusRuntimeException e) {
      logger.log(Level.SEVERE, "RPC failed: {0}", e.getStatus());
      return null;
    }
  }
 
}
