package com.axoom.drs.it;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.axoom.drs.pages.DemoResultsPage;
import com.axoom.drs.pages.MyAxoomLoginPage;
import com.axoom.drs.pages.DemoSurveySecondPage;
import com.axoom.talos.framework.WebDriverTest;
import com.axoom.talos.utils.DataProviderUtils;
import com.axoom.talos.utils.FileUtils;



public class DataDrivenDemoTestIT extends WebDriverTest {

  MyAxoomLoginPage demoSurveyFirstPage;
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

    demoSurveyFirstPage = initPage(driver, MyAxoomLoginPage.class);

   
    Reporter.log("Answer message is as expected");    
  }
}