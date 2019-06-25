package axoom.subjects.v1;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.HashMap;
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
import axoom.subjects.v1.Subjects.SubjectType;
import axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomSubjectTypesPositiveTestsIT extends WebDriverTest {
  private String timeStamp;  
  private String clientId;
  private String redirectUri;
  private String secret;
  private String cisUrl;
  private SubjectTypesClient client;
  private Map<String, String> requestParams = new HashMap<>();
  private static final Logger logger =
      Logger.getLogger(AxoomSubjectTypesPositiveTestsIT.class.getName());
  private String createdSubjectTypeName = null; 
  private String createdSubjectTypeWithExtenderName = null;
  private String recordMetaSchemaUrl = "recordMetaSchemaURL";
  private String recordSchemaUrl = "recordSchemaUrl";
  private String labelKey = null;
  private String labelValue = null;

  @BeforeClass
  public void beforeClass() {
    clientId = System.getenv("SRS_CLIENT_ID");
    redirectUri = System.getenv("SRS_REDIRECT_URI");
    cisUrl = System.getenv("CIS_URL");
    secret = System.getenv("SECRET");
    requestParams.put("clientId", clientId);
    requestParams.put("redirectUri", redirectUri);
    requestParams.put("cisUrl", cisUrl);
    requestParams.put("secret", secret);
    timeStamp = Long.toString(System.currentTimeMillis());
    createdSubjectTypeName = "SubjectType" + timeStamp; 
    createdSubjectTypeWithExtenderName = "SubjectTypeWithoutExtender" + timeStamp;
    labelKey = "label" + timeStamp;
    labelValue = "label-" + createdSubjectTypeName;
    
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
    logger.log(Level.INFO, "Working Directory = " + System.getProperty("user.dir"));
  }

  @BeforeMethod
  public void beforeMethod() {
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    // Create Client and establish connection to the server
    client = new SubjectTypesClient("subjects.dev.myaxoom.com", 443);
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }
 

  @Test()
  @Description("Create Subject Type with Extends")
  @Severity(SeverityLevel.BLOCKER)
  public void createSubjectTypeWithExtendsTest() throws Exception {
    try {
      Map<String, String> labels = new HashMap<>();
      labels.put("label1", "labelValue2");
      SubjectType subType = SubjectType.newBuilder().setName(createdSubjectTypeWithExtenderName)
          .setRecordMetaSchemaUrl(recordMetaSchemaUrl).setRecordSchemaUrl(recordSchemaUrl)
          .putAllLabels(labels).build();
      SubjectType createdSubjectType = client.createSubjectType("mySubjectType", subType);
      assertTrue(createdSubjectType.getName().equals(createdSubjectTypeWithExtenderName));
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  @Test()
  @Description("Create Subject Type without extends")
  @Severity(SeverityLevel.BLOCKER)
  public void createSubjectTypeWithoutExtendsTest() throws Exception {
    try {
      Map<String, String> labels = new HashMap<>();
      labels.put("label1", "labelValue2");
      SubjectType subType = SubjectType.newBuilder().setName(createdSubjectTypeName)
          .setRecordMetaSchemaUrl(recordMetaSchemaUrl).setRecordSchemaUrl(recordSchemaUrl)
          .putAllLabels(labels).build();
      SubjectType createdSubjectType = client.createSubjectType(null, subType);
      assertTrue(createdSubjectType.getName().equals(createdSubjectTypeName));
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
  

  /**
   * 
   * @throws Exception
   */
  @Test(dependsOnMethods = {"createSubjectTypeWithoutExtendsTest"})
  @Description("Get Subject Type by it's name")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectTypeByName() throws Exception {
    try {

      SubjectType subjectType = client.getSubjectType(createdSubjectTypeName);
      logger.log(Level.INFO, subjectType.getName());
      assertTrue(subjectType.getName().equals(createdSubjectTypeName));
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  /**
   * 
   * @throws Exception
   */
  @Test(dependsOnMethods = {"createSubjectTypeWithoutExtendsTest"})
  @Description("Get Subject Type by it's name")
  @Severity(SeverityLevel.BLOCKER)
  public void listSubjectTypesWithoutFilter() throws Exception {
    try {

      ListSubjectTypesResponse subjectTypes = client.listSubjectTypes();
      int count = subjectTypes.getSubjectTypesCount();
      logger.log(Level.INFO, "count " + subjectTypes.getSubjectTypesList().size());
      assertTrue(count > 0);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  /**
   * 
   * @throws Exception
   */
  @Test(dependsOnMethods = {"createSubjectTypeWithoutExtendsTest"})
  @Description("Get Subject Type by it's name")
  @Severity(SeverityLevel.BLOCKER)
  public void listSubjectTypesWithNonExistentFilter() throws Exception {
    try {
      ListSubjectTypesResponse subjectTypes = client.listSubjectTypes("mySubjectTypeLabel", "mySubjectType");
      int count = subjectTypes.getSubjectTypesCount();
      logger.log(Level.INFO, "count " + subjectTypes.getSubjectTypesList().size());
      assertTrue(count == 0);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }  
 
  /**
   * set SubjectTypeLabels Test
   */

  @Test(dependsOnMethods = {"createSubjectTypeWithExtendsTest"})
  @Description("Set label to a SubjectType")
  @Severity(SeverityLevel.BLOCKER)
  public void setSubjectTypeLabelsTest() {
    Map<String, String> labels = new HashMap<>();
    labels.put(labelKey, labelValue);
    SubjectType subjectType = client.setSubjectTypeLabel(createdSubjectTypeName, labels);
    Map<String, String> createdlabels = subjectType.getLabelsMap();
    assertTrue(createdlabels.containsKey(labelKey) && createdlabels.containsValue(labelValue));
  } 
  
  /**
   * 
   * @throws Exception
   */
  @Test(dependsOnMethods = {"setSubjectTypeLabelsTest"})
  @Description("Get Subject Type by it's name")
  @Severity(SeverityLevel.BLOCKER)
  public void listSubjectTypesWithFilter() throws Exception {
    try {
      ListSubjectTypesResponse subjectTypes = client.listSubjectTypes(labelKey, labelValue);
      int count = subjectTypes.getSubjectTypesCount();
      logger.log(Level.INFO, "count " + subjectTypes.getSubjectTypesList().size());
      assertTrue(count > 0);
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
  
  /**
   * Remove subject TypeLabels Test
   */
  @Test(dependsOnMethods = {"listSubjectTypesWithFilter"})
  @Description("Remove label to a SubjectType")
  @Severity(SeverityLevel.BLOCKER)
  public void removeSubjectTypeLabelsTest() {
    Map<String, String> labels = new HashMap<>();
    labels.put(labelKey, labelValue);
    SubjectType subjectType = client.removeSubjectTypeLabel(createdSubjectTypeName, labelKey);
    Map<String, String> createdlabels = subjectType.getLabelsMap();
    assertFalse(createdlabels.containsKey(labelKey) && createdlabels.containsValue(labelValue));
  }  
}
