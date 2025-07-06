package pages;

import java.io.File;                                      

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;                    
import org.openqa.selenium.WebElement;                   
import org.openqa.selenium.support.FindBy;            
import org.openqa.selenium.support.PageFactory;         
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.WebDriverWait;   
import java.time.Duration;                              
public class FileUploadPage {
    private WebDriver driver;                           
    private WebDriverWait wait;                          

    // Locate the file input element for uploads
    @FindBy(id = "file")
    private WebElement fileInput;

    // Locate the button to submit the file upload
    @FindBy(css = "button.svelte-m6d1rg")
    private WebElement uploadButton;

    // Constructor: initializes driver, wait, and page elements
    public FileUploadPage(WebDriver driver) {
        this.driver = driver;                            // Assign WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10‑second explicit wait
        PageFactory.initElements(driver, this);         // Populate annotated WebElements
    }

    // Navigate to the file upload demo page
    public void goToPage() {
        driver.get("https://training-support.net/webelements/file-upload"); // Load URL
    }

    // Get the current page title
    public String getTitle() {
        return driver.getTitle();                       // Retrieve page title
    }

    // Upload a file using a relative path
    public void uploadFile(String relativePath) {
        File file = new File(relativePath);             // Build File object from path
        fileInput.sendKeys(file.getAbsolutePath());     // Send absolute path to file input
    }

    // Click the upload button to submit the file
    public void submitUpload() {
        uploadButton.click();                           // Trigger upload action
    }

    // Wait for result message to appear, then return its text
    public String getResultText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result"))); // Wait for result
        return driver.findElement(By.id("result")).getText(); // Return the visible text
    }
}


