package com.axoom.drs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.axoom.talos.framework.WebDriverPage;


public class DemoSurveySecondPage extends WebDriverPage {
  
  private Select selectBrandDropDown;  
  
  private WebElement doneButton;  
  private WebElement radioButton;

  public DemoSurveySecondPage(WebDriver driver) {
    super(driver);    
  }
  
  public void selectFavBrand(String brandName){
    
    selectBrandDropDown = new Select(getDriver().findElement(By.xpath("//select[@id='855484535']")));
    selectBrandDropDown.selectByVisibleText(brandName);
  }
  
  public void chooseCar(String fieldName){
    String carCheckBoxVal = "//span[contains(text(), '" + fieldName + "')]/preceding-sibling::span"; 
    radioButton = getDriver().findElement(By.xpath(carCheckBoxVal));
    radioButton.click();    
  } 
  
  public void clickDoneButton(){
    doneButton = getDriver().findElement(By.xpath("//button[contains(text(),'Done')]"));
    doneButton.click();
    waitImplicitly();
  }

}
