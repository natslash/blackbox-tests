package axoom.recordmetas.v1;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import java.io.IOException;
import java.util.HashMap;
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
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import axoom.recordmetas.v1.RecordMetasClient;
import axoom.recordmetas.v1.Recordmetas.RecordMeta;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomRecordMetasTestsIT extends WebDriverTest {
  private String clientId;
  private String redirectUri;
  private String secret;
  private String cisUrl;
  private RecordMetasClient client;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger = Logger.getLogger(AxoomRecordMetasTestsIT.class.getName());

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
    // Create Client and establish connection to the server
    client = new RecordMetasClient("recordmetas.dev.myaxoom.com", 443);
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }

  @Test
  @Description("Create RecordMeta")
  @Severity(SeverityLevel.BLOCKER)
  public void createRecordMetaTest() throws Exception {
    RecordMeta recordMeta = RecordMeta.newBuilder().setId("1").setSubjectId("dc-b33a683812494b65aa8e036ed64adcc6")
        .setData(ByteString.copyFromUtf8("Example Data")).build();

    // Create a RecordMeta via API
    try {
      RecordMeta response = client.createRecordMeta(recordMeta);
      Timestamp timeStamp = response.getTimestamp();
      System.out.println("TimeStamp: " + timeStamp.toString());
      System.out.println("Id: " + response.getIdBytes().toStringUtf8());
      System.out.println("Subject Id: " + response.getSubjectId());
      System.out.println("Data: " + response.getData().toStringUtf8());
      assertTrue(response.getSerializedSize() > 0);
    } catch (StatusRuntimeException sre) {
      fail(sre.getMessage());
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"createRecordMetaTest"})
  @Description("Get Latest RecordMeta")
  @Severity(SeverityLevel.BLOCKER)
  public void getRecordMetaTest() throws Exception {
    // Now, get the same RecordMeta
    try {
      RecordMeta recordMeta = client.getLatestRecordMeta("1");
      Timestamp timeStamp = recordMeta.getTimestamp();
      System.out.println("TimeStamp: " + timeStamp);
      System.out.println("Id: " + recordMeta.getIdBytes().toStringUtf8());
      System.out.println("Subject Id: " + recordMeta.getSubjectId());
      System.out.println("Data: " + recordMeta.getData().toStringUtf8());
      assertTrue(recordMeta.getSubjectId().equals("1"));
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        Assert.assertTrue(true);
      } else {
        Assert.fail("Error occurred!");
        sre.printStackTrace();
      }
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"createRecordMetaTest"})
  @Description("Get Latest RecordMeta")
  @Severity(SeverityLevel.BLOCKER)
  public void getRecordMetaWithInvalidSubjectIdTest() throws Exception {
    // Now, get the same RecordMeta
    try {
      client.getLatestRecordMeta("2");
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("NOT_FOUND: could not retrieve latest recordmeta: no recordmeta found: document not found")) {
        Assert.assertTrue(true);
      } else {
        Assert.fail("Error occurred!");
        sre.printStackTrace();
      }
    }
  }
  

  

  @Test
  @Description("Create RecordMeta without Data")
  @Severity(SeverityLevel.BLOCKER)
  public void createRecordMetaWithoutDataTest() throws Exception {
    RecordMeta recordMeta = RecordMeta.newBuilder().setSubjectId("1").build();

    // Try to create a RecordMeta without data
    RecordMeta response = client.createRecordMeta(recordMeta);
    assertTrue(response.getData().toStringUtf8().isEmpty() == true);
  }

  @Test
  @Description("Create RecordMeta without subjectID")
  @Severity(SeverityLevel.BLOCKER)
  public void createRecordMetaWithoutSubjectIdTest() throws Exception {
    RecordMeta recordMeta =
        RecordMeta.newBuilder().setData(ByteString.copyFromUtf8("Example Data")).build();
    try {
      // Try to create a RecordMeta without subject Id
      client.createRecordMeta(recordMeta);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("INVALID_ARGUMENT: subjectID not set")) {
        logger.log(Level.INFO, "RPC failed: {0}", sre.getMessage());
        Assert.assertTrue(true);
      } else {
        logger.log(Level.SEVERE, "RPC failed: {0}", sre.getStatus());
        Assert.fail("Error occurred!");
      }
    }
  }
}
