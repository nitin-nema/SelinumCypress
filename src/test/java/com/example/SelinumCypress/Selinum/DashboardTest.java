package com.example.SelinumCypress.Selinum;


import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest {

    @Test
    public void testDashboardElements() {
        // Login first
        driver.get("http://example.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("testuser");
        loginPage.setPassword("password");
        loginPage.clickLoginButton();

        // Access Dashboard
        DashboardPage dashboardPage = new DashboardPage(driver);

        // Validate Profile Menu is Displayed
        Assert.assertTrue(dashboardPage.isProfileMenuDisplayed());

        // Validate Chart is Visible
        Assert.assertTrue(dashboardPage.isChartVisible());

        // Validate Table Data
        WebElement table = dashboardPage.getDataTable();
        Assert.assertNotNull(table);
        Assert.assertTrue(table.getText().contains("Expected Data"));
    }
}
