package axoom.mappings.v1;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.axoom.talos.framework.WebDriverTest;
import axoom.mappings.v1.Mappings.Expression;
import axoom.mappings.v1.Mappings.Expression.Type;
import axoom.mappings.v1.Mappings.Mapping;
import axoom.mappings.v1.MappingsService.ListMappingsResponse;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomMappingsPositiveTestsIT extends WebDriverTest {
  private String clientId;
  private String redirectUri;
  private String secret;
  private String cisUrl;
  private MappingsClient client;
  private Map<String, String> requestParams = new HashMap<>();
  private String preProcessingId = "axoom-devs/fission-machine01-temp3";
  private String randomPreProcessingId = null;
  private final String subjectId = "04f856a8-c686-422c-a721-95ba53b0d233";
  private final String deviceId = "d-b7f149c6438a4c7a84a81fcc4d71aeb2";

  private static final Logger logger =
      Logger.getLogger(AxoomMappingsPositiveTestsIT.class.getName());

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
    int length = 10;
    boolean useLetters = true;
    boolean useNumbers = true;
    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
    randomPreProcessingId = generatedString;

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
    client = new MappingsClient("mappings.dev.myaxoom.com", 443);
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }


  @Test
  @Description("Create a Mapping")
  @Severity(SeverityLevel.BLOCKER)
  public void createMappingTest() throws Exception {

    String expressionString = "{\"temperature2\": temp, \"timestamp2\": timestamp\"}";
    Expression expression =
        Expression.newBuilder().setExpressionString(expressionString).setType(Type.JSONATA).build();
    Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId(subjectId)
        .setDeviceId(deviceId).setPreprocessingId(randomPreProcessingId).build();

    try {
      Mapping createdMapping = client.createMapping(mapping);
      assertTrue(createdMapping.getSubjectId().equals(subjectId));
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingsWithDeviceAndPreProcessingIdsTest() throws Exception {
    try {
      ListMappingsResponse mappings =
          client.listMappingsWithDeviceAndPreProcessingIds(deviceId, preProcessingId);
      List<Mapping> mappingsList = mappings.getMappingsList();
      logger.log(Level.INFO, "Size of the list " + mappingsList.size());
      Iterator<Mapping> mappingsIterator = mappingsList.iterator();
      while (mappingsIterator.hasNext()) {
        Mapping mapping = mappingsIterator.next();
        assertTrue(mapping.getDeviceId().equals(deviceId));
      }
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingTestWithOnlyDeviceId() throws Exception {
    try {
      ListMappingsResponse mappings = client.listMappingsWithDeviceId(deviceId);

      List<Mapping> mappingsList = mappings.getMappingsList();
      logger.log(Level.INFO, "Size of the list " + mappingsList.size());
      Iterator<Mapping> mappingsIterator = mappingsList.iterator();
      while (mappingsIterator.hasNext()) {
        Mapping mapping = mappingsIterator.next();
        assertTrue(mapping.getDeviceId().equals(deviceId));
      }
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingTestWithOnlyPreProcessingId() throws Exception {
    try {
      ListMappingsResponse mappings = client.listMappingsWithPreProcessingId(preProcessingId);

      List<Mapping> mappingsList = mappings.getMappingsList();
      logger.log(Level.INFO, "Size of the list " + mappingsList.size());
      Iterator<Mapping> mappingsIterator = mappingsList.iterator();
      while (mappingsIterator.hasNext()) {
        Mapping mapping = mappingsIterator.next();
        assertTrue(mapping.getPreprocessingId().equals(preProcessingId));
      }
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingTestWithOnlySubjectId() throws Exception {
    try {
      ListMappingsResponse mappings = client.listMappingsWithSubjectId(subjectId);
      List<Mapping> mappingsList = mappings.getMappingsList();
      logger.log(Level.INFO, "Size of the list " + mappingsList.size());
      Iterator<Mapping> mappingsIterator = mappingsList.iterator();
      while (mappingsIterator.hasNext()) {
        Mapping mapping = mappingsIterator.next();
        assertTrue(mapping.getSubjectId().equals(subjectId));
      }
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingTest() throws Exception {
    try {
      ListMappingsResponse mappings = client.listMappings(deviceId, preProcessingId, subjectId);
      List<Mapping> mappingsList = mappings.getMappingsList();
      logger.log(Level.INFO, "Size of the list " + mappingsList.size());
      Iterator<Mapping> mappingsIterator = mappingsList.iterator();
      while (mappingsIterator.hasNext()) {
        Mapping mapping = mappingsIterator.next();
        assertTrue(mapping.getDeviceId().equals(deviceId));
      }
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }


  @Test(dependsOnMethods = {"createMappingTest"})
  @Description("Update a Mapping")
  @Severity(SeverityLevel.BLOCKER)
  public void updateMappingTest() throws Exception {
    String expressionString = "{\"temperature2upd\": temp, \"timestamp2upd\": timestamp\"}";
    Expression expression =
        Expression.newBuilder().setExpressionString(expressionString).setType(Type.JSONATA).build();
    Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId(subjectId)
        .setDeviceId(deviceId).setPreprocessingId(preProcessingId).build();

    try {
      Mapping createdMapping = client.createMapping(mapping);
      assertTrue(createdMapping.getExpression().getExpressionString().equals(expressionString));
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("UNKNOWN: Could not create record mapping. Mapping already exists.")) {
        Assert.assertTrue(true);
      } else {
        Assert.fail(sre.getLocalizedMessage());
        sre.printStackTrace();
      }
    } finally {
      client.shutdown();
    }
  }
}
