package com.axoom.drs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.axoom.talos.framework.LocatorPool;
import com.axoom.talos.framework.WebDriverPage;
import com.axoom.talos.utils.LocatorUtils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyAxoomLoginPage extends WebDriverPage {
  
  private WebElement inputEmailField;
  private WebElement inputPasswordField;
  private WebElement loginButton;
  private WebElement tenantField; 
  
  
  private String inputEmailFieldId = "Input_Email";
  private String inputPasswordFieldId = "Input_Password";
  private String loginButtonXpath = "//button[text()='Login']";
  
  

  public MyAxoomLoginPage(WebDriver driver) {
    super(driver);    
  }
  
  public void loginToMyAxoom(String email, String password){
    
    inputEmailField = getDriver().findElement(By.id(inputEmailFieldId));
    inputEmailField.sendKeys(email);
        
    inputPasswordField = getDriver().findElement(By.id(inputPasswordFieldId));
    inputPasswordField.sendKeys(password);
    
    loginButton = getDriver().findElement(By.xpath(loginButtonXpath));
    clickAndWaitForPageLoad(loginButton, 1);    
  }
  
  public void selectTenant(String tenantId) {
    String tenantXpath = "//button[contains(@formaction, 'data=" + tenantId + "')]";
    tenantField = getDriver().findElement(By.xpath(tenantXpath));
    clickAndWaitForPageLoad(tenantField, 1);
  }
  

}
