package com.demoguru99.tests;

import com.demoguru99.basepage.BaseClass;
import com.demoguru99.pages.HomePage;
import com.demoguru99.pages.UploadFilePage;
import com.demoguru99.utility.WebDriverUtility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;

public class ChooseFileTest extends BaseClass {

    @BeforeClass
    public void configBefore() throws IOException, InterruptedException {
        setUp();
        logger.info("Application started");
    }

    @Test
    public void verifyChooseFile() throws IOException, InterruptedException, AWTException {
        HomePage homePage = new HomePage(driver);
        WebDriverUtility webUtils = new WebDriverUtility(driver);
        webUtils.implicitOfSec();
        //actions.scrollTo(homePage.seleniumDropDown);
        homePage.seleniumDropDown.click();
        homePage.fileUploadOption1.click();
        Thread.sleep(2000);
        //Assert.assertTrue(webUtils.partialUrl(fileUtils.readData("upload")),"Validation of file upload page failed");
        UploadFilePage uploadFilePage=new UploadFilePage(driver);
        uploadFilePage.interaction1();
        //Assert.assertEquals(fileUtils.readData("uploaded"),response);
        logger.info("verifyChooseFile Testcase executed");


    }
    @AfterClass
    public void configAfter() {
        termination();
        logger.info("Termination completed");
    }



}
