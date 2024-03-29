package axoom.subjects.v1;

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
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomSubjectsNegativeTestsIT extends WebDriverTest {  
  private String clientId;
  private String redirectUri;
  private String secret;
  private String cisUrl;
  private SubjectsClient client;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger =
      Logger.getLogger(AxoomSubjectsNegativeTestsIT.class.getName());
  private String createdSubjectTypeId = null;
  Map<String, String> labels = new HashMap<>();


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
    labels.put("label", "labelValue");
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
    client = new SubjectsClient("subjects.dev.myaxoom.com", 443, "");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }


  @Test(dependsOnMethods = {"createSubjectTypeTest"})
  @Description("Try Creating a Subject without ID")
  @Severity(SeverityLevel.BLOCKER)
  public void createSubjectWithoutIdTest() throws Exception {
    try {
      client.createSubject("FirstSubject", createdSubjectTypeId, labels);
    } catch (StatusRuntimeException sre) {
      assertTrue(sre.getMessage().contains("INVALID_ARGUMENT: subject id not specified"),
          "The Error message doesn't match with what we expect!!!");
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }


  @Test(dependsOnMethods = {"createSubjectTypeTest"})
  @Description("Try Creating a Subject without Name")
  @Severity(SeverityLevel.BLOCKER)
  public void createSubjectWithoutNameTest() throws Exception {
    try {
      client.createSubject(null, createdSubjectTypeId, labels);
    } catch (StatusRuntimeException sre) {
      assertTrue(sre.getMessage().contains("INVALID_ARGUMENT: subject name not specified"),
          "The Error message doesn't match with what we expect!!!");
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }


  @Test
  @Description("Update a Subject")
  @Severity(SeverityLevel.BLOCKER)
  public void updateNonExistentSubject() throws Exception {
    Subject subject = Subject.newBuilder().setId("z").setName("Noname").build();
    try {
      client.updateSubject(subject, "name");
    } catch (StatusRuntimeException sre) {
      assertTrue(sre.getMessage().equals("UNKNOWN: subject z not found"));
    } finally {
      client.shutdown();
    }
  }

}
