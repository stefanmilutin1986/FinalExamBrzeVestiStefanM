package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegionsPage {
    public WebDriver driver;
    private static WebDriverWait wait;
    private By addRegionbuttonLocator = By.className("pull-right");
    private By titleInputFieldLocator = By.name("title");
    private By saveButtonLocator = By.name("save-region-button");   
    private By alertMessageLocator = By.className("alert-success");
    private By actionsDisableButtonLocator = By.cssSelector("button[title='Disable']");
    private By confirmationDisableButtonLocator = By.xpath("//button[contains(text(),'Disable')]");    
    private By backToHomePageLogoLocator = By.linkText("Brze Vesti");
    private By actionsEnableButtonLocator = By.cssSelector("button[title='Enable']");
    private By enableConfirmationbuttonLocator = By.xpath("//button[contains(text(),'Enable')]");
    private By actionsDeleteButtonLocator = By.cssSelector("button[title='Delete']");
    private By confirmationDeleteRegionsButtonLocator = By.xpath("//button[contains(text(),'Delete')]");
    private By regionTitleInFirstRowLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[3]");
    private By newTitleAddedLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[last]/td[3]");
    private By TitleOfDisabledRegionLocatorInFirstRow = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[3]");
    private By regionStatusAfterDisableLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[4]/span");
    
    public RegionsPage (WebDriver driver){
        this.driver = driver;
    }
    
    public void clickOnAddRegionButton() {
        driver.findElement(addRegionbuttonLocator).click();
    }
    
    public void enterDataToTitleField() {
        String newCategoryTitleAdding = Helper.generateTitle();
        driver.findElement(titleInputFieldLocator).sendKeys(newCategoryTitleAdding);
    }
    
    public String newTitleRegionAdd() {
        return driver.findElement(titleInputFieldLocator).getAttribute("value");
    }
    
    public void clickOnSaveButton() {
        driver.findElement(saveButtonLocator).click();
    }
    
    public String getAlertMessageText(){
    return driver.findElement(alertMessageLocator).getText();
    }

    public void clickOnDisableButtonInFirstRow() {
        driver.findElement(actionsDisableButtonLocator).click();
    }
    
    public void clickOnEnableRegionButtonInFirstRow() {
        driver.findElement(actionsEnableButtonLocator).click();
        
    }
    
    public void clickOnconfirmationEnableButton() {
        wait = new WebDriverWait(driver, 3);
        WebElement enableConfirmationbuttonLocator1 = wait.until(ExpectedConditions.elementToBeClickable(enableConfirmationbuttonLocator));
        enableConfirmationbuttonLocator1.click();
    }

    public void clickOnconfirmationDisableButton() {
        wait = new WebDriverWait(driver, 3);
        WebElement confirmationDisableButton = wait.until(ExpectedConditions.elementToBeClickable(confirmationDisableButtonLocator));
        confirmationDisableButton.click();
    }
    
    public String nameOfDisabledRegionInFirstRow() {
        return driver.findElement(TitleOfDisabledRegionLocatorInFirstRow).getText();
    }
    
    public String statusOfRegionInFirstRow() {
        return driver.findElement(regionStatusAfterDisableLocator).getText();
    }

    public void clickOnBackToHomePageLogo() {
        driver.findElement(backToHomePageLogoLocator).click();
    }
    
    public void clickOnDeleteRegionButtonInFirstRow() {
        driver.findElement(actionsDeleteButtonLocator).click();
    }
    
    public void clickOnConfirmationDeleteRegionButton() {
        wait = new WebDriverWait(driver, 3);
        WebElement ConfirmationDeleteRegionButton = wait.until(ExpectedConditions.elementToBeClickable(confirmationDeleteRegionsButtonLocator));
        ConfirmationDeleteRegionButton.click();
    }
    
    public String checkRegionTitleInFirstRow() {
        return driver.findElement(regionTitleInFirstRowLocator).getText();
    }
   
}
