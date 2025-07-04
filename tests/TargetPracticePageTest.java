package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import pages.TargetPracticePage;


public class TargetPracticePageTest {
	WebDriver driver;
    TargetPracticePage page;

    // Set up WebDriver and navigate to the page
    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        page = new TargetPracticePage(driver);
    }

    // Test to verify the page title
    @Test(priority = 1)
    public void testPageTitle() {
        String title = page.getPageTitle();
        assertEquals(title, "Selenium: Target Practice", "Incorrect page title");
    }

    // Test to check the orange heading text
    @Test(priority = 2)
    public void testOrangeHeadingText() {
        String orangeText = page.getOrangeHeadingText();
        assertEquals(orangeText, "Heading #3", "Incorrect orange heading text");
    }

    // Test to get the CSS color of the purple heading
    @Test(priority = 3)
    public void testPurpleHeadingColor() {
        String color = page.getPurpleHeadingColor();
        assertNotNull(color, "Color value should not be null");
    }

    // Test to get class attribute of element with class "text-purple-800"
    @Test(priority = 4)
    public void testPurpleClassAttribute() {
        String purpleClass = page.getPurpleClassAttribute();
        assertEquals(purpleClass, "ml-5 w-10 h-10 text-purple-800", "Incorrect class value for purple element");
    }

    // Test to get class attribute of element with class "text-slate-900"
    @Test(priority = 5)
    public void testSlateClassAttribute() {
        String slateClass = page.getSlateClassAttribute();
        assertEquals(slateClass, "rounded-xl bg-slate-200 p-2 text-3xl font-bold text-slate-900 svelte-2hb4ib", "Incorrect class value for slate element");
    }

    // Tear down the WebDriver after all tests
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
}
