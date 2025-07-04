package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;
public class SelectPage {
	WebDriver driver;
	// This finds the first (single) dropdown on the page
    @FindBy(css = "select.h-10")
    WebElement singleSelectDropdown;
    // This finds the second (multi-select) dropdown on the page
    @FindBy(css = "select.h-80")
    WebElement multiSelectDropdown;
    // These are used to interact with the dropdowns
    Select singleSelect;
    Select multiSelect;
    // Constructor - runs when the object is created
    public SelectPage(WebDriver driver) {
        this.driver = driver;
        // Open the webpage
        driver.get("https://training-support.net/webelements/selects");
        // Initialize the elements using PageFactory
        PageFactory.initElements(driver, this);
        // Create Select objects for both dropdowns
        singleSelect = new Select(singleSelectDropdown);
        multiSelect = new Select(multiSelectDropdown);
    }
    
    // Select an option in the single dropdown by visible text 
    public void selectSingleByVisibleText(String text) {
        singleSelect.selectByVisibleText(text);
    }
    // Select an option by its position
    public void selectSingleByIndex(int index) {
        singleSelect.selectByIndex(index);
    }
    // Select an option by its value
    public void selectSingleByValue(String value) {
        singleSelect.selectByValue(value);
    }
   // Get the currently selected option text from single dropdown
    public String getSelectedSingleOption() {
        return singleSelect.getFirstSelectedOption().getText();
    }
    // Get all the options from the single dropdown
    public List<String> getAllSingleOptions() {
        List<String> texts = new ArrayList<>();
        for (WebElement option : singleSelect.getOptions()) {
            texts.add(option.getText());
        }
        return texts;
    }
    // Select multiple items from the multi-select dropdown
    public void selectMultipleOptions() {
    	multiSelect.selectByVisibleText("HTML");
        multiSelect.selectByVisibleText("CSS");         
        multiSelect.selectByVisibleText("JavaScript");   
        multiSelect.selectByVisibleText("Node");
       
    }
    
    // Deselect one of the selected options by index
    public void deselectMultipleOptionByIndex(int index) {
        multiSelect.deselectByIndex(index);
    }
    // Check if the single-select dropdown supports multiple selections
    public boolean singleSelectIsMultiple() {
        return singleSelect.isMultiple();
    }
    // Check if the multi-select dropdown supports multiple selections
    public boolean multiSelectIsMultiple() {
        return multiSelect.isMultiple();
    }
    // Deselect all selected options in the multi-select dropdown
    public void multiSelectDeselectAll() {
        multiSelect.deselectAll();
    }
    // Deselect an option from the multi-select dropdown using its value
    public void multiSelectDeselectByValue(String value) {
        multiSelect.deselectByValue(value);
    }
    // Get the visible texts of all selected options in the multi-select dropdown
    public List<String> getAllMultiSelectedOptions() {
        List<String> selectedTexts = new ArrayList<>();
        for (WebElement option : multiSelect.getAllSelectedOptions()) {
            selectedTexts.add(option.getText());
        }
        return selectedTexts;
    }

}
