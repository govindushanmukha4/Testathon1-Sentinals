package tests;

import pages.LoginFormPage;
import pages.LoginFormSuccessPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginFormPageTest {
	//declare driver
	WebDriver driver;
	
    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test(priority = 1)
    public void loginFailTest() {
    	 // Create object for LoginFormPage
        LoginFormPage loginFormPage = new LoginFormPage(driver);
        //Attempt Login with invalid credentials 
        LoginFormSuccessPage successPage = loginFormPage.loginUser("username", "password");
        //Verify Redirectry  Assertion to verify if login was successful
        assertEquals(successPage.readPageHeading(), "Login Form");
    }
    
    @Test(priority = 2)
    public void loginSuccessTest() {
    	// Create object for LoginFormPage
        LoginFormPage loginFormPage = new LoginFormPage(driver);
        //attempt login with correct credentials 
        LoginFormSuccessPage successPage = loginFormPage.loginUser("admin", "password");
     // Assertion to verify if login was successful
        assertEquals(successPage.readPageHeading(), "Login Success!");
    }
    
    // This method runs once after all test methods
    @AfterClass
    public void tearDown() {
    	//close the browser
        driver.quit();
	
    }
	
}
