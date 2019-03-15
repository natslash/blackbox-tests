package com.axoom.drs.utils;

public class RequestParams {
  private String baseURI;
  private String contentType;
  private String accessToken;

  public String getBaseURI() {
    return baseURI;
  }

  public void setBaseURI(String baseURI) {
    this.baseURI = baseURI;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public String getAuthorization() {
    return accessToken;
  }

  public void setAuthorization(String accessToken) {
    this.accessToken = "Bearer " + accessToken;
  }
}
