package com.axoom.constants;

public final class EnvVariables {

  // restrict instantiation
  private EnvVariables() {

  }

  public static final String SYSTEM_INTEGRATOR_EMAIL = System.getenv("SYSTEM_INTEGRATOR_EMAIL");
  public static final String SYSTEM_INTEGRATOR_PASSWORD =
      System.getenv("SYSTEM_INTEGRATOR_PASSWORD");

  public static final String CIS_URL = System.getenv("CIS_URL");
  public static final String SECRET = System.getenv("SECRET");
  public static final String TENANT_ID = System.getenv("TENANT_ID");
  public static final String PROJECT_ID = System.getenv("PROJECT_ID");
  public static final String PROVIDER_REGION = System.getenv("PROVIDER_REGION");

  public static final String DRS_CLIENT_ID = System.getenv("DRS_CLIENT_ID");
  public static final String DRS_REDIRECT_URI = System.getenv("DRS_REDIRECT_URI");
  public static final String DRS_DEVICES_API = System.getenv("DRS_DEVICES_API");
  public static final String DRS_URL = System.getenv("DRS_URL");
  public static final String DRS_SCOPES = System.getenv("DRS_SCOPES");

  public static final String SRS_API = System.getenv("SRS_API");
  public static final String SRS_CLIENT_ID = System.getenv("SRS_CLIENT_ID");
  public static final String SRS_REDIRECT_URI = System.getenv("SRS_REDIRECT_URI");
  public static final String SRS_SCOPES = System.getenv("SRS_SCOPES");
  public static final String SRS_URL = System.getenv("SRS_URL");

  public static final String DCS_API = System.getenv("DCS_API");
  public static final String DCS_CLIENT_ID = System.getenv("DCS_CLIENT_ID");
  public static final String DCS_REDIRECT_URI = System.getenv("DCS_REDIRECT_URI");
  public static final String DCS_SCOPES = System.getenv("DCS_SCOPES");
  public static final String DCS_URL = System.getenv("DCS_URL");

  // Base URIs for services
  public static final String DRS_BASEURI = "https://device-registration-service.dev.myaxoom.com";
  public static final String DCS_BASEURI = "https://data-composition-service.dev.myaxoom.com";
  public static final String SRS_BASEURI = "https://schema-registration-service.dev.myaxoom.com";
}
