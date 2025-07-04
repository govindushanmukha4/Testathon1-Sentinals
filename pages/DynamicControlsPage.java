package pages;

import org.openqa.selenium.WebDriver;                      // WebDriver for browser automation
import org.openqa.selenium.WebElement;                     // Represents page elements
import org.openqa.selenium.support.FindBy;                // Annotation for locating elements
import org.openqa.selenium.support.PageFactory;           // Initializes @FindBy annotations
import org.openqa.selenium.support.ui.ExpectedConditions; // For explicit waits
import org.openqa.selenium.support.ui.WebDriverWait;      // Supports explicit waits
import java.time.Duration;                                // Used to set wait durations

public class DynamicControlsPage {
    private WebDriver driver;                              // WebDriver instance for browser interactions
    private WebDriverWait wait;                            // Used for explicit waiting on conditions

    // Locate the dynamic checkbox container (if present)
    @FindBy(id = "dynamicCheckbox")
    private WebElement checkboxContainer;

    // Locate the toggle button for adding/removing checkbox
    @FindBy(xpath = "//button[contains(text(),'Remove') or contains(text(),'Add')]")
    private WebElement toggleCheckboxButton;

    // Locate the text input field
    @FindBy(xpath = "//input[@type='text']")
    private WebElement textInputField;

    // Locate the toggle button for enabling/disabling the input
    @FindBy(xpath = "//button[contains(text(),'Enable') or contains(text(),'Disable')]")
    private WebElement toggleInputButton;

    // Constructor: initializes driver, wait, and page elements
    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;                              // Assign the driver passed in
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait up to 10 seconds
        PageFactory.initElements(driver, this);           // Initialize @FindBy annotated fields
    }

    // Navigate browser to the dynamic controls demo page
    public void goToPage() {
        driver.get("https://v1.training-support.net/selenium/dynamic-controls"); // Load the URL
    }

    // Check if the checkbox element exists and is visible
    public boolean isCheckboxPresent() {
        try {
            return checkboxContainer.isDisplayed();      // Returns true if visible
        } catch (Exception e) {
            return false;                                 // Returns false if element isn't present
        }
    }

    // Click the button to remove or add the checkbox
    public void clickToggleCheckbox() {
        toggleCheckboxButton.click();                    // Trigger checkbox toggle
    }

    // Wait until the checkbox disappears from the DOM or is hidden
    public void waitForCheckboxGone() {
        wait.until(ExpectedConditions.invisibilityOf(checkboxContainer)); // Wait until gone
    }

    // Wait until the checkbox shows up and is visible again
    public void waitForCheckboxVisible() {
        wait.until(ExpectedConditions.visibilityOf(checkboxContainer)); // Wait until visible
    }

    // Check if the text input is enabled and editable
    public boolean isInputEnabled() {
        return textInputField.isEnabled();               // Returns true if enabled
    }

    // Click the button to enable or disable the text input
    public void clickToggleInput() {
        toggleInputButton.click();                       // Toggle input state
    }

    // Wait until the input field becomes enabled and clickable
    public void waitForInputEnabled() {
        wait.until(ExpectedConditions.elementToBeClickable(textInputField)); // Wait until it's clickable
    }

    // Clear any existing content and type text into the input field
    public void enterTextInInput(String text) {
        textInputField.clear();                          // Remove current content
        textInputField.sendKeys(text);                   // Enter new text
    }
}
