package brzeVestiTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pages.DashboardPage;

public class DashboardPageTest extends BaseTestMethods {

    DashboardPage dashboardpage = new DashboardPage(driver);
    
    @Before
    public void setUp() {
        logInAction();
    }
    
    @After
    public void tearDown() {
        logOutAction();
    }
    
    @Test
    public void checkClickOnSignaturesLink(){
        dashboardpage.clickOnSignaturesPageLink();
        String expectedURL = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualURL = driver.getCurrentUrl();
        String signaturesElementPresent = dashboardpage.checkVisibilityOfSignaturesElement();
        assertTrue("Bad URL redirection", expectedURL.equals(actualURL));
        assertTrue("No signatures element on page", signaturesElementPresent.equals("Signatures"));
    }
    
    @Test
    public void checkClickOnCategoriesLink(){
        dashboardpage.clickOnCategoriesPageLink();
        String expectedURL = "http://bvtest.school.cubes.rs/admin/categories";
        String actualURL = driver.getCurrentUrl();
        String categoriesElementPresent = dashboardpage.checkVisibilityOfCategoriesElement();
        assertTrue("Bad URL redirection", expectedURL.equals(actualURL));
        assertTrue("No Add category link present", categoriesElementPresent.equals("Add category"));
    }
    
    @Test
    public void checkClickOnRegionsLink(){
        dashboardpage.clickOnRegionsPageLink();
        String expectedURL = "http://bvtest.school.cubes.rs/admin/regions";
        String actualURL = driver.getCurrentUrl();
        String regionsElementPresent = dashboardpage.checkVisibilityOfRegionsElement();
        assertTrue("Bad URL redirection", expectedURL.equals(actualURL));
        assertTrue("No Add region link present", regionsElementPresent.equals("Add region"));
    }
    
    @Test
    public void checkClickOnPortalsLink(){
        dashboardpage.clickOnPortalsPageLink();
        String expectedURL = "http://bvtest.school.cubes.rs/admin/portals";
        String actualURL = driver.getCurrentUrl();
        String addPortalLinkElement = dashboardpage.checkVisibilityAddPortalLinkElement();
        assertTrue("Bad URL redirection", expectedURL.equals(actualURL));
        assertTrue("No Add portal link present", addPortalLinkElement.equals("Add portal"));
    }
    
    @Test
    public void checkClickOnSourcesLink(){
        dashboardpage.clickOnSourcesPageLink();
        String expectedURL = "http://bvtest.school.cubes.rs/admin/sources";
        String actualURL = driver.getCurrentUrl();
        String addSourceLinkElement = dashboardpage.checkVisibilityAddSourceLinkElement();
        assertTrue("Bad URL redirection", expectedURL.equals(actualURL));
        assertTrue("No Add source link present", addSourceLinkElement.equals("Add source"));
    }
    
    @Test
    public void checkClickingOfHomePageLogo() {
        dashboardpage.backToHomePageLogo();
        String expectedUrl = "http://bvtest.school.cubes.rs/";
        String actualUrl = driver.getCurrentUrl();
        Boolean brzeVestiElementOnHomePage = dashboardpage.checkVisibilityBrzeVestiElementHomePage();
        assertTrue("URLs does not match" , expectedUrl.equals(actualUrl));
        assertTrue("No brze vesti element on home page", brzeVestiElementOnHomePage);
        driver.navigate().back();        //Must do because if not @After can not find locator for logout because no logout button on home page
    }

}
