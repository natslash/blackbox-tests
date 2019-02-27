package axoom.records.v1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.axoom.drs.utils.RestUtils;
import axoom.records.v1.Records.Record;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.MetadataUtils;

public class QrecordsClient {
  private static final Logger logger = Logger.getLogger(QrecordsClient.class.getName());

  private final ManagedChannel channel;
  private final QRecordsGrpc.QRecordsBlockingStub blockingStub;
  

  /** Construct client connecting to Qrecords server at {@code host:port}. */
  public QrecordsClient(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port).build());

  }

  /** Construct client for accessing Qrecords server using the existing channel. */
  QrecordsClient(ManagedChannel channel) {
    this.channel = channel;
    
    Map<String, String> requestParams = new HashMap<String, String>();
    requestParams.put("baseUrl", "https://account.dev.myaxoom.com/connect/token");
    requestParams.put("scope", "https://apis.axoom.com/scopes/qrecords.read");
    requestParams.put("clientId", "records-query-api-test-client");
    requestParams.put("clientSecret", System.getenv("QREC_SECRET"));
    requestParams.put("contentType", "application/x-www-form-urlencoded");
    
    String accessToken = RestUtils.getAccessTokenFromClientCredsFlow(requestParams);
    logger.log(Level.INFO, "Access Token: " + accessToken);
    Metadata authHeaders = new Metadata();
    authHeaders.put(Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER), accessToken);
    
    blockingStub = MetadataUtils.attachHeaders(QRecordsGrpc.newBlockingStub(channel), authHeaders);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }


  public Iterator<Record> getRecordStream(String dataCompositionId) {     
    Qrecords.RecordStreamRequest request = Qrecords.RecordStreamRequest.newBuilder().setGroupId("1")
        .setDataCompositionId(dataCompositionId).setTimeout(5).build();
    
    try {
      return blockingStub.getStream(request);         
    } catch (StatusRuntimeException e) {
      logger.log(Level.SEVERE, "RPC failed: {0}", e.getStatus());
      return null;
    }
  }  
  
}
