package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.JobApplicationFormPage;

public class JobApplicationFormPageTest {
	 // Declare driver
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize the Firefox driver
        driver = new FirefoxDriver();
    }
    
    // JobApplicationFormPage
    @Test
    public void verifyFormSubmittedTest() {
        // Create object for JobApplicationFormPage
    	JobApplicationFormPage jobFormPage = new JobApplicationFormPage(driver);
    	jobFormPage.fillJobApplication("John", "john@gmail.com", "9876543210", "Full Stack Developer", "src/test/resources/Selenium_Selenese.docx");
    	
        // Verify redirect
        assertEquals(jobFormPage.getMessage(), "Application Submitted Successfully!");
    }

    // Close the browser
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}