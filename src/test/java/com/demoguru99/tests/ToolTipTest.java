package com.demoguru99.tests;

import com.demoguru99.basepage.BaseClass;
import com.demoguru99.pages.HomePage;
import com.demoguru99.pages.ToolTipPage;
import com.demoguru99.utility.WebDriverUtility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class ToolTipTest extends BaseClass {

    @BeforeClass
    public void configBefore() throws IOException, InterruptedException {
        setUp();
        logger.info("Application Started");
    }

    @Test
    public void verifyToolTip() throws IOException, InterruptedException {
        HomePage homePage = new HomePage(driver);
        WebDriverUtility webUtils = new WebDriverUtility(driver);
        webUtils.implicitOfSec();
        homePage.seleniumDropDown.click();
        ToolTipPage toolTipPage = new ToolTipPage(driver);
        toolTipPage.toolTipOption.click();
        Assert.assertTrue(webUtils.partialUrl(fileUtils.readData("tooltippage")));
        String tooltipText = toolTipPage.interAct();
        Assert.assertTrue(tooltipText.equalsIgnoreCase(fileUtils.readData("tooltipText")), "Tooltip validation failed");
        logger.info("verifyToolTip testCase executed");
    }


    @AfterClass
    public void configAfter() {
        termination();
        logger.info("Application Terminated ");
    }
}
