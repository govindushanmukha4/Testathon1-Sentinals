package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TablesPage {
    WebDriver driver;
    // Locator to get all rows in the table body 
    private By tableRows = By.xpath("//table/tbody/tr");
    // Locator to get all columns in the first row (i.e., number of columns)
    private By tableCols = By.xpath("//table/tbody/tr[1]/td");
    // Locator for the "Price" column header—used to trigger sorting
    private By priceHeader = By.xpath("//table/thead/tr/th[5]");

    public TablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public int getRowCount() {
        return driver.findElements(tableRows).size();
    }

    public int getColumnCount() {
        return driver.findElements(tableCols).size();
    }

    public String getBookNameInRow(int rowNumber) {
    	 // XPath dynamically constructs the path based on rowNumber
        return driver.findElement(By.xpath("//table/tbody/tr[" + rowNumber + "]/td[2]")).getText();
    }

    public void sortByPrice() {
        driver.findElement(priceHeader).click();
    }
}




