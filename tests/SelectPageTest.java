package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SelectPage;

public class SelectPageTest {
	WebDriver driver;
    SelectPage page;
    // This method runs once before all tests
    @BeforeClass
    public void setUp() {
    	// Start Firefox browser
        driver = new FirefoxDriver();
        // Open the Selects page using the Page Object class
        page = new SelectPage(driver);
    }
     // This is the test method where we do all dropdown actions
    @Test(priority = 1)
    public void selectDropdownTest() {
        // Select "One" from the single dropdown and check if it's selected
        page.selectSingleByVisibleText("One");
        assertEquals(page.getSelectedSingleOption(), "One");
        // Select second option (index 2) and check
        page.selectSingleByIndex(2);
        assertEquals(page.getSelectedSingleOption(), "Two");
        // Select option by its value "three" and check
        page.selectSingleByValue("three");
        assertEquals(page.getSelectedSingleOption(), "Three");
        page.selectMultipleOptions();
        // Deselect one option by index from the multi-select dropdown
        page.deselectMultipleOptionByIndex(4);
    }
    // Test to verify whether the dropdowns support multiple selection modes
    @Test(priority = 2)
    public void testDropdownModes() {
        assertFalse(page.singleSelectIsMultiple(), "Single dropdown should not allow multiple selections");
        assertTrue(page.multiSelectIsMultiple(), "Multi dropdown should allow multiple selections");
    }

    //Test all expected options are present
    @Test(priority = 3)
    public void testSingleOptionsList() {
    	List<String> expected = Arrays.asList("Select an Option", "One", "Two", "Three", "Four", "Five", "Six");
        List<String> actual = page.getAllSingleOptions();
        assertEquals(actual, expected);
    }
 
    // Deselect all test
    @Test(priority = 4)
    public void testMultiSelectDeselectAll() {
        page.selectMultipleOptions();
        page.multiSelectDeselectAll();
        assertTrue(page.getAllMultiSelectedOptions().isEmpty(), "All options should be deselected");
    }

   
    // This method runs after all tests are done
    @AfterClass
    public void tearDown() {
        try {
        	// Close the browser
            driver.quit();
        } catch (Exception e) {
        	// If there's an error while closing, print it
        	Reporter.log(e.getMessage(), true);
        }
    }


}
