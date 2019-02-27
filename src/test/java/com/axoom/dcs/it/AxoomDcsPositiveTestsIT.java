package com.axoom.dcs.it;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
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

@Story("Positive test cases for DCS APIs")
public class AxoomDcsPositiveTestsIT extends WebDriverTest {
  private MyAxoomLoginPage myAxoomLoginPage;
  private String inputEmail;
  private String inputPassword;
  private String tenantId;
  private String clientId;
  private String redirectUri;
  private String scope;
  private String authCode;
  private String accessToken;
  private String cert;
  private String secret;
  private String cisUrl;
  private String dcs_endpoint;
  private String dataCompositionId;
  private String baseUri;
  private WebDriver driver;
  private int numOfDataCompositions;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger = Logger.getLogger(AxoomDcsPositiveTestsIT.class.getName());

  @BeforeClass
  public void beforeClass() {
    inputEmail = System.getenv("SYSTEM_INTEGRATOR_EMAIL");
    inputPassword = System.getenv("SYSTEM_INTEGRATOR_PASSWORD");
    tenantId = System.getenv("TENANT_ID");
    clientId = System.getenv("DCS_CLIENT_ID");
    redirectUri = System.getenv("DCS_REDIRECT_URI");
    scope = System.getenv("DCS_SCOPES");
    cisUrl = System.getenv("CIS_URL");
    secret = System.getenv("SECRET");
    authCode = null;
    accessToken = null;
    dataCompositionId = null;
    dcs_endpoint = System.getenv("DCS_API");
    baseUri = "https://data-composition-service.dev.myaxoom.com";
    numOfDataCompositions = 0;
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

  @Test(priority = 0)
  @Description("Perform Login UI test to get access token for API tests")
  @Severity(SeverityLevel.BLOCKER)
  public void myAxoomLoginTest(ITestContext context) throws InterruptedException {    
    
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
      context.setAttribute("accessToken", accessToken);
      Reporter.log("Access Token Obtained: " + accessToken);
      System.out.println(accessToken);
      Assert.assertTrue(!accessToken.isEmpty(), "access token is empty");

    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Create a Data Compositiion using DCS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createDataCompositionTest(ITestContext context) {

    // get total number of data compositions in the registry before creation of data composition
    numOfDataCompositions = getNumberOfDataCompositions();

    // prepare Schema Values
    Map<String, String> dataComposition = new HashMap<>();
    dataComposition.put("schemaId", "533d8038b3c34b43af2ffa191292bfda");
    dataComposition.put("friendlyName", "DataCompoistion" + System.currentTimeMillis());

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(dataComposition);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI = baseUri + dcs_endpoint;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("authorization", "Bearer " + accessToken);
    request.body(json);
    System.out.println(request.log().all(true));
    Response response = request.post("/");
    if (response.statusCode() == 201) {
      System.out.println(response.then().log().all(true));
      System.out.println("xxxxxxxxxxxxxxxxxxx\n" + response.getBody().jsonPath().prettyPrint()
          + "\nxxxxxxxxxxxxxxxxxxx\n");
      dataCompositionId = response.getBody().jsonPath().getString("id");
      Assert.assertTrue(!dataCompositionId.isEmpty(), "DataComposition is ID is null");
      context.setAttribute("dataCompositionId", dataCompositionId);
    } else {
      System.out.println(response.then().log().all(true));
      Assert.fail("Data Composition creation failed: " + response.statusCode());
    }
  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Verify creating an empty Data Composition using DCS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createEmptySchemaTest() {

    // prepare Schema Values
    Map<String, String> schemaData = new HashMap<>();

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(schemaData);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI = baseUri + dcs_endpoint;
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
      String responseString = response.getBody().asString();      
      Assert.assertTrue(responseString.contains("The FriendlyName field is required"));
      Assert.assertTrue(responseString.contains("The SchemaId field is required"));
    }
  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Verify creating a data composition with no name using DCS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createDataCompositionWithNoNameTest() {

    // prepare Schema Values
    Map<String, String> dataComposition = new HashMap<>();
    dataComposition.put("schemaId", "533d8038b3c34b43af2ffa191292bfda");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(dataComposition);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI = baseUri + dcs_endpoint;
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
      String NameErrorMsg = response.getBody().asString();
      Assert.assertTrue(NameErrorMsg.contains("The FriendlyName field is required."));
    }
  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Verify creating a data composition with no schema subject using DCS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createDataCompositionWithNoschemaIdTest() {

    // prepare Schema Values
    Map<String, String> dataComposition = new HashMap<>();
    dataComposition.put("friendlyName", "DataCompoistion" + System.currentTimeMillis());
    dataComposition.put("schemaId", null);

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(dataComposition);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI = baseUri + dcs_endpoint;
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
      String NameErrorMsg = response.getBody().asString();
      Assert.assertTrue(NameErrorMsg.contains("The SchemaId field is required."));
    }
  }

  @Test(dependsOnMethods = {"createDataCompositionTest"})
  @Description("Get a data composition´s details using DCS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getDataCompositionDetailsTest() {

    RestAssured.baseURI = baseUri + dcs_endpoint + "/" + dataCompositionId;
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

  @Test(dependsOnMethods = {"createDataCompositionTest"})
  @Description("Get total number of data composition using DCS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getNumberOfDataCompositionsTest() {

    int numOfDataCompositionsAfterCreation = getNumberOfDataCompositions();
    Assert.assertTrue(numOfDataCompositions == numOfDataCompositionsAfterCreation - 1,
        "The total number of data compositions should not be more than " + numOfDataCompositions
            + ". total Number of data compositions: " + numOfDataCompositionsAfterCreation);
  }

  // @Test(dependsOnMethods = {"getSchemaDetailsTest"})
  @Description("Update a data composition using DCS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void updateSchemaTest() {

    // prepare Device Configuration Values
    Map<String, String> config = new HashMap<>();
    config.put("publicKeyFormat", "rsa_x509_pem");
    config.put("publicKey", cert);
    config.put("location", "europe-west1");


    Map<String, Object> deviceValues = new HashMap<>();
    deviceValues.put("tenant", tenantId);
    deviceValues.put("configuration", config);
    deviceValues.put("name", "ChangedName");
    deviceValues.put("ioTProvider", "google");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(deviceValues);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI = baseUri + dcs_endpoint + "/" + dataCompositionId;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    System.out.println(request.log().all(true));
    Response response = request.put("/");
    System.out.println(response.then().log().all(true));
    Assert.assertTrue(response.statusCode() == 200,
        "Expected tatus code is 200 but the status is: " + response.statusCode());

  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Verify gettingl a non existent data composition´s details using DCS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getNonExistentDataCompositionDetailsTest() {

    RestAssured.baseURI = baseUri + dcs_endpoint + "/" + 999999;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);

    System.out.println(request.log().all(true));
    Response response = request.get();
    System.out.println(response.then().log().all(true));
    Assert.assertTrue(response.statusCode() == 404,
        "Expected status code is 404 but the status is:" + response.statusCode());

  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Get health details using DCS APIs")
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

  public int getNumberOfDataCompositions() {
    RestAssured.baseURI = baseUri + dcs_endpoint;
    logger.log(Level.INFO, "-------------getNumberOfDataCompositions-------------\n" + RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");    
    request.header("Authorization", "Bearer " + accessToken);
    logger.log(Level.INFO, "-------------Request-------------\n" + request.log().all(true));    
    Response response = request.get();    
    logger.log(Level.INFO, "-------------Response-------------\n" + response.then().log().all(true).toString());
    Assert.assertTrue(response.statusCode() == 200,
        "Expected status code is 200 but the status is: " + response.statusCode());
    JsonParser parser = new JsonParser();
    JsonObject responseJson = (JsonObject) parser.parse(response.asString());
    JsonArray dataCompositionsArray = responseJson.getAsJsonArray("elements");
    return dataCompositionsArray.size();
  }

}
