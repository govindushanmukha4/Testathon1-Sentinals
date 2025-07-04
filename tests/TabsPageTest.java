package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.TabsPage;
//Test class to validate tab-opening behavior on the Tabs page
public class TabsPageTest {
// WebDriver instance for browser automation
WebDriver driver;
//Instance of TabsPage to access tab-related actions
TabsPage tabs;
//Runs once before any test method in the class
@BeforeClass
public void setUp() {
	// Launch a Firefox browser instance
    driver = new FirefoxDriver();
    // Navigate to the web page that contains tab-opening functionality
    driver.get("https://training-support.net/webelements/tabs");
    // Initialize the TabsPage object using the driver
    tabs = new TabsPage(driver);
}

@Test(priority = 1)
// Open tabs until one contains the heading "release"
public void openTabsUntilReleaseTest() {
   // Call the method that opens tabs and returns the heading text when "release" is found
   String m =  tabs.openTabsUntilRelease();
   // Assert that the final heading equals "release"
   assertEquals(m, "release");
}


// Runs once after all test methods have been executed
@AfterClass
public void tearDown() {
    try {
    	 // Quit the WebDriver session to close the browser
        driver.quit();
    } catch (Exception e) {
    	// Log any exception that occurs during browser closure
    	Reporter.log(e.getMessage(), true);
    }
}

}
