package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DragAndDropPage;

public class DragAndDropPageTest {
	// WebDriver to control the browser
	WebDriver driver;
	// Page object for drag-and-drop
	DragAndDropPage dragPage;

	@BeforeClass
	public void setUp() {
		// Launch the Firefox browser
		driver = new FirefoxDriver();
	    // Instantiate the page object for the drag-and-drop functionality
		dragPage = new DragAndDropPage(driver);
	}

	@Test(priority = 1)
	public void testDragAndDrop() {
	    // Validate that the page title contains the word "Drag"
	    Assert.assertTrue( dragPage.getPageTitle().contains("Drag"),"Page title does not contain 'Drag'");

	    // Perform drag-and-drop to Dropzone 1 and validate the result
	    dragPage.dragToDropzone1();
	    String dropzone1Text = dragPage.getDropzone1Text();
	    Assert.assertEquals(dropzone1Text,"Dropped!","Ball was not dropped in Dropzone 1");
	   
	    // Perform drag-and-drop to Dropzone 2 and validate the result
	    dragPage.dragToDropzone2();
	    String dropzone2Text = dragPage.getDropzone2Text();
	    // Validate the drop result is successful
	    Assert.assertEquals(dropzone2Text,"Dropped!", "Ball was not dropped in Dropzone 2");
	    
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
