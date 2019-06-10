package axoom.mappings.v1;

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
import axoom.mappings.v1.Mappings.Expression;
import axoom.mappings.v1.Mappings.Expression.Type;
import axoom.mappings.v1.Mappings.Mapping;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomMappingsNegaitiveTestsIT extends WebDriverTest {
  private String clientId;
  private String redirectUri;
  private String secret;
  private String cisUrl;
  private MappingsClient client;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger =
      Logger.getLogger(AxoomMappingsNegaitiveTestsIT.class.getName());
  private final String subjectId = "04f856a8-c686-422c-a721-95ba53b0d233";
  private final String deviceId = "d-25368c9089bb4a3986030386b4ac6e6e";  

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
  @Description("Create a Mapping with invalid expression string")
  @Severity(SeverityLevel.BLOCKER)
  public void createMappingWithInvalidExpressionTest() throws Exception {

    try {
      String expressionString = "Invalid Expression";
      Expression expression = Expression.newBuilder().setExpressionString(expressionString)
          .setType(Type.JSONATA).build();
      Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId(subjectId)
          .setDeviceId(deviceId).build();

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
  public void createMappingWithNullSubjectIdTest() throws Exception {

    try {
      String expressionString = "{\"temperature2\": temp, \"timestamp2\": timestamp\"}";
      Expression expression = Expression.newBuilder().setExpressionString(expressionString)
          .setType(Type.JSONATA).build();
      Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId(null)
          .setDeviceId(deviceId).build();

      client.createMapping(mapping);
    } catch (NullPointerException npe) {
      Assert.assertTrue(true);
    } finally {
      client.shutdown();
    }
  }  
}
