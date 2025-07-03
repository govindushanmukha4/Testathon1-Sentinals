package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormSuccessPage {

	//declare driver
    WebDriver driver;

    //find the heading of the success page 
   @FindBy(tagName = "h1")
    WebElement pageHeading;

   // find  conformation message by id 
    @FindBy(id = "action-confirmation")
    WebElement confirmationMessage;

    public SimpleFormSuccessPage(WebDriver driver) {
    	//initialize driver
        this.driver = driver;
     // check if we're in the correct page or not 
        if (!driver.getTitle().contains("Dynamic Attributes")) {
            throw new IllegalStateException("This is not the right page. Current page is: " + driver.getCurrentUrl());
        } else {
        	// initialize all the elements for this page
        PageFactory.initElements(driver, this);
    }
    }
    
    //returns the heading of the page 
    public String readPageHeading() {
        return pageHeading.getText();
    }
    
    // * @return The text of the confirmation message.
       public String readConfirmationMessage() {
        return confirmationMessage.getText();
    }
}
