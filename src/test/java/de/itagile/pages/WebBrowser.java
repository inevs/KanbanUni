package de.itagile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;
import java.time.Duration;

public class WebBrowser {
    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;

    public WebBrowser() {
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/chromedriver/chromedriver").toString());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void quit() {
        driver.close();
        driver.quit();
    }
}
