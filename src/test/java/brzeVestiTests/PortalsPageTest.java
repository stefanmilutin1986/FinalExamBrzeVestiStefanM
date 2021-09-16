package brzeVestiTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.JavascriptExecutor;
import pages.DashboardPage;
import pages.PortalsPage;

public class PortalsPageTest extends BaseTestMethods{

    DashboardPage dashboardpage = new DashboardPage(driver);
    PortalsPage portalsspage = new PortalsPage(driver);

    @Before
    public void setUp(){
        logInAction();
        dashboardpage.clickOnPortalsPageLink();
    }

    @After
    public void tearDown(){        
        logOutAction();
    }
    
    @Test
    public void checkPlaceHolderMessagerAddPortalAction(){
        portalsspage.clickOnAddPortalButton();
        String titlePlaceHolder = portalsspage.checkPlaceHolderTitleAddPortalAction();
        String urlPlaceHolder = portalsspage.checkPlaceHolderUrlAddPortalAction();
        assertTrue("Wrong title placeholder message", titlePlaceHolder.equals("example: Sports, World"));
        assertTrue("Wrong url place holder message", urlPlaceHolder.equals("example: http://www.portal.org/"));        
    }
    
    @Test
    public void dragAndDropFirstRowToSecondRow(){
        portalsspage.dragAndDropFirstRowToSecondRow();
    }
    
    @Test
    public void addPortalAction() throws Exception{
        portalsspage.clickOnAddPortalButton();
        portalsspage.enterRandomDataToTitleField();
        portalsspage.enterRandomProperUrlFormDataToURLField();
        String newPortalTitle = portalsspage.getNewAddedPortalTitle();
        portalsspage.chooseRegionSecondInDropDown();
        portalsspage.clickOnSaveButton();
        String expectedAlertMessage = "Portal \"" + newPortalTitle + "\" has been successfully saved!";
        String actualAlertMessage = portalsspage.getAlertMessageText();
        assertTrue("Alert message is not correct", expectedAlertMessage.equals(actualAlertMessage));    
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        String portalTitleInLastRow = portalsspage.getPortalTitleInLastRow();
        assertTrue("Portal is not in table", newPortalTitle.equals(portalTitleInLastRow));
    }
    
    @Test
    public void deletePortalInFirstRow(){
        String portalDeleted = portalsspage.getPortalTitleInFirstRow();
        portalsspage.clickOnDeleteButton();
        portalsspage.clickOnDeleteConfirmationButton();
        String portalInFirstRowAfterDelete = portalsspage.getPortalTitleInFirstRow();
        String expectedAlertMessage = "Portal \"" + portalDeleted + "\" has been successfully deleted!";
        String actualAlertMessage = portalsspage.getAlertMessageText();
        assertTrue("Alert message is not correct", expectedAlertMessage.equals(actualAlertMessage));
        assertFalse("Portal is still in list", portalDeleted.equals(portalInFirstRowAfterDelete));
    }
    
    @Test
    public void clickOnHomePageLogo(){
        portalsspage.backToHomePageLogo();
        String expectedUrl = "http://bvtest.school.cubes.rs/";
        String actualUrl = driver.getCurrentUrl();         
        assertTrue ("URLs does not match" , expectedUrl.equals(actualUrl));
        driver.navigate().back();
    }

}
