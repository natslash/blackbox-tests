package axoom.recordmetas.v1;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.google.protobuf.ByteString;
import axoom.recordmetas.v1.RecordMetasClient;
import axoom.recordmetas.v1.Recordmetas.RecordMeta;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomMockedRecordMetasTestsIT extends PowerMockTestCase {

  // Mock client connection to server
  @Mock
  RecordMetasClient mockedClient;  

  // Mock Record
  @Mock
  RecordMeta mockedRecordMeta;

  ByteString mockedPayLoad = ByteString.copyFromUtf8("Mocked Payload Message");

  private static final Logger logger =
      Logger.getLogger(AxoomMockedRecordMetasTestsIT.class.getName());


  @BeforeClass
  public void beforeClass() {
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
    
    //Initialize Mock objects
    MockitoAnnotations.initMocks(this);
    
    // Specify to return mock objects
    when(mockedClient.getLatestRecordMeta("dc-b33a683812494b65aa8e036ed64adcc6"))
        .thenReturn(mockedRecordMeta);  
    when(mockedRecordMeta.getData()).thenReturn(mockedPayLoad);
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }


  @Test
  @Description("Get RecordMetaz preprocessed from getStream")
  @Severity(SeverityLevel.BLOCKER)
  public void getLatestRecordMeta() throws Exception {
    RecordMeta recordMetaz = null;
    try {
      recordMetaz = mockedClient.getLatestRecordMeta("dc-b33a683812494b65aa8e036ed64adcc6");
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED") && recordMetaz != null) {
        assertTrue(recordMetaz.getSubjectId().equals("dc-b33a683812494b65aa8e036ed64adcc6"));
      }
    } finally {
      mockedClient.shutdown();
    }
  }
}
