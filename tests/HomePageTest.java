package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AboutPage;
import pages.HomePage;

public class HomePageTest {
	 // Declare driver
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize the Firefox driver
        driver = new FirefoxDriver();
    }
    
    // Home Page
    @Test (priority=1)
    public void pageHeadingTest() {
        // Create object for HomePage
        HomePage homePage = new HomePage(driver);

        // Verify redirect
        assertEquals(homePage.readPageHeading(), "Training Support");
        homePage.aboutUsButton();
    }
    
    // about page
    @Test(priority=2)
    public void aboutPageHeading() {
    	AboutPage aboutPage = new AboutPage(driver);
        // Verify redirect
        assertEquals(aboutPage.readAboutUsPageHeading(), "About Us");
    }
    
    // Close the browser
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
