package com.demoguru99.tests;

import com.demoguru99.basepage.BaseClass;
import com.demoguru99.pages.HomePage;
import com.demoguru99.pages.MovieDemoPage;
import com.demoguru99.utility.WebDriverUtility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;

public class MovieDemoTest extends BaseClass {


        @BeforeClass
        public void configBefore() throws IOException, InterruptedException {
            setUp();
            logger.info("Application started");
        }

        @Test
        public void verifyDemoMovie() throws IOException, InterruptedException, AWTException {
            HomePage homePage = new HomePage(driver);
            WebDriverUtility webUtils = new WebDriverUtility(driver);
            webUtils.implicitOfSec();
            //actions.scrollTo(homePage.seleniumDropDown);
            homePage.seleniumDropDown.click();
            homePage.movieDemo.click();
            Assert.assertTrue(webUtils.partialUrl(fileUtils.readData("demomoviepage")),"Demo page validation failed");
            MovieDemoPage demoPage=new MovieDemoPage(driver);

            Assert.assertEquals(fileUtils.readData("demomovietext"),demoPage.demotext.getText());
            logger.info("Demo movie flash page verified");

        }
        @AfterClass
        public void configAfter() {
            termination();
            logger.info("Termination completed");
        }
    }


