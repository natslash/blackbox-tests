package axoom.subjectz.v1;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.google.protobuf.ByteString;
import axoom.subjectz.v1.Subjectz.Subject;
import axoom.subjectz.v1.Subjectz.SubjectType;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomMockedSubjectzTestsIT extends PowerMockTestCase {

  // Mock client connection to server
  @Mock
  SubjectzClient mockedClient;

  // Mock Subjects list
  @Mock
  List<Subject> mockedQSubjectsList;

  // Mock Iterator
  @Mock
  Iterator<Subject> mockedQSubjectsIterator;

  // Mock Subject
  @Mock
  Subject mockedSubject;

  // Mock Subject Type
  @Mock
  SubjectType mockedSubjectType;
  
  Map<String, String> labelMap = new HashMap<>();
  


  ByteString mockedNameBytes = ByteString.copyFromUtf8("Mocked NameBytes");

  private static final Logger logger = Logger.getLogger(AxoomMockedSubjectzTestsIT.class.getName());


  @BeforeClass
  public void beforeClass() {
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
    labelMap.put("1", "Dummy Label");
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
    when(mockedClient.getSubject("1")).thenReturn(mockedSubject);
    when(mockedClient.getSubjectz("1")).thenReturn(mockedQSubjectsIterator);    
    when(mockedQSubjectsIterator.hasNext()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(mockedQSubjectsIterator.next()).thenReturn(mockedSubject);
    when(mockedSubject.getNameBytes()).thenReturn(mockedNameBytes);
    when(mockedClient.getSubjectType("1")).thenReturn(mockedSubjectType);
    when(mockedSubjectType.getId()).thenReturn("100101");
    when(mockedSubjectType.getRecordSchemaUrl()).thenReturn("recordSchemaUrl");
    when(mockedSubjectType.getRecordMetaSchemaUrl()).thenReturn("recordMetaSchemaUrl");
    when(mockedSubject.getLabelsMap()).thenReturn(labelMap);
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log(
        "-----------------------------------------------------------------------------------------------");
  }


  @Test
  @Description("Get Subject's NameBytes")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectNameBytes() throws Exception {

    try {
      Iterator<Subject> subjects = mockedClient.getSubjectz("1");
      while (subjects.hasNext()) {
        Subject subject = subjects.next();
        logger.log(Level.INFO, subject.getNameBytes().toStringUtf8());
        assertTrue(subject.getNameBytes().toStringUtf8().equals(mockedNameBytes.toStringUtf8()));
      }

    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        Assert.assertTrue(true);
      } else {
        throw sre;
      }
    } finally {
      mockedClient.shutdown();
    }
  }

  @Test
  @Description("Get Subject's NameBytes")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectLabels() throws Exception {

    try {
      Iterator<Subject> subjects = mockedClient.getSubjectz("1");
      while (subjects.hasNext()) {
        Subject subject = subjects.next();
        logger.log(Level.INFO, subject.getLabelsMap().get("1"));        
        assertTrue(subject.getLabelsMap().get("1").equals("Dummy Label"));
      }

    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        Assert.assertTrue(true);
      } else {
        throw sre;
      }
    } finally {
      mockedClient.shutdown();
    }
  }

  @Test
  @Description("Get Subject's ID")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectTypeRecordSchemaUrl() throws Exception {

    try {
      SubjectType subjectType = mockedClient.getSubjectType("1");

      logger.log(Level.INFO, subjectType.getRecordSchemaUrl());
      assertTrue(subjectType.getRecordSchemaUrl().equals("recordSchemaUrl"));
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        Assert.assertTrue(true);
      } else {
        Assert.fail("Error occurred!");
        sre.printStackTrace();
      }
    } finally {
      mockedClient.shutdown();
    }
  }

  @Test
  @Description("Get Subject's ID")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectTypeRecordMetaSchemaUrl() throws Exception {

    try {
      SubjectType subjectType = mockedClient.getSubjectType("1");

      logger.log(Level.INFO, subjectType.getRecordSchemaUrl());
      assertTrue(subjectType.getRecordMetaSchemaUrl().equals("recordMetaSchemaUrl"));
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        Assert.assertTrue(true);
      } else {
        Assert.fail("Error occurred!");
        sre.printStackTrace();
      }
    } finally {
      mockedClient.shutdown();
    }
  }

  @Test
  @Description("Get Subject's ID")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectTypeId() throws Exception {

    try {
      SubjectType subjectType = mockedClient.getSubjectType("1");

      logger.log(Level.INFO, subjectType.getId());
      assertTrue(subjectType.getId().equals("100101"));
    } catch (StatusRuntimeException sre) {
      if (sre.getMessage().contains("RESOURCE_EXHAUSTED")) {
        Assert.assertTrue(true);
      } else {
        Assert.fail("Error occurred!");
        sre.printStackTrace();
      }
    } finally {
      mockedClient.shutdown();
    }
  }

}
