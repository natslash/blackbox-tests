package axoom.sharing.v1;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import axoom.sharing.v1.Sharing.ClientShare;
import axoom.sharing.v1.Sharing.TenantShare;
import axoom.sharing.v1.SharingService.ListClientSharesResponse;
import axoom.sharing.v1.SharingService.ListTenantSharesResponse;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for Sharing service APIs")
public class AxoomMockedSharingTestsIT extends PowerMockTestCase {

  // Mock client connection to server
  @Mock
  ClientShareService mockedClient;

  @Mock
  ListClientSharesResponse mockedListClientShareResponse;
  
  @Mock
  ListTenantSharesResponse mockedListTenantSharesResponse;

  @Mock
  ClientShare mockedClientShare;
  
  @Mock
  TenantShare mockedTenantShare;

  @Mock
  List<ClientShare> mockedClientSharesList;
  
  @Mock
  List<TenantShare> mockedTenantSharesList;

  private static final Logger logger = Logger.getLogger(AxoomMockedSharingTestsIT.class.getName());


  @BeforeClass
  public void beforeClass() {
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());    
    logger.log(Level.INFO, "Working Directory = " + System.getProperty("user.dir"));
  }

  @BeforeMethod
  public void beforeMethod() {
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());

    // Initialize Mock objects
    MockitoAnnotations.initMocks(this);

    // Specify to return mock objects
    when(mockedClient.listClientShares("1", "1", "1")).thenReturn(mockedListClientShareResponse);    
    when(mockedListClientShareResponse.getClientSharesList()).thenReturn(mockedClientSharesList);
    when(mockedListTenantSharesResponse.getTenantSharesList()).thenReturn(mockedTenantSharesList);
    when(mockedClientSharesList.get(0)).thenReturn(mockedClientShare);
    when(mockedTenantSharesList.get(0)).thenReturn(mockedTenantShare);
    when(mockedClientShare.getClientId()).thenReturn("1");
    when(mockedTenantShare.getTenantId()).thenReturn("1");
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }


  @Test
  @Description("List Client Shares")
  @Severity(SeverityLevel.BLOCKER)
  public void listClientShares() throws Exception {

    try {
      List<ClientShare> clientSharesList =
          mockedClient.listClientShares("1", "1", "1").getClientSharesList();
      clientSharesList.get(0).getClientId();

      assertTrue(clientSharesList.get(0).getClientId().equals("1"));


    } catch (StatusRuntimeException sre) {
      throw sre;
    } finally {
      mockedClient.shutdown();
    }
  }  
  
}
