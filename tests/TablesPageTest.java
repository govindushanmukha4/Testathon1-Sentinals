package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.TablesPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TablesPageTest {
    WebDriver driver;
    TablesPage tablePage;

    @BeforeClass
    public void setup() {
    	 // Initialize the Firefox browser instance
        driver = new FirefoxDriver();
        // Navigate directly to the target page under test
        driver.get("https://training-support.net/webelements/tables");
     // Instantiate the page object for interacting with the tables
        tablePage = new TablesPage(driver);
    }

    @Test(priority = 1)
    public void testTablePageTitle() {
        // Retrieve page title via page object, then validate it's correct
        String title = tablePage.getTitle();
        assertEquals(title, "Selenium: Tables", "Title does not match");
    }

    @Test(priority = 2)
    public void testTableStructure() {
    	// Use page object to query number of rows and columns in table
        int rowCount = tablePage.getRowCount();
        int colCount = tablePage.getColumnCount();
        
     // Assert the table has exactly 9 rows and 5 columns
        assertEquals(rowCount, 9, "Unexpected row count");
        assertEquals(colCount, 5, "Unexpected column count");
    }

    @Test(priority = 3)
    public void testBookNameBeforeAndAfterSorting() {
    	 // Capture the name of the book in the 5th row before sort
        String beforeSort = tablePage.getBookNameInRow(5);
        
     // Trigger sorting by price using page object method
        tablePage.sortByPrice();
        
        // Capture the name of the book in the same row after sorting
        String afterSort = tablePage.getBookNameInRow(5);
        
        // Ensure the book has changed, validating the sort action executed correctly
        assertNotEquals(beforeSort, afterSort, "Book name did not change after sorting");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}






