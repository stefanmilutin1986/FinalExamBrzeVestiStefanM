package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    public WebDriver driver;
    private By brzeVestiElementOnHomePage = By.cssSelector("img[alt='Brze vesti']");
    private By signaturesPageLinkLocator = By.linkText("Signatures");
    private By categoriesPageLinkLocator = By.linkText("Categories");
    private By regionsPageLinkLocator = By.linkText("Regions");
    private By portalsPageLinkLocator = By.linkText("Portals");
    private By sourcesPageLinkLocator = By.linkText("Sources");
    private By backToHomePageLogoLocator = By.linkText("Brze Vesti");
    private By signaturesElement = By.xpath("//div[contains(text(),'Signatures')]");
    private By addCategoryLinkElement = By.xpath("//a[contains(text(),'Add category')]");
    private By regionsElement = By.xpath("//a[contains(text(),'Add region')]");
    private By addPortalLinkElement = By.xpath("//a[contains(text(),'Add portal')]");
    private By addSourceLinkElement = By.xpath("//a[contains(text(),'Add source')]");
        
    public DashboardPage (WebDriver driver){
        this.driver = driver;
    }
    
    public boolean checkVisibilityBrzeVestiElementHomePage(){
        return driver.findElement(brzeVestiElementOnHomePage).isDisplayed();
    }
    
    public String checkVisibilityAddSourceLinkElement(){
        return driver.findElement(addSourceLinkElement).getText();
    }
    
    public String checkVisibilityAddPortalLinkElement(){
        return driver.findElement(addPortalLinkElement).getText();
    }
    
    public String checkVisibilityOfCategoriesElement(){
        return driver.findElement(addCategoryLinkElement).getText();
    }
    
    public String checkVisibilityOfSignaturesElement(){
        return driver.findElement(signaturesElement).getText();
    }
    
    public String checkVisibilityOfRegionsElement(){
        return driver.findElement(regionsElement).getText();
    }
    
    public void clickOnSignaturesPageLink(){
        driver.findElement(signaturesPageLinkLocator).click();
    }

    public void clickOnCategoriesPageLink(){
        driver.findElement(categoriesPageLinkLocator).click();
    }
    
    public void clickOnRegionsPageLink(){
        driver.findElement(regionsPageLinkLocator).click();
    }
    
    public void clickOnPortalsPageLink(){
        driver.findElement(portalsPageLinkLocator).click();
    }
    
    public void clickOnSourcesPageLink(){
        driver.findElement(sourcesPageLinkLocator).click();
    }

    public void backToHomePageLogo() {
        driver.findElement(backToHomePageLogoLocator).click();
    }
   
}
