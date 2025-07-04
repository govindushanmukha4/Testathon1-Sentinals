package pages;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	// Page class for handling keyboard event interactions
	public class KeyboardPage {

		// WebDriver instance for browser actions
		WebDriver driver;

		// Actions object for simulating keyboard input
		Actions builder;

		// Locate the heading that shows the typed message
		@FindBy(css = "h1.mt-3")
		WebElement messageHeading;

		// Constructor to initialize the page and validate the URL
		public KeyboardPage(WebDriver driver) {
			this.driver = driver;

			// Initialize the Actions object
			this.builder = new Actions(driver);

			// Load the keyboard events test page
			driver.get("https://training-support.net/webelements/keyboard-events");

			// Verify correct page has loaded
			if (!driver.getTitle().contains("Keyboard Events")) {
				throw new IllegalStateException("Not on the Keyboard Events page. Current page: " + driver.getCurrentUrl());
			}
			else {
				// Initialize the WebElements with PageFactory
				PageFactory.initElements(driver, this);
			}
		}

		// Get the title of the current page
		public String getPageTitle() {
			return driver.getTitle();
		}

		// Type the specified text using keyboard simulation
		public void typeText(String text) {
			builder.sendKeys(text).build().perform();
		}

		// Get the text displayed in the message heading
		public String getTypedMessage() {
			return messageHeading.getText();
		}
	}
