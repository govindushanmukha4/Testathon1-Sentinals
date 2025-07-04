package tests; 


import org.openqa.selenium.By;              // For locating elements (e.g., input field)
import org.openqa.selenium.WebDriver;        // Core WebDriver interface
import org.openqa.selenium.firefox.FirefoxDriver;  // Firefox browser driver
import org.testng.annotations.*;            // TestNG annotations: @BeforeClass, @Test, @AfterClass

import pages.DynamicControlsPage;           // Page Object encapsulating page interactions

import static org.testng.Assert.*;          // Static import of assertion methods

public class DynamicControlsPageTest {
    WebDriver driver;                        // WebDriver instance for browser automation
    DynamicControlsPage page;                // Our Page Object model instance

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();        // Launch a new instance of Firefox browser
        driver.manage().window().maximize(); // Maximize window for consistent layout
        page = new DynamicControlsPage(driver);  // Create Page Object with driver
        page.goToPage();                      // Navigate to the dynamic controls demo page
    }

    @Test
    public void checkboxToggleTest() {
        // Assert checkbox is initially visible
        assertTrue(page.isCheckboxPresent(), "Checkbox should be visible initially");

        page.clickToggleCheckbox();           // Click the Remove/Add toggle button
        page.waitForCheckboxGone();           // Wait until checkbox is removed from the page
        assertFalse(page.isCheckboxPresent(), "Checkbox should be removed");  // Confirm removal

        page.clickToggleCheckbox();           // Click the button again to add checkbox back
        page.waitForCheckboxVisible();        // Wait until checkbox reappears
        assertTrue(page.isCheckboxPresent(), "Checkbox should reappear");  // Confirm presence
    }

    @Test
    public void enableInputAndEnterTextTest() {
        // Assert input field is disabled on initial load
        assertFalse(page.isInputEnabled(), "Input should start disabled");

        page.clickToggleInput();              // Click Enable/Disable toggle for the input box
        page.waitForInputEnabled();           // Wait until the input becomes enabled
        assertTrue(page.isInputEnabled(), "Input should now be enabled");  // Confirm it's enabled

        page.enterTextInInput("Hello Selenium!");  // Type text into the enabled input box

        // Confirm that the input value matches the text entered
        assertEquals(driver.findElement(By.xpath("//input[@type='text']"))
                         .getAttribute("value"),
                     "Hello Selenium!",
                     "Text input should match what was typed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();                    // Close the browser and end WebDriver session
        }
    }
}
