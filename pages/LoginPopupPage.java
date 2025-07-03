package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPopupPage {
 // declare driver
    WebDriver driver;
   // find button for popup
    @FindBy(id = "launcher")
    WebElement launcherButton;
     
    //find username field 
    @FindBy(id = "username")
    public WebElement usernameField;

    //find password field 
    @FindBy(id = "password")
    public WebElement passwordField;

    //find submit button
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButton;

    public LoginPopupPage(WebDriver driver) {
    	//initializs driver
        this.driver = driver;
        //open the web page 
        driver.get("https://training-support.net/webelements/popups");

        // check if we're on the correct web page or not
        if (!driver.getTitle().contains("Popups")) {
        	// if not throw an error
            throw new IllegalStateException("Not on Popups page. Current URL: " + driver.getCurrentUrl());
        }

           //initialize all the elements for this page 
        PageFactory.initElements(driver, this);
    }
 
     //click the launcher button to open login popup 
    public void openLoginPopup() {
        launcherButton.click();
    }

    public LoginPopupSuccessPage login(String username, String password) {
    	// enter credentials or passs the credentials 
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
        //redirect to the LoginPopupSuccessPage
        return new LoginPopupSuccessPage(driver);
    }
}
