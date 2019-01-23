package com.axoom.drs.it;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.axoom.drs.pages.DemoResultsPage;
import com.axoom.drs.pages.MyAxoomLoginPage;
import com.axoom.drs.pages.DemoSurveySecondPage;
import com.axoom.talos.framework.WebDriverTest;
import io.qameta.allure.Step;

public class AxoomDrsPositiveTestsIT extends WebDriverTest{
	private MyAxoomLoginPage myAxoomLoginPage;
	private String inputEmail;
    private String inputPassword;
    private String tenantId;
	private WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		super.initPlatformBaseTest();
		this.driver = super.getDriver();
		inputEmail = System.getenv("SYSTEM_INTEGRATOR_EMAIL");
        inputPassword = System.getenv("SYSTEM_INTEGRATOR_PASSWORD");
        tenantId = System.getenv("TENANT_ID");
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
	public void surveyTest() throws InterruptedException {

		myAxoomLoginPage = initPage(driver, MyAxoomLoginPage.class);
		myAxoomLoginPage.loginToMyAxoom(inputEmail, inputPassword);
		
		
	}

}
