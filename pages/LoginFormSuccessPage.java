package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFormSuccessPage {
     // Declare the driver
	 WebDriver driver;
 
	 //find the heading of the LoginFormSuccess Page
	    @FindBy(tagName = "h1")
	    WebElement pageHeading;

	    public LoginFormSuccessPage(WebDriver driver) {
	    	//initialize webdriver
	        this.driver = driver;

	        // Initialize only after page change- initilaize all the elements for this page 
	        PageFactory.initElements(driver, this);
	    }

	    //read the heading of the LoginFormSuccessPage
	    public String readPageHeading() {
	        return pageHeading.getText();
	    }

}
