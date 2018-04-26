package es.talos.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.inlogiq.talos.framework.LocatorPool;
import com.inlogiq.talos.framework.WebDriverPage;
import com.inlogiq.talos.utils.LocatorUtils;

import io.qameta.allure.Step;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DemoSurveyFirstPage extends WebDriverPage {
  
  private WebElement nameTextField;
  private WebElement companyField;
  private WebElement cityField;
  private WebElement nextButton;
  private WebElement radioButton;
  private WebDriverWait wait;
  

  public DemoSurveyFirstPage(WebDriver driver) {
    super(driver);
    wait = new WebDriverWait(driver, 1000);
  }
  
  public void fillTextFields(String name, String company, String city){
    
    nameTextField = getDriver().findElement(LocatorUtils.getElementAttributes(LocatorPool.getLocator("nameFieldLoc"), LocatorPool.getLocator("nameFieldVal")));
    wait.until(ExpectedConditions.elementToBeClickable(nameTextField));
    nameTextField.sendKeys(name);
    
    companyField = getDriver().findElement(LocatorUtils.getElementAttributes(LocatorPool.getLocator("companyFieldLoc"), LocatorPool.getLocator("companyFieldVal")));
    companyField.sendKeys(company);
    
    cityField = getDriver().findElement(LocatorUtils.getElementAttributes(LocatorPool.getLocator("cityFieldLoc"), LocatorPool.getLocator("cityFieldVal")));
    cityField.sendKeys(city);    
  }
  
  @Step("Choosing option in the First Page")
  public void chooseOption(String fieldName){	 
	String checkBoxFieldVal = "//span[contains(text(), '" + fieldName + "')]/preceding-sibling::span";
	
    radioButton = getDriver().findElement(By.xpath(checkBoxFieldVal));
    radioButton.click();    
  } 
  
  @Step("moving to next Page")
  public void clickNextButton(){
    nextButton = getDriver().findElement(By.xpath("//button[contains(text(),'Next')]"));
    wait.until(ExpectedConditions.elementToBeClickable(nextButton));
    nextButton.click();
    waitImplicitly();
  }

}
