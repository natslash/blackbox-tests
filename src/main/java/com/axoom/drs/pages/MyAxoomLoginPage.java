package com.axoom.drs.pages;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.axoom.talos.framework.WebDriverPage;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class MyAxoomLoginPage extends WebDriverPage {

  private WebElement inputEmailField;
  private WebElement inputPasswordField;
  private WebElement loginButton;
  private WebElement tenantField;
  private WebElement scopeCheckBox;
  private WebElement grantAccessButton;  
  private WebElement accessGrantedMessage;  


  private String inputEmailFieldId = "Input_Email";
  private String inputPasswordFieldId = "Input_Password";
  private String loginButtonId = "button-login";
  private String grantAccessButtonXpath = "//button[contains(@id,'GrantConsent_Button')]";  
  private String accessGrantedMessageXpath =
      "//h1[contains(@id,'DeviceAuthorization_ConsentGranted_Title')]";
 

  private static final Logger logger = Logger.getLogger(MyAxoomLoginPage.class.getName());

  public MyAxoomLoginPage(WebDriver driver) {
    super(driver);
  }

  public void loginToMyAxoom(String email, String password) {

    inputEmailField = getDriver().findElement(By.id(inputEmailFieldId));
    if (inputEmailField.isDisplayed() && inputEmailField.isEnabled()) {
      inputEmailField.sendKeys(email);
    }

    inputPasswordField = getDriver().findElement(By.id(inputPasswordFieldId));
    inputPasswordField.sendKeys(password);

    loginButton = getDriver().findElement(By.id(loginButtonId));
    clickAndWaitForPageLoad(loginButton, 1);
  }

  public String selectTenantAndReturnAuthCode(String tenantId) {
    String tenantXpath = "//button[contains(@formaction, 'tenant=" + tenantId + "')]";
    tenantField = getDriver().findElement(By.xpath(tenantXpath));
    clickAndWaitForPageLoad(tenantField, 1);
    String urlWithAuthCode = getDriver().getCurrentUrl();
    String authCode = null;
    List<NameValuePair> params;
    try {
      params = URLEncodedUtils.parse(new URI(urlWithAuthCode), Charset.forName("UTF-8"));
      for (NameValuePair param : params) {
        if (param.getName().equals("code"))
          authCode = param.getValue();
      }
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    return authCode;
  }

  public String getAccessToken(Map<String, String> requestParams) {

    String clientId = requestParams.get("clientId");
    String secret = requestParams.get("secret");
    String redirectUri = requestParams.get("redirectUri");
    String authCode = requestParams.get("authCode");
    String contentType = requestParams.get("contentType");
    String cisUrl = requestParams.get("cisUrl");

    RestAssured.baseURI = cisUrl + "/connect/token";
    logger.log(Level.INFO,
        "-------------Begin getAccessToken-------------\n" + RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();
    request.formParam("code", authCode).formParam("grant_type", "authorization_code")
        .formParam("client_id", clientId).formParam("redirect_uri", redirectUri)
        .formParam("client_secret", secret);
    request.header("Content-Type", contentType);
    logger.log(Level.INFO, request.log().all(true).toString());

    Response response = request.post();
    logger.log(Level.INFO, response.then().log().all(true).toString());
    logger.log(Level.INFO, "-------------End getAccessToken-------------\n");
    if (response.statusCode() == 200) {
      JsonPath jsonPathEvaluator = response.jsonPath();
      return jsonPathEvaluator.get("access_token");
    }
    return response.asString();
  }

  public boolean grantAccess(String scope) {
    String message = null;
    String scopeCheckBoxXpath = "//input[contains(@value, '" + scope + "')]";
    scopeCheckBox = getDriver().findElement(By.xpath(scopeCheckBoxXpath));
    scopeCheckBox.click();

    grantAccessButton = getDriver().findElement(By.xpath(grantAccessButtonXpath));
    clickAndWaitForPageLoad(grantAccessButton, 2);
    accessGrantedMessage = getDriver().findElement(By.xpath(accessGrantedMessageXpath));
    message = accessGrantedMessage.getText();
    if (message.equals("Access granted")) {
      return true;
    } else {
      return false;
    }
  }
}
