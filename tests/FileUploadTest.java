package tests;


import org.openqa.selenium.WebDriver;  // Browser control
import org.openqa.selenium.firefox.FirefoxDriver;  // Firefox implementation
import org.testng.annotations.*;  // TestNG annotations
import pages.FileUploadPage;  // Our Page Object class

import static org.testng.Assert.*;  // Assertion methods for validation

public class FileUploadTest {
    WebDriver driver;  // Manages browser interactions
    FileUploadPage uploadPage;  // Page Object to encapsulate page behavior

    @BeforeClass
    public void setup() {
        // Initialize FirefoxDriver (Selenium 4 autohandles geckodriver)
        driver = new FirefoxDriver();
        driver.manage().window().maximize();  // Maximize window for stable interaction

        // Instantiate page object and navigate to the demo page
        uploadPage = new FileUploadPage(driver);
        uploadPage.goToPage();
    }

    @Test
    public void uploadFileTest() {

        // Perform the upload: provide path relative to project root
        uploadPage.uploadFile("src/test/resources/Selenium_Selenese.docx");
        // Submit the upload action
        uploadPage.submitUpload();

        // Capture and print the success/failure text from the page
        String result = uploadPage.getResultText();

        // Confirm the result indicates a successful upload
        assertTrue(result.toLowerCase().contains("uploaded"), "Expected upload confirmation");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            // Close browser and end session
            driver.quit();
        }
    }
}

