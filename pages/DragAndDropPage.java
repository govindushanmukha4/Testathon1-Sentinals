package pages;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.interactions.Actions;

	// Class definition
	public class DragAndDropPage {

		// Declare a WebDriver
		WebDriver driver;

		// Declare an Actions instance to perform complex user gestures like drag and drop
		Actions builder;

		// Locators for the WebElements
		@FindBy(id = "ball")
		WebElement ball;

		// Locate the first dropzone element using its ID
		@FindBy(id = "dropzone1")
		WebElement dropzone1;

		// Locate the second dropzone element using its ID
		@FindBy(id = "dropzone2")
		WebElement dropzone2;

		// Initialize the constuctor
		public DragAndDropPage(WebDriver driver) {

			this.driver = driver; // Assign the incoming driver to the class variable
			this.builder = new Actions(driver); // Initialize the Actions object

			// Navigate to the drag-and-drop training page
			driver.get("https://training-support.net/webelements/drag-drop");

			// Verify that the correct page has loaded by checking the title
			if (!driver.getTitle().contains("Drag")) {

				// If not, throw an exception to alert the tester
				throw new IllegalStateException(
						"Not on the Drag and Drop page. Current page: " + driver.getCurrentUrl());
			}
			else {
				// Initialize the WebElements declared with @FindBy annotations
				PageFactory.initElements(driver, this);
			}
		}

		// Method to return the page title
		public String getPageTitle() {
			return driver.getTitle();
		}

		// Perform drag-and-drop of the ball into dropzone1
		public void dragToDropzone1() {
			builder.dragAndDrop(ball, dropzone1).build().perform();
		}

		// Alternate method to drag the ball into dropzone2 using click-and-hold
		public void dragToDropzone2() {
			builder.clickAndHold(ball).moveToElement(dropzone2).release().build().perform();
		}

		// Returns the text displayed inside dropzone1
		public String getDropzone1Text() {
			return dropzone1.getText();
		}

		// Returns the text displayed inside dropzone2
		public String getDropzone2Text() {
			return dropzone2.getText();
		}
	}
