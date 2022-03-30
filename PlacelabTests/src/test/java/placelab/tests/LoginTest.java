package placelab.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import placelab.utilities.WebDriverSetup;

public class LoginTest {
    public WebDriver driver;
    private String host = System.getProperty("host");

    //Specify the driver and browser that will be used for this scenario

    @Parameters({"browser"})
    @BeforeSuite(alwaysRun = true)
    public void openBrowser(String browser) {

        driver = WebDriverSetup.getWebDriver(browser);
    }

//    public void initDriver() {
//
//        driver = WebDriverSetup.getWebDriver("chrome");
//    }

    //Actual test case implementation

    @Test
    public void testLoginPage() {

        //Go to PlaceLab demo app
        driver.navigate().to(host);

        //Validate that user is redirected to the right page
        Assert.assertEquals(driver.getCurrentUrl(), host);
        Assert.assertEquals(driver.getTitle(), "PlaceLab");

    }

    //Clean up - close the browser

    @AfterSuite
    public void quitDriver() {
        driver.close();
    }
}