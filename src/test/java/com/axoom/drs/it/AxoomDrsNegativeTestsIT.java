package com.axoom.drs.it;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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

@Story("Negative tests for device creation")
public class AxoomDrsNegativeTestsIT extends WebDriverTest {
  private String tenantId;
  private String clientId;
  private String redirectUri;
  private String accessToken;
  private String cert;
  private String secret;
  private String cisUrl;
  private String drs_endpoint;
  private String deviceId;
  private String baseUri;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger = Logger.getLogger(AxoomDrsNegativeTestsIT.class.getName());

  @BeforeClass
  public void beforeClass(ITestContext context) {
    tenantId = System.getenv("TENANT_ID");
    clientId = System.getenv("DRS_CLIENT_ID");
    redirectUri = System.getenv("DRS_REDIRECT_URI");
    cisUrl = System.getenv("CIS_URL");
    secret = System.getenv("SECRET");
    accessToken = (String) context.getAttribute("accessToken");
    deviceId = null;
    drs_endpoint = System.getenv("DRS_DEVICES_API");
    baseUri = "https://device-registration-service.dev.myaxoom.com";
    cert =
        "-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE+SbFi/8yDdq3rOBOSVTcja4HHUJ7DXhsKds3iqMU8cP2bX7bNkb3DSsHwO1/29bJrX2IWiC+xfXSoEePmsVQNw==\n-----END PUBLIC KEY-----";
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

    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }
  
  @AfterClass 
  public void deleteDevice() {

    RestAssured.baseURI = baseUri + drs_endpoint + "/" + deviceId;
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

  @Test
  @Description("Create a device with invalid provider using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createDeviceWithInvalidProviderTest() {
    // prepare Device Configuration Values
    Map<String, String> config = new HashMap<>();
    config.put("publicKeyFormat", "EC256_pem");
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
    RestAssured.baseURI = baseUri + drs_endpoint;
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
  
  @Test
  @Description("Verify creating a device with invalid certificate format using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createDeviceWithInvalidCertFormatTypeTest() {
    // prepare Device Configuration Values
    Map<String, String> config = new HashMap<>();
    config.put("publicKeyFormat", "rsa_x50_pem");
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
    if (response.statusCode() == 400) {
      System.out.println(response.then().log().all(true));
      System.out.println("xxxxxxxxxxxxxxxxxxx\n" + response.getBody().prettyPrint()
          + "\nxxxxxxxxxxxxxxxxxxx\n");
      String errorMessage = "The publicKeyFormat has to match one of following formats: RSA_PEM, ES256_PEM, RSA_X509_PEM, ES256_X509_PEM";
      Assert.assertTrue(response.getBody().asString().contains(errorMessage));

    } else {
      System.out.println(response.statusCode());
    }
  }
  
  
  @Test
  @Description("Verify creating a device with invalid certificate using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createDeviceWithInvalidCertTest() {
    // prepare Device Configuration Values
    Map<String, String> config = new HashMap<>();
    config.put("publicKeyFormat", "rsa_x509_pem");
    config.put("publicKey", cert + 1);
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
    if (response.statusCode() == 400) {
      System.out.println(response.then().log().all(true));
      System.out.println("xxxxxxxxxxxxxxxxxxx\n" + response.getBody().prettyPrint()
          + "\nxxxxxxxxxxxxxxxxxxx\n");
      String errorMessage = "Invalid RS256 certificate";
      Assert.assertTrue(response.getBody().asString().contains(errorMessage));

    } else {
      System.out.println(response.statusCode());
    }
  }


  @Test
  @Description("Create a device using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void createDeviceTest() {
    // prepare Device Configuration Values
    Map<String, String> config = new HashMap<>();
    config.put("publicKeyFormat", "ES256_PEM");
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
      Assert.fail("Create device failed: " + response.getBody().prettyPrint());
    }
  }  

  @Test(dependsOnMethods = {"createDeviceTest"})
  @Description("Update a device with wrong IoT provider using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
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
    RestAssured.baseURI = baseUri + drs_endpoint + "/" + deviceId;
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
  
  @Test(dependsOnMethods = {"createDeviceTest"})
  @Description("Update a device with no location using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
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
    RestAssured.baseURI = baseUri + drs_endpoint + "/" + deviceId;
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

  @Test(dependsOnMethods = {"createDeviceTest"})
  @Description("Update a device with wrong Certificate using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
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
    RestAssured.baseURI = baseUri + drs_endpoint + "/" + deviceId;
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
  

  @Test(dependsOnMethods = {"createDeviceTest"})
  @Description("Update a device with No config using DRS APIs")
  @Severity(SeverityLevel.BLOCKER)
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
    RestAssured.baseURI = baseUri + drs_endpoint + "/" + deviceId;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);
    request.body(json);
    logger.log(Level.INFO, request.log().all(true).toString());
    Response response = request.put();
    logger.log(Level.INFO, response.then().log().all(true).toString());
    Assert.assertTrue(response.statusCode() == 400,
        "Expected tatus code is 400 but the status is: " + response.statusCode());

  }
}
