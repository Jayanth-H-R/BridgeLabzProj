package com.demoguru99.tests;

import com.demoguru99.basepage.BaseClass;
import com.demoguru99.pages.HomePage;
import com.demoguru99.pages.LoginPage;
import com.demoguru99.utility.WebDriverUtility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;

public class LoginTest extends BaseClass {

    @BeforeClass
    public void configBefore() throws IOException, InterruptedException {
        setUp();
        logger.info("Application started");
    }

    @Test
    public void verifyLogin() throws IOException, InterruptedException, AWTException {
        HomePage homePage = new HomePage(driver);
        WebDriverUtility webUtils = new WebDriverUtility(driver);
        webUtils.implicitOfSec();
        //actions.scrollTo(homePage.seleniumDropDown);
        homePage.seleniumDropDown.click();
        homePage.loginPage.click();
        Assert.assertTrue(webUtils.partialUrl("login"),"login page validation failed");
        LoginPage lPage=new LoginPage(driver);
        String response = lPage.login();
        Assert.assertEquals(fileUtils.readData("loginsuccess"),response);
        logger.info("Login functionality validated");

    }
    @AfterClass
    public void configAfter() {
        termination();
        logger.info("Termination completed");
    }
}
