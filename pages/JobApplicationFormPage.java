package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class JobApplicationFormPage {
	// Declare the driver
	WebDriver driver;
	File fileUpload;

	// define locators
	@FindBy(id = "name")
	WebElement nameField;
	
	@FindBy(id = "email")
	WebElement emailField;
	
	@FindBy(id = "phone")
	WebElement phoneField;
	
	@FindBy(id = "position")
	WebElement empPositionField;
	Select dropdown;
	
	@FindBy(xpath = "//input[@value='Employed']")
	WebElement currentEmpStatus;
	

    @FindBy(id = "resume")
    WebElement fileUploadButton;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submitButton;

    @FindBy(id = "action-confirmation")
    WebElement confirmationMessage;
    
    
	public JobApplicationFormPage (WebDriver driver) {
		// Initialize webdriver
		this.driver = driver;
		driver.get("https://training-support.net/complex-forms/job-application");
		// Check if we are on the right page
		if (!driver.getTitle().equals("Job Application Form")) {
			throw new IllegalStateException("This is not right page. Current page is: " + driver.getCurrentUrl());
		} else {
			// Initialize all the elements for this page
			PageFactory.initElements(driver, this);
		}
	}
	
	public void fillJobApplication(String name, String email, String phone, String empPosition, String filePath) {
		// enter name
		nameField.sendKeys(name);
		// enter email
		emailField.sendKeys(email);
		// enter phone
		phoneField.sendKeys(phone);
		
		// select Full Stack Developer from dropdown
		dropdown = new Select(empPositionField);
		dropdown.selectByVisibleText(empPosition);
		
		// check Employed emp current status
		currentEmpStatus.click();
		
		// enter the aboslute path
		fileUpload= new File(filePath);

		//Upload the file
		fileUploadButton.sendKeys(fileUpload.getAbsolutePath());
		
		submitButton.click();
	}
	
	// success message
	public String getMessage() {
		return confirmationMessage.getText();
	}
	
}
