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
import com.axoom.drs.pages.MyAxoomLoginPage;
import com.axoom.talos.framework.WebDriverTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Story("Positive test cases for SRS APIs")
public class AxoomCreateSrsTestsIT extends WebDriverTest {
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
  private String baseUri;
  private WebDriver driver;
  private int numOfSchemas;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger = Logger.getLogger(AxoomCreateSrsTestsIT.class.getName());

  @BeforeClass
  public void beforeClass() {
    inputEmail = System.getenv("SYSTEM_INTEGRATOR_EMAIL");
    inputPassword = System.getenv("SYSTEM_INTEGRATOR_PASSWORD");
    tenantId = System.getenv("TENANT_ID");
    clientId = System.getenv("SRS_CLIENT_ID");
    redirectUri = System.getenv("SRS_REDIRECT_URI");
    scope = System.getenv("SRS_SCOPES");
    cisUrl = System.getenv("CIS_URL");
    secret = System.getenv("SECRET");
    authCode = null;
    accessToken = null;
    schemaId = null;
    srs_endpoint = System.getenv("SRS_API");
    baseUri = "https://schema-registration-service.dev.myaxoom.com";
    numOfSchemas = 0;
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

    String baseUrl = "https://account.dev.myaxoom.com/connect/authorize";
    try {
      URIBuilder loginUrl = new URIBuilder(baseUrl).addParameter("response_type", "code")
          .addParameter("client_id", clientId).addParameter("redirect_uri", redirectUri)
          .addParameter("scope", scope);
      System.out.println(loginUrl);
      getDriver().get(loginUrl.toString());
      myAxoomLoginPage = initPage(driver, MyAxoomLoginPage.class);
      myAxoomLoginPage.loginToMyAxoom(inputEmail, inputPassword);
      authCode = myAxoomLoginPage.selectTenantAndReturnAuthCode(tenantId);
      Reporter.log("Logged into My Axoom");

      requestParams.put("authCode", authCode);
      requestParams.put("authType", "Basic");
      requestParams.put("contentType", "application/x-www-form-urlencoded");
      accessToken = myAxoomLoginPage.getAccessToken(requestParams);
      Reporter.log("Access Token Obtained: " + accessToken);
      System.out.println(accessToken);
      Assert.assertTrue(!accessToken.isEmpty(), "access token is empty");

    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Create a schema using SRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createSchemaTest() {

    // get total number of schemas in the registry before creation of schema
    numOfSchemas = getNumberOfSchemas();

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

    System.out.println(json);
    RestAssured.baseURI = baseUri + srs_endpoint;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    System.out.println(request.log().all(true));
    Response response = request.post("/");
    if (response.statusCode() == 201) {
      System.out.println(response.then().log().all(true));
      System.out.println("xxxxxxxxxxxxxxxxxxx\n" + response.getBody().jsonPath().prettyPrint()
          + "\nxxxxxxxxxxxxxxxxxxx\n");
      schemaId = response.getBody().jsonPath().getString("id");
      Assert.assertTrue(!schemaId.isEmpty(), "Schema is ID is null");
    } else {
      Assert.fail("Create Schema failed: " + response.statusCode());
    }
  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Create a schema using SRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createEmptyRequestBodyTest() {

    // prepare Schema Values
    Map<String, String> schemaData = new HashMap<>();

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(schemaData);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI = baseUri + srs_endpoint;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    System.out.println(request.log().all(true));
    Response response = request.post("/");
    if (response.statusCode() == 400) {
      logger.log(Level.INFO, response.then().log().all(true).toString());
      logger.log(Level.INFO, "xxxxxxxxxxxxxxxxxxx\n" + response.getBody().jsonPath().prettyPrint()
          + "\nxxxxxxxxxxxxxxxxxxx\n");
      String nameErrorMsg = response.getBody().jsonPath().getString("Name");
      String schemaErrorMsg = response.getBody().jsonPath().getString("Schema");
      String TypeErrorMsg = response.getBody().jsonPath().getString("Type");
      Assert.assertTrue(nameErrorMsg.equalsIgnoreCase("[The Name field is required.]"));
      Assert.assertTrue(schemaErrorMsg.equalsIgnoreCase("[The Schema field is required.]"));
      Assert.assertTrue(TypeErrorMsg.equalsIgnoreCase("[The field Type is invalid.]"));
    }
    else {
      Assert.fail("Test createEmptyRequestBodyTest failed" + response.statusCode()); 
    }
  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Create a schema using SRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createSchemaWithNoNameTest() {

    // prepare Schema Values
    Map<String, String> schemaData = new HashMap<>();
    schemaData.put("name", null);
    schemaData.put("schema",
        "{\"type\":\"record\",\"name\":\"DeviceMeasurement\",\"namespace\":\"com.axoom.playground.devicemeasurement\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\",\"logicalType\":\"timestamp-micros\"},{\"name\":\"value\",\"type\":\"double\"},{\"name\":\"tenant\",\"type\":\"boolean\"}]}");
    schemaData.put("type", "avro");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(schemaData);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI = baseUri + srs_endpoint;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    System.out.println(request.log().all(true));
    Response response = request.post("/");
    if (response.statusCode() == 400) {
      System.out.println(response.then().log().all(true));
      System.out.println("xxxxxxxxxxxxxxxxxxx\n" + response.getBody().jsonPath().prettyPrint()
          + "\nxxxxxxxxxxxxxxxxxxx\n");
      String nameErrorMsg = response.getBody().jsonPath().getString("Name");
      Assert.assertTrue(nameErrorMsg.equalsIgnoreCase("[The Name field is required.]"));
    }
    else {
      Assert.fail("Test createSchemaWithNoNameTest failed" + response.statusCode()); 
    }
    
  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Create a schema using SRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createSchemaWithNullSchemaTest() {

    // prepare Schema Values
    Map<String, String> schemaData = new HashMap<>();
    schemaData.put("name", "new" + System.currentTimeMillis());
    schemaData.put("schema", null);
    schemaData.put("type", "avro");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(schemaData);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI = baseUri + srs_endpoint;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    System.out.println(request.log().all(true));
    Response response = request.post("/");
    if (response.statusCode() == 400) {
      System.out.println(response.then().log().all(true));
      System.out.println("xxxxxxxxxxxxxxxxxxx\n" + response.getBody().jsonPath().prettyPrint()
          + "\nxxxxxxxxxxxxxxxxxxx\n");
      String schemaErrorMsg = response.getBody().jsonPath().getString("Schema");
      Assert.assertTrue(schemaErrorMsg.equalsIgnoreCase("[The Schema field is required.]"));
    }
    else {
      Assert.fail("Test  createSchemaWithNullSchemaTest failed" + response.statusCode()); 
    }
  }

  @Test(dependsOnMethods = {"getNumberOfSchemasTest"})
  @Description("Create a schema using SRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createSchemaWithNoTypeTest() {

    // prepare Schema Values
    Map<String, String> schemaData = new HashMap<>();
    schemaData.put("name", "Schema" + System.currentTimeMillis());
    schemaData.put("schema",
        "{\"type\":\"record\",\"name\":\"DeviceMeasurement\",\"namespace\":\"com.axoom.playground.devicemeasurement\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\",\"logicalType\":\"timestamp-micros\"},{\"name\":\"value\",\"type\":\"double\"},{\"name\":\"tenant\",\"type\":\"boolean\"}]}");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(schemaData);
    } catch (JsonProcessingException e) {

      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI = baseUri + srs_endpoint;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    System.out.println(request.log().all(true));
    Response response = request.post("/");
    if (response.statusCode() == 400) {
      System.out.println(response.then().log().all(true));
      System.out.println("xxxxxxxxxxxxxxxxxxx\n" + response.getBody().jsonPath().prettyPrint()
          + "\nxxxxxxxxxxxxxxxxxxx\n");
      String typeErrorMsg = response.getBody().jsonPath().getString("Type");
      Assert.assertTrue(typeErrorMsg.equalsIgnoreCase("[The field Type is invalid.]"));
    }
    
    else if(response.statusCode() == 201){
      Assert.fail("Schema without type can be created " + response.statusCode());
    }
    else {
      Assert.fail("Test  createSchemaWithNoTypeTest failed" + response.statusCode()); 
    }
  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Create a schema using SRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createSchemaWithInvalidSchemaTest() {

    // prepare Schema Values
    Map<String, String> schemaData = new HashMap<>();
    schemaData.put("name", "new" + System.currentTimeMillis());
    schemaData.put("schema", "Schema");
    schemaData.put("type", "avro");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(schemaData);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI = baseUri + srs_endpoint;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    System.out.println(request.log().all(true));
    Response response = request.post();
    System.out.println(response.then().log().all(true));
    System.out.println(
        "xxxxxxxxxxxxxxxxxxx\n" + response.getBody().prettyPrint() + "\nxxxxxxxxxxxxxxxxxxx\n");
    // String nameErrorMsg = response.getBody().jsonPath().getString("Schema");
    Assert.assertTrue(
        response.getBody().asString().contains("Invalid Avro schema"));
    Assert.assertTrue(response.statusCode() == 422,
        "Expected Status code is 400, but the actual status code is: " + response.statusCode());
  }

  @Test(dependsOnMethods = {"createSchemaTest"})
  @Description("Get a schema´s details using SRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getSchemaDetailsTest() {

    RestAssured.baseURI = baseUri + srs_endpoint + "/" + schemaId + "/versions" + "/latest";
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);

    System.out.println(request.log().all(true));
    Response response = request.get();
    System.out.println(response.then().log().all(true));
    Assert.assertTrue(response.statusCode() == 200,
        "Expected status code is 200 but the status is: " + response.statusCode());

  }

  @Test(dependsOnMethods = {"createSchemaTest"})
  @Description("Get total number of schema using SRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getNumberOfSchemasTest() {

    int numOfSchemasAfterCreation = getNumberOfSchemas();
    Assert.assertTrue(numOfSchemas + 1 == numOfSchemasAfterCreation,
        "The total number of scehmas should not be more than " + numOfSchemas + 1
            + ". total Number of schemas: " + numOfSchemasAfterCreation);
  }  

  @Test
  @Description("Get a non existent schema´s details using SRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getNonExistentSchemaDetailsTest() {

    RestAssured.baseURI = baseUri + srs_endpoint + "/" + 999999 + "/verions/" + "1";
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);

    System.out.println(request.log().all(true));
    Response response = request.get("/");
    System.out.println(response.then().log().all(true));
    Assert.assertTrue(response.statusCode() == 404,
        "Expected status code is 404 but the status is:" + response.statusCode());
  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Get health details using SRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getHealth() {

    RestAssured.baseURI = baseUri + "/health";
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "text/plain");
    request.header("Authorization", "Bearer " + accessToken);

    System.out.println(request.log().all(true));
    Response response = request.get();
    System.out.println(response.then().log().all(true));
    Assert.assertTrue(response.statusCode() == 200,
        "Expected status code is 200 but the status is: " + response.statusCode());
  }

  public int getNumberOfSchemas() {
    logger.log(Level.INFO, "-------------getNumberOfSchemas-------------\n" + RestAssured.baseURI);
    RestAssured.baseURI = baseUri + srs_endpoint;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);

    logger.log(Level.INFO, "-------------Request-------------\n" + request.log().all(true).toString());    
    Response response = request.get();    
    logger.log(Level.INFO, "-------------Response-------------\n" + response.then().log().all(true).toString());
    Assert.assertTrue(response.statusCode() == 200,
        "Expected status code is 200 but the status is: " + response.statusCode());
    JsonParser parser = new JsonParser();
    JsonObject responseJson = (JsonObject) parser.parse(response.asString());    
    JsonArray schemasArray = responseJson.getAsJsonArray("elements");
    return schemasArray.size();
  }

}
