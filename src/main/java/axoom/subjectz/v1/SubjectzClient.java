package axoom.subjectz.v1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.axoom.constants.ContentType;
import com.axoom.drs.utils.RestUtils;
import axoom.subjectz.v1.Subjectz.Subject;
import axoom.subjectz.v1.Subjectz.SubjectType;
import axoom.subjectz.v1.SubjectzGrpc.SubjectzBlockingStub;
import axoom.subjectz.v1.SubjectzService.CreateSubjectRequest;
import axoom.subjectz.v1.SubjectzService.CreateSubjectResponse;
import axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest;
import axoom.subjectz.v1.SubjectzService.CreateSubjectTypeResponse;
import axoom.subjectz.v1.SubjectzService.GetAllSubjectzRequest;
import axoom.subjectz.v1.SubjectzService.GetAllSubjectzResponse;
import axoom.subjectz.v1.SubjectzService.GetSubjectRequest;
import axoom.subjectz.v1.SubjectzService.GetSubjectResponse;
import axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest;
import axoom.subjectz.v1.SubjectzService.GetSubjectTypeResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.MetadataUtils;

public class SubjectzClient {
  private static final Logger logger = Logger.getLogger(SubjectzClient.class.getName());

  private final ManagedChannel channel;
  private final SubjectzBlockingStub blockingStub;


  /* Construct client connecting to RecordMetas server at {@code name:port}. */
  public SubjectzClient(String name, int port) {
    this(ManagedChannelBuilder.forAddress(name, port).build());
  }
  
  public SubjectzClient(ManagedChannel channel) {
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

    blockingStub = MetadataUtils.attachHeaders(SubjectzGrpc.newBlockingStub(channel), authHeaders);
  }
  
  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  } 
  
  public List<Subject> getAllSubjectz(String subjectzTypeId) {
    GetAllSubjectzRequest request = GetAllSubjectzRequest.newBuilder().setSubjectTypeId(subjectzTypeId).build();

    try {      
      GetAllSubjectzResponse response = blockingStub.getAllSubjectz(request);
      return response.getSubjectsList();
      
    } catch (StatusRuntimeException e) {
      logger.log(Level.SEVERE, "RPC failed: {0}", e.getStatus());
      return null;
    }
  }
  
  public Subject getSubject(String subjectId) {
    GetSubjectRequest request = GetSubjectRequest.newBuilder().setSubjectId(subjectId).build();

    try {      
      GetSubjectResponse response = blockingStub.getSubject(request);
      return response.getSubject();
      
    } catch (StatusRuntimeException e) {
      logger.log(Level.SEVERE, "RPC failed: {0}", e.getStatus());
      return null;
    }
  }
  
  public CreateSubjectResponse createSubject(Subject subject) {
    CreateSubjectRequest request = CreateSubjectRequest.newBuilder().setSubject(subject).build();

    try {      
      return blockingStub.createSubject(request);      
    } catch (StatusRuntimeException e) {
      logger.log(Level.SEVERE, "RPC failed: {0}", e.getStatus());
      return null;
    }
  }
 
  public CreateSubjectTypeResponse createSubjectType(SubjectType subjectType) {
    CreateSubjectTypeRequest request = CreateSubjectTypeRequest.newBuilder().setSubjectType(subjectType).build();

    try {      
      return blockingStub.createSubjectType(request);     
    } catch (StatusRuntimeException e) {
      logger.log(Level.SEVERE, "RPC failed: {0}", e.getStatus());
      return null;
    }
  }
  
  public SubjectType getSubjectType(String subjectTypeId) {
    GetSubjectTypeRequest request = GetSubjectTypeRequest.newBuilder().setSubjectTypeId(subjectTypeId).build();

    try {      
      GetSubjectTypeResponse response = blockingStub.getSubjectType(request);
      return response.getSubjectType();
    } catch (StatusRuntimeException e) {
      logger.log(Level.SEVERE, "RPC failed: {0}", e.getStatus());
      return null;
    }
  }
}
