package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.AlertsPage;

import static org.testng.Assert.*;

public class AlertsPageTest {
    WebDriver driver;         // WebDriver for browser control
    AlertsPage alertsPage;    // Page Object for alerts interactions

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();                   // Launch Firefox
        driver.manage().window().maximize();            // Maximize window
        alertsPage = new AlertsPage(driver);            // Initialize page object
        alertsPage.goToPage();                          // Navigate to demo
    }

    @Test(priority=1)
    public void simpleAlertTest() {
        alertsPage.clickSimpleAlert();                  // Trigger simple alert
        String alertText = alertsPage.getAlertText();   // Capture alert text
        assertEquals(alertText, "You've just triggered a simple alert!", 
                     "Alert text mismatch");            // Validate expected text
        alertsPage.acceptAlert();                       // Close alert via OK
        // Optional: validate result message on page
    }

    @Test(priority=2)
    public void confirmAlertTest() {
        alertsPage.clickConfirmAlert();                 // Trigger confirm alert
        String alertText = alertsPage.getAlertText();   // Capture prompt
        assertEquals(alertText, "You've just triggered a confirmation alert!", 
                     "Confirm text mismatch");          // Verify expected text

        alertsPage.dismissAlert();                      // Dismiss via Cancel
        String result = alertsPage.getResultText();     // Read result message
        assertFalse(result.contains("cancel"), 
                   "Expected cancellation message");     // Ensure cancellation is processed
    }

    @Test(priority=3)
    public void promptAlertTest() {
        alertsPage.clickPromptAlert();                  // Trigger prompt alert
        String alertText = alertsPage.getAlertText();   // Capture prompt label
        assertEquals(alertText, "I'm a Prompt! Type something into me!", 
                     "Prompt text mismatch");           // Validate expected text

        alertsPage.sendTextToPrompt("Selenium");        // Enter text + accept
        String result = alertsPage.getResultText();     // Read page result
        assertTrue(result.contains("Selenium"), 
                   "Expected prompt input to appear");   // Validate input reflection
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Clean up and close session
        }
    }
}
