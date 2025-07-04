package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import pages.paginationPage;

import java.time.Duration;

public class PaginationPageTest {

	WebDriver driver;
	WebDriverWait wait;
	paginationPage pg1;

	@BeforeClass
	public void setUp() {
		
		  // 1. Launch new Firefox browser instance
		driver = new FirefoxDriver();
		
	    // 2. Set up explicit wait with a 10-second timeout
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		 // 3. Maximize the browser window for consistent element visibility
		driver.manage().window().maximize();
		
        // 4. Initialize page object for pagination functionality
		pg1 = new paginationPage(driver);
	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		// Assert that the page title matches the expected text
		Assert.assertEquals(pg1.getPageTitle(), "Selenium: Pagination", "Page title mismatch");
	}

	@Test(priority = 2)
	public void verifyCharminarDisplayed() {
		 // Verify that the Charminar element is visible on the initial page
		Assert.assertTrue(pg1.isCharminarVisible(), "Charminar is not displayed");
	}

	@Test(priority = 3)
	public void verifyGatewayIndiaDisplayed() {
		pg1.clickRightArrowTwice();
	       // Verify that the Gateway of India is now visible
		Assert.assertTrue(pg1.isGatewayIndiaVisible(), "Gateway of India is not displayed");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}







