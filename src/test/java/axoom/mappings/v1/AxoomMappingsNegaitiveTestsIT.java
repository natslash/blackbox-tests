package axoom.mappings.v1;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.HashMap;
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
public class AxoomMappingsNegaitiveTestsIT extends WebDriverTest {
  private String clientId;
  private String redirectUri;
  private String secret;
  private String cisUrl;
  private MappingsClient client;  
  private String preProcessingId = "axoom-devs/fission-machine01-temp3";  
  private final String subjectId = "04f856a8-c686-422c-a721-95ba53b0d233";
  private final String deviceId = "d-b7f149c6438a4c7a84a81fcc4d71aeb2";

  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger =
      Logger.getLogger(AxoomMappingsNegaitiveTestsIT.class.getName());

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
    preProcessingId = generatedString;

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
          .setDeviceId(deviceId).setPreprocessingId(preProcessingId).build();

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
  @Description("Create a Mapping")
  @Severity(SeverityLevel.BLOCKER)
  public void createMappingWithEmptyValuesTest() throws Exception {

    String expressionString = "{\"temperature2\": temp, \"timestamp2\": timestamp\"}";
    Expression expression =
        Expression.newBuilder().setExpressionString(expressionString).setType(Type.JSONATA).build();
    Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId("")
        .setDeviceId("").setPreprocessingId("").build();

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
  @Description("Create a Mapping")
  @Severity(SeverityLevel.BLOCKER)
  public void createMappingWithEmptyDeviceIDTest() throws Exception {

    String expressionString = "{\"temperature2\": temp, \"timestamp2\": timestamp\"}";
    Expression expression =
        Expression.newBuilder().setExpressionString(expressionString).setType(Type.JSONATA).build();
    Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId(subjectId)
        .setDeviceId("").setPreprocessingId(preProcessingId).build();

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
  @Description("Create a Mapping")
  @Severity(SeverityLevel.BLOCKER)
  public void createMappingWithEmptySubjectIDTest() throws Exception {

    String expressionString = "{\"temperature2\": temp, \"timestamp2\": timestamp\"}";
    Expression expression =
        Expression.newBuilder().setExpressionString(expressionString).setType(Type.JSONATA).build();
    Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId("")
        .setDeviceId(deviceId).setPreprocessingId(preProcessingId).build();

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
  @Description("Create a Mapping")
  @Severity(SeverityLevel.BLOCKER)
  public void createMappingWithEmptyPreProcessingIDTest() throws Exception {

    String expressionString = "{\"temperature2\": temp, \"timestamp2\": timestamp\"}";
    Expression expression =
        Expression.newBuilder().setExpressionString(expressionString).setType(Type.JSONATA).build();
    Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId(subjectId)
        .setDeviceId(deviceId).setPreprocessingId("").build();

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
  @Description("Create a Mapping with invalid expression string")
  @Severity(SeverityLevel.BLOCKER)
  public void createMappingWithNullDeviceIdTest() throws Exception {

    try {
      String expressionString = "{\"temperature2\": temp, \"timestamp2\": timestamp\"}";
      Expression expression = Expression.newBuilder().setExpressionString(expressionString)
          .setType(Type.JSONATA).build();
      Mapping mapping = Mapping.newBuilder().setExpression(expression).setSubjectId("")
          .setDeviceId(null).setPreprocessingId("").build();

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
  
  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingsWithNullPreProcessingIdTest() throws Exception {
    try {
      client.listMappingsWithDeviceAndPreProcessingIds(deviceId, null);     
    } catch (NullPointerException npe) {
      assertTrue(true);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingsWithNullDeviceIdTest() throws Exception {
    try {
      client.listMappingsWithDeviceAndPreProcessingIds(null, preProcessingId);      
    } catch (NullPointerException npe) {
      assertTrue(true);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingWithNullDeviceIdTest() throws Exception {
    try {
      client.listMappings(null, preProcessingId, subjectId);              
    } catch (NullPointerException npe) {
      assertTrue(true);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingWithNullPreProcessingIdTest() throws Exception {
    try {
      client.listMappings(deviceId, null, subjectId);              
    } catch (NullPointerException npe) {
      assertTrue(true);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingWithNullSubjectIdTest() throws Exception {
    try {
      client.listMappings(deviceId, null, subjectId);              
    } catch (NullPointerException npe) {
      assertTrue(true);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingWithNullValuesTest() throws Exception {
    try {
      client.listMappings(null, null, null);              
    } catch (NullPointerException npe) {
      assertTrue(true);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
 
  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingsWithEmptyDeviceIdTest() throws Exception {
    try {
      ListMappingsResponse mappings = client.listMappings("", preProcessingId, subjectId);
      List<Mapping> mappingsList = mappings.getMappingsList();
      assertTrue(mappingsList.size() == 0, "Size of the list " + mappingsList.size());      
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingsWithEmptyPreProcessingIdTest() throws Exception {
    try {
      ListMappingsResponse mappings = client.listMappings(deviceId, "", subjectId);
      List<Mapping> mappingsList = mappings.getMappingsList();
      assertTrue(mappingsList.size() == 0, "Size of the list " + mappingsList.size());      
    } catch (Exception e) {      
      throw e;
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingWithEmptySubjectIdTest() throws Exception {
    try {
      ListMappingsResponse mappings = client.listMappings(deviceId, preProcessingId, "");
      List<Mapping> mappingsList = mappings.getMappingsList();
      assertTrue(mappingsList.size() == 0, "Size of the list " + mappingsList.size());      
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("List Mappings")
  @Severity(SeverityLevel.BLOCKER)
  public void listMappingsWithEmptyValuesTest() throws Exception {
    try {
      ListMappingsResponse mappings = client.listMappings("", "", "");
      List<Mapping> mappingsList = mappings.getMappingsList();
      assertTrue(mappingsList.size() == 0, "Size of the list " + mappingsList.size());      
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
}
