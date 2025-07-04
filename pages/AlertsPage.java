package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AlertsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Buttons on the page
    @FindBy(id = "simple")
    private WebElement simpleAlertButton;

    @FindBy(id = "confirmation")
    private WebElement confirmAlertButton;

    @FindBy(id = "prompt")
    private WebElement promptAlertButton;

    // Result text after interacting with alerts
    @FindBy(id = "result")
    private WebElement resultText;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /** Navigate to the Alerts demo page */
    public void goToPage() {
        driver.get("https://training-support.net/webelements/alerts");
    }

    /** Click to trigger a simple alert */
    public void clickSimpleAlert() {
        simpleAlertButton.click();
    }

    /** Click to trigger a confirmation alert */
    public void clickConfirmAlert() {
        confirmAlertButton.click();
    }

    /** Click to trigger a prompt alert */
    public void clickPromptAlert() {
        promptAlertButton.click();
    }

    /** Wait for alert, and return its text */
    public String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    /** Accept (OK) the alert */
    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    /** Dismiss (Cancel) the alert */
    public void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    /** Send text into prompt alert and accept */
    public void sendTextToPrompt(String text) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
    }

    /** Read the page result text after handling alert */
    public String getResultText() {
        return wait.until(ExpectedConditions.visibilityOf(resultText)).getText();
    }
}



