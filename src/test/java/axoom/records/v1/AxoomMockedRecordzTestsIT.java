package axoom.records.v1;

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
import com.google.protobuf.Timestamp;
import axoom.filters.v1.Filter.StringPropertyFilter;
import axoom.records.v1.Records.Record;
import axoom.records.v1.Records.RecordsSubscription;
import axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse;
import axoom.records.v1.RecordsService.RecordsSubscriptionsFilter;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomMockedRecordzTestsIT extends PowerMockTestCase {

  // Mock client connection to server
  @Mock
  RecordsClient mockedClient;

  // Mock QRecords
  @Mock
  Iterator<Record> mockedQRecords;

  // Mock Record
  @Mock
  RecordsSubscription mockedRecordSubscription;
  
  @Mock
  ListRecordsSubscriptionsResponse response;

  ByteString mockedPayLoad = ByteString.copyFromUtf8("Mocked Payload Message");

  Timestamp oneMinFromNow = null;
  StringPropertyFilter filterProperty = null;      
  RecordsSubscriptionsFilter filter = null;
  private static final Logger logger = Logger.getLogger(AxoomMockedRecordzTestsIT.class.getName());


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

    // Initialize Mock objects
    MockitoAnnotations.initMocks(this);

    // Specify to return mock objects
    oneMinFromNow =
        Timestamp.newBuilder().setSeconds(System.currentTimeMillis() + 1 * 60 * 1000).build();
    filterProperty =
        StringPropertyFilter.newBuilder().setValue("subjectTypeName").build();
    filter =
        RecordsSubscriptionsFilter.newBuilder().setSubjectTypeName(filterProperty).build();
    when(mockedClient.createRecordSubscription("1", "subjectTypeName", oneMinFromNow))
        .thenReturn(mockedRecordSubscription);
    when(mockedClient.listRecordsSubscriptions("subjectTypeName", filter)).thenReturn(response);
    when(mockedRecordSubscription.getSerializedSize()).thenReturn(1);
    when(response.getSerializedSize()).thenReturn(1);
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }


  @Test
  @Description("create a recordSubscription")
  @Severity(SeverityLevel.BLOCKER)
  public void createRecordSubscriptionTest() throws Exception {
    int size = 0;

    try {
      RecordsSubscription recSub =
          mockedClient.createRecordSubscription("1", "subjectTypeName", oneMinFromNow);
      size = recSub.getSerializedSize();
      logger.log(Level.INFO, "Size of Record subscription " + size);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        if (size > 0)
          Assert.assertTrue(true);
      } else {
        Assert.fail(sre.getMessage());        
      }
    } finally {
      mockedClient.shutdown();
    }
  }


  @Test

  @Description("list Record subscriptions")

  @Severity(SeverityLevel.BLOCKER)
  public void listRecordSubscriptions() throws Exception {
    int size = 0;
    StringPropertyFilter filterProperty =
        StringPropertyFilter.newBuilder().setValue("subjectTypeName").build();
    RecordsSubscriptionsFilter filter =
        RecordsSubscriptionsFilter.newBuilder().setSubjectTypeName(filterProperty).build();
    try {
      ListRecordsSubscriptionsResponse recSubList =
          mockedClient.listRecordsSubscriptions("subjectTypeName", filter);
      size = recSubList.getSerializedSize();
      logger.log(Level.INFO, "Number of Records " + size);
    } catch (StatusRuntimeException sre) {
      if (size == 1 && sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        Assert.assertTrue(true);
      } else {
        Assert.fail(sre.getMessage());
      }
    } finally {
      mockedClient.shutdown();
    }
  }


}
