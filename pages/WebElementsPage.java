//package pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class WebElementsPage {
//	// Declare the driver
//	WebDriver driver;
//
//	// Find the heading of the home page
//	@FindBy(tagName = "h1")
//	WebElement pageHeading;
//	
//	@FindBy(tagName="button")
//	WebElement navButton;
//
//	@FindBy(linkText = "WebElements")
//	WebElement webElements;
//	
//	if (!driver.getTitle().equals("Training Support: WebElement Playground")) {
//		navButton.click();
//		webElements.click();
//		PageFactory.initElements(driver, this);
//	} else {
//		// Initialize all the elements for this page
//		PageFactory.initElements(driver, this);
//	}
//			
//}
