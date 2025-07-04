package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TargetPracticePage {
	WebDriver driver;
	// Locate the orange <h3> heading using partial class name match
    @FindBy(xpath = "//h3[contains(@class,'text-orange-600')]")
    WebElement orangeHeading;
    // Locate the purple <h5> heading using partial class name match
    @FindBy(xpath = "//h5[contains(@class,'text-purple-600')]")
    WebElement purpleHeading;
    // Locate an element with exact class "text-purple-800"
    @FindBy(className = "text-purple-800")
    WebElement purpleClassElement;
    // Locate an element with exact class "text-slate-900"
    @FindBy(className = "text-slate-900")
    WebElement slateClassElement;
    // Constructor to initialize the WebDriver, open the page, and bind elements
    public TargetPracticePage(WebDriver driver) {
        this.driver = driver;
        // Navigate to the Target Practice test page
        driver.get("https://training-support.net/webelements/target-practice");
        // Initialize WebElements using PageFactory
        PageFactory.initElements(driver, this);
    }
    // Returns the title of the current page
    public String getPageTitle() {
        return driver.getTitle();
    }
    // Returns the text content of the orange heading element
    public String getOrangeHeadingText() {
        return orangeHeading.getText();
    }
    // Returns the computed CSS color value of the purple heading
    public String getPurpleHeadingColor() {
        return purpleHeading.getCssValue("color");
    }
    // Returns the 'class' attribute value of the purple class element
    public String getPurpleClassAttribute() {
        return purpleClassElement.getDomAttribute("class");
    }

    public String getSlateClassAttribute() {
        return slateClassElement.getDomAttribute("class");
    }
	

}
