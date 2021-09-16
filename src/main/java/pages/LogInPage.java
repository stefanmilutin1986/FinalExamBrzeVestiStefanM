package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    public WebDriver driver;
    private By emailInputFieldlocator = By.name("email");
    private By passwordInputFieldlocator = By.name("password");
    private By logInButtonLocator = By.className("btn-primary");
    private By eMailFieldMessageForInvalidEmailLocator = By.xpath("//*[contains(text(),'These credentials do not match our records.')]");
    private By passwordFieldMessageForInvalidPasswordLocator = By.xpath("//*[contains(text(),'These credentials do not match our records.')]");
    private By emailFieldMessageEmptyField = By.xpath("//*[contains(text(),'The email field is required.')]");
    private By passwordFieldMessageEmptyField = By.xpath("//*[contains(text(),'The password field is required.')]");
    private By dashboardElementPresentHomePage = By.xpath("//div[contains(text(),'Dashboard')]");
        
    public LogInPage (WebDriver driver){
        this.driver = driver;
    }
    
    public String DashboardElementPresentOnHomePage(){
        return driver.findElement(dashboardElementPresentHomePage).getText();
    }
    
    public void enterEmail(String email){
        driver.findElement(emailInputFieldlocator).sendKeys(email);
    }
    
    public void enterPassword(String password){
        driver.findElement(passwordInputFieldlocator).sendKeys(password);
    }
    
    public void clickOnLogInButton(){
        driver.findElement(logInButtonLocator).click();
    }
    
    public String getWarningMessageForInputInvalidEmail(){
        return driver.findElement(eMailFieldMessageForInvalidEmailLocator).getText();
    }
    
    public String getWarningMessageForInputInvalidPassword(){
        return driver.findElement(passwordFieldMessageForInvalidPasswordLocator).getText();
    }
    
    public String getWarningMessageForEmptyEmailField(){
        return driver.findElement(emailFieldMessageEmptyField).getText();
    }
    
    public String getWarningMessageForEmptyPasswordField(){
        return driver.findElement(passwordFieldMessageEmptyField).getText();
    }
}
