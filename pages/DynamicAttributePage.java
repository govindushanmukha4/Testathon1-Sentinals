package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicAttributePage {
    WebDriver driver;
    WebDriverWait wait;

    // Web elements with dynamic attributes
    @FindBy(xpath = "//input[starts-with(@id, 'full-name-')]")
    WebElement fullNameInput;

    @FindBy(xpath = "//input[contains(@id, '-email')]")
    WebElement emailInput;

    @FindBy(xpath = "//input[contains(@name, '-event-date-')]")
    WebElement eventDateInput;

    @FindBy(xpath = "//textarea[contains(@id, '-additional-details-')]")
    WebElement detailsTextarea;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButton;

    @FindBy(id = "action-confirmation")
    WebElement confirmationMessage;

    public DynamicAttributePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://training-support.net/webelements/dynamic-attributes");

        // Wait for the correct title before doing anything else
        wait.until(ExpectedConditions.titleIs("Dynamic Attributes"));

        // Initialize web elements only after the page is loaded
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String fillForm(String name, String email, String date, String notes) {
        fullNameInput.sendKeys(name);
        emailInput.sendKeys(email);
        eventDateInput.sendKeys(date);
        detailsTextarea.sendKeys(notes);
        submitButton.click();

        return wait.until(ExpectedConditions.visibilityOf(confirmationMessage)).getText();
    }
}
