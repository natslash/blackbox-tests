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
import com.axoom.drs.utils.ContentType;
import com.axoom.talos.framework.WebDriverTest;
import axoom.records.v1.QrecordsClient;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Story("Negative test cases for DCS APIs")
public class AxoomDcsNegativeTestsIT extends WebDriverTest {
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
  private String dcs_endpoint;
  private String dataCompositionId;
  private String baseUri;
  private WebDriver driver;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger = Logger.getLogger(AxoomDcsNegativeTestsIT.class.getName());

  @BeforeClass
  public void beforeClass() {
    inputEmail = System.getenv("SYSTEM_INTEGRATOR_EMAIL");
    inputPassword = System.getenv("SYSTEM_INTEGRATOR_PASSWORD");
    tenantId = "blackboxtest02";
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
    
     String baseUrl = cisUrl + "/connect/authorize";
     
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
      requestParams.put("contentType", ContentType.FORM_URL_ENCODED);
      accessToken = myAxoomLoginPage.getAccessToken(requestParams);
      context.setAttribute("accessToken", accessToken);
      Reporter.log("Access Token Obtained: " + accessToken);      
      Assert.assertTrue(!accessToken.isEmpty(), "access token is empty");

    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

  @Test(dependsOnMethods = {"myAxoomLoginTest"})
  @Description("Get a data composition�s details from other tenant using DCS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getDataCompositionDetailsFromOtherTenantTest(ITestContext context) {
    dataCompositionId = (String) context.getAttribute("dataCompositionId");
    System.out.println("Shared data composition ID is: " + dataCompositionId);
    RestAssured.baseURI = baseUri + dcs_endpoint + "/" + dataCompositionId;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", ContentType.APPLICATION_JSON);
    request.header("Authorization", "Bearer " + accessToken);

    logger.log(Level.INFO, request.log().all(true).toString());
    Response response = request.get();
    logger.log(Level.INFO, response.then().log().all(true).toString());
    Assert.assertTrue(response.statusCode() == 404,
        "Expected status code is 404 but the status is: " + response.statusCode());

  } 
}
