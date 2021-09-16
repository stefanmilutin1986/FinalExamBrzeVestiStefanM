package brzeVestiTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pages.DashboardPage;
import pages.SourcesPage;

public class SourcesPageTest extends BaseTestMethods {
    
    DashboardPage dashboardpage = new DashboardPage(driver);
    SourcesPage sourcesspage = new SourcesPage(driver);
    
    public SourcesPageTest() {
    }

    @Before
    public void setUp() {
        logInAction();
        dashboardpage.clickOnSourcesPageLink();
    }
    
    @After
    public void tearDown() {
        logOutAction();
    }
    
    @Test
    public void checkBackToSourcesLinkWhenAddSource() {
        sourcesspage.clickOnAddSourceButton();
        sourcesspage.backToSourcesClick();
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();         
        assertTrue ("URLs does not match" , expectedUrl.equals(actualUrl));   
    }
    
    @Test
    public void addSourceAction() {
        sourcesspage.clickOnAddSourceButton();
        sourcesspage.chooseSecondPortalInDropDown();
        sourcesspage.enterTitle();
        String newSourceTitle = sourcesspage.getNewAddedSourceTitle();
        sourcesspage.enterUrl();
        sourcesspage.chooseSecondCategoryinDropDown();
        sourcesspage.clickOnSaveButton();
        String expectedAlertMessage = "Source \"" + newSourceTitle + "\" has been successfully saved!";
        String actualAlertMessage = sourcesspage.getAlertMessageText();
        assertTrue("Alert message is not correct", expectedAlertMessage.equals(actualAlertMessage));        
    }
    
    @Test
    public void disableSourceInFirstRowAction() {
        sourcesspage.clickOnDisableButtonInFirstRow();
        sourcesspage.clickOnConfirmationDisableButton();
        String statusAfterDisableSource = sourcesspage.getDisabledSourceStatusInFirstRow();        
        String statusBeforeDisableSource = "E";        
        assertFalse("Source status after disable is not changed", statusBeforeDisableSource.equals(statusAfterDisableSource));
    }
    
    @Test
    public void clickOnHomePageLogo() {
        sourcesspage.clickOnBackToHomePageLogo();
        String expectedUrl = "http://bvtest.school.cubes.rs/";
        String actualUrl = driver.getCurrentUrl();         
        assertTrue ("URLs does not match" , expectedUrl.equals(actualUrl));
        driver.navigate().back();
    }

    @Test
    public void changeCategory(){
        String secondCategoryDropDown = sourcesspage.getTextCategoryDropDownSecondOption();
        sourcesspage.chooseSecondCategoryinDropDown();        
    }
}
