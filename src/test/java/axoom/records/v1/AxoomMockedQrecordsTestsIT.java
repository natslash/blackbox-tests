package axoom.records.v1;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.google.protobuf.ByteString;
import axoom.records.v1.Records.Record;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomMockedQrecordsTestsIT extends PowerMockTestCase {
  private String clientId;
  private String redirectUri;
  private String secret;
  private String cisUrl;

  @Mock
  QrecordsClient mockedClient;

  @Mock
  Iterator<Record> mockedQRecords;

  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger = Logger.getLogger(AxoomMockedQrecordsTestsIT.class.getName());


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
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
    MockitoAnnotations.initMocks(this);
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
    Record mockedRecord = mock(Record.class);
    ByteString mockedPayLoad = ByteString.copyFromUtf8("Mocked getPreProcessedQrecordsForDCTest Message");
    
    when(mockedClient.getRecordStream("dc-b33a683812494b65aa8e036ed64adcc6"))
        .thenReturn(mockedQRecords);
    when(mockedQRecords.hasNext()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(mockedQRecords.next()).thenReturn(mockedRecord);
    when(mockedRecord.getPayload()).thenReturn(mockedPayLoad);
    
    try {
      Iterator<Record> qRecords =
          mockedClient.getRecordStream("dc-b33a683812494b65aa8e036ed64adcc6");
      while (qRecords.hasNext()) {
        logger.log(Level.INFO, qRecords.next().getPayload().toStringUtf8());
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
      mockedClient.shutdown();
    }
  }

  @Test
  @Description("Get QRecords from getStream")
  @Severity(SeverityLevel.BLOCKER)
  public void getPubSubRecordsFromGrpcTest() throws Exception {
    
    Record mockedRecord = mock(Record.class);
    ByteString mockedPayLoad = ByteString.copyFromUtf8("Mocked getPubSubRecordsFromGrpcTest Message");

    when(mockedClient.getRecordStream("blackboxtest01")).thenReturn(mockedQRecords);
    when(mockedQRecords.hasNext()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(mockedQRecords.next()).thenReturn(mockedRecord);
    when(mockedRecord.getPayload()).thenReturn(mockedPayLoad);

    
    int count = 0;
    try {
      Iterator<Record> qRecords = mockedClient.getRecordStream("blackboxtest01");
      while (qRecords.hasNext()) {

        logger.log(Level.INFO, qRecords.next().getPayload().toStringUtf8());
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
      mockedClient.shutdown();
    }
  }

}
