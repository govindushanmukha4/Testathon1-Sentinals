package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CateringServicePage {
	// Declare the driver
	WebDriver driver;

	// finding locators
	@FindBy(id = "name")
	WebElement nameField;

	@FindBy(id = "phone")
	WebElement phoneField;

	@FindBy(id = "address")
	WebElement addressField;

	@FindBy(id = "catering-type")
	WebElement cateringEventDropdown;
	Select dropdown;

	Actions builder;
	@FindBy(id = "num_guests")
	WebElement guestCountSlider;

	@FindBy(xpath = "//*[@id=\"bookingForm\"]/div[2]/label[1]/span")
	WebElement vegetarian;

	@FindBy(xpath = "//*[@id=\"bookingForm\"]/div[2]/label[2]/span")
	WebElement nonVegetarian;

	@FindBy(xpath = "//*[@id=\"bookingForm\"]/div[2]/label[3]/span")
	WebElement GlutenFree;

	@FindBy(xpath = "//*[@id=\"bookingForm\"]/div[2]/label[4]/span")
	WebElement DairyFree;

	@FindBy(id = "event-date")
	WebElement eventDate;

	@FindBy(id = "event-time")
	WebElement eventTime;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submitButton;

	@FindBy(id = "action-confirmation")
	WebElement confirmationMessage;

	public CateringServicePage(WebDriver driver) {
		// Initialize webdriver
		this.driver = driver;
		driver.get("https://training-support.net/complex-forms/catering");
		// Check if we are on the right page
		if (!driver.getTitle().equals("Catering Service")) {
			throw new IllegalStateException("This is not right page. Current page is: " + driver.getCurrentUrl());
		} else {
			// Initialize all the elements for this page
			PageFactory.initElements(driver, this);
		}
	}

	// Fill the form
	public void fillJobApplication(String name, String phone, String address, String eventType, String date,
			String time) {
		// enter name
		nameField.sendKeys(name);
		// enter phone number
		phoneField.sendKeys(phone);
		// enter address
		addressField.sendKeys(address);

		// select eventType = "BBQ" from dropdown
		dropdown = new Select(cateringEventDropdown);
		dropdown.selectByVisibleText(eventType);

		// need to move slider right by 227.63
		builder = new Actions(driver);
		guestCountSlider = driver.findElement(By.id("num-guests"));
		builder.moveToElement(guestCountSlider).clickAndHold(guestCountSlider).moveByOffset(2, 0).release().build()
				.perform();

		// selecting checkbox
		vegetarian.click();
		nonVegetarian.click();
		DairyFree.click();

		// enter date
		eventDate.sendKeys(date);
		// enter time
		eventTime.sendKeys(time);

		// click submit button
		submitButton.click();
	}

	// form submittion successful message
	public String getMessage() {
		return confirmationMessage.getText();
	}

}
