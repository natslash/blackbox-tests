package axoom.subjectz.v1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.axoom.constants.ContentType;
import com.axoom.drs.utils.RestUtils;
import axoom.subjectz.v1.Subjectz.Subject;
import axoom.subjectz.v1.Subjectz.SubjectContext;
import axoom.subjectz.v1.Subjectz.SubjectType;
import axoom.subjectz.v1.Subjectz.SubjectTypeContext;
import axoom.subjectz.v1.SubjectzGrpc.SubjectzBlockingStub;
import axoom.subjectz.v1.SubjectzService.CreateSubjectRequest;
import axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest;
import axoom.subjectz.v1.SubjectzService.GetSubjectContextRequest;
import axoom.subjectz.v1.SubjectzService.GetSubjectRequest;
import axoom.subjectz.v1.SubjectzService.GetSubjectTypeContextRequest;
import axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest;
import axoom.subjectz.v1.SubjectzService.GetSubjectTypezRequest;
import axoom.subjectz.v1.SubjectzService.GetSubjectzRequest;
import axoom.subjectz.v1.SubjectzService.UpdateSubjectRequest;
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
    requestParams.put("scope", "https://apis.axoom.com/scopes/subjects");
    requestParams.put("clientId", System.getenv("API_TEST_CLIENT"));
    requestParams.put("clientSecret", System.getenv("API_TEST_SECRET"));
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
  
  public Iterator<Subject> getSubjectz(String subjectTypeId) {
    GetSubjectzRequest request = GetSubjectzRequest.newBuilder().setSubjectTypeId(subjectTypeId).build();

    try {      
      return blockingStub.getSubjectz(request);      
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }catch (Exception e) {
      logger.log(Level.SEVERE, "RPC failed: {0}", e.getMessage());
      throw e;
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
   * @param subjectTypeId
   * @return subjectType
   */
  public SubjectType getSubjectType(String subjectTypeId) {
    GetSubjectTypeRequest request = GetSubjectTypeRequest.newBuilder().setSubjectTypeId(subjectTypeId).build();

    try {      
      return blockingStub.getSubjectType(request);
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }
  
  /**
   * 
   * @return subjectType iterator
   */
  public Iterator<SubjectType> getSubjectTypez() {
    GetSubjectTypezRequest request = GetSubjectTypezRequest.newBuilder().build();

    try {      
      return blockingStub.getSubjectTypez(request);
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
   * @param subjectTypeId
   * @return subjectContext
   */
  public SubjectTypeContext getSubjectTypeContext(String subjectTypeId) {
    GetSubjectTypeContextRequest request = GetSubjectTypeContextRequest.newBuilder().setSubjectTypeId(subjectTypeId).build();

    try {      
      return blockingStub.getSubjectTypeContext(request);
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }
  
  /**
   * 
   * @param subject
   * @param subjectTypeId
   * @return subject
   */
  public Subject createSubject(Subject subject, String subjectTypeId) {
    CreateSubjectRequest request = CreateSubjectRequest.newBuilder().addInstanceOf(subjectTypeId).setSubject(subject).build();

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
  
  public SubjectType getSubjectTypeFromSubjectContextInstanceGraph(SubjectContext subjectContext, int index) {
    return subjectContext.getInstanceGraph(index).getSubjectType();
  } 
 
}
