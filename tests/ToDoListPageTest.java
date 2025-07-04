package tests;
import org.testng.annotations.Test;
import pages.ToDoListPage;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
public class ToDoListPageTest {
	WebDriver driver;
	ToDoListPage todoPage;
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		todoPage = new ToDoListPage(driver);
	}
	// Test to verify adding a new task to the To-Do list
	@Test
	public void testAddTask() {
		String task = "Buy Bread";
		todoPage.addTask(task);
		String thirdTask = todoPage.getThirdTaskText();
		assertEquals(task, thirdTask, "Added task should be in the third position.");
	}
	// Test to verify marking the third task as complete
	@Test
	public void testMarkTaskComplete() {
		String task = "Finish Homework";
		todoPage.addTask(task);
		// Mark the third task complete and assert it returns true
		assertTrue(todoPage.markThirdTaskComplete(), "The third task should be marked as complete.");
	}
	// Test to verify retrieving the text of the third task
	@Test
	public void testGetThirdTaskText() {
		String task = "Buy Bread";
		todoPage.addTask(task);
		String text = todoPage.getThirdTaskText();
		assertEquals(task, text, "Text of third task should match the added task.");
	}
	// Test to verify removing the third task from the list
	@Test
	public void testRemoveThirdTask() {
		String task = "Clean Room";
		todoPage.addTask(task);
		// Remove the third task
		todoPage.removeThirdTask();
		// Verify the third task is no longer present (or that the task text changed)
		String newThirdTaskText = todoPage.getThirdTaskText();
		assertTrue(!newThirdTaskText.equals(task), "Third task should be removed and no longer be the same task.");
	}
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
