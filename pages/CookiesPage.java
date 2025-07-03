package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiesPage {
	
    WebDriver driver;
    
    @FindBy(css = "p.text-xl")
    WebElement primaryMessage;
    
    @FindBy(css = "b.p-1")
    WebElement cookieId;
    
    // Find page heading
    @FindBy(css = "h1.text-5xl.font-bold.text-center.text-black.lg\\:text-6xl.font-display")
    WebElement pageHeading;

    public CookiesPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://training-support.net/webelements/cookies");

        // Check if we are on the correct page
        if (!driver.getTitle().equals("Selenium: Cookies")) {
            throw new IllegalStateException("This is not the Cookies page. Current page: " + driver.getCurrentUrl());
        }

        // Initialize page elements
        PageFactory.initElements(driver, this);
    }

    // To get the page heading
    public String getPageHeading() {
        return pageHeading.getText();
    }

    // Find and return the first message(before refresh)
    public String getPrimaryMessage() {
    	return primaryMessage.getText();
    }

    // Refresh the page
    public void refreshPage() {
        driver.navigate().refresh();
    }
    
    // Find and return the cookieId
    public String getCookieId() {
    	return cookieId.getText();
    }

}

