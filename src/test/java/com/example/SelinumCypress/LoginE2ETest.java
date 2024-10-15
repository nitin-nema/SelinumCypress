package com.example.SelinumCypress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginE2ETest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testUserLogin() {
        // Open the application
        driver.get("http://localhost:8080/login");

        // Find elements
        WebElement loginText = driver.findElement(By.xpath("//h1[text() =\"Login\"]"));
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginBtn"));

        // Simulate user interaction
        username.sendKeys("testuser");
        password.sendKeys("password123");
        loginButton.click();

        // Check the URL after login to confirm success
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8080/home");

        // asserationStatment(actualValue,expectedValues)
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
