package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.*;

import pages.LoginPopupPage;
import pages.LoginPopupSuccessPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginPopupPageTest {

    WebDriver driver;
    WebDriverWait wait;
  // This method runs once before all tests
    @BeforeClass
    public void setUp() {
    	 // Initialize Firefox browser
        driver = new FirefoxDriver();
     // Initialize explicit wait with a 10-second timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Test case for login popup
    @Test
    public void testLoginPopup() {
    	// Create an instance of the LoginPopupPage
        LoginPopupPage popupPage = new LoginPopupPage(driver);

        // Open the login popup 
        popupPage.openLoginPopup();
        // Wait until the username field is clickable to ensure it's ready for input
        wait.until(ExpectedConditions.elementToBeClickable(popupPage.usernameField));

        // Perform login with given credentials
        LoginPopupSuccessPage successPage = popupPage.login("admin", "password");

     // Get the success message after login
        String message = successPage.getSuccessMessage();

        // Assert that the actual message matches the expected message
        assertEquals(message, "Welcome Back, Admin!");
    }

 // This method runs once after all test methods
    @AfterClass
    public void tearDown() {
    	//close the browser
        driver.quit();
    }
}
