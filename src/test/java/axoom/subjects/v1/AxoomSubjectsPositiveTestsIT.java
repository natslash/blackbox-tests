package axoom.subjects.v1;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.axoom.talos.framework.WebDriverTest;
import axoom.subjects.v1.Subjects.Subject;
import axoom.subjects.v1.Subjects.SubjectContext;
import axoom.subjects.v1.SubjectsService.ListSubjectsResponse;
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
  private String accessTokenFromCodeFlow;
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
  public void beforeClass(ITestContext context) {
    clientId = System.getenv("SRS_CLIENT_ID");
    redirectUri = System.getenv("SRS_REDIRECT_URI");
    cisUrl = System.getenv("CIS_URL");
    secret = System.getenv("SECRET");
    accessTokenFromCodeFlow = (String) context.getAttribute("accessTokenFromCodeFlow");
    requestParams.put("clientId", clientId);
    requestParams.put("redirectUri", redirectUri);
    requestParams.put("cisUrl", cisUrl);
    requestParams.put("secret", secret);
    timeStamp = Long.toString(System.currentTimeMillis());
    originalSubjectName = "subject" + timeStamp;
    updatedSubjectName = "updatedSubject" + timeStamp;    
    
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
    logger.log(Level.INFO, "accessTokenFromCodeFlow = " + accessTokenFromCodeFlow);
    logger.log(Level.INFO, "Working Directory = " + System.getProperty("user.dir"));
  }

  @BeforeMethod
  public void beforeMethod() {
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    // Create Client and establish connection to the server
    client = new SubjectsClient("subjects.dev.myaxoom.com", 443, accessTokenFromCodeFlow);
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }

  @Test (dependsOnGroups = {"subjects"})
  @Description("Create Subject")
  @Severity(SeverityLevel.BLOCKER)
  public void createSubjectTest(ITestContext context) throws Exception {
    Map<String, String> labels = new HashMap<>();
    labels.put("label-" + originalSubjectName, "value-" + originalSubjectName);
    String subjectTypeName = (String) context.getAttribute("subjectTypeName");
    try {
      Subject createdSubject = client.createSubject(originalSubjectName, subjectTypeName, labels);
      createdSubjectId = createdSubject.getId();
      logger.log(Level.INFO, "Subject created with ID: " + createdSubjectId + " , Name: " + createdSubject.getName());
      assertTrue(createdSubject.getName().equals(originalSubjectName));
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
  
  @Test (dependsOnMethods = {"createSubjectTest"})
  @Description("List Subjects with name filter")
  @Severity(SeverityLevel.BLOCKER)
  public void listSubjectsWithNameFilterTest(ITestContext context) throws Exception {
    int count = 0;
    try {      
      ListSubjectsResponse subjectsReponse = client.listSubjectsWithNameFilter(originalSubjectName);
      List<Subject> subjectsList = subjectsReponse.getSubjectsList();
      for (Subject subject : subjectsList) {
        if(subject.getName().equals(originalSubjectName)) { //this should be originalSubjectName
          count++;
        }
      }
      
      assertTrue(count > 0);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
  
  @Test (dependsOnMethods = {"createSubjectTest"})
  @Description("List Subjects without filter")
  @Severity(SeverityLevel.BLOCKER)
  public void listSubjectsWithoutFilterTest(ITestContext context) throws Exception {
    int count = 0;
    try {      
      ListSubjectsResponse subjectsReponse = client.listSubjectsWithoutFilter();
      List<Subject> subjectsList = subjectsReponse.getSubjectsList();
      for (Subject subject : subjectsList) {
        if(subject.getName().equals(originalSubjectName)) {
          count++;
        }
      }
      
      assertTrue(count > 0);
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
      Subject subject = client.getSubject(createdSubjectId);
      logger.log(Level.INFO, subject.getId());
      assertTrue(
          subject.getId().equals(createdSubjectId) && subject.getName().equals(originalSubjectName));
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
  
  /**
   * 
   * @throws Exception
   */
  @Test(dependsOnMethods = {"createSubjectTest"})
  @Description("Get Subject context by it's ID")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectContextById() throws Exception {
    try {
      SubjectContext subjectContext = client.getSubjectContext(createdSubjectId);
      logger.log(Level.INFO, "Subject Context's subject ID: " + subjectContext.getSubject().getId());
      logger.log(Level.INFO, "Subject Context's Implementation Graph count: " + subjectContext.getImplementationGraphCount());
      assertTrue(
          subjectContext.getImplementationGraphList().size() > 0);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"listSubjectsWithoutFilterTest"})
  @Description("Update a Subject")
  @Severity(SeverityLevel.BLOCKER)
  public void updateSubjectTest() throws Exception {
    String subjectId = client.getSubject(createdSubjectId).getId();
    Subject subject = Subject.newBuilder().setId(subjectId).setName(updatedSubjectName).build();
    try {
      Subject updatedSubject = client.updateSubject(subject, "name");
      assertTrue(updatedSubject.getId().equals(createdSubjectId));
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"listSubjectsWithoutFilterTest"})
  @Description("Update a Subject")
  @Severity(SeverityLevel.BLOCKER)
  public void updateSubjectWithoutNameTest() throws Exception {
    String subjectId = client.getSubject(createdSubjectId).getId();
    Subject subject = Subject.newBuilder().setId(subjectId).build();
    try {
      Subject updatedSubject = client.updateSubject(subject, "name");
      assertTrue(updatedSubject.getId().equals(createdSubjectId));
    } catch (StatusRuntimeException sre) {
      logger.log(Level.INFO, "updateSubjectWithoutNameTest: " + sre.getLocalizedMessage());
      assertTrue(sre.getMessage().equals("INVALID_ARGUMENT: subject name not specified"));
    } finally {
      client.shutdown();
    }
  }
}
