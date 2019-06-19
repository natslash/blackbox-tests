package axoom.subjects.v1;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.HashMap;
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
import axoom.subjects.v1.Subjects.Subject;
import axoom.subjects.v1.Subjects.SubjectType;
import axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomSubjectsPositiveTestsIT extends WebDriverTest {
  private String timeStamp;
  private String originalSubjectName;
  private String updatedSubjectName;
  private String recordSchemaUrl;
  private String recordMetaSchemaUrl;
  private String clientId;
  private String redirectUri;
  private String secret;
  private String cisUrl;
  private SubjectsClient client;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger =
      Logger.getLogger(AxoomSubjectsPositiveTestsIT.class.getName());  
  private String createdSubjectId = null;

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
    originalSubjectName = "FirstSubject" + timeStamp;
    updatedSubjectName = "updatedSubject" + timeStamp;
    recordSchemaUrl = "recordSchemaUrl" + timeStamp;
    recordMetaSchemaUrl = "recordMetaSchemaUrl" + timeStamp;
    createdSubjectId = "Subject" + timeStamp;
    
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
    client = new SubjectsClient("subjects.dev.myaxoom.com", 443);
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }

  @Test(dependsOnMethods = {"createSubjectTypeWithoutExtendsTest"})
  @Description("Create Subject")
  @Severity(SeverityLevel.BLOCKER)
  public void createSubjectTest() throws Exception {
    Map<String, String> labels = new HashMap<>();
    labels.put("label-" + createdSubjectId, "value-" + createdSubjectId);
    try {
      Subject createdSubject = client.createSubject(createdSubjectId, createdSubjectId + "implements", labels);
      assertTrue(createdSubject.getName().equals(createdSubjectId));
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
      Subject subject = client.getSubject(timeStamp);
      logger.log(Level.INFO, subject.getId());
      assertTrue(
          subject.getId().equals(createdSubjectId) && subject.getName().equals(originalSubjectName));
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"createSubjectTest"})
  @Description("Update a Subject")
  @Severity(SeverityLevel.BLOCKER)
  public void updateSubjectTest() throws Exception {
    String subjectId = client.getSubject(timeStamp).getId();
    Subject subject = Subject.newBuilder().setId(subjectId).setName(updatedSubjectName).build();
    try {
      Subject updatedSubject = client.updateSubject(subject);
      assertTrue(updatedSubject.getId().equals(timeStamp));
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"createSubjectTest"})
  @Description("Update a Subject")
  @Severity(SeverityLevel.BLOCKER)
  public void updateSubjectWithoutNameTest() throws Exception {
    String subjectId = client.getSubject(timeStamp).getId();
    Subject subject = Subject.newBuilder().setId(subjectId).build();
    try {
      Subject updatedSubject = client.updateSubject(subject);
      assertTrue(updatedSubject.getId().equals(timeStamp));
    } catch (StatusRuntimeException sre) {
      assertTrue(sre.getMessage().equals("INVALID_ARGUMENT: subject name not specified"));
    } finally {
      client.shutdown();
    }
  }
}
