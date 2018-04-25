package es.talos.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inlogiq.talos.framework.LocatorPool;
import com.inlogiq.talos.framework.WebDriverPage;
import com.inlogiq.talos.utils.LocatorUtils;




public class DemoResultsPage extends WebDriverPage {
  
  private WebElement answeredMessage;  
  private WebElement doneButton;
  private WebElement thanksMessage;
  private WebDriverWait wait;

  public DemoResultsPage(WebDriver driver) {
    super(driver);
    wait = new WebDriverWait(driver, 100);
  }
  
  public String getAnswerMessage(){
    
    answeredMessage = getDriver().findElement(LocatorUtils.getElementAttributes(LocatorPool.getLocator("answeredMessageLoc"), LocatorPool.getLocator("answeredMessageVal")));
    return answeredMessage.getText(); 
  }
  
  public String getQuestionText(){
    thanksMessage = getDriver().findElement(By.xpath("//h1[contains(text(),'Discover new things')]"));
    wait.until(ExpectedConditions.visibilityOf(thanksMessage));
    return thanksMessage.getText();    
  } 
  
  public void clickDoneButton(){
    Actions action = new Actions(getDriver());
    doneButton = getDriver().findElement(By.xpath("//button[contains(text(),'Done')]|//a[contains(text(),'Done')]"));
    wait.until(ExpectedConditions.visibilityOf(doneButton));
    action.moveToElement(doneButton);
    doneButton.click();
    waitImplicitly();
  }

}
