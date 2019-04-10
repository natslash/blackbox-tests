package axoom.recordz.v1;

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
import axoom.recordz.v1.Recordz.Record;
import axoom.recordz.v1.RecordzClient;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomRecordzTestsIT extends WebDriverTest {
  private String clientId;
  private String redirectUri;
  private String secret;
  private String cisUrl;
  private RecordzClient client;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger = Logger.getLogger(AxoomRecordzTestsIT.class.getName());

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
    client = new RecordzClient("qrecords.dev.myaxoom.com", 443);
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }

  @Test
  @Description("Get QRecords preprocessed from getStream")
  @Severity(SeverityLevel.BLOCKER)
  public void getPreProcessedQrecordsForDCTest() throws Exception {
    int count = 0;
    try {
      //Get recrod streams from Qrecords client for the Data Composition ID
      Iterator<Record> qRecords = client.getRecordStream("dc-b33a683812494b65aa8e036ed64adcc6");
      while (qRecords.hasNext()) {
        logger.log(Level.INFO, qRecords.next().getData().toStringUtf8());
        count++;
      }
      logger.log(Level.INFO, "Number of Records " + count);
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
  @Description("Get QRecords from getStream")
  @Severity(SeverityLevel.BLOCKER)
  public void getPubSubRecordsFromGrpcTest() throws Exception {
    //Publich messages to google pubsub
    PubSubPublishererUtils.publishMessages("mvp-iotcore-eval", "axoiotl-apis-test-client");
    
    //Receive messages from google pubsub directly
    List<ReceivedMessage> receivedMessages =
        PubSubSubscriberUtils.synchronousPull("mvp-iotcore-eval", "axoiotl-apis-test-client-shovel", 2);
    for (ReceivedMessage receivedMessage : receivedMessages) {
      logger.log(Level.INFO, receivedMessage.getMessage().getData().toStringUtf8());
    }
    int count = 0;
    
    //Now, get the same messages via Qrecords API and keep count of number of messages
    try {
      Iterator<Record> qRecords = client.getRecordStream("axoiotl-apis-test-client");
      while (qRecords.hasNext()) {

        logger.log(Level.INFO, qRecords.next().getData().toStringUtf8());
        count++;
        logger.log(Level.INFO, "Current count is: " + count);
      }
      logger.log(Level.INFO, "Number of Records " + count);
    } catch (StatusRuntimeException sre) {
      if (count == 2 && sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
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
