package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import framework.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SourcesPage {
    public WebDriver driver;
    private static WebDriverWait wait;
    private By addSourcebuttonLocator = By.className("pull-right");
    private By titleFieldLocator = By.id("sourceTitleText");
    private By urlFieldLocator = By.id("sourceUrlText");
    private By saveButtonlocator = By.id("save-source-button");
    private By backToSourcesbuttonLocator = By.id("back-button");
    private By actionsDisableButtonInFirstRowLocator = By.cssSelector("button[title='Disable']");
    private By confirmationDisableButtonLocator = By.xpath("//button[contains(text(),'Disable')]");
    private By alertMessageLocator = By.className("alert-success");
    private By statusOfDisabledSourceInFirstRow = By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr[1]/td[7]");
    private By backToHomePageLogoLocator = By.linkText("Brze Vesti");
    private By newSourceTitleLocator = By.id("sourceTitleText");
    private By secondCategoryInDropDown = By.xpath("//option[@value='2']");
    
    public SourcesPage (WebDriver driver){
        this.driver = driver;
    }
    
    public void clickOnAddSourceButton() {
        driver.findElement(addSourcebuttonLocator).click();
    }
    
    public void chooseSecondPortalInDropDown() {
        Select selectPortal = new Select (driver.findElement(By.id("sourcePortalSelect")));
        selectPortal.selectByIndex(1);
    }
    
    public String getTextCategoryDropDownSecondOption(){
        return driver.findElement(secondCategoryInDropDown).getText();
    }
    
    public void enterTitle() {        
        driver.findElement(titleFieldLocator).sendKeys(Helper.generateTitle());
    }
    
    public void enterUrl() {
        driver.findElement(urlFieldLocator).sendKeys(Helper.generateUrl());
    }
    
    public void chooseSecondCategoryinDropDown() {
        Select selectCategory = new Select (driver.findElement(By.id("sourceCategorySelect")));
        selectCategory.selectByIndex(1);
    }
    
    public void clickOnSaveButton() {
        driver.findElement(saveButtonlocator).click();
    }
    
    public void backToSourcesClick() {
        driver.findElement(backToSourcesbuttonLocator).click();
    }
    
    public String getAlertMessageText() {
        return driver.findElement(alertMessageLocator).getText();
    }
    
    public String getNewAddedSourceTitle() {
        return driver.findElement(newSourceTitleLocator).getAttribute("value");
    }
    
    public void clickOnDisableButtonInFirstRow() {
        driver.findElement(actionsDisableButtonInFirstRowLocator).click();
    }
    
    public void clickOnConfirmationDisableButton() {
        wait = new WebDriverWait(driver, 3);
        WebElement ConfirmationDisableButton = wait.until(ExpectedConditions.elementToBeClickable(confirmationDisableButtonLocator));
        ConfirmationDisableButton.click();
    }
    
    public String getDisabledSourceStatusInFirstRow() {
        return driver.findElement(statusOfDisabledSourceInFirstRow).getText();
    }
    
    public void clickOnBackToHomePageLogo() {
        driver.findElement(backToHomePageLogoLocator).click();
    }

}

    
