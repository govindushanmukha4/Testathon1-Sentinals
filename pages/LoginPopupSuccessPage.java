package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPopupSuccessPage {
	// WebDriver instance for interacting with the browser
    WebDriver driver;
    // Locators Section start
    // find the  Login success message in the webpage
    @FindBy(css = "h2.text-center")
    WebElement successMessage;
    
 // Constructor Start
    public LoginPopupSuccessPage(WebDriver driver) {
        this.driver = driver;
        
        // initialisw all the elements for this page
        PageFactory.initElements(driver, this);
    }

      //returns  the login success message after login
    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
