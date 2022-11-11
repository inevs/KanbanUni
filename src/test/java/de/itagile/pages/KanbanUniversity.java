package de.itagile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class KanbanUniversity {
    private final Properties properties = new Properties();
    private WebDriver driver;

    public KanbanUniversity(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        readProperties();

        driver.navigate().to("https://kanban.university/kuapps/#/auth/login");

        String name = properties.getProperty("ku.username");
        String password = properties.getProperty("ku.password");

        driver.findElement(By.cssSelector("input.form-control[formcontrolname='username']")).sendKeys(name);
        driver.findElement(By.cssSelector("input.form-control[formcontrolname='password']")).sendKeys(password);
        driver.findElement(By.id("kt_login_signin_submit")).click();
    }

    private void readProperties() {
        try (InputStream input = new FileInputStream("src/test/resources/credentials.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}