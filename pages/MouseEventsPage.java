package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class MouseEventsPage {
	WebDriver driver;
	Actions builder;

	// Constructor to initialize browser and elements
	public MouseEventsPage(WebDriver driver) {
		this.driver = driver;
		this.builder = new Actions(driver);
		driver.get("https://training-support.net/webelements/mouse-events");

		if (!driver.getTitle().contains("Mouse Events")) {
			throw new IllegalStateException("Not on Mouse Events page. Current: " + driver.getCurrentUrl());
		}
		else {
			// Initialize the WebElements declared with @FindBy annotations
			PageFactory.initElements(driver, this);
		}
	}

	// Get the title of the page
	public String getTitle() {
		return driver.getTitle();
	}

	// Perform click on Cargo.lock and Cargo.toml
	public void clickCargoFiles() {
		WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
		WebElement cargoToml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
		builder.click(cargoLock).pause(500).click(cargoToml).build().perform();
	}

	// Get confirmation message text
	public String getResultText() {
		return driver.findElement(By.id("result")).getText();
	}

	// Double click src and right-click target
	public void performClickActions() {
		WebElement src = driver.findElement(By.xpath("//h1[text()='src']"));
		WebElement target = driver.findElement(By.xpath("//h1[text()='target']"));
		builder.doubleClick(src).pause(500).contextClick(target).build().perform();
	}

	// Click the "Open" option from the context menu
	public void openTarget() {
		WebElement openOption = driver.findElement(By.cssSelector("span.ml-3"));
		builder.click(openOption).build().perform();
	}

	// Close browser
	public void close() {
		driver.quit();
	}
}