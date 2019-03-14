package com.axoom.drs.utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class AxoomRequest {
  private static RequestSpecification request;

  public static RequestSpecification getPreparedRequest(RequestParams requestParams) {
    RestAssured.baseURI = requestParams.getBaseURI();
    request = RestAssured.given();
    request.header("Content-Type", requestParams.getContentType());
    request.header("Authorization", requestParams.getAuthorization());
    return request;
  }
  
}
