package axoom.subjects.v1;

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
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.google.protobuf.ByteString;
import axoom.subjects.v1.Subjects.Subject;
import axoom.subjects.v1.Subjects.SubjectType;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("Positive test cases for SRS APIs")
public class AxoomMockedSubjectsTestsIT extends PowerMockTestCase {

  // Mock client connection to server
  @Mock
  SubjectsClient mockedClient;

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

  private static final Logger logger = Logger.getLogger(AxoomMockedSubjectsTestsIT.class.getName());


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
    when(mockedClient.getSubject("1")).thenReturn(mockedSubject);    
    when(mockedQSubjectsIterator.hasNext()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(mockedQSubjectsIterator.next()).thenReturn(mockedSubject);
    when(mockedSubject.getNameBytes()).thenReturn(mockedNameBytes);
    when(mockedClient.getSubjectType("1")).thenReturn(mockedSubjectType);
    when(mockedSubjectType.getName()).thenReturn("100101");
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
      Subject subject = mockedClient.getSubject("1");
      if (subject != null) {        
        logger.log(Level.INFO, subject.getNameBytes().toStringUtf8());
        assertTrue(subject.getNameBytes().toStringUtf8().equals(mockedNameBytes.toStringUtf8()));
      }

    } catch (StatusRuntimeException sre) {
      throw sre;
    } finally {
      mockedClient.shutdown();
    }
  }

  @Test
  @Description("Get Subject's NameBytes")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectLabels() throws Exception {

    try {
      Subject subject = mockedClient.getSubject("1");
      if(subject != null) {        
        logger.log(Level.INFO, subject.getLabelsMap().get("1"));        
        assertTrue(subject.getLabelsMap().get("1").equals("Dummy Label"));
      }

    } catch (StatusRuntimeException sre) {      
        throw sre;      
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
      throw sre;
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
      throw sre;
    } finally {
      mockedClient.shutdown();
    }
  }

  @Test
  @Description("Get Subject's ID")
  @Severity(SeverityLevel.BLOCKER)
  public void getSubjectTypeName() throws Exception {

    try {
      SubjectType subjectType = mockedClient.getSubjectType("1");

      logger.log(Level.INFO, subjectType.getName());
      assertTrue(subjectType.getName().equals("100101"));
    } catch (StatusRuntimeException sre) {
      throw sre;
    } finally {
      mockedClient.shutdown();
    }
  }

}
