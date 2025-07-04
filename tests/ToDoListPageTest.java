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
		String thirdTask = todoPage.getTaskText(3);
		assertEquals(task, thirdTask, "Added task should be in the third position.");
	}

	// Test to verify marking the task as complete
	@Test
	public void testMarkTaskComplete() {
		String task = "Finish Homework";
		todoPage.addTask(task);
		// Mark the task complete and assert it returns true
		assertTrue(todoPage.markTaskComplete(3), "The third task should be marked as complete.");
	}

	// Test to verify retrieving the text of the task
	@Test
	public void testGetTaskText() {
		String task = "Buy Bread";
		todoPage.addTask(task);
		String text = todoPage.getTaskText(3);
		assertEquals(task, text, "Text of third task should match the added task.");
	}

	// Test to verify removing the task from the list
	@Test
	public void testRemoveTask() {
		String task = "Clean Room";
		todoPage.addTask(task);

		// Remove the task
		todoPage.removeTask(3);

		// Verify the task is no longer present (or that the task text changed)
		String updatedTask = todoPage.getTaskText(3);
		assertTrue(!updatedTask.equals(task), "Third task should be removed and no longer be the same task.");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
