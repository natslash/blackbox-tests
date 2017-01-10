package es.talos.demo.it;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inlogiq.talos.framework.WebDriverTest;
import com.inlogiq.talos.utils.DataProviderUtils;
import com.inlogiq.talos.utils.FileUtils;

import es.talos.demo.pages.DemoResultsPage;
import es.talos.demo.pages.DemoSurveyFirstPage;
import es.talos.demo.pages.DemoSurveySecondPage;

public class DataDrivenDemoTestIT extends WebDriverTest {

  DemoSurveyFirstPage demoSurveyFirstPage;
  DemoSurveySecondPage demoSurveySecondPage;
  DemoResultsPage demoResultsPage;

  WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
    super.initPlatformBaseTest();
    this.driver = super.getDriver();
    Reporter.log("-----------------------------------------------------------------------------------------------");
    Reporter.log("Started Test: " + this.getClass().getSimpleName());
  }
  
  @DataProvider(name = "getSurveyData")
  public static Object[][] getSurveyData() {
    Object[][] retObjArr = null;
    try {
      String xlsFilePath = FileUtils.getTestBaseDirectory() + "SurveyData.xls";
      String sheetname = "SurveyDataSheet";
      String tablename = "SurveyDataTable";

      retObjArr = DataProviderUtils.createData(xlsFilePath, sheetname, tablename);

    } catch (Exception e) {      
      e.printStackTrace();
    }
    return (retObjArr);
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
    stopWebDriverTest(testResult);
    Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
    Reporter.log("-----------------------------------------------------------------------------------------------");
  }

  @Test(dataProvider = "getSurveyData")
  public void dataDrivenSurveyTest(String name, String company, String city, String healthOption, String yesOrNo, String brand, String car, String ansMessage) throws InterruptedException {

    demoSurveyFirstPage = initPage(driver, DemoSurveyFirstPage.class);

    demoSurveyFirstPage.fillTextFields(name, company, city);
    Reporter.log("Entered address details "  + name + ", " + company + ", " + city + ", "); 
    
    demoSurveyFirstPage.chooseOption(healthOption);
    Reporter.log("Chose option " + healthOption);
    
    demoSurveyFirstPage.chooseOption(yesOrNo);
    Reporter.log("Chose option " + yesOrNo);
    
    demoSurveyFirstPage.clickNextButton();

    demoSurveySecondPage = initPage(driver, DemoSurveySecondPage.class);

    demoSurveySecondPage.selectFavBrand(brand);
    Reporter.log("Selected brand " + brand);
    
    demoSurveySecondPage.chooseCar(car);
    Reporter.log("Chose car " + car );
    
    demoSurveySecondPage.clickDoneButton();
    Reporter.log("Completed Survey");
    
    demoResultsPage = initPage(driver, DemoResultsPage.class);
    demoResultsPage.clickDoneButton();
    
    String ansMessageExpected = demoResultsPage.getQuestionText();
    Assert.assertTrue(ansMessageExpected.contains(ansMessage), "The actual message is not the same as expected message: " + ansMessageExpected);
    Reporter.log("Answer message is as expected");    
  }
}