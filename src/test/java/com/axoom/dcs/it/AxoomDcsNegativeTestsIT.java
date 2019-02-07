package com.axoom.dcs.it;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.axoom.talos.framework.WebDriverTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Story("Negative test cases for DCS APIs")
public class AxoomDcsNegativeTestsIT extends WebDriverTest {
  private String clientId;
  private String redirectUri;  
  private String accessToken;
  private String secret;
  private String cisUrl;
  private String dcs_endpoint;
  private String dataCompositionId;
  private String baseUri;
  private Map<String, String> requestParams = new HashMap<>();

  @BeforeClass
  public void beforeClass(ITestContext context) {
    clientId = System.getenv("DCS_CLIENT_ID");
    redirectUri = System.getenv("DCS_REDIRECT_URI");
    cisUrl = System.getenv("CIS_URL");
    secret = System.getenv("SECRET");
    accessToken = (String) context.getAttribute("accessToken");
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
  @Description("Get a data composition´s details from other tenant using DCS APIs")
  @Severity(SeverityLevel.BLOCKER)
  public void getDataCompositionDetailsFromOtherTenantTest(ITestContext context) {
    dataCompositionId = (String) context.getAttribute("dataCompositionId");
    System.out.println("Shared data composition ID is: " + dataCompositionId);
    RestAssured.baseURI = baseUri + dcs_endpoint + "/" + dataCompositionId;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);

    System.out.println(request.log().all(true));
    Response response = request.get();
    System.out.println(response.then().log().all(true));
    Assert.assertTrue(response.statusCode() == 404,
        "Expected status code is 200 but the status is: " + response.statusCode());

  }

  public int getNumberOfDataCompositions() {
    RestAssured.baseURI = baseUri + dcs_endpoint;
    System.out.println(RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();

    request.header("Content-Type", "application/json");
    request.header("Authorization", "Bearer " + accessToken);

    System.out.println(request.log().all(true));
    Response response = request.get();
    System.out.println(response.then().log().all(true));
    Assert.assertTrue(response.statusCode() == 200,
        "Expected status code is 200 but the status is: " + response.statusCode());
    JsonParser parser = new JsonParser();
    JsonArray responseJson = (JsonArray) parser.parse(response.asString());
    return responseJson.size();
  }

}
