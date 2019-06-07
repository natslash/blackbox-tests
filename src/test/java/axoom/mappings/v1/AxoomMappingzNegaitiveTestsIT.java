package axoom.mappings.v1;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.HashMap;
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
import axoom.mappings.v1.MappingzClient;
import axoom.mappings.v1.Mappingz.Expression;
import axoom.mappings.v1.Mappingz.Mapping;
import axoom.mappings.v1.Mappingz.Expression.Type;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomMappingzNegaitiveTestsIT extends WebDriverTest {
  private String clientId;
  private String redirectUri;
  private String secret;
  private String cisUrl;
  private MappingzClient client;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger =
      Logger.getLogger(AxoomMappingzNegaitiveTestsIT.class.getName());
  private final String subjectId = "04f856a8-c686-422c-a721-95ba53b0d233";
  private final String deviceId = "d-25368c9089bb4a3986030386b4ac6e6e";
  private final String sensorId = "123"; 

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
    client = new MappingzClient("mappings.dev.myaxoom.com", 443);
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }

  @Test
  @Description("Create a Mapping with invalid expression string")
  @Severity(SeverityLevel.BLOCKER)
  public void createMappingWithInvalidExpressionTest() throws Exception {

    try {
      String expressionString = "Invalid Expression";
      Expression expression = Expression.newBuilder().setExpressionString(expressionString)
          .setType(Type.JSONATA).build();
      Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId(subjectId)
          .setDeviceId(deviceId).setSensorId(sensorId).build();

      client.createMapping(mapping);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("Mapping Expression is not valid")) {
        Assert.assertTrue(true);
      } else {
        throw sre;
      }
    } finally {
      client.shutdown();
    }
  }

  @Test
  @Description("Create a Mapping with invalid expression string")
  @Severity(SeverityLevel.BLOCKER)
  public void createMappingWithNullDeviceIdTest() throws Exception {

    try {
      String expressionString = "{\"temperature2\": temp, \"timestamp2\": timestamp\"}";
      Expression expression = Expression.newBuilder().setExpressionString(expressionString)
          .setType(Type.JSONATA).build();
      Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId(subjectId)
          .setDeviceId(null).build();

      client.createMapping(mapping);
    } catch (NullPointerException npe) {
      Assert.assertTrue(true);
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("Create a Mapping with invalid expression string")
  @Severity(SeverityLevel.BLOCKER)
  public void createMappingWithNullSensorIdTest() throws Exception {

    try {
      String expressionString = "{\"temperature2\": temp, \"timestamp2\": timestamp\"}";
      Expression expression = Expression.newBuilder().setExpressionString(expressionString)
          .setType(Type.JSONATA).build();
      Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId(subjectId)
          .setDeviceId(deviceId).setSensorId(null).build();

      client.createMapping(mapping);
    } catch (NullPointerException npe) {
      Assert.assertTrue(true);
    } finally {
      client.shutdown();
    }
  }

  @Test
  @Description("Create a Mapping with invalid expression string")
  @Severity(SeverityLevel.BLOCKER)
  public void createMappingWithNullSubjectIdTest() throws Exception {

    try {
      String expressionString = "{\"temperature2\": temp, \"timestamp2\": timestamp\"}";
      Expression expression = Expression.newBuilder().setExpressionString(expressionString)
          .setType(Type.JSONATA).build();
      Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId(null)
          .setDeviceId(deviceId).setSensorId(sensorId).build();

      client.createMapping(mapping);
    } catch (NullPointerException npe) {
      Assert.assertTrue(true);
    } finally {
      client.shutdown();
    }
  }

  @Test
  @Description("Try getting a non existent mapping")
  @Severity(SeverityLevel.BLOCKER)
  public void getNonExistentMappingTest() throws Exception {
    try {
      client.getMapping(deviceId, sensorId);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("NOT_FOUND: could not find mapping with id: xyz")) {
        assertTrue(true);
      }

      else {
        Assert.fail("Error message doesn't match with expected value " + sre.getMessage());
      }
    } finally {
      client.shutdown();
    }
  }

  @Test
  @Description("Try getting by using null as mapping Id")
  @Severity(SeverityLevel.BLOCKER)
  public void getMappingByNullMappingIdTest() throws Exception {
    try {
      Mapping mapping = client.getMapping(null, null);
      assertTrue(mapping == null);
    } catch (NullPointerException npe) {
      assertTrue(true);
    } finally {
      client.shutdown();
    }
  }  
  
  @Test
  @Description("Get All mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void getAllMappingsWithNegativeOffsetValueTest() throws Exception {
    try {
      List<Mapping> mappings = client.getMappingsList(0, -1);
      assertTrue(mappings == null);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains(
          "LIMIT offset value is not a number or out of range (while instantiating plan)")) {
        assertTrue(true);
      } else {
        Assert.fail("Error message doesn't match with expected value " + sre.getMessage());
      }
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("Get All mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void getAllMappingsWithNegativeCountValueTest() throws Exception {
    try {
      List<Mapping> mappings = client.getMappingsList(-1, 0);
      assertTrue(mappings == null);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains(
          "LIMIT count value is not a number or out of range (while instantiating plan)")) {
        assertTrue(true);
      } else {
        Assert.fail("Error message doesn't match with expected value " + sre.getMessage());
      }
    } finally {
      client.shutdown();
    }
  }
}
