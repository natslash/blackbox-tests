package axoom.subjectz.v1;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.axoom.talos.framework.WebDriverTest;
import axoom.subjectz.v1.Subjectz.Subject;
import axoom.subjectz.v1.Subjectz.SubjectContext;
import axoom.subjectz.v1.Subjectz.SubjectType;
import axoom.subjectz.v1.Subjectz.SubjectTypeContext;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomSubjectzPositiveTestsIT extends WebDriverTest {
  private String timeStamp;
  private String clientId;
  private String redirectUri;
  private String secret;
  private String cisUrl;
  private SubjectzClient client;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger =
      Logger.getLogger(AxoomSubjectzPositiveTestsIT.class.getName());
  private String createdSubjectTypeId = null;

  @BeforeClass
  public void beforeClass() {
    clientId = System.getenv("SRS_CLIENT_ID");
    redirectUri = System.getenv("SRS_REDIRECT_URI");
    cisUrl = System.getenv("CIS_URL");
    secret = System.getenv("SECRET");
    requestParams.put("clientId", clientId);
    requestParams.put("redirectUri", redirectUri);
    requestParams.put("cisUrl", cisUrl);
    requestParams.put("secret", secret);
    timeStamp = Long.toString(System.currentTimeMillis());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
    logger.log(Level.INFO, "Working Directory = " + System.getProperty("user.dir"));
  }

  @BeforeMethod
  public void beforeMethod() {
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    // Create Client and establish connection to the server
    client = new SubjectzClient("subjects.dev.myaxoom.com", 443);
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }

  @Test
  @Description("Create SubjectType")
  @Severity(SeverityLevel.BLOCKER)
  public void createSubjectTypeTest() throws Exception {
    SubjectType subjectType =
        SubjectType.newBuilder().setId(timeStamp).setRecordSchemaUrl("recordSchemaUrl" + timeStamp)
            .setRecordMetaSchemaUrl("recordMetaSchemaUrl" + timeStamp).build();
    try {
      SubjectType createdSubjectType = client.createSubjectType(subjectType);
      logger.log(Level.INFO, "SubjectType created " + createdSubjectType.getId());
      createdSubjectTypeId = createdSubjectType.getId();
      assertTrue(createdSubjectType != null);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"createSubjectTypeTest"})
  @Description("Get SubjectType's RecordSchemaUrl")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectTypeRecordSchemaUrl() throws Exception {
    try {
      // Get Subject type
      SubjectType subjectType = client.getSubjectType(createdSubjectTypeId);

      logger.log(Level.INFO, subjectType.getRecordSchemaUrl());
      assertTrue(subjectType.getRecordSchemaUrl().equals("recordSchemaUrl" + timeStamp));

    } catch (StatusRuntimeException sre) {
      throw sre;
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"createSubjectTypeTest"})
  @Description("Get SubjectType's RecordMetaSchemaUrl")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectTypeRecordMetaSchemaUrl() throws Exception {
    try {
      // Get Subject type
      SubjectType subjectType = client.getSubjectType(createdSubjectTypeId);

      logger.log(Level.INFO, subjectType.getRecordMetaSchemaUrl());
      assertTrue(subjectType.getRecordMetaSchemaUrl().equals("recordMetaSchemaUrl" + timeStamp));

    } catch (StatusRuntimeException sre) {
      throw sre;
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"createSubjectTest"})
  @Description("Get SubjectTypez")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectTypes() throws Exception {
    try {
      // Get Subject type
      Iterator<SubjectType> subjectTypes = client.getSubjectTypez();
      assertTrue(subjectTypes.hasNext(), "No SubjectTypes found for the subject type");
    } catch (StatusRuntimeException sre) {
      throw sre;
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }


  @Test(dependsOnMethods = {"createSubjectTypeTest"})
  @Description("Create Subject")
  @Severity(SeverityLevel.BLOCKER)
  public void createSubjectTest() throws Exception {
    Subject subject =
        Subject.newBuilder().setId(timeStamp).setName("FirstSubject" + timeStamp).build();
    try {
      Subject createdSubject = client.createSubject(subject, createdSubjectTypeId);
      assertTrue(createdSubject.getId().equals(timeStamp));
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"createSubjectTest"})
  @Description("Get Subject by it's ID")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectById() throws Exception {
    try {
      // Get all subjects with SubjectTypeId
      Subject subject = client.getSubject(timeStamp);
      logger.log(Level.INFO, subject.getId());
      assertTrue(subject.getId().equals(timeStamp) && subject.getName().equals("FirstSubject" + timeStamp));
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }   
  

  @Test(dependsOnMethods = {"createSubjectTest"})
  @Description("Get Subjects for a subjectType")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectsBySubjectType() throws Exception {
    try {
      // Get Subject type
      Iterator<Subject> subjects = client.getSubjectz(createdSubjectTypeId);      
      assertTrue(subjects.hasNext(), "No Subjects found for the subject type");
    } catch (StatusRuntimeException sre) {
      throw sre;
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"createSubjectTest"})
  @Description("Get SubjectContext by specifying a subject id")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectContextForASubject() throws Exception {
    try {
      // get subject context by subject ID
      SubjectContext subjectContext = client.getSubjectContext(timeStamp);
      assertTrue(subjectContext.getSubject().getId().equals(timeStamp)
          && subjectContext.getSubject().getName().equals("FirstSubject" + timeStamp));
    } catch (StatusRuntimeException sre) {
      throw sre;
    } catch (NullPointerException ne) {
      assertTrue(true);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"createSubjectTest"})
  @Description("Get SubjectContext by specifying nonexistent subject id")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectContextForNonexistentSubject() throws Exception {
    try {
      // null subject ID
      client.getSubjectContext("x");
    } catch (StatusRuntimeException sre) {
      assertTrue(sre.getMessage().contains("UNKNOWN: subject not found"),
          "The Error message doesn't match with what we expect!!!");
    } catch (NullPointerException ne) {
      assertTrue(true);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
  
  @Test(dependsOnMethods = {"createSubjectTypeTest"})
  @Description("Get SubjectTypeContext for a non existent subjectType")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectContextForNonExistentSubjectType() throws Exception {
    try {
      // Get Subject type context by subject type ID
      client.getSubjectTypeContext("x");
    } catch (StatusRuntimeException sre) {
      assertTrue(sre.getMessage().contains("UNKNOWN: subject type not found"),
          "The Error message doesn't match with what we expect!!!");
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
  
  @Test(dependsOnMethods = {"createSubjectTypeTest"})
  @Description("Get SubjectTypeContext for SubjectType")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectTypeContextBySubjectTypeId() throws Exception {
    try {
      // Get Subject type context by subject type ID
      SubjectTypeContext subjectTypeContext = client.getSubjectTypeContext(createdSubjectTypeId);

      SubjectType subjectType = subjectTypeContext.getSubjectType();
      assertTrue(subjectType.getId().equals(createdSubjectTypeId)
          && subjectType.getRecordSchemaUrl().equals("recordSchemaUrl" + timeStamp)
          && subjectType.getRecordMetaSchemaUrl().equals("recordMetaSchemaUrl" + timeStamp));
    } catch (StatusRuntimeException sre) {
      throw sre;
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
  
  @Test(dependsOnMethods = {"createSubjectTest"})
  @Description("Get SubjectContext by specifying nonexistent subject id")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectTypeFromSubjectContextInstanceGraph() throws Exception {
    try {
      // null subject ID
      SubjectContext subjectContext = client.getSubjectContext(timeStamp);
      SubjectType subjectType = client.getSubjectTypeFromSubjectContextInstanceGraph(subjectContext, 0);
      assertTrue(subjectType.getId().equals(createdSubjectTypeId)
          && subjectType.getRecordSchemaUrl().equals("recordSchemaUrl" + timeStamp)
          && subjectType.getRecordMetaSchemaUrl().equals("recordMetaSchemaUrl" + timeStamp));
    } catch (StatusRuntimeException sre) {
      assertTrue(sre.getMessage().contains("UNKNOWN: subject not found"),
          "The Error message doesn't match with what we expect!!!");
    } catch (NullPointerException ne) {
      assertTrue(true);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
}
