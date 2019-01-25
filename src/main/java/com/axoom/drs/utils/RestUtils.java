package com.axoom.drs.utils;
import java.util.Base64;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestUtils {

  public static RequestSpecification prepareRequest(Map<String, String> requestParams) {
    
    String clientId = requestParams.get("clientId");
    String secret = requestParams.get("secret");
    String redirectUri = requestParams.get("redirectUri");
    String authCode = requestParams.get("authCode");
    String authType = requestParams.get("authType");
    String contentType = requestParams.get("contentType");
    
    String authValues =  (clientId + ":" + secret);
    String authValuesEncoded = new String(Base64.getEncoder().encode((authValues.getBytes())));
    RestAssured.baseURI = requestParams.get("baseUri");
    RequestSpecification request = RestAssured.given();    
    request.header("Content-Type",contentType);
    request.header("Authorization", authType + " "+  authValuesEncoded);
    return request;
    
  }
}
