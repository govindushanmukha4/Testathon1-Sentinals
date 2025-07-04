package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CateringServicePage;

public class CateringServicePageTest {
	// Declare driver
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initialize the Firefox driver
		driver = new FirefoxDriver();
	}

	// Home Page
	@Test
	public void CateringServiceFormVerify() {
		// Create object for HomePage
		CateringServicePage jobFormPage = new CateringServicePage(driver);
		jobFormPage.fillJobApplication("John", "9876543210", "4-52, French colony, Chennai", "BBQ", "2026-01-01",
				"09:50");

		// Verify redirect
		assertEquals(jobFormPage.getMessage(), "Booking Successful!");
	}

	// Close the browser
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}