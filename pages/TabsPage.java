package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabsPage {
	WebDriver driver;
    WebDriverWait wait;
    // Finds the "Open A New Tab" button
    @FindBy(xpath = "//button[text()='Open A New Tab']")
    WebElement openNewTabBtn;
    // Finds the "Open Another One" button 
    @FindBy(xpath = "//button[text()='Open Another One']")
    WebElement openAnotherOneBtn;
    // Finds the bold heading text on the newly opened tab
    @FindBy(css = "span.font-bold")
    WebElement headingText;
    // Constructor to initialize WebDriver, wait, and elements using PageFactory
    public TabsPage(WebDriver driver) {
        this.driver = driver;
        // Set up a wait with 20 seconds timeout
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Initialize all @FindBy elements
        PageFactory.initElements(driver, this);
    }
    // Get and return the title of the current page
    public String getPageTitle() {
        return driver.getTitle();
    }
    // This method switches to the most recently opened browser tab
    private void switchToNewestWindow() {
    	// Get all window handles
        Set<String> handles = driver.getWindowHandles();
        String latestHandle = "";
        // The last handle in the loop is the latest tab
        for (String handle : handles) {
            latestHandle = handle;
        }
        // Switch to the newest tab
        driver.switchTo().window(latestHandle);
    }
    // Keep opening new tabs until we find one with heading "release"
    public String openTabsUntilRelease() {
    	// Click the first button to open the initial new tab
        openNewTabBtn.click();
        // Wait until 2 tabs are open 
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        switchToNewestWindow();
        // Get the heading text on the new tab
        String text = headingText.getText();
        // Start with 2 windows
        int expectedWindowCount = 2;
        // Loop until we find a tab where the heading text is "release"
        while (!text.equalsIgnoreCase("release")) {
        	// Click the button to open another new tab
        	openAnotherOneBtn.click();
        	// Increase expected window count
        	expectedWindowCount++;
        	// Wait for the new tab to appear
            wait.until(ExpectedConditions.numberOfWindowsToBe(expectedWindowCount));
            // Switch to the latest opened tab
            switchToNewestWindow();
            // Read the heading text from the current tab
            text = headingText.getText();   

    }
        // Return the heading text after finding the "release" tab
        return text;
    }
    
    

}
