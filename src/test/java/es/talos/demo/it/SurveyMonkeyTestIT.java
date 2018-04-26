package es.talos.demo.it;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.inlogiq.talos.framework.WebDriverTest;

import es.talos.demo.pages.DemoResultsPage;
import es.talos.demo.pages.DemoSurveyFirstPage;
import es.talos.demo.pages.DemoSurveySecondPage;
import io.qameta.allure.Step;

public class SurveyMonkeyTestIT extends WebDriverTest{
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

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws IOException {
		stopWebDriverTest(testResult);
		Reporter.log("Stopped Test: " + this.getClass().getSimpleName());
		Reporter.log("-----------------------------------------------------------------------------------------------");
	}

	@Test
	@Step("Testing completing the survey")
	public void surveyTest() throws InterruptedException {

		demoSurveyFirstPage = initPage(driver, DemoSurveyFirstPage.class);

		demoSurveyFirstPage.fillTextFields("Test", "inlogiq", "Valencia");
		
		demoSurveyFirstPage.chooseOption("Very healthy");

		demoSurveyFirstPage.chooseOption("No");
		
		demoSurveyFirstPage.clickNextButton();

		demoSurveySecondPage = initPage(driver, DemoSurveySecondPage.class);

		demoSurveySecondPage.selectFavBrand("Sony");
		Reporter.log("Selected brand " + "Sony");

		demoSurveySecondPage.chooseCar("Ferrari");
		Reporter.log("Chose car " + "Ferrari");

		demoSurveySecondPage.clickDoneButton();
		Reporter.log("Completed Survey");

		demoResultsPage = initPage(driver, DemoResultsPage.class);
		demoResultsPage.clickDoneButton();

		String ansMessageExpected = demoResultsPage.getQuestionText();
		Assert.assertTrue(ansMessageExpected.contains("Discover new things"), "The actual message is not the same as expected message: " + ansMessageExpected);
		Reporter.log("Answer message is as expected");
	}

}
