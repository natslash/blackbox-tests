package axoom.sharing.v1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import axoom.filters.v1.Filter.StringPropertyFilter;
import axoom.filters.v1.Filter.StringPropertyFilter.Operation;
import axoom.sharing.v1.Sharing.ClientShare;
import axoom.sharing.v1.SharingGrpc.SharingBlockingStub;
import axoom.sharing.v1.SharingService.ClientShareFilter;
import axoom.sharing.v1.SharingService.CreateClientShareRequest;
import axoom.sharing.v1.SharingService.DeleteClientShareRequest;
import axoom.sharing.v1.SharingService.ListClientSharesRequest;
import axoom.sharing.v1.SharingService.ListClientSharesResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.stub.MetadataUtils;

public class ClientShareService implements ShareInterface {
  private static final Logger logger = Logger.getLogger(ClientShareService.class.getName());

  private final ManagedChannel channel;
  private final SharingBlockingStub blockingStub;
  private String accessTokenFromCodeFlow = null;

  // Get file from resources folder
  private File resourcesDirectory = new File("src/test/resources/");
  private String subjectsPropertiesFilePath;
  private Properties prop;
  private InputStream input;

  /* Construct client connecting to Client Shares service at {@code name:port}. */
  public ClientShareService(String name, int port) {
    this(ManagedChannelBuilder.forAddress(name, port).build());
  }

  public ClientShareService(ManagedChannel channel) {
    this.channel = channel;
    subjectsPropertiesFilePath = resourcesDirectory.getAbsolutePath() + "/" + "subjects.properties";
    prop = new Properties();

    try {
      input = new FileInputStream(subjectsPropertiesFilePath);
      prop.load(input);
      accessTokenFromCodeFlow = prop.getProperty("accessToken");
    } catch (Exception e) {
      e.printStackTrace();
    }

    logger.log(Level.INFO, "Access Token from code flow: " + accessTokenFromCodeFlow);
    Metadata authHeaders = new Metadata();
    authHeaders.put(Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER),
        ": Bearer " + accessTokenFromCodeFlow);

    blockingStub = MetadataUtils.attachHeaders(SharingGrpc.newBlockingStub(channel), authHeaders);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /**
   * 
   * @param clientShare
   * @return
   */
  public GeneratedMessageV3 createShare(GeneratedMessageV3 clientShare) {
    CreateClientShareRequest request =
        CreateClientShareRequest.newBuilder().setClientShare((ClientShare) clientShare).build();
    return blockingStub.createClientShare(request);
  }

  /**
   * 
   * @param clientId
   * @param subjectId
   * @param tenantId
   * @return
   */
  public ListClientSharesResponse listClientShares(String clientId, String subjectId,
      String tenantId) {
    StringPropertyFilter clientIdFilter = StringPropertyFilter.newBuilder().setValue("clientId")
        .setOperation(Operation.EQUALS).build();
    StringPropertyFilter subjectIdFilter = StringPropertyFilter.newBuilder()
        .setValue("subjectIdFilter").setOperation(Operation.EQUALS).build();
    StringPropertyFilter tenantIdFilter =
        StringPropertyFilter.newBuilder().setValue(tenantId).setOperation(Operation.EQUALS).build();
    ClientShareFilter clientShareFilter = ClientShareFilter.newBuilder().setClientId(clientIdFilter)
        .setSubjectId(subjectIdFilter).setTenantId(tenantIdFilter).build();
    ListClientSharesRequest request =
        ListClientSharesRequest.newBuilder().setFilter(clientShareFilter).build();
    return blockingStub.listClientShares(request);
  }


  public Empty deleteShare(GeneratedMessageV3 clientShare) {
    DeleteClientShareRequest request =
        DeleteClientShareRequest.newBuilder().setClientShare((ClientShare) clientShare).build();
    return blockingStub.deleteClientShare(request);
  }
}
