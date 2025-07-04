package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;


import pages.KeyboardPage;


//Test class to verify keyboard input behavior
public class KeyboardPageTest {

	// Declare WebDriver to control the browser
	WebDriver driver;

	// Declare page object for keyboard interaction
	KeyboardPage keyboardPage;

	// Method that runs once before all tests
	@BeforeClass
	public void setUp() {
		// Launch Firefox browser
		driver = new FirefoxDriver();

		// Open the keyboard page
		keyboardPage = new KeyboardPage(driver);
	}

	// Test method to check if typing works correctly
	@Test
	public void testKeyboardInput() {
		// Text to type
		String inputText = "This is bhavana";

		// Type the text into the page
		keyboardPage.typeText(inputText);

		// Get the message displayed after typing
		String actualMessage = keyboardPage.getTypedMessage();

		// Check if the displayed message matches the input
		Assert.assertEquals(actualMessage, inputText + "|", "Typed message does not match expected input");
	}

	// Method that runs once after all tests are done
	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
