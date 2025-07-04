package pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class paginationPage {
    WebDriver driver;

    // Constructor initializes the driver, navigates to the page, and constructs elements
    public paginationPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://training-support.net/webelements/pagination");
        PageFactory.initElements(driver, this);
    }

    // Locators using @FindBy
    @FindAll(@FindBy(id = "title"))
    List<WebElement> cardTitles;

    @FindBy(id = "right-arrow")
    WebElement rightArrow;

    // Actions
    public String getPageTitle() {
        return driver.getTitle();
    }
    // Checks visibility of the Charminar card (first card in the list)
    public boolean isCharminarVisible() {
        return cardTitles.get(0).isDisplayed();
    }

    // Navigates forward two pages
    public void clickRightArrowTwice() {
        rightArrow.click();
        rightArrow.click();
    }

    public boolean isGatewayIndiaVisible() {
        return cardTitles.get(1).isDisplayed();
    }
}

 


