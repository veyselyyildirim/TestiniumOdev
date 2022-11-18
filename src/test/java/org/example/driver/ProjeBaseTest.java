package org.example.driver;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProjeBaseTest {

    public static WebDriver driver ;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-plugins");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("disable-translate");
        chromeOptions.setExperimentalOption("w3c",false);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.network.com.tr/");

        /** Url kontrol */
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.network.com.tr/" );
    }
    @After
    public void tearDown(){
        if(driver != null)
        {
           /* driver.close();
            driver.quit();*/
        }
    }
}
