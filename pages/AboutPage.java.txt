package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {
	// Declare the driver
	WebDriver driver;

	// Find the heading of the about page
	@FindBy(xpath = "//h1[contains(text(), 'About Us')]")
	WebElement pageHeading;

	public AboutPage(WebDriver driver) {
		this.driver = driver;

		// Check if we are on the right page
		if (!driver.getTitle().equals("About Training Support")) {
			throw new IllegalStateException("This is not right page. Current page is: " + driver.getCurrentUrl());
		} else {
			// Initialize all the elements for this page
			PageFactory.initElements(driver, this);
		}
	}

	// returns about us page heading
	public String readAboutUsPageHeading() {
		return pageHeading.getText();
	}
}
