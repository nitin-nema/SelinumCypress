package com.example.SelinumCypress.Selinum;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    private WebDriver driver;

    // Locators
    private By profileMenu = By.id("profileMenu");
    private By chartElement = By.id("chart");
    private By tableElement = By.id("dataTable");

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public boolean isProfileMenuDisplayed() {
        return driver.findElement(profileMenu).isDisplayed();
    }

    public boolean isChartVisible() {
        return driver.findElement(chartElement).isDisplayed();
    }

    public WebElement getDataTable() {
        return driver.findElement(tableElement);
    }
}
