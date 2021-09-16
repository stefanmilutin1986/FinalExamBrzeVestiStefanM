package brzeVestiTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pages.DashboardPage;
import pages.RegionsPage;

public class RegionsPageTest extends BaseTestMethods{
    
    DashboardPage dashboardpage = new DashboardPage(driver);
    RegionsPage regionspage = new RegionsPage(driver);
    
    @Before
    public void setUp() {
        logInAction();
        dashboardpage.clickOnRegionsPageLink();
    }
    
    @After
    public void tearDown() {
        logOutAction();
    }
    
    @Test
    public void addRegionTest() {
        regionspage.clickOnAddRegionButton();
        regionspage.enterDataToTitleField();
        waitAction2Seconds();
        String newCategoryTitle = regionspage.newTitleRegionAdd();        
        regionspage.clickOnSaveButton();       
        String expectedAlertMessage = "Region \"" + newCategoryTitle + "\" has been successfully saved!";
        String actualAlertMessage = regionspage.getAlertMessageText();
        assertTrue("Alert message is not correct", expectedAlertMessage.equals(actualAlertMessage));        
    }
    
    @Test
    public void disableRegionInFirstRow() {
        if (regionspage.statusOfRegionInFirstRow().equalsIgnoreCase("D")){
            regionspage.clickOnEnableRegionButtonInFirstRow();
            regionspage.clickOnconfirmationEnableButton();
        }
        String newCategoryTitle = regionspage.nameOfDisabledRegionInFirstRow();
        regionspage.clickOnDisableButtonInFirstRow();
        regionspage.clickOnconfirmationDisableButton();
        String actualAlertMessageAfterDisable = regionspage.getAlertMessageText();
        String expectedAlertMessageAfterDisable = "Region \"" + newCategoryTitle + "\" has been disabled";
        assertTrue("Alert message is not correct", actualAlertMessageAfterDisable.equals(expectedAlertMessageAfterDisable));  
    }
    
    @Test
    public void deleteRegionInFirstRow() {
        String FirstRowRegionTitleBeforeDelete = regionspage.checkRegionTitleInFirstRow();
        regionspage.clickOnDeleteRegionButtonInFirstRow();
        regionspage.clickOnConfirmationDeleteRegionButton();
        String FirstRowRegionTitleAfterDelete = regionspage.checkRegionTitleInFirstRow();
        assertFalse("Delete element is still in list", FirstRowRegionTitleBeforeDelete.equals(FirstRowRegionTitleAfterDelete));       
    }
    
    @Test
    public void clickOnHomePageLogo() {
        regionspage.clickOnBackToHomePageLogo();
        String expectedUrl = "http://bvtest.school.cubes.rs/";
        String actualUrl = driver.getCurrentUrl();         
        assertTrue ("URLs does not match" , expectedUrl.equals(actualUrl));
        driver.navigate().back();
    }

}
