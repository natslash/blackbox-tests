package com.axoom.srs.it;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.axoom.constants.ContentType;
import com.axoom.constants.EnvVariables;
import com.axoom.drs.pages.MyAxoomLoginPage;
import com.axoom.talos.framework.WebDriverTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Story("Positive test cases for SRS APIs")
public class AxoomUpdateSrsTestsIT extends WebDriverTest {
  private MyAxoomLoginPage myAxoomLoginPage;
  private String inputEmail;
  private String inputPassword;
  private String tenantId;
  private String clientId;
  private String redirectUri;
  private String scope;
  private String authCode;
  private String accessToken;
  private String secret;
  private String cisUrl;
  private String srs_endpoint;
  private String schemaId;
  private String schemaName;
  private String baseUri;
  private WebDriver driver;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger = Logger.getLogger(AxoomUpdateSrsTestsIT.class.getName());
  
  @BeforeClass
  public void beforeClass() {
    inputEmail = EnvVariables.SYSTEM_INTEGRATOR_EMAIL;
    inputPassword = EnvVariables.SYSTEM_INTEGRATOR_PASSWORD;
    tenantId = EnvVariables.TENANT_ID;
    clientId = EnvVariables.SRS_CLIENT_ID;
    redirectUri = EnvVariables.SRS_REDIRECT_URI;
    scope = EnvVariables.SRS_SCOPES;
    cisUrl = EnvVariables.CIS_URL;
    secret = EnvVariables.SECRET;
    authCode = null;
    accessToken = null;
    schemaId = null;
    schemaName = null;
    srs_endpoint = EnvVariables.SRS_API;
    baseUri = EnvVariables.SRS_BASEURI;
    requestParams.put("clientId", clientId);
    requestParams.put("redirectUri", redirectUri);
    requestParams.put("cisUrl", cisUrl);
    requestParams.put("secret", secret);

    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @BeforeMethod
  public void beforeMethod() {
    super.initPlatformBaseTest();
    this.driver = super.getDriver();

    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    stopWebDriverTest(testResult);
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }

  @Test
  @Description("Perform Login UI test to get access token for API tests")
  @Severity(SeverityLevel.BLOCKER)
  public void myAxoomLoginTest() throws InterruptedException {

    String baseUrl = cisUrl + "/connect/authorize";
    try {
      URIBuilder loginUrl = new URIBuilder(baseUrl).addParameter("response_type", "code")
          .addParameter("client_id", clientId).addParameter("redirect_uri", redirectUri)
          .addParameter("scope", scope);
      getDriver().get(loginUrl.toString());
      myAxoomLoginPage = initPage(driver, MyAxoomLoginPage.class);
      myAxoomLoginPage.loginToMyAxoom(inputEmail, inputPassword);
      authCode = myAxoomLoginPage.selectTenantAndReturnAuthCode(tenantId);
      Reporter.log("Logged into My Axoom");

      requestParams.put("authCode", authCode);
      requestParams.put("authType", "Basic");
      requestParams.put("contentType", ContentType.FORM_URL_ENCODED);
      accessToken = myAxoomLoginPage.getAccessToken(requestParams);
      Reporter.log("Access Token Obtained: " + accessToken);
      Assert.assertTrue(!accessToken.isEmpty(), "access token is empty");

    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Create a schema using SRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createSchemaTest() {

    // prepare Schema Values
    Map<String, String> schemaData = new HashMap<>();
    String name = "MySchema" + System.currentTimeMillis();
    schemaData.put("name", name);
    schemaData.put("schema",
        "{\"type\":\"record\",\"name\":\"DeviceMeasurement\",\"namespace\":\"com.axoom.playground.devicemeasurement\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\",\"logicalType\":\"timestamp-micros\"},{\"name\":\"value\",\"type\":\"double\"},{\"name\":\"tenant\",\"type\":\"boolean\"}]}");
    schemaData.put("type", "avro");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(schemaData);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    RestAssured.baseURI = baseUri + srs_endpoint;
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", ContentType.APPLICATION_JSON);
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    logger.log(Level.INFO, request.log().all(true).toString());
    Response response = request.post();
    if (response.statusCode() == 201) {
      logger.log(Level.INFO, response.then().log().all(true).toString());
      logger.log(Level.INFO, "xxxxxxxxxxxxxxxxxxx\n" + response.getBody().jsonPath().prettyPrint()
          + "\nxxxxxxxxxxxxxxxxxxx\n");
      schemaId = response.getBody().jsonPath().getString("id");
      Assert.assertTrue(!schemaId.isEmpty(), "Schema is ID is null");
      schemaName = name;
    } else {
      Assert.fail("Create Schema failed: " + response.statusCode());
    }
  }

  public Map<String, String> getSchemaDetailsTest() {

    Map<String, String> schemaDetails = new HashMap<>();

    RestAssured.baseURI = baseUri + srs_endpoint + "/" + schemaId + "/versions" + "/latest";
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", ContentType.APPLICATION_JSON);
    request.header("Authorization", "Bearer " + accessToken);

    logger.log(Level.INFO, request.log().all(true).toString());
    Response response = request.get();
    logger.log(Level.INFO, response.then().log().all(true).toString());
    if (response.statusCode() == 200) {
      schemaDetails.put("schema", response.getBody().jsonPath().getString("schema"));
      schemaDetails.put("version", response.getBody().jsonPath().getString("version"));

    }

    return schemaDetails;
  }

  @Test(dependsOnMethods = {"createSchemaTest"})
  @Description("Update a schema using SRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void updateWithIncompatibleSchemaTest() {

    // prepare Schema Values
    Map<String, String> schemaData = new HashMap<>();
    schemaData.put("name", schemaName);
    schemaData.put("schema",
        "{\"type\":\"record\",\"name\":\"DeviceMeasurement\",\"namespace\":\"com.axoom.playground.devicemeasurement\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\",\"logicalType\":\"timestamp-micros\"},{\"name\":\"value\",\"type\":\"double\"}, {\"name\":\"custom\",\"type\":\"double\"},{\"name\":\"tenant\",\"type\":\"boolean\"}]}");
    schemaData.put("type", "avro");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(schemaData);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    RestAssured.baseURI = baseUri + srs_endpoint + "/" + schemaId;
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", ContentType.APPLICATION_JSON);
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    logger.log(Level.INFO, request.log().all(true).toString());
    Response response = request.put("/");
    if (response.statusCode() == 409) {
      logger.log(Level.INFO, response.then().log().all(true).toString());
      logger.log(Level.INFO, 
          "xxxxxxxxxxxxxxxxxxx\n" + response.getBody().prettyPrint() + "\nxxxxxxxxxxxxxxxxxxx\n");
    } else {
      Assert.fail("Update Invalid Schema failed: " + response.statusCode());
    }

  }


  @Test(dependsOnMethods = {"updateWithIncompatibleSchemaTest"})
  @Description("Update a schema using SRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void updateSchemaTest() {

    String updatedSchemaString = null;
    String partialSchemaString = "{\"name\":\"custom\",\"type\":\"double\", \"default\":1.0}";

    // Get schema
    Map<String, String> schemaBeforeUpdate = getSchemaDetailsTest();

    // prepare Schema Values
    Map<String, String> schemaData = new HashMap<>();
    schemaData.put("name", schemaName);
    schemaData.put("schema",
        "{\"type\":\"record\",\"name\":\"DeviceMeasurement\",\"namespace\":\"com.axoom.playground.devicemeasurement\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\",\"logicalType\":\"timestamp-micros\"},{\"name\":\"value\",\"type\":\"double\"}, {\"name\":\"custom\",\"type\":\"double\", \"default\":1.0},{\"name\":\"tenant\",\"type\":\"boolean\"}]}");
    schemaData.put("type", "avro");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(schemaData);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    RestAssured.baseURI = baseUri + srs_endpoint + "/" + schemaId;
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", ContentType.APPLICATION_JSON);
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    logger.log(Level.INFO, request.log().all(true).toString());
    Response response = request.put("/");
    if (response.statusCode() == 201) {
      logger.log(Level.INFO, response.then().log().all(true).toString());
      logger.log(Level.INFO, "xxxxxxxxxxxxxxxxxxx\n" + response.getBody().jsonPath().prettyPrint()
          + "\nxxxxxxxxxxxxxxxxxxx\n");
      updatedSchemaString = response.getBody().jsonPath().getString("schema");
      int latestVersion = Integer.parseInt(response.getBody().jsonPath().getString("version"));
      int previousVersion = Integer.parseInt(schemaBeforeUpdate.get("version"));
      Assert.assertTrue(!schemaBeforeUpdate.get("schema").contains(partialSchemaString));
      Assert.assertTrue(updatedSchemaString.contains(partialSchemaString));
      Assert.assertTrue(latestVersion - previousVersion == 1);
    } else {
      Assert.fail("Update Valid Schema failed: " + response.statusCode());
    }

  }


  @Test(dependsOnMethods = {"updateSchemaTest"})
  @Description("Update a schema using SRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void updateSchemaNameTest() {

    // prepare Schema Values
    Map<String, String> schemaData = new HashMap<>();
    schemaData.put("name", schemaName + "renamed");
    schemaData.put("schema",
        "{\"type\":\"record\",\"name\":\"DeviceMeasurement\",\"namespace\":\"com.axoom.playground.devicemeasurement\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\",\"logicalType\":\"timestamp-micros\"},{\"name\":\"value\",\"type\":\"double\"},{\"name\":\"tenant\",\"type\":\"boolean\"}]}");
    schemaData.put("type", "avro");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(schemaData);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    RestAssured.baseURI = baseUri + srs_endpoint + "/" + schemaId;
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", ContentType.APPLICATION_JSON);
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    logger.log(Level.INFO, request.log().all(true).toString());
    Response response = request.put("/");
    if (response.statusCode() == 201) {
      logger.log(Level.INFO, response.then().log().all(true).toString());
      logger.log(Level.INFO, "xxxxxxxxxxxxxxxxxxx\n" + response.getBody().jsonPath().prettyPrint()
          + "\nxxxxxxxxxxxxxxxxxxx\n");
      schemaId = response.getBody().jsonPath().getString("id");
      String version = response.getBody().jsonPath().getString("version");
      Assert.assertTrue(!schemaId.isEmpty(), "Schema is ID is null");
      // Changing just the name should retain the version
      Assert.assertTrue(version.equals("2"), "Version is not 2");
    } else {
      Assert
          .fail("Update Schema name failed: " + response.statusCode() + "\n" + response.asString());
    }
  }
}
