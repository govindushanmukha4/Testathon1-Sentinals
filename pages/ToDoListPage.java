package pages;
import java.time.Duration;


import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

//Page Object Model class for the To-Do List web page
public class ToDoListPage {
	WebDriver driver;
    WebDriverWait wait;
    // Locate the input field for entering a new task
    @FindBy(id = "todo-input")
    WebElement todoInput;
    // Locate the 'Add' button
    @FindBy(css = "svg.h-6.w-6")
    WebElement addButton;
    // Constructor initializes WebDriver, WebDriverWait, opens the page, and sets up PageFactory
    public ToDoListPage(WebDriver driver) {
        this.driver = driver;
        // Set wait timeout to 10 seconds
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Navigate to the To-Do List web application
        driver.get("https://training-support.net/webelements/todo-list");
        // Initialize WebElements annotated with @FindBy
        PageFactory.initElements(driver, this);
    }
    // Method to add a new task to the to-do list
    public void addTask(String task) {
    	// Type the task into the input field
        todoInput.sendKeys(task);
        // Click the add button to submit the task
        addButton.click();
    }
    // Method to mark the task in the list as complete (by clicking its checkbox)
    public boolean markTaskComplete(int taskNumber) {
        // XPath to locate the checkbox of the item
        By checkboxBy = By.xpath("//ul[contains(@class, 'mt-5')]/li[" + taskNumber + "]//input[@type='checkbox']");
        
        // Wait until the checkbox is clickable, then click it
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxBy));
        checkbox.click();

        // Return whether the checkbox is now selected (marked complete)
        return checkbox.isSelected();
    }
    // Method to get the text of the task in the list
    public String getTaskText(int taskNumber) 
    {
    	// XPath to locate the text task
        By taskText = By.xpath("//ul[contains(@class, 'mt-5')]/li["+ taskNumber +"]//h3");
        // Wait for visibility of the element and return its text
        return wait.until(ExpectedConditions.visibilityOfElementLocated(taskText)).getText();
    }
    // Method to remove task from the list
    public void removeTask(int taskNumber) {
    	// XPath to locate the delete button for the task
        By removeButton = By.xpath("//ul[contains(@class, 'mt-5')]/li[" + taskNumber + "]//button");
        // Wait until the button is clickable, then click to remove the task
        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
    }


}
