package axoom.recordmetas.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.axoom.constants.ContentType;
import com.axoom.drs.utils.RestUtils;
import axoom.recordmetas.v1.RecordMetasGrpc.RecordMetasBlockingStub;
import axoom.recordmetas.v1.Recordmetas.RecordMeta;
import axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest;
import axoom.recordmetas.v1.RecordmetasService.GetLatestRecordMetaRequest;
import axoom.recordmetas.v1.RecordmetasService.GetRecordMetaRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.MetadataUtils;

public class RecordMetasClient {
  private static final Logger logger = Logger.getLogger(RecordMetasClient.class.getName());

  private final ManagedChannel channel;
  private final RecordMetasBlockingStub blockingStub;


  /* Construct client connecting to RecordMetas server at {@code name:port}. */
  public RecordMetasClient(String name, int port) {
    this(ManagedChannelBuilder.forAddress(name, port).build());
  }

  public RecordMetasClient(ManagedChannel channel) {
    this.channel = channel;
    Map<String, String> requestParams = new HashMap<String, String>();
    requestParams.put("baseUrl", "https://account.dev.myaxoom.com/connect/token");
    requestParams.put("scope", "https://apis.axoom.com/auth/recordmetas");
    requestParams.put("clientId", System.getenv("API_TEST_CLIENT"));
    requestParams.put("clientSecret", System.getenv("API_TEST_SECRET"));
    requestParams.put("contentType", ContentType.FORM_URL_ENCODED);

    String accessToken = RestUtils.getAccessTokenFromClientCredsFlow(requestParams);
    logger.log(Level.INFO, "Access Token: " + accessToken);
    Metadata authHeaders = new Metadata();
    authHeaders.put(Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER),
        ": Bearer " + accessToken);

    blockingStub =
        MetadataUtils.attachHeaders(RecordMetasGrpc.newBlockingStub(channel), authHeaders);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }


  public RecordMeta getLatestRecordMeta(String subjectId) {
    GetLatestRecordMetaRequest request =
        GetLatestRecordMetaRequest.newBuilder().setSubjectId(subjectId).build();

    try {          
      return blockingStub.getLatestRecordMeta(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.SEVERE, "RPC failed: {0}", e.getStatus());
      throw e;
    }
  }
  
  public RecordMeta getRecordMeta(String subjectId) {
    GetRecordMetaRequest request =
        GetRecordMetaRequest.newBuilder().setId(subjectId).build();

    try {          
      return blockingStub.getRecordMeta(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.SEVERE, "RPC failed: {0}", e.getStatus());
      throw e;
    }
  }

  public RecordMeta createRecordMeta(RecordMeta recordMeta) {
    CreateRecordMetaRequest request =
        CreateRecordMetaRequest.newBuilder().setRecordMeta(recordMeta).build();        
    try {
      return blockingStub.createRecordMeta(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.SEVERE, "RPC failed: {0}", e.getStatus());
      throw e;
    }
  }
}
