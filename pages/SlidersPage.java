package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SlidersPage {
    private WebDriver driver;
    private Actions actions;

    // Locate the slider element
    @FindBy(id = "volume")
    private WebElement slider;

    // Locate the displayed volume text
    @FindBy(css = "h1.text-5xl.font-extrabold")
    private WebElement volumeText;

    // Constructor: initialize page factory and Actions  
    public SlidersPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    // Navigate to slider page
    public void open() {
        driver.get("https://training-support.net/webelements/sliders");
    }

    // Get current volume value as integer
    public int getVolume() {
        String text = volumeText.getText().replace("%", "");
        return Integer.parseInt(text);
    }

    // Move slider by a relative offset (with no fine-tuning)
    public void moveSliderByOffset(int xOffset) {
        actions
          .clickAndHold(slider)
          .moveByOffset(xOffset, 0)
          .release()
          .perform();
    }

    // Combined method: move to a percentage using offset then fine-tune by keys
    public void setVolumeTo(int targetPercent) {
        int width = slider.getSize().getWidth();
        int half = width / 2;
        int xOffset = Math.round((targetPercent / 100f) * width) - half;

        moveSliderByOffset(xOffset);

        // Fine-tune using arrow keys until the target is reached
        slider.sendKeys(org.openqa.selenium.Keys.ARROW_LEFT);
        int current = getVolume();
        while (current < targetPercent) {
            slider.sendKeys(org.openqa.selenium.Keys.ARROW_RIGHT);
            current++;
        }
        while (current > targetPercent) {
            slider.sendKeys(org.openqa.selenium.Keys.ARROW_LEFT);
            current--;
        }
    }
}

