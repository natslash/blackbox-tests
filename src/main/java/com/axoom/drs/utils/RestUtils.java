package com.axoom.drs.utils;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {

  public static RequestSpecification prepareRequest(Map<String, String> requestParams) {
    
    String clientId = requestParams.get("clientId");
    String secret = requestParams.get("secret");    
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
  
  public static String getAccessTokenFromClientCredsFlow(Map<String, String> requestParams) {
    RestAssured.baseURI = requestParams.get("baseUrl");
    RequestSpecification request = RestAssured.given();
    
    request.formParam("scope", requestParams.get("scope")).formParam("grant_type", "client_credentials")
    .formParam("client_id", requestParams.get("clientId")).formParam("client_secret", requestParams.get("clientSecret"));
    
    request.header("Content-Type",requestParams.get("contentType"));
    Response response = request.post();
    if (response.statusCode() == 200) {
      JsonPath jsonPathEvaluator = response.jsonPath();
      return jsonPathEvaluator.get("access_token");
    }
    else
      return null;
    
  }
  
  public static void main(String[] args) {   
    Map<String, String> requestParams = new HashMap<String, String>();
    requestParams.put("baseUrl", "https://account.dev.myaxoom.com/connect/token");
    requestParams.put("scope", "records-query-scope.read");
    requestParams.put("clientId", "mvp-records-query-api-test-client");
    requestParams.put("clientSecret", "supersecret");
    requestParams.put("contentType", "application/x-www-form-urlencoded");
    
    String accessToken = getAccessTokenFromClientCredsFlow(requestParams);
    System.out.println(accessToken);
  }
}
