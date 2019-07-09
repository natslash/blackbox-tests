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
import axoom.sharing.v1.Sharing.TenantShare;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for Sharing service APIs")
public class AxoomTenantSharesTestsIT extends WebDriverTest {
  private String clientId;
  private String tenantId;
  private String redirectUri;
  private String secret;
  private String cisUrl;
  private TenantShareService client;
  private long timeStamp;
  private String subjectId;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger = Logger.getLogger(AxoomTenantSharesTestsIT.class.getName());

  @BeforeClass
  public void beforeClass() {
    clientId = System.getenv("SRS_CLIENT_ID");
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
  }

  @BeforeMethod
  public void beforeMethod() {
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    //Create Client and establish connection to the server
    client = new TenantShareService("sharing.dev.myaxoom.com", 443);
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }  

  //@Test
  @Description("List Tenant Shares")
  @Severity(SeverityLevel.BLOCKER)
  public void listTenantShares() throws Exception {

    try {
      List<TenantShare> tenantSharesList =
          client.listTenantShares("1", "1").getTenantSharesList();
      tenantSharesList.get(0).getTenantId();

      assertTrue(tenantSharesList.get(0).getTenantId().equals("1"));


    } catch (StatusRuntimeException sre) {
      throw sre;
    } finally {
      client.shutdown();
    }
  }    
  
  
  @Test
  @Description("Create Client Shares")
  @Severity(SeverityLevel.BLOCKER)
  public void createTenantSharesWithNullSubjectId() throws Exception {

    try {
      TenantShare clientShare = TenantShare.newBuilder().setTenantId(tenantId).setSubjectId(null).build();
      client.createShare(clientShare);
    } catch (NullPointerException ne) {
      assertTrue(true);
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("Create Tenant Shares")
  @Severity(SeverityLevel.BLOCKER)
  public void createTenantShares() throws Exception {

    try {
      TenantShare tenantShare = TenantShare.newBuilder().setTenantId(tenantId).setSubjectId(subjectId).build();
      TenantShare createdTenantShare = (TenantShare) client.createShare(tenantShare);
      logger.log(Level.INFO, "TenantShareId: " + createdTenantShare.getTenantId() + " Subject ID: " + createdTenantShare.getSubjectId());
      assertTrue(createdTenantShare.getTenantId().equals(tenantId));

    } catch (StatusRuntimeException sre) {
      throw sre;
    } finally {
      client.shutdown();
    }
  }
  
  @Test(dependsOnMethods = {"createTenantShares"})
  @Description("Create Tenant Shares")
  @Severity(SeverityLevel.BLOCKER)
  public void deleteTenantShares() throws Exception {

    try {
      TenantShare tenantShare = TenantShare.newBuilder().setTenantId(tenantId).setSubjectId(subjectId).build();
      client.deleteShare(tenantShare);
    } catch (StatusRuntimeException sre) {
      throw sre;
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("Create Tenant Shares")
  @Severity(SeverityLevel.BLOCKER)
  public void deleteTenantSharesWithNonExistentSubjectId() throws Exception {
    String wrongSubjectId = subjectId + "1";
    try {
      TenantShare tenantShare = TenantShare.newBuilder().setTenantId(tenantId).setSubjectId(wrongSubjectId).build();
      client.deleteShare(tenantShare);
    } catch (StatusRuntimeException sre) {
     assertTrue(sre.getLocalizedMessage().contains("INVALID_ARGUMENT: TenantShare with tenantID = '" + tenantId + "', subjectID = '" + wrongSubjectId + "' could not be found in the dictionary."));
    } finally {
      client.shutdown();
    }
  }
  
  @Test
  @Description("Create Tenant Shares")
  @Severity(SeverityLevel.BLOCKER)
  public void deleteTenantSharesWithNonExistentTenantId() throws Exception {
    String wrongTenantId = tenantId + "1";
    try {
      TenantShare tenantShare = TenantShare.newBuilder().setTenantId(wrongTenantId).setSubjectId(subjectId).build();
      client.deleteShare(tenantShare);      
    } catch (StatusRuntimeException sre) {
      logger.log(Level.INFO, "deleteTenantSharesWithNonExistentTenantId: " + sre.getLocalizedMessage());
      assertTrue(sre.getLocalizedMessage().contains("INVALID_ARGUMENT: TenantShare with tenantID = '" + wrongTenantId + "', subjectID = '" + subjectId + "' could not be found in the dictionary."));
    } finally {
      client.shutdown();
    }
  }
}
