package com.axoom.dcf.it;


import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.axoom.codeflow.CodeFlows;
import com.axoom.constants.EnvVariables;
import com.axoom.drs.pages.MyAxoomLoginPage;
import com.axoom.talos.framework.WebDriverTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Story("Positive test cases for Device Code Flow")
public class AxoomDcfPositiveTestsIT extends WebDriverTest {
  private MyAxoomLoginPage myAxoomLoginPage;
  private String inputEmail;
  private String inputPassword;
  private String tenantId;
  private String clientId;
  private String redirectUri;  
  private String accessToken;
  private String idToken;
  private String secret;
  private String cisUrl;
  private String deviceCode;
  private String userCode;
  private WebDriver driver;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger = Logger.getLogger(AxoomDcfPositiveTestsIT.class.getName());
  
  //Get file from resources folder
  private File resourcesDirectory = new File("src/test/resources/");
  private String subjectsPropertiesFilePath;
  private Properties prop;
  private OutputStream output;
  
  @BeforeClass
  public void beforeClass() {
    inputEmail = EnvVariables.SYSTEM_INTEGRATOR_EMAIL;
    inputPassword = EnvVariables.SYSTEM_INTEGRATOR_PASSWORD;
    tenantId = EnvVariables.TENANT_ID;
    clientId = "blackboxtest01-test1";
    redirectUri = EnvVariables.DRS_REDIRECT_URI;
    cisUrl = EnvVariables.CIS_URL;
    secret = EnvVariables.SECRET;
    accessToken = null;
    idToken = null;
    deviceCode = null;
    userCode = null;
    subjectsPropertiesFilePath = resourcesDirectory.getAbsolutePath() + "/" + "subjects.properties";
    prop = new Properties();    
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
  @Description("Get device & user codes")
  @Severity(SeverityLevel.BLOCKER)
  public void getCodesTest() {
    Response response = CodeFlows.getUserNDeviceCodes(clientId);
    logger.log(Level.INFO, response.then().log().all(true).toString());
    logger.log(Level.INFO, "-------------End getAccessToken-------------\n");
    if (response.statusCode() == 200) {
      JsonPath jsonPathEvaluator = response.jsonPath();
      deviceCode = jsonPathEvaluator.get("device_code");
      userCode = jsonPathEvaluator.get("user_code");
      assertTrue(!deviceCode.isEmpty());
      assertTrue(!userCode.isEmpty());
    } else {
      fail(response.then().log().all(true).toString());
    }

  }

  @Test(dependsOnMethods = {"getCodesTest"})
  @Description("Perform Login UI test to grant access for user code")
  @Severity(SeverityLevel.BLOCKER)
  public void grantAccessTest(ITestContext context) throws InterruptedException {
    assertTrue(grantOrDenyAccess("records", userCode));
  }

  @Test(dependsOnMethods = {"grantAccessTest"}, groups = {"subjects"})
  @Description("Test to get access token from device code")
  @Severity(SeverityLevel.BLOCKER)
  public void getAccessTokenTest(ITestContext context) {
    Response response = CodeFlows.getAccessToken(clientId, deviceCode);
    logger.log(Level.INFO, response.then().log().all(true).toString());
    if (response.statusCode() == 200) {
      JsonPath jsonPathEvaluator = response.jsonPath();
      idToken = deviceCode = jsonPathEvaluator.get("id_token");
      accessToken = jsonPathEvaluator.get("access_token");
      prop.setProperty("idToken", idToken);
      prop.setProperty("accessToken", accessToken);
      assertTrue(!idToken.isEmpty());
      assertTrue(!accessToken.isEmpty()); 
      // save properties to project root folder
      try {
        output = new FileOutputStream(subjectsPropertiesFilePath);
        prop.store(output, null);
      } catch (IOException e) {         
        e.printStackTrace();
      }
    } else {
      fail(response.then().log().all(true).toString());
    }
  }

  @Test(dependsOnMethods = {"getAccessTokenTest"})
  @Description("Test to get access token from an already used device code")
  @Severity(SeverityLevel.BLOCKER)
  public void getAccessTokenForUsedCode() {
    Response response = CodeFlows.getAccessToken(clientId, deviceCode);
    logger.log(Level.INFO, response.then().log().all(true).toString());
    if (response.statusCode() == 400) {
      JsonPath jsonPathEvaluator = response.jsonPath();
      String errorMessage = deviceCode = jsonPathEvaluator.get("error");
      assertTrue(errorMessage.equals("invalid_grant"));
    } else {
      fail(response.then().log().all(true).toString());
    }
  }

  @Test
  @Description("Test to get access token from an already used device code")
  @Severity(SeverityLevel.BLOCKER)
  public void getAccessTokenForExpiredCode() {
    String localDeviceCode = null;
    String localUserCode = null;
    Response response = CodeFlows.getUserNDeviceCodes(clientId);
    logger.log(Level.INFO, response.then().log().all(true).toString());
    logger.log(Level.INFO, "-------------End getAccessToken-------------\n");
    if (response.statusCode() == 200) {
      JsonPath jsonPathEvaluator = response.jsonPath();
      localDeviceCode = jsonPathEvaluator.get("device_code");
      localUserCode = jsonPathEvaluator.get("user_code");
    }
    if (grantOrDenyAccess("mappings", localUserCode)) {
      try {
        TimeUnit.SECONDS.sleep(60);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      response = CodeFlows.getAccessToken(clientId, localDeviceCode);
    }

    if (response.statusCode() == 400) {
      JsonPath jsonPathEvaluator = response.jsonPath();
      String errorMessage = deviceCode = jsonPathEvaluator.get("error");
      assertTrue(errorMessage.equals("expired_token"));
    } else {
      fail(response.then().log().all(true).toString());
    }
  }


  @Test
  @Description("Test to get access token from an already used device code")
  @Severity(SeverityLevel.BLOCKER)
  public void getAccessTokenForUnconfirmedCode() {
    String localDeviceCode = null;
    Response response = CodeFlows.getUserNDeviceCodes(clientId);
    logger.log(Level.INFO, response.then().log().all(true).toString());
    logger.log(Level.INFO, "-------------End getAccessToken-------------\n");
    if (response.statusCode() == 200) {
      JsonPath jsonPathEvaluator = response.jsonPath();
      localDeviceCode = jsonPathEvaluator.get("device_code");
    }

    response = CodeFlows.getAccessToken(clientId, localDeviceCode);

    if (response.statusCode() == 400) {
      JsonPath jsonPathEvaluator = response.jsonPath();
      String errorMessage = deviceCode = jsonPathEvaluator.get("error");
      assertTrue(errorMessage.equals("authorization_pending"));
    } else {
      fail(response.then().log().all(true).toString());
    }
  }

  public boolean grantOrDenyAccess(String scope, String userCode) {
    String baseUrl = cisUrl + "/device?userCode=" + userCode;
    try {
      URIBuilder grantAccessUrl = new URIBuilder(baseUrl);
      logger.log(Level.INFO, grantAccessUrl.toString());
      getDriver().get(grantAccessUrl.toString());
      myAxoomLoginPage = initPage(driver, MyAxoomLoginPage.class);
      myAxoomLoginPage.loginToMyAxoom(inputEmail, inputPassword);
      myAxoomLoginPage.selectTenantAndReturnAuthCode(tenantId);
      return myAxoomLoginPage.grantAccess("subjects");
    } catch (URISyntaxException e) {
      e.printStackTrace();
      fail("Test failed");
      return false;
    }
  }
}
