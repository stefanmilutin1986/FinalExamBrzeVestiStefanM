package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import framework.Helper;
import java.io.File;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortalsPage {
    
    public WebDriver driver;
    private static WebDriverWait wait;
    public Helper helper;
    private By disablePortalButtonFirstRow = By.cssSelector("button[title='Disable']");
    private By addPortalButtonLocator = By.className("pull-right");
    private By titleFieldLocator = By.id("title");
    private By urlFieldLocator = By.id("url");
    private By saveButtonLocator = By.id("save-portal-button");
    private By urlPlaceHolder = By.cssSelector("input[placeholder='example: http://www.portal.org/']");
    private By actionsDeleteButtonLocator = By.cssSelector("button[title='Delete']");
    private By deleteConfirmationButtonLocator = By.xpath("//button[contains(text(),'Delete')]");
    private By alertMessageLocator = By.className("alert-success");
    private By titleInFirstRowLocator = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[1]/td[3]");
    private By backToHomePageLogoLocator = By.linkText("Brze Vesti");
    private By titleInLastRowNewPortalCheckLocator = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[last()]/td[3]");
    private By firstRowPortal = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[1]/td[1]/span");
    private By secondRowPortal = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[2]/td[1]/span");
    private By titlePlaceHolder = By.cssSelector("input[placeholder='example: Sports, World']");
    private By popUpMessageDisablePortal = By.className("modal-header");
                
    public PortalsPage (WebDriver driver){
        this.driver = driver;
    }
    
    public String popUpDisablePortalMessage(){
        return driver.findElement(popUpMessageDisablePortal).getText();
    }
    
    public String checkPlaceHolderTitleAddPortalAction(){
        return driver.findElement(titlePlaceHolder).getAttribute("placeholder");
    }
    
    public String checkPlaceHolderUrlAddPortalAction(){
        return driver.findElement(urlPlaceHolder).getAttribute("placeholder");
    }
    
    public void dragAndDropFirstRowToSecondRow(){
        Actions action = new Actions(driver);
        Action dragAndDrop = action.clickAndHold(driver.findElement(firstRowPortal)).moveToElement(driver.findElement(secondRowPortal)).release(driver.findElement(secondRowPortal)).build();
        dragAndDrop.perform();    
    }
    
    public void clickOnAddPortalButton() {
        driver.findElement(addPortalButtonLocator).click();
    }
    
    public void enterRandomDataToTitleField() {
        String newPortalTitle = Helper.generateTitle();
        driver.findElement(titleFieldLocator).sendKeys(newPortalTitle);
    }
    
    public void enterRandomProperUrlFormDataToURLField() {
        String newPortalUrl = Helper.generateUrl();
        driver.findElement(urlFieldLocator).sendKeys(newPortalUrl);
    }
    
    public void clickOnDisablePortalButtonFirstRow(){
        driver.findElement(disablePortalButtonFirstRow).click();
    }
    
    public void chooseRegionSecondInDropDown() {
    Select selectcategory = new Select(driver.findElement(By.name("region_id")));
    selectcategory.selectByIndex(1);
    }
    
    public void clickOnSaveButton() {
        driver.findElement(saveButtonLocator).click();
    }
    
    public String getAlertMessageText() {
        return driver.findElement(alertMessageLocator).getText();
    }
    
    public String getNewAddedPortalTitle() {
        return driver.findElement(titleFieldLocator).getAttribute("value");
    }
    
    public String getPortalTitleInLastRow() {
        return driver.findElement(titleInLastRowNewPortalCheckLocator).getText();
    }
    
    public void clickOnDeleteButton() {
        driver.findElement(actionsDeleteButtonLocator).click();
    }
    
    public void clickOnDeleteConfirmationButton() {
        wait = new WebDriverWait(driver, 2);
        WebElement clickOnDeleteConfirmationButton = wait.until(ExpectedConditions.elementToBeClickable(deleteConfirmationButtonLocator));
        clickOnDeleteConfirmationButton.click();
    }

    public String getPortalTitleInFirstRow() {
        return driver.findElement(titleInFirstRowLocator).getText();
    }
    
    public void backToHomePageLogo() {
        driver.findElement(backToHomePageLogoLocator).click();
    }
   
}
