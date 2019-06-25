package axoom.subjects.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.axoom.constants.ContentType;
import com.axoom.drs.utils.RestUtils;
import axoom.filters.v1.Filter.KeyValueFilter;
import axoom.filters.v1.Filter.StringPropertyFilter;
import axoom.subjects.v1.Subjects.Subject;
import axoom.subjects.v1.Subjects.SubjectContext;
import axoom.subjects.v1.Subjects.SubjectType;
import axoom.subjects.v1.Subjects.SubjectTypeContext;
import axoom.subjects.v1.SubjectsGrpc.SubjectsBlockingStub;
import axoom.subjects.v1.SubjectsService.CreateSubjectRequest;
import axoom.subjects.v1.SubjectsService.CreateSubjectTypeRequest;
import axoom.subjects.v1.SubjectsService.GetSubjectContextRequest;
import axoom.subjects.v1.SubjectsService.GetSubjectRequest;
import axoom.subjects.v1.SubjectsService.GetSubjectTypeContextRequest;
import axoom.subjects.v1.SubjectsService.GetSubjectTypeRequest;
import axoom.subjects.v1.SubjectsService.ListSubjectTypesRequest;
import axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse;
import axoom.subjects.v1.SubjectsService.ListSubjectsRequest;
import axoom.subjects.v1.SubjectsService.ListSubjectsResponse;
import axoom.subjects.v1.SubjectsService.SubjectFilter;
import axoom.subjects.v1.SubjectsService.SubjectTypeFilter;
import axoom.subjects.v1.SubjectsService.UpdateSubjectRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.MetadataUtils;

public class SubjectsClient {
  private static final Logger logger = Logger.getLogger(SubjectsClient.class.getName());

  private final ManagedChannel channel;
  private final SubjectsBlockingStub blockingStub;


  /* Construct client connecting to RecordMetas server at {@code name:port}. */
  public SubjectsClient(String name, int port) {
    this(ManagedChannelBuilder.forAddress(name, port).build());
  }
  
  public SubjectsClient(ManagedChannel channel) {
    this.channel = channel;
    Map<String, String> requestParams = new HashMap<String, String>();
    requestParams.put("baseUrl", "https://account.dev.myaxoom.com/connect/token");
    requestParams.put("scope", "https://apis.axoom.com/auth/subjects");
    requestParams.put("clientId", System.getenv("API_TEST_CLIENT"));
    requestParams.put("clientSecret", System.getenv("API_TEST_SECRET"));
    requestParams.put("contentType", ContentType.FORM_URL_ENCODED);

    String accessToken = RestUtils.getAccessTokenFromClientCredsFlow(requestParams);
    logger.log(Level.INFO, "Access Token: " + accessToken);
    Metadata authHeaders = new Metadata();
    authHeaders.put(Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER),  ": Bearer " + accessToken);

    blockingStub = MetadataUtils.attachHeaders(SubjectsGrpc.newBlockingStub(channel), authHeaders);
  }
  
  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }    
  
  /**
   * 
   * @param subject
   * @param subjectTypeName
   * @return subject
   */
  public Subject createSubject(String name, String implementsValue, Map<String, String> labels) {
    CreateSubjectRequest request = CreateSubjectRequest.newBuilder().putAllLabels(labels).setName(name).addImplements(implementsValue).build();

    try {      
      return blockingStub.createSubject(request);      
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }
 
  /**
   * 
   * @param subjectType
   * @return subjectType
   */
  public SubjectType createSubjectType(SubjectType subjectType) {
    CreateSubjectTypeRequest request = CreateSubjectTypeRequest.newBuilder().setSubjectType(subjectType).build();

    try {      
      return blockingStub.createSubjectType(request);     
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }     
  
  
  /**
   * 
   * @param subject
   * @return subject
   */
  public Subject updateSubject(Subject subject) {
    UpdateSubjectRequest request = UpdateSubjectRequest.newBuilder().setSubject(subject).build();    
    try {      
      return blockingStub.updateSubject(request);     
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }  
  
  /**
   * 
   * @param subjectId
   * @return subject
   */
  public Subject getSubject(String subjectId) {
    GetSubjectRequest request = GetSubjectRequest.newBuilder().setSubjectId(subjectId).build();

    try {      
      return blockingStub.getSubject(request);
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }
  
  /**
   * 
   * @param subjectTypeName
   * @return subjectType
   */
  public SubjectType getSubjectType(String subjectTypeName) {
    GetSubjectTypeRequest request = GetSubjectTypeRequest.newBuilder().setSubjectTypeName(subjectTypeName).build();

    try {      
      return blockingStub.getSubjectType(request);
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  } 
 
  
  /**
   * 
   * @param subjectId
   * @return subjectContext
   */
  public SubjectContext getSubjectContext(String subjectId) {
    GetSubjectContextRequest request = GetSubjectContextRequest.newBuilder().setSubjectId(subjectId).build();

    try {      
      return blockingStub.getSubjectContext(request);
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }

  /**
   * 
   * @param subjectTypeName
   * @return subjectContext
   */
  public SubjectTypeContext getSubjectTypeContext(String subjectTypeName) {
    GetSubjectTypeContextRequest request = GetSubjectTypeContextRequest.newBuilder().setSubjectTypeName(subjectTypeName).build();

    try {      
      return blockingStub.getSubjectTypeContext(request);
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }
  
  /**
   * 
   * @param subjectName
   * @return listSubjectsResponse
   */
  public ListSubjectsResponse listSubjects(String subjectName) {
    StringPropertyFilter filter = StringPropertyFilter.newBuilder().setValue(subjectName).build();
    SubjectFilter subjectFilter = SubjectFilter.newBuilder().setName(filter).build();
    ListSubjectsRequest request = ListSubjectsRequest.newBuilder().setFilter(subjectFilter).build();

    try {      
      return blockingStub.listSubjects(request);
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }
  
  
  public ListSubjectTypesResponse listSubjectTypes(String subjectTypeName) {
    KeyValueFilter filter = KeyValueFilter.newBuilder().setKey("label").setValue(subjectTypeName).build();
    SubjectTypeFilter subjectFilter = SubjectTypeFilter.newBuilder().setLabels(0, filter).build();
    ListSubjectTypesRequest request = ListSubjectTypesRequest.newBuilder().setFilter(subjectFilter).build();

    try {      
      return blockingStub.listSubjectTypes(request);
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }
 
}