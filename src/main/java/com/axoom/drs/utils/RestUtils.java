package com.axoom.drs.utils;

import java.util.Base64;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {

  private static final Logger logger = Logger.getLogger(RestUtils.class.getName());

  /**
   * 
   * @param requestParams
   * @return request
   */
  public static RequestSpecification getPreparedRequest(Map<String, String> requestParams) {

    String clientId = requestParams.get("clientId");
    String secret = requestParams.get("secret");
    String authType = requestParams.get("authType");
    String contentType = requestParams.get("contentType");

    String authValues = (clientId + ":" + secret);
    String authValuesEncoded = new String(Base64.getEncoder().encode((authValues.getBytes())));
    RestAssured.baseURI = requestParams.get("baseUri");
    RequestSpecification request = RestAssured.given();
    request.header("Content-Type", contentType);
    request.header("Authorization", authType + " " + authValuesEncoded);
    logger.log(Level.INFO, "-------------Request-------------\n" + request.log().all(true));
    return request;

  }

  /**
   * 
   * @param requestParams
   * @return String
   */
  public static String getAccessTokenFromClientCredsFlow(Map<String, String> requestParams) {
    RestAssured.baseURI = requestParams.get("baseUrl");
    RequestSpecification request = RestAssured.given();

    request.formParam("scope", requestParams.get("scope"))
        .formParam("grant_type", "client_credentials")
        .formParam("client_id", requestParams.get("clientId"))
        .formParam("client_secret", requestParams.get("clientSecret"));

    request.header("Content-Type", requestParams.get("contentType"));
    logger.log(Level.INFO, "-------------Request-------------\n" + request.log().all(true));
    try {
      Response response = request.post();
      logger.log(Level.INFO,
          "-------------Response-------------\n" + response.then().log().all(true));
      JsonPath jsonPathEvaluator = response.jsonPath();
      return jsonPathEvaluator.get("access_token");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      return null;
    }
  }
}
