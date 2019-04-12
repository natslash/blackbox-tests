package axoom.subjectz.v1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.axoom.talos.framework.WebDriverTest;
import com.google.pubsub.v1.ReceivedMessage;
import axoom.recordz.v1.PubSubPublishererUtils;
import axoom.recordz.v1.PubSubSubscriberUtils;
import axoom.subjectz.v1.Subjectz.Subject;
import axoom.subjectz.v1.Subjectz.SubjectType;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomSubjectzTestsIT extends WebDriverTest {
  private String clientId;
  private String redirectUri;
  private String secret;
  private String cisUrl;
  private SubjectzClient client;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger = Logger.getLogger(AxoomSubjectzTestsIT.class.getName());

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

    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
    logger.log(Level.INFO, "Working Directory = " + System.getProperty("user.dir"));
  }

  @BeforeMethod
  public void beforeMethod() {
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    //Create Client and establish connection to the server
    client = new SubjectzClient("qrecords.dev.myaxoom.com", 443);
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }

  @Test
  @Description("Get Subjectz preprocessed from getStream")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectId() throws Exception {
    int count = 0;
    try {
      //Get recrod streams from Qrecords client for the Data Composition ID
      Iterator<Subject> qSubjectz = client.getAllSubjectz("1").iterator();
      while (qSubjectz.hasNext()) {
        logger.log(Level.INFO, qSubjectz.next().getId());
        count++;
      }
      logger.log(Level.INFO, "Number of Subjectz " + count);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        if (count > 0)
          Assert.assertTrue(true);
      } else {
        Assert.fail("Error occurred!");
        sre.printStackTrace();
      }
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("Get Subjectz preprocessed from getStream")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectName() throws Exception {
    int count = 0;
    try {
      //Get recrod streams from Qrecords client for the Data Composition ID
      Iterator<Subject> qSubjectz = client.getAllSubjectz("1").iterator();
      while (qSubjectz.hasNext()) {
        logger.log(Level.INFO, qSubjectz.next().getName());
        count++;
      }
      logger.log(Level.INFO, "Number of Subjectz " + count);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        if (count > 0)
          Assert.assertTrue(true);
      } else {
        Assert.fail("Error occurred!");
        sre.printStackTrace();
      }
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("Get Subjectz preprocessed from getStream")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectNameByte() throws Exception {
    int count = 0;
    try {
      //Get recrod streams from Qrecords client for the Data Composition ID
      Iterator<Subject> qSubjectz = client.getAllSubjectz("1").iterator();
      while (qSubjectz.hasNext()) {
        logger.log(Level.INFO, qSubjectz.next().getNameBytes().toStringUtf8());
        count++;
      }
      logger.log(Level.INFO, "Number of Subjectz " + count);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        if (count > 0)
          Assert.assertTrue(true);
      } else {
        Assert.fail("Error occurred!");
        sre.printStackTrace();
      }
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("Get Subjectz preprocessed from getStream")
  @Severity(SeverityLevel.BLOCKER)
  public void createSubjectTest() throws Exception {
    int count = 0;
    Subject subject = Subject.newBuilder().setId("1").setName("FirstSubject").build();
    try {
      client.createSubject(subject);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        if (count > 0)
          Assert.assertTrue(true);
      } else {
        Assert.fail("Error occurred!");
        sre.printStackTrace();
      }
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("Get Subjectz preprocessed from getStream")
  @Severity(SeverityLevel.BLOCKER)
  public void createSubjectTypeTest() throws Exception {
    int count = 0;
    SubjectType subjectType = SubjectType.newBuilder().setId("1").setRecordSchemaUrl("recordSchemaUrl").setRecordMetaSchemaUrl("recordMetaSchemaUrl").build();
    try {
      client.createSubjectType(subjectType);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        if (count > 0)
          Assert.assertTrue(true);
      } else {
        Assert.fail("Error occurred!");
        sre.printStackTrace();
      }
    } finally {
      client.shutdown();
    }
  }
}
