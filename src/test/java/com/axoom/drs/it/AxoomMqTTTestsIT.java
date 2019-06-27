package com.axoom.drs.it;

import java.io.File;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.axoom.constants.ContentType;
import com.axoom.constants.EnvVariables;
import com.axoom.drs.devices.MqttExample;
import com.axoom.drs.pages.MyAxoomLoginPage;
import com.axoom.talos.framework.WebDriverTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import axoom.filters.v1.Filter.StringPropertyFilter;
import axoom.records.v1.RecordsClient;
import axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse;
import axoom.records.v1.RecordsService.RecordsSubscriptionsFilter;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Story("MQTT Device simulation and messaging test")
public class AxoomMqTTTestsIT extends WebDriverTest {
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
  private String projectId;
  private String providerRegion;
  private String baseUri;
  private WebDriver driver;
  private RecordsClient client;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger = Logger.getLogger(AxoomMqTTTestsIT.class.getName());

  @BeforeClass
  public void beforeClass() {
    inputEmail = EnvVariables.SYSTEM_INTEGRATOR_EMAIL;
    inputPassword = EnvVariables.SYSTEM_INTEGRATOR_PASSWORD;
    tenantId = EnvVariables.TENANT_ID;
    clientId = EnvVariables.DRS_CLIENT_ID;
    redirectUri = EnvVariables.DRS_REDIRECT_URI;
    scope = EnvVariables.DRS_SCOPES;
    cisUrl = EnvVariables.CIS_URL;
    secret = EnvVariables.SECRET;
    projectId = EnvVariables.PROJECT_ID;
    providerRegion = EnvVariables.PROVIDER_REGION;
    drs_endpoint = EnvVariables.DRS_DEVICES_API;
    authCode = null;
    accessToken = null;
    deviceId = null;
    baseUri = EnvVariables.DRS_BASEURI;
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
    this.driver = super.getDriver();
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @AfterClass
  public void deleteDevice() {

    RestAssured.baseURI = baseUri + drs_endpoint + "/" + deviceId;
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", ContentType.APPLICATION_JSON);
    request.header("Authorization", "Bearer " + accessToken);

    logger.log(Level.INFO, "-------------Request-------------\n" + request.log().all(true));
    Response response = request.delete("/");
    logger.log(Level.INFO,
        "-------------Response-------------\n" + response.then().log().all(true).toString());
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

  @Test(priority = 0)
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

    RestAssured.baseURI = baseUri + drs_endpoint;
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
      deviceId = response.getBody().jsonPath().getString("id");
      Assert.assertTrue(response.statusCode() == 201,
          "Expected tatus code is 201 but the status is: " + response.statusCode());
      Assert.assertTrue(!deviceId.isEmpty(), "Device is ID is null");
    } else {
      Assert.fail("Create device failed: " + response.getBody().prettyPrint());
    }
  }

  @Test(dependsOnMethods = {"createDeviceTest"})
  @Description("Simulate a device and send an MQTT message")
  @Severity(SeverityLevel.BLOCKER)
  public void sendMessageViaMqttAndReceiveTest() {
    // Get file from resources folder
    File resourcesDirectory = new File("src/test/resources/com/automation/keypairs");
    String privateKeyFilePath = resourcesDirectory.getAbsolutePath() + "/" + "ec_private_pkcs8";
    String[] args = {"-project_id=" + projectId, "-registry_id=" + tenantId,
        "-cloud_region=" + providerRegion, "-device_id=" + deviceId,
        "-private_key_file=" + privateKeyFilePath, "-algorithm=ES256"};
    int size = 0;
    
    client = new RecordsClient("qrecords.dev.myaxoom.com", 443);
    try {
      MqttExample.main(args);

      StringPropertyFilter value = StringPropertyFilter.newBuilder().setValue("value").build();
      RecordsSubscriptionsFilter filter = RecordsSubscriptionsFilter.newBuilder().setSubjectTypeName(value ).build();
      ListRecordsSubscriptionsResponse recSubResponse = client.listRecordsSubscriptions("subject", filter );
      size = recSubResponse.getSerializedSize();
      client.shutdown();
    } catch (InterruptedException e) {
      Assert.fail("Error occurred!");
      e.printStackTrace();
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        if (size > 0)
          Assert.assertTrue(true);
        else
          Assert.fail("Count is: " + size);
      } else {
        Assert.fail("Error occurred!");
        sre.printStackTrace();
      }

    } catch (Exception e) {
      Assert.fail("Sending message failed" + "\n" + e.getMessage());
    }
  }

}
