package axoom.mappingz.v1;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
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
import axoom.mappingz.v1.Mappingz.Expression;
import axoom.mappingz.v1.Mappingz.Expression.Type;
import axoom.mappingz.v1.Mappingz.Mapping;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomMappingzPositiveTestsIT extends WebDriverTest {
  private String clientId;
  private String redirectUri;
  private String secret;
  private String cisUrl;
  private MappingzClient client;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger = Logger.getLogger(AxoomMappingzPositiveTestsIT.class.getName());
  private final String subjectId = "04f856a8-c686-422c-a721-95ba53b0d233";
  private final String preprocessing_id =
      "d-b7f149c6438a4c7a84a81fcc4d71aeb1-axoom-devs/fission-machine01-temp2";

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
  @Description("Create a Mapping")
  @Severity(SeverityLevel.BLOCKER)
  public void createMappingTest() throws Exception {

    String expressionString = "{\"temperature2\": temp, \"timestamp2\": timestamp\"}";
    Expression expression =
        Expression.newBuilder().setExpressionString(expressionString).setType(Type.JSONATA).build();
    Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId(subjectId)
        .setPreprocessingId(preprocessing_id).build();

    try {
      Mapping createdMapping = client.createMapping(mapping);
      assertTrue(createdMapping.getSubjectId().equals(subjectId));
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        Assert.assertTrue(true);
      } else {
        Assert.fail("Error occurred!");
        sre.printStackTrace();
      }
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"createMappingTest"})
  @Description("Get a mapping by it's ID")
  @Severity(SeverityLevel.BLOCKER)
  public void getMappingTest() throws Exception {
    try {
      Mapping mapping = client.getMapping(preprocessing_id);

      // TODO separate tests for the following methods
      logger.log(Level.INFO, mapping.getPreprocessingId());
      logger.log(Level.INFO, mapping.getSubjectId());
      logger.log(Level.INFO, mapping.getExpression().getExpressionString());
      assertTrue(mapping != null);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        throw sre;
      }
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"createMappingTest"})
  @Description("Get All mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void getAllMappingsTest() throws Exception {
    try {
      List<Mapping> mappings = client.getMappingsList(10, 0);
      assertTrue(mappings.size() > 0);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        throw sre;
      }
    } finally {
      client.shutdown();
    }
  }

  @Test
  @Description("Create several Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void createSeveralMappingTest() throws Exception {
    int count = 0;
    Random rand = new Random();
    List<String> expressionStrings = new ArrayList<>();
    expressionStrings.add("{\"temperature1\": temp, \"timestamp1\": timestamp\"}");
    expressionStrings.add("{\"temperature2\": temp, \"timestamp2\": timestamp\"}");

    List<String> preProcessingIds = new ArrayList<>();
    preProcessingIds.add(preprocessing_id + rand.nextInt() + "1");
    preProcessingIds.add(preprocessing_id + rand.nextInt() + "2");

    List<Mapping> mappings = new ArrayList<>();
    try {
      for (int i = 0; i < 2; i++) {
        Expression expression = Expression.newBuilder()
            .setExpressionString(expressionStrings.get(i)).setType(Type.JSONATA).build();
        Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId(subjectId)
            .setPreprocessingId(preProcessingIds.get(i)).build();
        mappings.add(client.createMapping(mapping));
      }

      Iterator<Mapping> mappingIterator = mappings.iterator();
      while (mappingIterator.hasNext()) {
        Mapping createdMapping = mappingIterator.next();
        for (int i = 0; i < 2; i++) {
          if (createdMapping.getExpression().getExpressionString().equals(expressionStrings.get(i))
              && createdMapping.getPreprocessingId().equals(preProcessingIds.get(i))) {
            count++;
          }
        }
      }
      assertTrue(count == 2,
          "Expression strings didn't match the expected value(s), count: " + count);
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        Assert.assertTrue(true);
      } else {
        Assert.fail("Error occurred!");
        sre.printStackTrace();
      }
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
        .setPreprocessingId(preprocessing_id).build();

    try {
      Mapping createdMapping = client.createMapping(mapping);
      assertTrue(createdMapping.getExpression().getExpressionString().equals(expressionString));
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
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
