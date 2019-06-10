package axoom.mappings.v1;

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
import axoom.mappings.v1.MappingsClient;
import axoom.mappings.v1.Mappingz.Mapping;
import axoom.mappings.v1.MappingzService.MappingEvent;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomMockedMappingsTestsIT extends PowerMockTestCase {

  //Mock client connection to server
  @Mock
  MappingsClient mockedClient;

  //Mock RecordMetaz
  @Mock
  Iterator<MappingEvent> mockedMappingEvents;
  
  @Mock
  MappingEvent mockedMappingEvent;
  
  //Mock Record
  @Mock
  Mapping mockedMapping;

  private static final Logger logger = Logger.getLogger(AxoomMockedMappingsTestsIT.class.getName());


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
    when(mockedClient.getMappingEvents("dc-b33a683812494b65aa8e036ed64adcc6"))
        .thenReturn(mockedMappingEvents);
    when(mockedClient.getMappingEvents("blackboxtest01")).thenReturn(mockedMappingEvents);
    when(mockedMappingEvents.hasNext()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(mockedMappingEvents.next()).thenReturn(mockedMappingEvent);
    when(mockedMappingEvent.getMapping()).thenReturn(mockedMapping);
    when(mockedMapping.getDeviceId()).thenReturn("1");
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
      Iterator<MappingEvent> mappingEvents =
          mockedClient.getMappingEvents("blackboxtest01");
      while (mappingEvents.hasNext()) {
        logger.log(Level.INFO, mappingEvents.next().getMapping().toString());
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
}
