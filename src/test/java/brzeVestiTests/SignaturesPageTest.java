package brzeVestiTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pages.DashboardPage;
import pages.SignaturesPage;

public class SignaturesPageTest extends BaseTestMethods {
       
    DashboardPage dashboardpage = new DashboardPage(driver);
    SignaturesPage signaturespage = new SignaturesPage(driver);
    
    @Before
    public void setUp() {
        logInAction();
        dashboardpage.clickOnSignaturesPageLink();
    }
    
    @After
    public void tearDown() {
        logOutAction();
    }
    
    @Test
    public void checkPortalDropDownChooseVestiOnlinePortal() {
        String expectedPortalAfterChangePortalAction = "Vesti Online";
        signaturespage.chooseVestiOnlinePortalFromDropDown();
        String portalNameAfterDropDown = signaturespage.portalNameAfterDropDown();
        assertTrue("Bad Portal after change", expectedPortalAfterChangePortalAction.equals(portalNameAfterDropDown));
    }

    @Test
    public void checkingOfHomePageLogo() {
        signaturespage.backToHomePageLogo();
        String expectedUrl = "http://bvtest.school.cubes.rs/";
        String actualUrl = driver.getCurrentUrl();         
        assertTrue ("URLs does not match" , expectedUrl.equals(actualUrl));
        driver.navigate().back();
    }
    
    @Test
    public void deleteSignatureAction() {
        String FirstRowSignatureTitleBeforeDelete = signaturespage.checkSignatureTitleInFirstRow();
        signaturespage.clickOnDeleteSignaturesButton();
        signaturespage.clickOnConfirmationDeleteSignaturesButton();
        String FirstRowSignatureTitleAfterDelete = signaturespage.checkSignatureTitleInFirstRow();
        assertFalse("Delete element is still in list", FirstRowSignatureTitleBeforeDelete.equals(FirstRowSignatureTitleAfterDelete));        
    }   
}