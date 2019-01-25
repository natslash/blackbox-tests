package com.axoom.drs.devices;

import java.util.Map;

public class Configuration {
  private String publicKeyFormat;
  private String location;
  private String publicKey;
  
  public Configuration(Map<String, String> configValues) {
    setPublicKeyFormat(configValues.get("publicKeyFormat"));
    setLocation(configValues.get("location"));
    setPublicKeyFormat(configValues.get("publicKeyFormat"));
  }
  public String getPublicKeyFormat() {
    return publicKeyFormat;
  }
  public void setPublicKeyFormat(String publicKeyFormat) {
    this.publicKeyFormat = publicKeyFormat;
  }
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  public String getPublicKey() {
    return publicKey;
  }
  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }
}
