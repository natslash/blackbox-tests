package com.axoom.codeflow;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.axoom.constants.EnvVariables;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CodeFlows {
  
  private static String cisUrl = EnvVariables.CIS_URL;
  private static String secret = EnvVariables.SECRET;
  //private static String scope = "openid tenant identityapi.tenant https://apis.axoom.com/auth/subjects https://apis.axoom.com/auth/shares";
  private static String scope = "";
  private static final Logger logger = Logger.getLogger(CodeFlows.class.getName()); 
  
  public static Response getUserNDeviceCodes(String clientId) {
    RestAssured.baseURI = cisUrl + "/connect/deviceauthorization";
    logger.log(Level.INFO,
        "-------------Begin getAccessToken-------------\n" + RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();
    request.formParam("client_id", clientId).formParam("scope", scope).formParam("client_secret", secret);
    
    //NO scope
    //request.formParam("client_id", clientId).formParam("client_secret", secret);
    
    request.header("Content-Type", "application/x-www-form-urlencoded");
    logger.log(Level.INFO, request.log().all(true).toString());

    return request.post();
  }  
  
  
  public static Response getAccessToken(String clientId, String deviceCode) {
    RestAssured.baseURI = cisUrl + "/connect/token";
    logger.log(Level.INFO,
        "-------------Begin getAccessToken-------------\n" + RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();
    request.formParam("client_id", clientId).formParam("scope", scope)
        .formParam("client_secret", secret).formParam("device_code", deviceCode)
        .formParam("grant_type", "urn:ietf:params:oauth:grant-type:device_code");
    request.header("Content-Type", "application/x-www-form-urlencoded");
    logger.log(Level.INFO, request.log().all(true).toString());
    return request.post();    
  }

}
