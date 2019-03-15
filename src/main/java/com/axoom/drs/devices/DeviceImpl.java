package com.axoom.drs.devices;

import java.util.Map;

public class DeviceImpl implements Device {

  private String tenant;
  private String name;
  private Configuration deviceConfugration;

  public DeviceImpl(Map<String, Object> deviceValues) {
    this.name = deviceValues.get("name").toString();
    this.tenant = deviceValues.get("tenant").toString();
    this.deviceConfugration = (Configuration) deviceValues.get("deviceConfugration");
  }

  public String getTenant() {
    return tenant;
  }

  public void setTenant(String tenant) {
    this.tenant = tenant;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Configuration getDeviceConfugration() {
    return deviceConfugration;
  }

  public void setDeviceConfugration(Configuration deviceConfugration) {
    this.deviceConfugration = deviceConfugration;
  }

}
