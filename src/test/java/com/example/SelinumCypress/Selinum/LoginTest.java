package com.example.SelinumCypress.Selinum;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        driver.get("http://example.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("testuser");
        loginPage.setPassword("password");
        loginPage.clickLoginButton();

        // Verify user is redirected to the home page
        Assert.assertEquals(driver.getCurrentUrl(), "http://example.com/home");
    }
}
