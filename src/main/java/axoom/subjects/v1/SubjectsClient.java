package axoom.subjects.v1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.protobuf.FieldMask;
import axoom.filters.v1.Filter.KeyValueFilter;
import axoom.filters.v1.Filter.StringPropertyFilter;
import axoom.filters.v1.Filter.StringPropertyFilter.Operation;
import axoom.subjects.v1.Subjects.Subject;
import axoom.subjects.v1.Subjects.SubjectContext;
import axoom.subjects.v1.Subjects.SubjectTypeContext;
import axoom.subjects.v1.SubjectsGrpc.SubjectsBlockingStub;
import axoom.subjects.v1.SubjectsService.CreateSubjectRequest;
import axoom.subjects.v1.SubjectsService.GetSubjectContextRequest;
import axoom.subjects.v1.SubjectsService.GetSubjectRequest;
import axoom.subjects.v1.SubjectsService.GetSubjectTypeContextRequest;
import axoom.subjects.v1.SubjectsService.ListSubjectsRequest;
import axoom.subjects.v1.SubjectsService.ListSubjectsResponse;
import axoom.subjects.v1.SubjectsService.RemoveSubjectLabelsRequest;
import axoom.subjects.v1.SubjectsService.SetSubjectLabelsRequest;
import axoom.subjects.v1.SubjectsService.SubjectFilter;
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
  private String accessTokenFromCodeFlow = null;
  
  //Get file from resources folder
  private File resourcesDirectory = new File("src/test/resources/");
  private String subjectsPropertiesFilePath;
  private Properties prop;  
  private InputStream input;
  

  /* Construct client connecting to RecordMetas server at {@code name:port}. */
  public SubjectsClient(String name, int port, String accessTokenFromCodeFlow) {    
    this(ManagedChannelBuilder.forAddress(name, port).build());    
  }
  
  public SubjectsClient(ManagedChannel channel) {
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
    authHeaders.put(Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER),  ": Bearer " + accessTokenFromCodeFlow);

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
   * @param subject
   * @return subject
   */
  public Subject updateSubject(Subject subject, String fieldName) {    
    FieldMask fieldMask = FieldMask.newBuilder().addPaths("subject." + fieldName).build();
    UpdateSubjectRequest request = UpdateSubjectRequest.newBuilder().setSubject(subject).setUpdateMask(fieldMask).build();    
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
  public ListSubjectsResponse listSubjectsWithNameFilter(String subjectName) {
    StringPropertyFilter filter = StringPropertyFilter.newBuilder().setValue(subjectName).setOperation(Operation.EQUALS).build();
    SubjectFilter subjectFilter = SubjectFilter.newBuilder().setName(filter).build();
    ListSubjectsRequest request = ListSubjectsRequest.newBuilder().setFilter(subjectFilter).build();

    try {      
      return blockingStub.listSubjects(request);
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }
  
  
  /** 
  * @param owner
  * @return listSubjectsResponse
  */
 public ListSubjectsResponse listSubjectsWithOwnerFilter(String owner) {
   StringPropertyFilter filter = StringPropertyFilter.newBuilder().setValue(owner).setOperation(Operation.EQUALS).build();
   SubjectFilter subjectFilter = SubjectFilter.newBuilder().setOwner(filter).build();
   ListSubjectsRequest request = ListSubjectsRequest.newBuilder().setFilter(subjectFilter).build();

   try {      
     return blockingStub.listSubjects(request);
   } catch (StatusRuntimeException sre) {
     logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
     throw sre;
   }
 }
 
 /** 
  * @param label
  * @return listSubjectsResponse
  */
 public ListSubjectsResponse listSubjectsWithLabelsFilter(String labelKey, String labelValue) {
   KeyValueFilter filter = KeyValueFilter.newBuilder().setKey(labelKey).setValue(labelValue).build();
   SubjectFilter subjectFilter = SubjectFilter.newBuilder().setLabels(0, filter).build();
   ListSubjectsRequest request = ListSubjectsRequest.newBuilder().setFilter(subjectFilter).build();

   try {      
     return blockingStub.listSubjects(request);
   } catch (StatusRuntimeException sre) {
     logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
     throw sre;
   }
 }
  
  
  public ListSubjectsResponse listSubjectsWithoutFilter() {    
    ListSubjectsRequest request = ListSubjectsRequest.newBuilder().build();    
    try {      
      return blockingStub.listSubjects(request);
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }
  
  /**
   * 
   * @param subjectId
   * @param labelKey
   * @param labelValue
   * @return subject
   */
  public Subject setSubjectsLabel(String subjectId, String labelKey, String labelValue) {
    SetSubjectLabelsRequest request = SetSubjectLabelsRequest.newBuilder().setSubjectId(subjectId).putLabels(labelKey, labelValue).build();    
    try {      
      return blockingStub.setSubjectLabels(request);
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }
  
  /**
   * 
   * @param subjectId
   * @param labels
   * @return subject
   */
  public Subject setSubjectsLabels(String subjectId, Map<String, String> labels) {
    SetSubjectLabelsRequest request = SetSubjectLabelsRequest.newBuilder().setSubjectId(subjectId).putAllLabels(labels).build();

    try {      
      return blockingStub.setSubjectLabels(request);
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }
  
  /**
   * 
   * @param subjectId
   * @param labelKey
   * @return subject
   */
  public Subject removeSubjectLabels(String subjectId, String labelKey) {
    RemoveSubjectLabelsRequest request = RemoveSubjectLabelsRequest.newBuilder().setSubjectId(subjectId).addLabels(labelKey).build();
    
    try {      
      return blockingStub.removeSubjectLabels(request);
    } catch (StatusRuntimeException sre) {
      logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
      throw sre;
    }
  }  
 
}
