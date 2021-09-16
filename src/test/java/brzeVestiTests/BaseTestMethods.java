package brzeVestiTests;

import java.io.File;
import org.codehaus.plexus.util.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LogInPage;
import pages.LogOutPage;

public class BaseTestMethods {
    
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    LogInPage loginpage = new LogInPage(driver);
    LogOutPage logoutpage = new LogOutPage(driver);
    
    @BeforeClass
    public static void setUpClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @AfterClass
    public static void tearDownClass(){
        driver.quit();
    }
    
    public void takeScreenShot(WebDriver driver, String screenShotName) throws Exception{        
        TakesScreenshot scrShot = (TakesScreenshot)driver;
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File("C:\\Users\\Stefan\\Desktop\\screenshot.png" + screenShotName + ".png"));
    }
    
    protected void logInAction() {
        driver.get("http://bvtest.school.cubes.rs/login");
        loginpage.enterEmail("qa@cubes.rs");
        loginpage.enterPassword("cubesqa");
        loginpage.clickOnLogInButton();
    }
    
    protected void logOutAction(){
        logoutpage.clickOnCubesQADropDown();
        logoutpage.clickOnLogOutButton(); 
    }
    
    protected void waitAction2Seconds(){
        wait = new WebDriverWait (driver, 2);
    }
    
    protected void waitAction(int howManySecondsToWait){
        wait = new WebDriverWait (driver, howManySecondsToWait);
    }
}
