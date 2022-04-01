package placelab.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import placelab.pages.HomePage;
import placelab.pages.Login;
import placelab.utilities.WebDriverSetup;

public class SmokeTest {
    public WebDriver driver;
    private SoftAssert softAssert = new SoftAssert();
    public String host = System.getProperty("host");
    public String user = System.getProperty("user");
    private String username = System.getProperty("username");
    private String password = System.getProperty("password");
    private String homePageURL = System.getProperty("homepage");
    private Login login;
    private HomePage homePage;

    @Parameters({"browser"})

//    @BeforeSuite(alwaysRun = true)
//    public void initDriver(String browser) {
//       driver = WebDriverSetup.getWebDriver(browser);
//        login = new Login(driver);
//        homePage = new HomePage(driver);
//    }



    @BeforeTest(alwaysRun = true, description = "Verify that the user can open Placelab")
    public void initDriver(String browser) {
        driver = WebDriverSetup.getWebDriver(browser);
        login = new Login(driver);
        homePage = new HomePage(driver);

        driver.navigate().to(host);
        login.verifyLoginPage(host);
    }



    @Test(priority = 1, description = "Verify that the user can log in to Placelab with valid credentials",
            suiteName = "Smoke Test")
    public void testLoginPage() {
        //Fill out login parameters
        login.enterUsername(username);
        login.enterPassword(password);
        //Click on login button
        login.submit();


        //Validate that the user is sucessfully logged in
        Assert.assertEquals(driver.getCurrentUrl(), homePageURL, "The right URL doesn't display after" +
                "the user logs in");
        assert (homePage.getUser().contains(user));
        softAssert.assertEquals(homePage.getUserRole(), "Group Admin", "Logged user has an " +
                "invalid user role");
        softAssert.assertAll();

    }
@AfterTest(alwaysRun = true)
    public void cleanAfterTest(){
        homePage.signOut();
        Assert.assertEquals(driver.getCurrentUrl(),host);
        driver.close();
    }
}
