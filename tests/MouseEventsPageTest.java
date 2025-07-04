package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.MouseEventsPage;

public class MouseEventsPageTest {
	// Declare WebDriver to control the browser
	WebDriver driver;

	// Declare page object for interacting with mouse events UI
	MouseEventsPage mousePage;

	// Method to run once before all test methods
	@BeforeClass
	public void setUp() {
		// Initialize Firefox browser
		driver = new FirefoxDriver();

		// Instantiate the page object representing the Mouse Events page
		mousePage = new MouseEventsPage(driver);
	}

	@Test(priority = 1)
	public void testTitle() {
		// Get the actual page title
		String actualTitle = mousePage.getTitle();

		// Define the expected page title
		String expectedTitle = "Selenium: Mouse Events";

		// Validate that the actual title matches the expected title
		Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");
	}

	@Test(priority = 2)
	public void testClickSequence() {
		// Perform a single click on the 'Cargo.toml' file element
		mousePage.clickCargoFiles();

		// Retrieve the result text displayed on the page
		String result = mousePage.getResultText();
		// Verify that the result text matches the expected output
		Assert.assertEquals(result, "You clicked on Cargo.toml", "Unexpected result text after click");
	}

	@Test(priority = 3)
	public void testContextAndDoubleClick() {
		// Perform a right-click (context click) on a target element
		mousePage.performClickActions();

		// Perform a double-click on the 'src' folder
		 Actions actions = new Actions(driver);
		    actions.doubleClick().perform();

		// Retrieve the result text after double-clicking
		    String result = mousePage.getResultText();
		// Verify that the result text reflects the double-click action
		Assert.assertEquals(result, "You double clicked on src", "Unexpected result after double click");

	}

	// Method to run once after all tests complete
	@AfterClass
	public void tearDown() {
		// Close the browser and release resources
		driver.quit();
	}
}
