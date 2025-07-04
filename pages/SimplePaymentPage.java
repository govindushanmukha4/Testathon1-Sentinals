package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SimplePaymentPage {
	
	// Declare the driver
	WebDriver driver;

	// page heading locator
	@FindBy(tagName = "h1")
	WebElement pageHeading;

	// aboutButton locator
	@FindBy(linkText = "About Us")
	WebElement aboutButton;
	
	// Enter Withdraw money 
	@FindBy(id = "paymentAmount")
	WebElement withdrawMoney;
	
	@FindBy(xpath = "//button[contains(text(),'Pay')]")
    WebElement payButton;
	
	@FindBy(className = "text-green-600")
	WebElement message;
	

	public SimplePaymentPage(WebDriver driver) {
		// Initialize webdriver
		this.driver = driver;
		driver.get("https://training-support.net/complex-forms/simple-payment/");
		// Check if we are on the right page
		if (!driver.getTitle().equals("Simple Withdrawal Form")) {
			throw new IllegalStateException("This is not right page. Current page is: " + driver.getCurrentUrl());
		} else {
			// Initialize all the elements for this page
			PageFactory.initElements(driver, this);
		}
	}
	

	public String makePayment1(int amount) {
		//write 500 in amount to pay
		withdrawMoney.clear();
		withdrawMoney.sendKeys(""+amount);
		
		//click pay
		payButton.click();
		return message.getText();
		}
	
}
