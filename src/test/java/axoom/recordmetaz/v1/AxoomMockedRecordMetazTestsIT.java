package axoom.recordmetaz.v1;

import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.Iterator;
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
import axoom.recordmetaz.v1.RecordMetasClient;
import axoom.recordmetaz.v1.Recordmetaz.RecordMeta;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomMockedRecordMetazTestsIT extends PowerMockTestCase {

  //Mock client connection to server
  @Mock
  RecordMetasClient mockedClient;

  //Mock RecordMetaz
  @Mock
  Iterator<RecordMeta> mockedRecordMetaz;
  
  //Mock Record
  @Mock
  RecordMeta mockedRecord;

  ByteString mockedPayLoad = ByteString.copyFromUtf8("Mocked Payload Message");

  private static final Logger logger = Logger.getLogger(AxoomMockedRecordMetazTestsIT.class.getName());


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
    when(mockedClient.getRecordMetaStream("dc-b33a683812494b65aa8e036ed64adcc6"))
        .thenReturn(mockedRecordMetaz);
    when(mockedClient.getRecordMetaStream("blackboxtest01")).thenReturn(mockedRecordMetaz);
    when(mockedRecordMetaz.hasNext()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(mockedRecordMetaz.next()).thenReturn(mockedRecord);
    when(mockedRecord.getData()).thenReturn(mockedPayLoad);
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
  public void getMockedRecordMetaStreamTestIT() throws Exception {
    int count = 0;
    
    try {
      Iterator<RecordMeta> recordMetaz =
          mockedClient.getRecordMetaStream("dc-b33a683812494b65aa8e036ed64adcc6");
      while (recordMetaz.hasNext()) {
        logger.log(Level.INFO, recordMetaz.next().getData().toStringUtf8());
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
  @Description("Get RecordMetaz from getStream")
  @Severity(SeverityLevel.BLOCKER)
  public void getMockedRecordMetazTestIT() throws Exception {
    int count = 0;
    
    try {
      Iterator<RecordMeta> recordMetaz = mockedClient.getRecordMetaStream("blackboxtest01");
      while (recordMetaz.hasNext()) {

        logger.log(Level.INFO, recordMetaz.next().getData().toStringUtf8());
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
