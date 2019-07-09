package axoom.sharing.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.axoom.constants.ContentType;
import com.axoom.drs.utils.RestUtils;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import axoom.filters.v1.Filter.StringPropertyFilter;
import axoom.filters.v1.Filter.StringPropertyFilter.Operation;
import axoom.sharing.v1.Sharing.TenantShare;
import axoom.sharing.v1.SharingGrpc.SharingBlockingStub;
import axoom.sharing.v1.SharingService.CreateTenantShareRequest;
import axoom.sharing.v1.SharingService.DeleteTenantShareRequest;
import axoom.sharing.v1.SharingService.ListTenantSharesRequest;
import axoom.sharing.v1.SharingService.ListTenantSharesResponse;
import axoom.sharing.v1.SharingService.TenantShareFilter;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.stub.MetadataUtils;

public class TenantShareService implements ShareInterface{
  private static final Logger logger = Logger.getLogger(TenantShareService.class.getName());

  private final ManagedChannel channel;
  private final SharingBlockingStub blockingStub;  
  
  /* Construct client connecting to tenant shares service at {@code name:port}. */
  public TenantShareService(String name, int port) {
    this(ManagedChannelBuilder.forAddress(name, port).build());
  }

  public TenantShareService(ManagedChannel channel) {
    this.channel = channel;
    Map<String, String> requestParams = new HashMap<String, String>();
    requestParams.put("baseUrl", "https://account.dev.myaxoom.com/connect/token");
    requestParams.put("scope", "https://apis.axoom.com/auth/shares");
    requestParams.put("clientId", System.getenv("API_TEST_CLIENT"));
    requestParams.put("clientSecret", System.getenv("API_TEST_SECRET"));
    requestParams.put("contentType", ContentType.FORM_URL_ENCODED);

    String accessToken = RestUtils.getAccessTokenFromClientCredsFlow(requestParams);
    logger.log(Level.INFO, "Access Token: " + accessToken);
    Metadata authHeaders = new Metadata();
    authHeaders.put(Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER), ": Bearer " + accessToken);

    blockingStub = MetadataUtils.attachHeaders(SharingGrpc.newBlockingStub(channel), authHeaders);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /**
   * 
   * @param tenantShare
   * @return
   */
  public GeneratedMessageV3 createShare(GeneratedMessageV3 tenantShare) {   
    CreateTenantShareRequest request = CreateTenantShareRequest.newBuilder().setTenantShare((TenantShare) tenantShare).build();     
    return blockingStub.createTenantShare(request);    
  }    
  
  
  /**
   * 
   * @param subjectId
   * @param tenantId
   * @return
   */
  public ListTenantSharesResponse listTenantShares(String subjectId, String tenantId) {    
    StringPropertyFilter subjectIdFilter = StringPropertyFilter.newBuilder().setValue("subjectIdFilter").setOperation(Operation.EQUALS).build();
    StringPropertyFilter tenantIdFilter = StringPropertyFilter.newBuilder().setValue(tenantId).setOperation(Operation.EQUALS).build();
    TenantShareFilter clientShareFilter = TenantShareFilter.newBuilder().setSubjectId(subjectIdFilter).setTenantId(tenantIdFilter).build();
    ListTenantSharesRequest request = ListTenantSharesRequest.newBuilder().setFilter(clientShareFilter).build();   
    return blockingStub.listTenantShares(request);    
  }
  
  public Empty deleteShare(GeneratedMessageV3 tenantShare) {   
    DeleteTenantShareRequest request = DeleteTenantShareRequest.newBuilder().setTenantShare((TenantShare) tenantShare).build();     
    return blockingStub.deleteTenantShare(request);    
  }  
}
