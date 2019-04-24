package axoom.mappingz.v1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.axoom.constants.ContentType;
import com.axoom.drs.utils.RestUtils;
import axoom.mappingz.v1.Mappingz.Mapping;
import axoom.mappingz.v1.MappingzGrpc.MappingzBlockingStub;
import axoom.mappingz.v1.MappingzService.CreateMappingRequest;
import axoom.mappingz.v1.MappingzService.CreateMappingResponse;
import axoom.mappingz.v1.MappingzService.GetRequest;
import axoom.mappingz.v1.MappingzService.GetResponse;
import axoom.mappingz.v1.MappingzService.MappingEvent;
import axoom.mappingz.v1.MappingzService.MappingListRequest;
import axoom.mappingz.v1.MappingzService.MappingStreamRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.MetadataUtils;

public class MappingzClient {
  private static final Logger logger = Logger.getLogger(MappingzClient.class.getName());

  private final ManagedChannel channel;
  private final MappingzBlockingStub blockingStub;

  /* Construct client connecting to RecordMetas server at {@code name:port}. */
  public MappingzClient(String name, int port) {
    this(ManagedChannelBuilder.forAddress(name, port).build());
  }

  public MappingzClient(ManagedChannel channel) {
    this.channel = channel;
    Map<String, String> requestParams = new HashMap<String, String>();
    requestParams.put("baseUrl", "https://account.dev.myaxoom.com/connect/token");
    requestParams.put("scope", "https://apis.axoom.com/scopes/mappings");
    requestParams.put("clientId", System.getenv("API_TEST_CLIENT"));
    requestParams.put("clientSecret", System.getenv("API_TEST_SECRET"));
    requestParams.put("contentType", ContentType.FORM_URL_ENCODED);

    String accessToken = RestUtils.getAccessTokenFromClientCredsFlow(requestParams);
    logger.log(Level.INFO, "Access Token: " + accessToken);
    Metadata authHeaders = new Metadata();
    authHeaders.put(Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER), accessToken);

    blockingStub = MetadataUtils.attachHeaders(MappingzGrpc.newBlockingStub(channel), authHeaders);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  public Iterator<MappingEvent> getMappingEvents(String subscriptionId) {
    MappingStreamRequest request = MappingStreamRequest.newBuilder().build();

    try {
      return blockingStub.getStream(request);

    } catch (StatusRuntimeException e) {
      logger.log(Level.SEVERE, "RPC failed: {0}", e.getStatus());
      throw e;
    } catch (Exception e) {
      logger.log(Level.SEVERE, e.getMessage());
      throw e;
    }
  }

  /**
   * 
   * @param count
   * @param offset
   * @return list
   */
  public List<Mapping> getMappingsList(int count, int offset) {
    try {
      MappingListRequest request =
          MappingListRequest.newBuilder().setCount(count).setOffset(offset).build();
      return blockingStub.getAll(request).getMappingsList();
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    } catch (Exception e) {
      logger.log(Level.SEVERE, e.getMessage());
      throw e;
    }
  }

  /**
   * 
   * @param mappingEvent
   * @return mapping
   */
  public Mapping getMappingFromEvent(MappingEvent mappingEvent) {
    return mappingEvent.getMapping();
  }

  /**
   * 
   * @param mapping
   * @return mapping
   */
  public Mapping createMapping(Mapping mapping) {
    try {
      CreateMappingRequest request = CreateMappingRequest.newBuilder().setMapping(mapping).build();
      CreateMappingResponse response = blockingStub.createMapping(request);
      return response.getMapping();
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    } catch (Exception e) {
      logger.log(Level.SEVERE, e.getMessage());
      throw e;
    }
  }

  public Mapping getMapping(String mappingId) {
    try {
      GetRequest request = GetRequest.newBuilder().setMappingId(mappingId).build();
      GetResponse response = blockingStub.get(request);
      return response.getMapping();
    } catch (NullPointerException npe) {
      logger.log(Level.SEVERE, npe.getMessage());
      throw npe;
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }
}
