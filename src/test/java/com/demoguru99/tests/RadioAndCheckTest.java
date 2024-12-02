package com.demoguru99.tests;

import com.demoguru99.basepage.BaseClass;
import com.demoguru99.pages.HomePage;
import com.demoguru99.pages.RadioPage;
import com.demoguru99.utility.WebDriverUtility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class RadioAndCheckTest extends BaseClass {

    @BeforeClass
    public void configBefore() throws IOException, InterruptedException {
        setUp();
        logger.info("Application started");
    }

    @Test
    public void checkBoxAndRadio() throws IOException {
        HomePage homePage=new HomePage(driver);
        WebDriverUtility webUtils=new WebDriverUtility(driver);
        webUtils.implicitOfSec();
        homePage.seleniumDropDown.click();
        homePage.radioAndCheckBox.click();
        Assert.assertTrue(webUtils.partialUrl(fileUtils.readData("radiopage")),"radio page validation failed");
        RadioPage radioAndCheckPage=new RadioPage(driver);
        radioAndCheckPage.selectRadio();
        Assert.assertTrue(radioAndCheckPage.radioOption1.isSelected(),"Invalid radio Selection");
        radioAndCheckPage.selectCheckBox();
        Assert.assertTrue(radioAndCheckPage.checkBox1.isSelected(),"Invalid checkBox Selection");
        logger.info("checkBoxAndRadio TestCase executed");
    }

    @AfterClass
    public void configAfter(){
        termination();
        logger.info("Application Terminated ");
    }

}
