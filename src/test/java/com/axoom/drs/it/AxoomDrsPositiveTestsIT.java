package com.axoom.drs.it;

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
import com.axoom.constants.ContentType;
import com.axoom.constants.EnvVariables;
import com.axoom.drs.pages.MyAxoomLoginPage;
import com.axoom.drs.utils.AxoomRequest;
import com.axoom.drs.utils.RequestParams;
import com.axoom.talos.framework.WebDriverTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
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
  private static final Logger logger = Logger.getLogger(AxoomDrsPositiveTestsIT.class.getName());

  @BeforeClass
  public void beforeClass() {
    inputEmail = EnvVariables.SYSTEM_INTEGRATOR_EMAIL;
    inputPassword = EnvVariables.SYSTEM_INTEGRATOR_PASSWORD;
    tenantId = EnvVariables.TENANT_ID;
    clientId = EnvVariables.DRS_CLIENT_ID;
    //clientId = "blackboxtest01";
    redirectUri = EnvVariables.DRS_REDIRECT_URI;
    scope = EnvVariables.DRS_SCOPES;
    cisUrl = EnvVariables.CIS_URL;
    secret = EnvVariables.SECRET;
    drs_endpoint = EnvVariables.DRS_DEVICES_API;
    baseUri = EnvVariables.DRS_BASEURI;
    authCode = null;
    accessToken = null;
    deviceId = null;
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

  @Test(groups = {"prerequisites"}, priority = 0)
  @Description("Perform Login UI test to get access token for API tests")
  @Severity(SeverityLevel.BLOCKER)
  public void myAxoomLoginTest(ITestContext context) throws InterruptedException {

    String baseUrl = cisUrl + "/connect/authorize";
    try {
      URIBuilder loginUrl = new URIBuilder(baseUrl).addParameter("response_type", "code")
          .addParameter("client_id", clientId).addParameter("redirect_uri", redirectUri)
          .addParameter("scope", scope);
      logger.log(Level.INFO, loginUrl.toString());
      getDriver().get(loginUrl.toString());
      myAxoomLoginPage = initPage(driver, MyAxoomLoginPage.class);
      myAxoomLoginPage.loginToMyAxoom(inputEmail, inputPassword);
      authCode = myAxoomLoginPage.selectTenantAndReturnAuthCode(tenantId);
      Reporter.log("Logged into My Axoom");

      requestParams.put("authCode", authCode);
      requestParams.put("authType", "Basic");
      requestParams.put("contentType", ContentType.FORM_URL_ENCODED);
      accessToken = myAxoomLoginPage.getAccessToken(requestParams);
      context.setAttribute("accessToken", accessToken);
      Reporter.log("Access Token Obtained: " + accessToken);
      logger.log(Level.INFO, accessToken);
      Assert.assertTrue(!accessToken.isEmpty(), "access token is empty");

    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Create a device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createDeviceTest() {

    // get total number of devices in the registry before creation of device
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
    deviceValues.put("connectivity", "vertical-connect");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(deviceValues);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    String baseURI = baseUri + drs_endpoint;

    RequestParams requestParams = new RequestParams();
    requestParams.setBaseURI(baseURI);
    requestParams.setContentType(ContentType.APPLICATION_JSON);
    requestParams.setAuthorization(accessToken);
    RequestSpecification request = AxoomRequest.getPreparedRequest(requestParams);
    request.body(json);

    logger.log(Level.INFO, request.log().all(true).toString());
    Response response = request.post();

    if (response.statusCode() == 201) {
      logger.log(Level.INFO, "xxxxxxxxxxxxxxxxxxx\n" + response.getBody().jsonPath().prettyPrint()
          + "\nxxxxxxxxxxxxxxxxxxx\n");
      deviceId = response.getBody().jsonPath().getString("id");
      Assert.assertTrue(response.statusCode() == 201,
          "Expected tatus code is 201 but the status is: " + response.statusCode());
      Assert.assertTrue(!deviceId.isEmpty(), "Device is ID is null");
    } else {
      logger.log(Level.SEVERE, "Create device failed: " + response.statusCode());
    }
  }

  @Test(dependsOnMethods = {"createDeviceTest"})
  @Description("Get a device details using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getDeviceDetailsTest() {

    String baseURI = baseUri + drs_endpoint + "/" + deviceId;

    RequestParams requestParams = new RequestParams();
    requestParams.setBaseURI(baseURI);
    requestParams.setContentType(ContentType.APPLICATION_JSON);
    requestParams.setAuthorization(accessToken);

    RequestSpecification request = AxoomRequest.getPreparedRequest(requestParams);
    logger.log(Level.INFO, request.log().all(true).toString());

    Response response = request.get();
    logger.log(Level.INFO, response.then().log().all(true).toString());
    Assert.assertTrue(response.statusCode() == 200,
        "Expected status code is 200 but the status is: " + response.statusCode());

  }

  @Test(dependsOnMethods = {"createDeviceTest"})
  @Description("Get total number of device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getNumberOfDevicesTest() {

    int numOfDevicesAfterCreation = getNumberOfDevices();
    Assert.assertTrue(numOfDevices == numOfDevicesAfterCreation - 1,
        "The total number of devices should not be more than " + numOfDevices
            + ". total Number of devices: " + numOfDevicesAfterCreation);
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
    deviceValues.put("connectivity", "machine-simulator");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(deviceValues);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    String baseURI = baseUri + drs_endpoint + "/" + deviceId;
    RequestParams requestParams = new RequestParams();
    requestParams.setBaseURI(baseURI);
    requestParams.setContentType(ContentType.APPLICATION_JSON);
    requestParams.setAuthorization(accessToken);
    RequestSpecification request = AxoomRequest.getPreparedRequest(requestParams);
    request.body(json);

    logger.log(Level.INFO, request.log().all(true).toString());
    Response response = request.put();

    logger.log(Level.INFO, response.then().log().all(true).toString());
    Assert.assertTrue(response.statusCode() == 200,
        "Expected tatus code is 200 but the status is: " + response.statusCode());

  }

  @Test(dependsOnMethods = {"updateDeviceTest"})
  @Description("Delete a device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void deleteDeviceTest() {

    String baseURI = baseUri + drs_endpoint + "/" + deviceId;
    RequestParams requestParams = new RequestParams();
    requestParams.setBaseURI(baseURI);
    requestParams.setContentType(ContentType.APPLICATION_JSON);
    requestParams.setAuthorization(accessToken);
    RequestSpecification request = AxoomRequest.getPreparedRequest(requestParams);

    Response response = request.delete();
    logger.log(Level.INFO, response.then().log().all(true).toString());
    Assert.assertTrue(response.statusCode() == 204,
        "Expected status code is 204 but the status is: " + response.statusCode());

  }

  @Test(dependsOnMethods = {"deleteDeviceTest"})
  @Description("Get a non existent device details using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getNonExistentDeviceDetailsTest() {

    String baseURI = baseUri + drs_endpoint + "/" + deviceId;
    RequestParams requestParams = new RequestParams();
    requestParams.setBaseURI(baseURI);
    requestParams.setContentType(ContentType.APPLICATION_JSON);
    requestParams.setAuthorization(accessToken);
    RequestSpecification request = AxoomRequest.getPreparedRequest(requestParams);

    Response response = request.get();
    logger.log(Level.INFO, response.then().log().all(true).toString());
    Assert.assertTrue(response.statusCode() == 404,
        "Expected status code is 404 but the status is:" + response.statusCode());

  }

  @Test(dependsOnMethods = {"deleteDeviceTest"})
  @Description("Try Deleting a non existent device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void deleteANonExistentDeviceTest() {

    String baseURI = baseUri + drs_endpoint + "/" + deviceId;
    RequestParams requestParams = new RequestParams();
    requestParams.setBaseURI(baseURI);
    requestParams.setContentType(ContentType.APPLICATION_JSON);
    requestParams.setAuthorization(accessToken);
    RequestSpecification request = AxoomRequest.getPreparedRequest(requestParams);

    Response response = request.delete();
    logger.log(Level.INFO, response.then().log().all(true).toString());

    Assert.assertTrue(response.statusCode() == 404,
        "Expected tatus code is 204 but the status is: " + response.statusCode());

  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Get health details using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getHealth() {

    String baseURI = baseUri + "/health";
    RequestParams requestParams = new RequestParams();
    requestParams.setBaseURI(baseURI);
    requestParams.setContentType(ContentType.PLAIN_TEXT);
    requestParams.setAuthorization(accessToken);
    RequestSpecification request = AxoomRequest.getPreparedRequest(requestParams);

    Response response = request.get();
    logger.log(Level.INFO, response.then().log().all(true).toString());

    Assert.assertTrue(response.statusCode() == 200,
        "Expected status code is 200 but the status is: " + response.statusCode());

  }

  public int getNumberOfDevices() {
    String baseURI = baseUri + drs_endpoint;
    RequestParams requestParams = new RequestParams();
    requestParams.setBaseURI(baseURI);
    requestParams.setContentType(ContentType.APPLICATION_JSON);
    requestParams.setAuthorization(accessToken);
    RequestSpecification request = AxoomRequest.getPreparedRequest(requestParams);

    Response response = request.get();
    logger.log(Level.INFO, response.then().log().all(true).toString());
    Assert.assertTrue(response.statusCode() == 200,
        "Expected status code is 200 but the status is: " + response.statusCode());
    JsonParser parser = new JsonParser();
    JsonArray responseJson = (JsonArray) parser.parse(response.asString());
    return responseJson.size();
  } 
}
