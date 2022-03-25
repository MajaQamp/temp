package Placelab.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Placelab_LoginPage {

    public String browser;
    public WebDriver driver;
    public String host = "https://demo.placelab.com/";
    public String username = System.getProperty("username");
    public String password = System.getProperty("password");


    @BeforeTest
    public void openBrowser() {
        this.browser="Firefox";
        if (this.browser.contains("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        }else if (this.browser.contains("Chrome")){
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        }else if (this.browser.contains("Edge")){
            WebDriverManager.edgedriver().setup();
            this.driver = new EdgeDriver();
        }
        this.driver.navigate().to(host);
    }

    @Test
    public void LogIn(){
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @AfterTest
    public void closeBrowser(){
        this.driver.close();
    }




}
