package axoom.subjects.v1;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
  private String accessTokenFromCodeFlow = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjQ1RDRGN0E0ODJGMkVEMjM5QkJBRkEwODQ1N0Q5RDYwRTdCQzRDMjIiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJSZFQzcElMeTdTT2J1dm9JUlgyZFlPZThUQ0kifQ.eyJuYmYiOjE1NjE2MjUxNzMsImV4cCI6MTU2MTYyODc3MywiaXNzIjoiaHR0cHM6Ly9hY2NvdW50LmRldi5teWF4b29tLmNvbSIsImF1ZCI6WyJodHRwczovL2FjY291bnQuZGV2Lm15YXhvb20uY29tL3Jlc291cmNlcyIsImh0dHBzOi8vYXBpcy5heG9vbS5jb20vYXV0aC9zdWJqZWN0cyJdLCJjbGllbnRfaWQiOiJibGFja2JveHRlc3QwMS10ZXN0MSIsInN1YiI6IjUwNmE5ZDMxLTc1M2MtNGMwOS05M2I5LTNlOWY2NmJkZGJkNSIsImF1dGhfdGltZSI6MTU2MTYyNTE2MywiaWRwIjoiaHR0cHM6Ly9hY2NvdW50LmRldi5teWF4b29tLmNvbS8iLCJhY2Nlc3MiOlsiZGF0YS1jb21wb3NpdGlvbi1zZXJ2aWNlIiwic2NoZW1hLXJlZ2lzdHJhdGlvbi1zZXJ2aWNlIiwiZGV2aWNlLXJlZ2lzdHJhdGlvbi1zZXJ2aWNlIiwidXNlcm1hbmFnZW1lbnQiXSwidGVuYW50IjoiYmxhY2tib3h0ZXN0MDEiLCJzY29wZSI6WyJvcGVuaWQiLCJodHRwczovL2FwaXMuYXhvb20uY29tL2F1dGgvc3ViamVjdHMiXSwiYW1yIjpbImV4dGVybmFsIl19.B5sgGCC1WIC0pFSZqK39slut1P_BEWHzalm-oBmrXQX0PhgZ8BY7d41c0r5gDW5ayRciGg-toXRh4M1_aVZRjwqu7EHzBpjUSl0p9bwiE76L7sSHesrEXOFws-pcQ3lmuEmbM-pgZ2uC9z44zUs926jk4ML-2BUmcHoqsBeuLN5HCXq7g_IveKB7GuU23281OnPNSXPToHjnVJZKb8RQ0FQ-IYeRL29Og5CGr6vKac9HAAf86aH0GMeCNmr08xG9qBKfU04YHPfopm6iSuADuqY1hR55zGODupL1Ae-30lAZF34P_EI_AV3XAH_xKjWWiGBSAd8MkgqpAifXlSwA65DIObLg9gf5RWHUJj--rtHpAY0qbaRJVYXrqxLPJXVn6W_mt_HywPuaHQ3KwOGDpOFSgIKvNbyeWV6RizVjQ3yxxeg5So7d1--_jxMmtEYMFnRZzQ1OO6cIOhAA0hRSVgS3LSgIXnR1rNWYGK0FLykMRvfDPL25oS5M_uiIolqbId2PNDYzWfqIxyUyxwYjnM3561ACOUDNV7eIMVm9yjtlcQmU-MpyCPlwOPhgJBDhuS0CnoNTMEHaIUpcCY2fpQER_8cs599BG1k3rsTaTWPtVzARF3I8MguDsomUzPFKV4yblK0WlaunmdpFUIhNdaV_J6zudFyf2QVlfKaveBU";


  /* Construct client connecting to RecordMetas server at {@code name:port}. */
  public SubjectsClient(String name, int port, String accessTokenFromCodeFlow) {    
    this(ManagedChannelBuilder.forAddress(name, port).build());    
  }
  
  public SubjectsClient(ManagedChannel channel) {
    this.channel = channel;   
    logger.log(Level.INFO, "Access Token: " + accessTokenFromCodeFlow);
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
