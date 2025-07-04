package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class SlidersPageTest {
    private WebDriver driver;
    private Actions actions;
    // Locators for slider and the displayed volume percentage
    private By sliderLocator = By.id("volume");
    private By volumeValueLocator = By.cssSelector("h1.text-5xl.font-extrabold");

    @BeforeClass
    public void setup() {
    	 // Initialize Firefox and Actions builder
        driver = new FirefoxDriver();
        actions = new Actions(driver);
     // Navigate to the slider demo page
        driver.get("https://training-support.net/webelements/sliders");
    }

    @AfterClass
    public void teardown() {
    	// Clean up and close browser after all tests
        driver.quit();
    }

    private int getVolume() {
        String t = driver.findElement(volumeValueLocator).getText().replace("%", "");
        return Integer.parseInt(t);
    }

    private void setSliderTo(int targetPercent) {
        WebElement slider = driver.findElement(sliderLocator);
        // Compute horizontal offset: from center towards target percentage

        int width = slider.getSize().getWidth();
        int half = width / 2;
        int xOffset = Math.round((targetPercent / 100f) * width) - half;
        // Drag slider with mouse movement
        actions.clickAndHold(slider)
               .moveByOffset(xOffset, 0)
               .release()
               .perform();

        // Fine‑tune with arrow keys :contentReference[oaicite:1]{index=1}
        WebElement handle = driver.findElement(sliderLocator);
        handle.sendKeys(Keys.ARROW_LEFT); // ensure focus
        // Fine-adjust until we hit the exact percentage
        int current = getVolume();
        while (current < targetPercent) {
            handle.sendKeys(Keys.ARROW_RIGHT);
            current++;
        }
        while (current > targetPercent) {
            handle.sendKeys(Keys.ARROW_LEFT);
            current--;
        }
    }
    // move slider to 50%
    @Test(priority = 1)
    public void initialVolumeShouldBe50() {
        Assert.assertEquals(getVolume(), 50, "Initial volume not 50%");
    }
    // move slider to 25%
    @Test(priority = 2)
    public void setVolumeTo25Percent() {
        setSliderTo(25);
        Assert.assertEquals(getVolume(), 25, "Failed to set volume to 25%");
    }
    
    // move slider to 75%
    @Test(priority = 3)
    public void setVolumeTo75Percent() {
        setSliderTo(75);
        Assert.assertEquals(getVolume(), 75, "Failed to set volume to 75%");
    }
}





