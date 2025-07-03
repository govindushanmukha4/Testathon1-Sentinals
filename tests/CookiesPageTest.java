package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CookiesPage;

import static org.testng.Assert.assertEquals;

public class CookiesPageTest {
	WebDriver driver;
	CookiesPage cookiesPage;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		cookiesPage = new CookiesPage(driver);
	}

	@Test
	public void headingTest() {
		String pageHeading = cookiesPage.getPageHeading();
		
		assertEquals(pageHeading, "Cookies 🍪", "Heading should be 'Cookies'");
	}

	@Test
	public void visitMessageTest() throws InterruptedException {
		cookiesPage.refreshPage();
		Thread.sleep(3000); // Allow message to reload
		String message = cookiesPage.getPrimaryMessage();
		//System.out.println("Visit Message: " + message);
		assertEquals(message, message, "Message should be 'You have visited this page before'");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
