package axoom.subjects.v1;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.axoom.talos.framework.WebDriverTest;
import axoom.subjects.v1.Subjects.SubjectType;
import axoom.subjects.v1.Subjects.SubjectTypeContext;
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
  private String subjectTypeName = null;
  private SubjectType createdSubjectType = null;
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
    subjectTypeName = "SubjectType" + timeStamp;
    createdSubjectTypeWithExtenderName = "SubjectTypeWithExtender" + timeStamp;
    labelKey = "label" + timeStamp;
    labelValue = "label-" + subjectTypeName;

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


  @Test(groups = {"subjects"})
  @Description("Create Subject Type without extends")
  @Severity(SeverityLevel.BLOCKER)
  public void createSubjectTypeWithoutExtendsTest(ITestContext context) throws Exception {
    try {
      Map<String, String> labels = new HashMap<>();
      labels.put("label1", "labelValue2");
      SubjectType subType = SubjectType.newBuilder().setName(subjectTypeName)
          .setRecordMetaSchemaUrl(recordMetaSchemaUrl).setRecordSchemaUrl(recordSchemaUrl)
          .putAllLabels(labels).build();
      createdSubjectType = client.createSubjectType(null, subType);
      context.setAttribute("subjectTypeName", createdSubjectType.getName());
      assertTrue(createdSubjectType.getName().equals(subjectTypeName));
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

      SubjectType subjectType = client.getSubjectType(subjectTypeName);
      logger.log(Level.INFO, subjectType.getName());
      assertTrue(subjectType.getName().equals(subjectTypeName));
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }

  /**
   * 
   * @param context
   * @throws Exception
   */
  @Test(groups = {"subjects"}, dependsOnMethods = {"getSubjectTypeByName"})
  @Description("Create Subject Type with Extends")
  @Severity(SeverityLevel.BLOCKER)
  public void createSubjectTypeWithExtendsTest() throws Exception {
    try {
      Map<String, String> labels = new HashMap<>();
      labels.put("label1", "labelValue2");
      SubjectType subType = SubjectType.newBuilder().setName(createdSubjectTypeWithExtenderName)
          .setRecordMetaSchemaUrl(recordMetaSchemaUrl).setRecordSchemaUrl(recordSchemaUrl).build();
      SubjectType createdSubjectType = client.createSubjectType(subjectTypeName, subType);
      assertTrue(createdSubjectType.getName().equals(createdSubjectTypeWithExtenderName));
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
  @Test(dependsOnMethods = {"createSubjectTypeWithExtendsTest"})
  @Description("Get Subject Type by it's name")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectTypeContext() throws Exception {
    try {
      SubjectTypeContext subjectTypeContext =
          client.getSubjectTypeContext(createdSubjectTypeWithExtenderName);

      logger.log(Level.INFO, "SubjectTypeContext extends: " + subjectTypeContext.getExtends(0));
      assertTrue(subjectTypeContext != null);
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
      ListSubjectTypesResponse subjectTypes =
          client.listSubjectTypes("mySubjectTypeLabel", "mySubjectType");
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
   * 
   * @throws InterruptedException
   */

  @Test(dependsOnMethods = {"getSubjectTypeByName"})
  @Description("Set label to a SubjectType")
  @Severity(SeverityLevel.BLOCKER)
  public void setSubjectTypeLabelsTest() throws InterruptedException {
    Map<String, String> newLabel = new HashMap<>();
    newLabel.put(labelKey, labelValue);
    try {
      SubjectType subjectType = client.setSubjectTypeLabel(subjectTypeName, newLabel);
      Map<String, String> createdlabels = subjectType.getLabelsMap();
      for (Map.Entry<String, String> label : createdlabels.entrySet()) {
        logger.log(Level.INFO, "Label Key & Value " + label.getKey() + " : " + label.getValue());
      }
      assertTrue(createdlabels.containsKey(labelKey) && createdlabels.containsValue(labelValue));
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
  @Test(dependsOnMethods = {"setSubjectTypeLabelsTest"})
  @Description("Get Subject Type by it's lables")
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
   * @throws InterruptedException 
   */
  @Test(dependsOnMethods = {"setSubjectTypeLabelsTest"})
  @Description("Remove label to a SubjectType")
  @Severity(SeverityLevel.BLOCKER)
  public void removeSubjectTypeLabelsTest() throws InterruptedException {
    Map<String, String> labels = new HashMap<>();
    labels.put(labelKey, labelValue);
    try {
      SubjectType subjectType = client.removeSubjectTypeLabel(subjectTypeName, labelKey);
      Map<String, String> createdlabels = subjectType.getLabelsMap();
      assertFalse(createdlabels.containsKey(labelKey) && createdlabels.containsValue(labelValue));
    } catch (Exception e) {
      throw e;
    } finally {
      client.shutdown();
    }
  }
}
