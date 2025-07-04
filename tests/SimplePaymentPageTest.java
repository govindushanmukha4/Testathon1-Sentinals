package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SimplePaymentPage;

public class SimplePaymentPageTest {
	// Declare driver
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize the Firefox driver
        driver = new FirefoxDriver();
    }
    
    // Home Page
    @Test
    public void payment() {
        // Create object for simplePaymentPage
    	SimplePaymentPage simplePaymentPage = new SimplePaymentPage(driver);
    	
        // Verify redirect
    	assertEquals(simplePaymentPage.makePayment1(500), "Your payment is successful. Now your account balance is 500");
    	
    	// verify redirect
    	// assertEquals(simplePaymentPage.makePayment1(500), "Your payment is successful. Now your account balance is 0");
    }
    
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}