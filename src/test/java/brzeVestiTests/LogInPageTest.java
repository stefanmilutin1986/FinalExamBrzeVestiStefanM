package brzeVestiTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LogInPageTest extends BaseTestMethods {

    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void logInWithValidCredentials(){        
        logInAction();
        String expectedURL = "http://bvtest.school.cubes.rs/admin";
        String actualURL = driver.getCurrentUrl();
        String dashboardPagePresentOnHomePage = loginpage.DashboardElementPresentOnHomePage();
        assertTrue("No Dashboard element present on home page", dashboardPagePresentOnHomePage.equals("Dashboard"));
        assertTrue("Bad URL redirection, not logged in to admin page", expectedURL.equals(actualURL));
        logOutAction();
    }
    
    @Test
    public void logInWithInvalidEmailAndInvalidPassword(){
        loginpage.enterEmail("sdasdasdqa@cubes.rs");
        loginpage.enterPassword("cubesqa");
        loginpage.clickOnLogInButton();
        String expectedMessage = "These credentials do not match our records.";
        String actaulMessage = loginpage.getWarningMessageForInputInvalidEmail();
        assertTrue("Bad Warning message for login with invalid email and invalid password", expectedMessage.equals(actaulMessage));
    }
    
    @Test
    public void logInWithEmptyEmailAndEmptyPasswordFields(){
        loginpage.clickOnLogInButton();
        String EmailField = "The email field is required.";
        String PasswordField = "The password field is required.";
        String actualEmailField = loginpage.getWarningMessageForEmptyEmailField();
        String actualPasswordField = loginpage.getWarningMessageForEmptyPasswordField();
        assertTrue("Bad Warning message for login with empty email field", EmailField.equals(actualEmailField));
        assertTrue("Bad Warning message for login with empty password field", PasswordField.equals(actualPasswordField));        
    }
    
    @Test
    public void logInWithValidEmailAndInvalidPassword(){
        loginpage.enterEmail("qa@cubes.rs");
        loginpage.enterPassword("cubesqa111");
        loginpage.clickOnLogInButton();
        String expectedMessage = "These credentials do not match our records.";
        String actaulMessage = loginpage.getWarningMessageForInputInvalidEmail();
        assertTrue("Bad Warning message for login with Invalid Password and valid email Message", expectedMessage.equals(actaulMessage));
    }
    
    @Test
    public void logInWithInvalidEmailAndValidPassword(){
        loginpage.enterEmail("qa@ggggcubes.rs");
        loginpage.enterPassword("cubesqa");
        loginpage.clickOnLogInButton();
        String expectedMessage = "These credentials do not match our records.";
        String actaulMessage = loginpage.getWarningMessageForInputInvalidEmail();
        assertTrue("Bad Warning message for login with Invalid email and valid password", expectedMessage.equals(actaulMessage));
    }

}
