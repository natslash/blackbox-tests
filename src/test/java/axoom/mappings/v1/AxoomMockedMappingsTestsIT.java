package axoom.mappings.v1;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import axoom.mappings.v1.Mappings.Mapping;
import axoom.mappings.v1.MappingsService.ListMappingsResponse;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomMockedMappingsTestsIT extends PowerMockTestCase {

  // Mock client connection to server
  @Mock
  MappingsClient mockedClient;

  // Mock ListMappingsResponse
  @Mock
  ListMappingsResponse mappingsResponse;

  @Mock
  List<Mapping> mappingsList = new ArrayList<>();

  @Mock
  Iterator<Mapping> mappIterator;

  // Mock Mapping
  @Mock
  Mapping mockedMapping;

  private static final Logger logger = Logger.getLogger(AxoomMockedMappingsTestsIT.class.getName());


  @BeforeClass
  public void beforeClass() {
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
    logger.log(Level.INFO, "Working Directory = " + System.getProperty("user.dir"));
    mappingsList.add(mockedMapping);
  }

  @BeforeMethod
  public void beforeMethod() {
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());

    // Initialize Mock objects
    MockitoAnnotations.initMocks(this);
    when(mockedClient.createMapping(mockedMapping)).thenReturn(mockedMapping);
    when(mockedClient.listMappings("1", "preprocessingId")).thenReturn(mappingsResponse);
    when(mappingsResponse.getMappingsList()).thenReturn(mappingsList);
    when(mappingsList.iterator()).thenReturn(mappIterator);
    when(mappIterator.hasNext()).thenReturn(true).thenReturn(false);
    when(mappIterator.next()).thenReturn(mockedMapping);
    when(mockedMapping.getDeviceId()).thenReturn("1");
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }

  @Test
  @Description("Create a mapping")
  @Severity(SeverityLevel.BLOCKER)
  public void createMappingTest() throws Exception {

    try {
      Mapping mapping = mockedClient.createMapping(mockedMapping);
      assertTrue(mapping.getDeviceId().equals("1"));
    } catch (StatusRuntimeException sre) {
      throw sre;
    } finally {
      mockedClient.shutdown();
    }
  }


  @Test
  @Description("List all mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingsTest() throws Exception {
    int count = 0;

    try {
      ListMappingsResponse mappings = mockedClient.listMappings("1", "preprocessingId");
      List<Mapping> mapList = mappings.getMappingsList();
      Iterator<Mapping> mappingIterator = mapList.iterator();
      while (mappingIterator.hasNext()) {
        Mapping mapping = mappingIterator.next();
        if (mapping.getDeviceId().equals("1")) {
          count++;
        }
      }
      logger.log(Level.INFO, "Number of Records " + count);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        if (count > 0)
          Assert.assertTrue(true);
      } else {
        throw sre;
      }
    } finally {
      mockedClient.shutdown();
    }
  }
}
