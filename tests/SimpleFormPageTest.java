package tests;


import pages.SimpleFormPage;
import pages.SimpleFormSuccessPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class SimpleFormPageTest {
  //declare driver 
    WebDriver driver;
    
  // runs before once all the Test methods 
    @BeforeClass
    public void setUp() {
    	// initialize firefox Browser
        driver = new FirefoxDriver();
    }
    @Test
    public void simpleFormSubmissionTest() {
    	// Create object for the form page
        SimpleFormPage formPage = new SimpleFormPage(driver);
        // Fill and submit the form with test data
        SimpleFormSuccessPage successPage = formPage.fillAndSubmitForm(
            "DesireddiMadhupriya", "madhupriya@gmail.com", "2025-07-02", "I'm Desireddi Madhupriya");

        // Get confirmation message from the success page
        String confirmation = successPage.readConfirmationMessage();

        // Verify that the confirmation message is as same as the expected (actual and expected value same )
        assertEquals(confirmation, "Your event has been scheduled!");
    }

   
   // this method runs after all the Test Methods
    @AfterClass
    public void tearDown() {
    	// close the browser
      driver.quit();
    }
}
