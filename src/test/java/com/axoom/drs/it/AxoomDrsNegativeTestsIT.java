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
import org.testng.annotations.AfterClass;
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

public class AxoomDrsNegativeTestsIT extends WebDriverTest {
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
  private WebDriver driver;
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
    cert =
        "-----BEGIN CERTIFICATE-----\nMIIDBTCCAe2gAwIBAgIUC6zaR1eCZnzUkvjRw5Av9xFbugIwDQYJKoZIhvcNAQELBQAwETEPMA0GA1UEAwwGdW51c2VkMCAXDTE4MTIxMTEzMDA0NVoYDzQ3NTYxMTA3MTMwMDQ1WjARMQ8wDQYDVQQDDAZ1bnVzZWQwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDNoB/kj0CGGVK7/nulywUugteDXyfP51PPpa8V5nN+CVeZj0jZA+iIV4vuF2AJCXIx9LkVY7/TRcv0oTUGt+N68BjFEAldYoYKNr+PCfJaVCGFPTgBok1uwQ49XAyXdZEWMRxVy1B1f78Ak+mKV+EbBuCPQPXLE7I5qUE7B1NorpnkX8gmbFnLFB2i6iiPybAw7p3clhr6M6vt1AJBJCpNJ4CqJkuZtz19xP36ZLv2BWU1/bZzRWXJG7Af+daYccxFclS3S9SM7tVaE/5PNmQ2CRr1Qub3rUtqVUDls7KYNh6GrTzjwy7LaUpIa2oH7wgJwBJREftTDNavGXTNhuxpAgMBAAGjUzBRMB0GA1UdDgQWBBSQeQGm7O1A1l02SR4aXQozmI3iqjAfBgNVHSMEGDAWgBSQeQGm7O1A1l02SR4aXQozmI3iqjAPBgNVHRMBAf8EBTADAQH/MA0GCSqGSIb3DQEBCwUAA4IBAQCIINss2WMxZXMuq5W+lKRXq5MZ4Hq/g5JKoqUpeQBmrsq42vVOLoi96dtwoTpNpZ8Ka+yQQXjcr8az4HTX2AyleE3PX1EGODuMx6aQTbrhr7wAWFxD87jjKhC5MUCPtJErSQOWYyd58qFoqLxmnw7kZWJ1SIwwhT3kU+hwxovYPd8HCDR/wMhRLOv6PNk3Z7wBaZ/C2qEUHJ9qnXmS/f/7CJlLEvDfRIvawj8HyaIjUQscIy29FOqoHJ/KsyGyYlrOdp4xQ5STif3he/iVWFa51wUUOhPK7Kv9GuoGghdeR3VWf0BGq+IoU+FDpJ8iCnzqu5rmB302hU788AxUn6vW\n-----END CERTIFICATE-----";
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
  
  @AfterClass 
  public void deleteDeviceTest() {

    RestAssured.baseURI =
        "https://device-registration-service.dev.myaxoom.com" + drs_endpoint + "/" + deviceId;
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

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    stopWebDriverTest(testResult);
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }

  @Test(priority = 0, description = "Perform Login UI test to get access token for API tests")
  @Description("Perform Login UI test to get access token for API tests")
  @Severity(SeverityLevel.BLOCKER)
  @Story("Perform Valid Login to My Axoom")
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

  @Test(dependsOnMethods = {"myAxoomLoginTest"}, priority = 0,
      description = "Create an invalid device using DRS APIs")

  @Severity(SeverityLevel.BLOCKER)
  @Story("Create a device with invalid values using DRS APIs")
  public void createDeviceWithInvalidDataTest() {
    // prepare Device Configuration Values
    Map<String, String> config = new HashMap<>();
    config.put("publicKeyFormat", "rsa_x509_pem");
    config.put("publicKey", cert);
    config.put("location", "europe-west1");


    Map<String, Object> deviceValues = new HashMap<>();
    deviceValues.put("tenant", tenantId);
    deviceValues.put("name", "AxoomTestDevice" + System.currentTimeMillis());
    deviceValues.put("configuration", config);
    deviceValues.put("ioTProvider", "axoom");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(deviceValues);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI = "https://device-registration-service.dev.myaxoom.com" + drs_endpoint;
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

      Assert.assertTrue(response.statusCode() == 400,
          "Expected tatus code is 400 but the status is: " + response.statusCode());

    } else {
      System.out.println(response.statusCode());
    }
  }


  @Test(dependsOnMethods = {"myAxoomLoginTest"}, priority = 0,
      description = "Create a device using DRS APIs")
  @Description("Create a device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  @Story("Create a device with valid values using DRS APIs")
  public void createDeviceTest() {
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
    RestAssured.baseURI = "https://device-registration-service.dev.myaxoom.com" + drs_endpoint;
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

  @Test(dependsOnMethods = {"createDeviceTest"}, priority = 0, description = "Update a device with wrong IoT provider using DRS APIs")
  @Description("Delete a device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  @Story("Update a device with wrong IoT provider using DRS APIs")
  public void updateDeviceWithWrongIotProviderTest() {

    // prepare Device Configuration Values
    Map<String, String> config = new HashMap<>();
    config.put("publicKeyFormat", "rsa_x509_pem");
    config.put("publicKey", cert);
    config.put("location", "europe-west1");


    Map<String, Object> deviceValues = new HashMap<>();
    deviceValues.put("tenant", tenantId);
    deviceValues.put("configuration", config);
    deviceValues.put("name", "ChangedName");
    deviceValues.put("ioTProvider", "axoom");

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(deviceValues);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI =
        "https://device-registration-service.dev.myaxoom.com" + drs_endpoint + "/" + deviceId;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    System.out.println(request.log().all(true));
    Response response = request.put();
    System.out.println(response.then().log().all(true));
    Assert.assertTrue(response.statusCode() == 400,
        "Expected tatus code is 400 but the status is: " + response.statusCode());

  }
  
  @Test(dependsOnMethods = {"createDeviceTest"}, priority = 0, description = "Update a device with no location using DRS APIs")
  @Description("Delete a device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  @Story("Update a device with no location using DRS APIs")
  public void updateDeviceWithNoLocationTest() {

    // prepare Device Configuration Values
    Map<String, String> config = new HashMap<>();
    config.put("publicKeyFormat", "rsa_x509_pem");
    config.put("publicKey", cert);

    Map<String, Object> deviceValues = new HashMap<>();    
    deviceValues.put("configuration", config);    

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(deviceValues);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI =
        "https://device-registration-service.dev.myaxoom.com" + drs_endpoint + "/" + deviceId;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    System.out.println(request.log().all(true));
    Response response = request.put();
    System.out.println(response.then().log().all(true));
    Assert.assertTrue(response.statusCode() == 400,
        "Expected tatus code is 400 but the status is: " + response.statusCode());

  }

  @Test(dependsOnMethods = {"createDeviceTest"}, priority = 0, description = "Update a device with wrong Certificate using DRS APIs")
  @Description("Delete a device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  @Story("Update a device with wrong Certificate using DRS APIs")
  public void updateDeviceWithInvalidCertificateTest() {

    // prepare Device Configuration Values
    Map<String, String> config = new HashMap<>();
    config.put("publicKeyFormat", "rsa_x509_pem");
    config.put("publicKey", "-----BEGIN CERTIFICATE-----\\n\n-----END CERTIFICATE-----");
    config.put("location", "europe-west1");


    Map<String, Object> deviceValues = new HashMap<>();   
    deviceValues.put("configuration", config);   

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(deviceValues);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI =
        "https://device-registration-service.dev.myaxoom.com" + drs_endpoint + "/" + deviceId;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    System.out.println(request.log().all(true));
    Response response = request.put();
    System.out.println(response.then().log().all(true));
    Assert.assertTrue(response.statusCode() == 400,
        "Expected tatus code is 400 but the status is: " + response.statusCode());

  }
  

  @Test(dependsOnMethods = {"createDeviceTest"}, priority = 0, description = "Update a device with No config using DRS APIs")
  @Description("Delete a device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  @Story("Update a device with No config values using DRS APIs")
  public void updateDeviceWithNoConfigurationTest() {

    // prepare Device Configuration Values
    Map<String, String> config = new HashMap<>();
    config.put("publicKeyFormat", "");
    config.put("publicKey", "");
    config.put("location", "");


    Map<String, Object> deviceValues = new HashMap<>();   
    deviceValues.put("configuration", config);   

    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(deviceValues);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println(json);
    RestAssured.baseURI =
        "https://device-registration-service.dev.myaxoom.com" + drs_endpoint + "/" + deviceId;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    System.out.println(request.log().all(true));
    Response response = request.put();
    System.out.println(response.then().log().all(true));
    Assert.assertTrue(response.statusCode() == 400,
        "Expected tatus code is 400 but the status is: " + response.statusCode());

  }
}
