package com.axoom.drs.it;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
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
import com.google.gson.JsonParser;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Story("Positive test cases for DRS APIs")
public class AxoomDrsPositiveTestsIT extends WebDriverTest {
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
  private String drs_endpoint;
  private String deviceId;
  private String baseUri;
  private WebDriver driver;
  private int numOfDevices;
  private Map<String, String> requestParams = new HashMap<>();

  @BeforeClass
  public void beforeClass() {
    inputEmail = System.getenv("SYSTEM_INTEGRATOR_EMAIL");
    inputPassword = System.getenv("SYSTEM_INTEGRATOR_PASSWORD");
    tenantId = System.getenv("TENANT_ID");
    clientId = System.getenv("DRS_CLIENT_ID");
    redirectUri = System.getenv("DRS_REDIRECT_URI");
    scope = System.getenv("DRS_SCOPES");
    cisUrl = System.getenv("CIS_URL");
    secret = System.getenv("DRS_SECRET");
    authCode = null;
    accessToken = null;
    deviceId = null;
    drs_endpoint = System.getenv("DRS_DEVICES_API");
    baseUri = "https://device-registration-service.dev.myaxoom.com";
    numOfDevices = 0;
    cert =
        "-----BEGIN CERTIFICATE-----\nMIIDBTCCAe2gAwIBAgIUF1iV/9udf9JB8v2yvHbNC2A0deAwDQYJKoZIhvcNAQELBQAwETEPMA0GA1UEAwwGdW51c2VkMCAXDTE5MDEzMDE1MTc1NloYDzQ3NTYxMjI3MTUxNzU2WjARMQ8wDQYDVQQDDAZ1bnVzZWQwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDtCQTYfELLfHNJWxmW5JYYnIpptHh4GWSo+/ZJOZhcRFozTR944sLQ582bdjEggosCs8XfIjXfSMCHT3Jbo2MVCgW2W/8dG1hRke/UN6T0Gz89QqCHrve4C3n/N4k+KbxOCOEfkXEZvaljGZ/uVSpnlHBztAXxxWlG9EoXqD3swj9i3jfvdLGzw1owIB19PZL7i+TKgpVDz6Kexa0f7d5n7Sp5ASxuWbcs/+UsPFRePZT8zMsuPhXp9yVSjtd2QktBNezsSI8b3JeyFg0KXgjv4VoP1RRaD+CkGhJKkLQp4afq4yVaPUiJttQwpT0dMXzdmfgP1e9w5WVLdwT0O0gjAgMBAAGjUzBRMB0GA1UdDgQWBBTE9NeokJNR2uhUQkqrQcrDlu/UajAfBgNVHSMEGDAWgBTE9NeokJNR2uhUQkqrQcrDlu/UajAPBgNVHRMBAf8EBTADAQH/MA0GCSqGSIb3DQEBCwUAA4IBAQCxam8a8cYrO7XN7XAhzUlbZ1eNCYl45CeFsrM8MUBPpXmGIO7QjkVIIJhD6AWDCeXWaDL80su4YPZMMpOLwVeVsJwAMMs5KAqkieifsz1UJg4PBZVfpN6jBtkONAFBj6RcZTUEo8gvH/rI166oqD+zcKiVkkZYSS2MFzYcLZAkGbtEytefcZzycrGPCSnhOg245cDhSP7CBTNBRW54C8TuzhdaRqjAgwYeSEoQKAMiIKJCldornqHlK/XFU7A7QRuT3vTEVbisUqqMRpIfa8vilb1GMIDIJihSyhN2EWGTg7garew8uGDpIQMeFZVhgc2GHkXB8u4I68dhbpm1KUc5\n-----END CERTIFICATE-----";
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
  @Description("Create a device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createDeviceTest() {
    
    //get total number of devices in the registry before creation of device
    numOfDevices = getNumberOfDevices();
    
    // prepare Device Configuration Values
    Map<String, String> config = new HashMap<>();
    config.put("publicKeyFormat", "rsa_x509_pem");
    config.put("publicKey", cert);
    config.put("location", "europe-west1");


    Map<String, Object> deviceValues = new HashMap<>();
    deviceValues.put("tenant", tenantId);
    deviceValues.put("name", "AxoomTestDevice" + System.currentTimeMillis());
    deviceValues.put("configuration", config);
    deviceValues.put("ioTProvider", "google");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(deviceValues);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI = baseUri + drs_endpoint;
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
      deviceId = response.getBody().jsonPath().getString("id");
      Assert.assertTrue(response.statusCode() == 201,
          "Expected tatus code is 201 but the status is: " + response.statusCode());
      Assert.assertTrue(!deviceId.isEmpty(), "Device is ID is null");
    } else {
      System.out.println("Create device failed: " + response.statusCode());
    }
  }

  @Test(dependsOnMethods = {"createDeviceTest"})
  @Description("Get a device´s details using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getDeviceDetailsTest() {

    RestAssured.baseURI = baseUri + drs_endpoint + "/" + deviceId;
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

  @Test(dependsOnMethods = {"createDeviceTest"})
  @Description("Get total number of device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getNumberOfeviceDetailsTest() {

    int numOfDevicesAfterCreation = getNumberOfDevices();
    Assert.assertTrue(numOfDevices == numOfDevicesAfterCreation - 1,
        "The total number of devices should not be more than 1. total Number of devices: " + numOfDevicesAfterCreation);
  }

  @Test(dependsOnMethods = {"getDeviceDetailsTest"})
  @Description("Update a device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void updateDeviceTest() {

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
    RestAssured.baseURI =
        baseUri + drs_endpoint + "/" + deviceId;
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

  @Test(dependsOnMethods = {"updateDeviceTest"})
  @Description("Delete a device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void deleteDeviceTest() {

    RestAssured.baseURI =
        baseUri + drs_endpoint + "/" + deviceId;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);

    System.out.println(request.log().all(true));
    Response response = request.delete("/");
    System.out.println(response.then().log().all(true));
    Assert.assertTrue(response.statusCode() == 204,
        "Expected status code is 204 but the status is: " + response.statusCode());

  }

  @Test(dependsOnMethods = {"deleteDeviceTest"})
  @Description("Get a non existent device´s details using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getNonExistentDeviceDetailsTest() {

    RestAssured.baseURI = baseUri + drs_endpoint + "/" + deviceId;
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

  @Test(dependsOnMethods = {"deleteDeviceTest"})
  @Description("Try Deleting a non existent device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void deleteANonExistentDeviceTest() {

    RestAssured.baseURI =
        baseUri + drs_endpoint + "/" + deviceId;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);

    System.out.println(request.log().all(true));
    Response response = request.delete("/");
    System.out.println(response.then().log().all(true));
    Assert.assertTrue(response.statusCode() == 404,
        "Expected tatus code is 204 but the status is: " + response.statusCode());

  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Get health details using DRS APIs")  
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
  
  public int getNumberOfDevices() {
    RestAssured.baseURI = baseUri + drs_endpoint;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);

    System.out.println(request.log().all(true));
    Response response = request.get("/");
    System.out.println(response.then().log().all(true));
    Assert.assertTrue(response.statusCode() == 200,
        "Expected status code is 200 but the status is: " + response.statusCode());
    JsonParser parser = new JsonParser();
    JsonArray responseJson = (JsonArray) parser.parse(response.asString());
    return responseJson.size() ;
  }

}
