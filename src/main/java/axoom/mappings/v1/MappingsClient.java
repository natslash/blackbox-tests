package axoom.mappings.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.axoom.constants.ContentType;
import com.axoom.drs.utils.RestUtils;
import axoom.filters.v1.Filter.StringPropertyFilter;
import axoom.mappings.v1.Mappings.Mapping;
import axoom.mappings.v1.MappingsGrpc.MappingsBlockingStub;
import axoom.mappings.v1.MappingsService.CreateMappingRequest;
import axoom.mappings.v1.MappingsService.ListMappingsRequest;
import axoom.mappings.v1.MappingsService.ListMappingsResponse;
import axoom.mappings.v1.MappingsService.MappingFilter;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.stub.MetadataUtils;

public class MappingsClient {
  private static final Logger logger = Logger.getLogger(MappingsClient.class.getName());

  private final ManagedChannel channel;
  private final MappingsBlockingStub blockingStub;  
  
  /* Construct client connecting to RecordMetas server at {@code name:port}. */
  public MappingsClient(String name, int port) {
    this(ManagedChannelBuilder.forAddress(name, port).build());
  }

  public MappingsClient(ManagedChannel channel) {
    this.channel = channel;
    Map<String, String> requestParams = new HashMap<String, String>();
    requestParams.put("baseUrl", "https://account.dev.myaxoom.com/connect/token");
    requestParams.put("scope", "https://apis.axoom.com/auth/mappings");
    requestParams.put("clientId", System.getenv("API_TEST_CLIENT"));
    requestParams.put("clientSecret", System.getenv("API_TEST_SECRET"));
    requestParams.put("contentType", ContentType.FORM_URL_ENCODED);

    String accessToken = RestUtils.getAccessTokenFromClientCredsFlow(requestParams);
    logger.log(Level.INFO, "Access Token: " + accessToken);
    Metadata authHeaders = new Metadata();
    authHeaders.put(Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER), ": Bearer " + accessToken);

    blockingStub = MetadataUtils.attachHeaders(MappingsGrpc.newBlockingStub(channel), authHeaders);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  public Mapping createMapping(Mapping mapping) {   
    CreateMappingRequest request = CreateMappingRequest.newBuilder().setMapping(mapping).build();    
    return blockingStub.createMapping(request);    
  }
  
  public ListMappingsResponse listMappings(String deviceId, String preProcessingId) {
    StringPropertyFilter deviceIdFilter = StringPropertyFilter.newBuilder().setValue(deviceId).build();
    StringPropertyFilter preProcessingIdFilter = StringPropertyFilter.newBuilder().setValue(preProcessingId).build();
    MappingFilter mappingFilter = MappingFilter.newBuilder().setDeviceId(deviceIdFilter).setPreprocessingId(preProcessingIdFilter).build();
    ListMappingsRequest request = ListMappingsRequest.newBuilder().setFilter(mappingFilter).build();    
    return blockingStub.listMappings(request);    
  }
}
