package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage {
    public WebDriver driver;
    private By CubesQADropDownLocator = By.className("dropdown-toggle");
    private By logOutButtonLocator = By.linkText("Logout");
    
    public LogOutPage (WebDriver driver){
        this.driver = driver;
    }
    
    public void clickOnCubesQADropDown(){
        driver.findElement(CubesQADropDownLocator).click();        
    }
    
    public void clickOnLogOutButton(){
        driver.findElement(logOutButtonLocator).click();
    }
     
}
