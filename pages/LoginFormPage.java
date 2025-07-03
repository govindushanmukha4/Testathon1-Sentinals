package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFormPage {
   //declare the driver
	private WebDriver driver;
 
	//find by username field
	@FindBy(id = "username")
	WebElement usernameField;

	//find by password field
	@FindBy(id = "password")
	WebElement passwordField;

	//find submit button
	@FindBy(css = "button.svelte-1pdjkmx")
	WebElement submitButton;

	public LoginFormPage(WebDriver driver) {
		//initialize driver
		this.driver = driver;
		//open webpage or current url
		driver.get("https://training-support.net/webelements/login-form");

		//check if we are on the right page
		if (!driver.getTitle().equals("Selenium: Login Form")) {
			//if not throw an error 
			throw new IllegalStateException("This is not the right page. Current page is: " + driver.getCurrentUrl());
		} else {
			//initialize all the elements to this page 
			PageFactory.initElements(driver, this);
		}
	}
   
	//login valid user or correct credentials
	public LoginFormSuccessPage loginUser(String admin, String password) {
		// enter credentials 
		usernameField.sendKeys(admin);
		passwordField.sendKeys(password);
		// click the submit button
		submitButton.click();
		
		// redirect to LoginFormSuccessPage
		return new LoginFormSuccessPage(driver);
	}
	// Interactions End
}
