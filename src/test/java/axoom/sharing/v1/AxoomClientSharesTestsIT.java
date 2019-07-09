package axoom.sharing.v1;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.axoom.talos.framework.WebDriverTest;
import com.google.protobuf.Empty;
import axoom.sharing.v1.Sharing.ClientShare;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for Sharing service APIs")
public class AxoomClientSharesTestsIT extends WebDriverTest {
  private String clientId;
  private String tenantId;
  private String redirectUri;
  private String secret;
  private String cisUrl;
  private ClientShareService client;
  private long timeStamp;
  private String subjectId;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger = Logger.getLogger(AxoomClientSharesTestsIT.class.getName());

  @BeforeClass
  public void beforeClass() {
    clientId = "blackboxtest01-test1";
    tenantId = System.getenv("TENANT_ID");
    redirectUri = System.getenv("SRS_REDIRECT_URI");
    cisUrl = System.getenv("CIS_URL");
    secret = System.getenv("SECRET");
    requestParams.put("clientId", clientId);
    requestParams.put("redirectUri", redirectUri);
    requestParams.put("cisUrl", cisUrl);
    requestParams.put("secret", secret);
    timeStamp = System.currentTimeMillis();
    subjectId = "subjectId" + timeStamp;

    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
    logger.log(Level.INFO, "Working Directory = " + System.getProperty("user.dir"));
    logger.log(Level.INFO, "Client ID = " + clientId);
    logger.log(Level.INFO, "Tenant ID = " + tenantId);
  }

  @BeforeMethod
  public void beforeMethod() {
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    // Create Client and establish connection to the server
    client = new ClientShareService("sharing.dev.myaxoom.com", 443);
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }

  // @Test
  @Description("List Client Shares")
  @Severity(SeverityLevel.BLOCKER)
  public void listClientShares() throws Exception {

    try {
      List<ClientShare> clientSharesList =
          client.listClientShares("1", "1", "1").getClientSharesList();
      clientSharesList.get(0).getClientId();

      assertTrue(clientSharesList.get(0).getClientId().equals("1"));


    } catch (StatusRuntimeException sre) {
      throw sre;
    } finally {
      client.shutdown();
    }
  }


  @Test
  @Description("Create Client Shares")
  @Severity(SeverityLevel.BLOCKER)
  public void createClientShares() throws Exception {

    try {
      ClientShare clientShare =
          ClientShare.newBuilder().setTenantId(tenantId).setClientId(clientId).setSubjectId(subjectId).build();
      ClientShare createdClientShare = (ClientShare) client.createShare(clientShare);
      logger.log(Level.INFO, "clientShareID: " + createdClientShare.getClientId() + " Subject ID: "
          + createdClientShare.getSubjectId());
      assertTrue(createdClientShare.getClientId().equals(clientId));

    } catch (StatusRuntimeException sre) {
      throw sre;
    } finally {
      client.shutdown();
    }
  }

  @Test(dependsOnMethods = {"createClientShares"})
  @Description("Create Client Shares")
  @Severity(SeverityLevel.BLOCKER)
  public void deleteClientShares() throws Exception {

    try {
      ClientShare clientShare =
          ClientShare.newBuilder().setTenantId(tenantId).setClientId(clientId).setSubjectId(subjectId).build();
      client.deleteShare(clientShare);
    } catch (StatusRuntimeException sre) {
      throw sre;
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("Create Client Shares")
  @Severity(SeverityLevel.BLOCKER)
  public void deleteClientSharesWithNonExistentSubjectID() throws Exception {

    try {
      ClientShare clientShare =
          ClientShare.newBuilder().setTenantId(tenantId).setClientId(clientId).setSubjectId(subjectId + "1").build();
      client.deleteShare(clientShare);
    } catch (StatusRuntimeException sre) {
      throw sre; 
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("Create Client Shares")
  @Severity(SeverityLevel.BLOCKER)
  public void deleteClientSharesWithNonExistentClientID() throws Exception {

    try {
      ClientShare clientShare =
          ClientShare.newBuilder().setTenantId(tenantId).setClientId(clientId + "1").setSubjectId(subjectId).build();
      client.deleteShare(clientShare);      
    } catch (StatusRuntimeException sre) {
      assertTrue(sre.getLocalizedMessage().contains("INTERNAL: internal server error")); 
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("Create Client Shares")
  @Severity(SeverityLevel.BLOCKER)
  public void deleteClientSharesWithNonExistentTenantID() throws Exception {

    try {
      ClientShare clientShare =
          ClientShare.newBuilder().setTenantId(tenantId + "1").setClientId(clientId).setSubjectId(subjectId).build();
      client.deleteShare(clientShare);      
    } catch (StatusRuntimeException sre) {
      assertTrue(sre.getLocalizedMessage().contains("PERMISSION_DENIED: missing tenant information in access token")); 
    } finally {
      client.shutdown();
    }
  }

  @Test
  @Description("Create Client Shares")
  @Severity(SeverityLevel.BLOCKER)
  public void createClientSharesWithNullSubjectId() throws Exception {

    try {
      ClientShare clientShare =
          ClientShare.newBuilder().setClientId(tenantId).setSubjectId(null).build();
      client.createShare(clientShare);
    } catch (NullPointerException ne) {
      assertTrue(true);
    } finally {
      client.shutdown();
    }
  }
}
