package axoom.records.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.axoom.constants.ContentType;
import com.axoom.drs.utils.RestUtils;
import com.google.protobuf.Timestamp;
import axoom.filters.v1.Filter;
import axoom.filters.v1.Filter.StringPropertyFilter;
import axoom.records.v1.Records.RecordsSubscription;
import axoom.records.v1.RecordsGrpc.RecordsBlockingStub;
import axoom.records.v1.RecordsService.CreateRecordsSubscriptionRequest;
import axoom.records.v1.RecordsService.ListRecordsSubscriptionsRequest;
import axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse;
import axoom.records.v1.RecordsService.RecordsSubscriptionsFilter;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.stub.MetadataUtils;


public class RecordsClient {

  private static final Logger logger = Logger.getLogger(RecordsClient.class.getName());

  private final ManagedChannel channel;
  private final RecordsBlockingStub blockingStub;


  /* Construct client connecting to Qrecords server at {@code host:port}. */
  public RecordsClient(String host, int port) {
    //Instantiate client and connect to server
    this(ManagedChannelBuilder.forAddress(host, port).build());

  }

  /* Construct client for accessing Qrecords server using the existing channel. */
  RecordsClient(ManagedChannel channel) {
    this.channel = channel;

    Map<String, String> requestParams = new HashMap<String, String>();
    requestParams.put("baseUrl", "https://account.dev.myaxoom.com/connect/token");
    requestParams.put("scope", "https://apis.axoom.com/scopes/records");
    requestParams.put("clientId", System.getenv("API_TEST_CLIENT"));
    requestParams.put("clientSecret", System.getenv("API_TEST_SECRET"));
    requestParams.put("contentType", ContentType.FORM_URL_ENCODED);

    //Get Access token from client creds flow from CIS
    String accessToken = RestUtils.getAccessTokenFromClientCredsFlow(requestParams);
    logger.log(Level.INFO, "Access Token: " + accessToken);

    //Put access token in auth headers for gRPC 
    Metadata authHeaders = new Metadata();
    authHeaders.put(Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER), ": Bearer " + accessToken);

    //Attach headers
    blockingStub = MetadataUtils.attachHeaders(RecordsGrpc.newBlockingStub(channel), authHeaders);
  }

  public RecordsSubscription createRecordSubscription(String id, String subjectTypeName, Timestamp expiryTimeStamp) {    
    RecordsSubscription subscription = RecordsSubscription.newBuilder().setId(id).setExpiry(expiryTimeStamp).setSubjectTypeName("subjectTypeName").build();
    CreateRecordsSubscriptionRequest request = CreateRecordsSubscriptionRequest.newBuilder().setRecordsSubscription(subscription).build();
    return blockingStub.createRecordsSubscription(request);    
  }
  
  public ListRecordsSubscriptionsResponse listRecordsSubscriptions(String subjectTypeName, RecordsSubscriptionsFilter filter) {    
    ListRecordsSubscriptionsRequest request = ListRecordsSubscriptionsRequest.newBuilder().setFilter(filter).build();
    ListRecordsSubscriptionsResponse response = blockingStub.listRecordsSubscriptions(request);
    return response;
  }
  
  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }  
}
