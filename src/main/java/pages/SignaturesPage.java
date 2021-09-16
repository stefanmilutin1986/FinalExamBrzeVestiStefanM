package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignaturesPage {
    public WebDriver driver;
    private static WebDriverWait wait;
    private By portalDropDownLocator = By.id("newsProcessorSignaturePortalSelect");
    private By actionsApproveButtonInFirstRowLocator = By.cssSelector("button[title='Approve']");
    private By approveConfirmationButtonLocator = By.xpath("//button[contains(text(),'Approve')]");
    private By alertMessageLocator = By.className("alert-success");
    private By deleteSignatureButtonInFirstRowLocator = By.cssSelector("button[title='Delete']");
    private By actionsIgnoreButtonInFirstRowLocator = By.cssSelector("button[title='Ignore']");
    private By ignoreConfirmationButtonLocator = By.xpath("//button[contains(text(),'Ignore')]");
    private By changeCategoryButtoninFirstRowLocator = By.cssSelector("button[title='Change category']");
    private By approveChangeButtonLocator = By.xpath("//button[contains(text(),'Approve')]");
    private By categoryNameinFirstRowLocator = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[1]/td[4]");
    private By backToHomePageLogoLocator = By.linkText("Brze Vesti");
    private By firstInPortalDropDownListLocator = By.xpath("//*[@id=\"newsProcessorSignaturePortalSelect\"]/option[2]");
    private By portalNameAfterDropDownLocator = By.xpath("//*[@id=\"newsProcessorSignaturePortalSelect\"]/option[0]");
    private By confirmationDeleteSignatureButtonLocator = By.xpath("//button[contains(text(),'Delete')]");
    private By signatureInFirstRowLocator = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[1]/td[3]");
    private By portalInFirstRowAfterPortalChangeAndApprove = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[1]/td[2]");
    private By statusOfCategoryAfterApproveActioninFirstRowLocator = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[1]/td[6]/div/button[1]");
        
    public SignaturesPage (WebDriver driver){
        this.driver = driver;
    }

    public void chooseVestiOnlinePortalFromDropDown() {
        Select selectPortal = new Select (driver.findElement(By.name("portal_id")));
        selectPortal.selectByVisibleText("Vesti Online");
    }
    
    public void changeSignatureStatusToApproved() {
        Select selectStatus = new Select (driver.findElement(By.xpath("//*[@id=\"newsProcessorSignatureStatusSelect\"]")));
        selectStatus.selectByVisibleText("Approved");
    }
    
    public void clickOnApproveButtonInFirstRow() {
        driver.findElement(actionsApproveButtonInFirstRowLocator).click();
    }
    
    public String portalTitleInFirstRowAfterPortalChangeAndApprove() {
        return driver.findElement(portalInFirstRowAfterPortalChangeAndApprove).getText();
    }
    
    public void clickOnApproveConfirmationButton() {
        driver.findElement(approveConfirmationButtonLocator).click();
    }
    
    public String checkingAlertMessage(){
        return driver.findElement(alertMessageLocator).getText();
    }
    
    public void clickOnIgnoreButtonInFirstRow() {
        driver.findElement(actionsIgnoreButtonInFirstRowLocator).click();
    }
    
    public void clickOnIgnoreConfirmationButton() {
        driver.findElement(ignoreConfirmationButtonLocator).click();
    }

    public void clickOnApproveChangeCategory() {
        driver.findElement(approveChangeButtonLocator).click();
    }

    public void backToHomePageLogo() {
        driver.findElement(backToHomePageLogoLocator).click();
    }
    
    public String portalNameAfterDropDown() {
        Select selectPortal = new Select (driver.findElement(By.name("portal_id")));
        return selectPortal.getFirstSelectedOption().getText();        
    }
    
    public void clickOnDeleteSignaturesButton() {
        driver.findElement(deleteSignatureButtonInFirstRowLocator).click();
    }
    
    public void clickOnConfirmationDeleteSignaturesButton() {
        wait = new WebDriverWait(driver, 3);
        WebElement ConfirmationDeleteSignaturesButton1 = wait.until(ExpectedConditions.elementToBeClickable(confirmationDeleteSignatureButtonLocator));
        ConfirmationDeleteSignaturesButton1.click();
    }
    
    public String checkSignatureTitleInFirstRow() {
        return driver.findElement(signatureInFirstRowLocator).getText();
    }
    
}
