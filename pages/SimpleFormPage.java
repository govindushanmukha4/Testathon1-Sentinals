package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormPage {
        //declare driver
    private WebDriver driver;
   // find the full name field
    @FindBy(xpath = "//input[starts-with(@id,'full-name-')]")
    WebElement nameField;
     // find the email field
    @FindBy(xpath = "//input[contains(@id,'-email')]")
    WebElement emailField;
  // find the event date field 
    @FindBy(xpath = "//input[contains(@name,'-event-date-')]")
    WebElement dateField;
 // find the additional detials 
    @FindBy(xpath = "//textarea[contains(@id,'-additional-details-')]")
    WebElement detailsField;
   // find the submit buttomn
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButton;

    
    
    public SimpleFormPage(WebDriver driver) {
    	//initialise the driver
        this.driver = driver;
        //open the page 
        driver.get("https://training-support.net/webelements/dynamic-attributes");
// check if we're in the correct page or not 
        if (!driver.getTitle().contains("Dynamic Attributes")) {
            throw new IllegalStateException("This is not the right page. Current page is: " + driver.getCurrentUrl());
        } else {
        	// initialize all the elements for this page 
            PageFactory.initElements(driver, this);
        }
    }
  // login valid user 
    public SimpleFormSuccessPage fillAndSubmitForm(String name, String email, String date, String details) {
    	// enter credentials or pass the credentials 
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        dateField.sendKeys(date);
        detailsField.sendKeys(details);
        submitButton.click();
        //redirect to the SimpleFormSuccess page 
        return new SimpleFormSuccessPage(driver);
    }
}
