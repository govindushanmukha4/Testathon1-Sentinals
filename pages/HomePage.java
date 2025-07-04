package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// Declare the driver
	WebDriver driver;

	// Find the heading of the home page
	@FindBy(tagName = "h1")
	WebElement pageHeading;
	
	// about us button
	@FindBy(linkText = "About Us")
	WebElement aboutButton;

	public HomePage(WebDriver driver) {
		// Initialize webdriver
		this.driver = driver;
		driver.get("https://training-support.net/");
		// Check if we are on the right page
		if (!driver.getTitle().equals("Training Support")) {
			throw new IllegalStateException("This is not right page. Current page is: " + driver.getCurrentUrl());
		} else {
			// Initialize all the elements for this page
			PageFactory.initElements(driver, this);
		}
	}
	
	// Returns page heading
	public String readPageHeading() {
		return pageHeading.getText();
	}

	// return driver to about page
	public AboutPage aboutUsButton() {
		aboutButton.click();
		return new AboutPage(driver);
	}

}