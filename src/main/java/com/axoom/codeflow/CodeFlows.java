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
  private static String scope = "openid tenant";  
  private static final Logger logger = Logger.getLogger(CodeFlows.class.getName()); 
  
  public static Response getUserNDeviceCodes(String clientId, String scope) {
    RestAssured.baseURI = cisUrl + "/connect/deviceauthorization";
    logger.log(Level.INFO,
        "-------------Begin getAccessToken-------------\n" + RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();
    request.formParam(clientId, scope)
        .formParam("client_secret", secret);
    request.header("Content-Type", "application/x-www-form-urlencoded");
    logger.log(Level.INFO, request.log().all(true).toString());

    return request.post();
  }  
  
  
  public static Response getAccessToken(String deviceCode) {
    RestAssured.baseURI = cisUrl + "/connect/token";
    logger.log(Level.INFO,
        "-------------Begin getAccessToken-------------\n" + RestAssured.baseURI);
    RequestSpecification request = RestAssured.given();
    request.formParam("client_id", "blackboxtest01-test1").formParam("scope", scope)
        .formParam("client_secret", secret).formParam("device_code", deviceCode)
        .formParam("grant_type", "urn:ietf:params:oauth:grant-type:device_code");
    request.header("Content-Type", "application/x-www-form-urlencoded");
    logger.log(Level.INFO, request.log().all(true).toString());
    return request.post();    
  }

}
