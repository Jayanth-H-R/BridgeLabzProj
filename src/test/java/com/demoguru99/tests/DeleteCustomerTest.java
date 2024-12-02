package com.demoguru99.tests;

import com.demoguru99.basepage.BaseClass;
import com.demoguru99.pages.DeleteCustomerFormPage;
import com.demoguru99.pages.HomePage;
import com.demoguru99.utility.WebDriverUtility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class DeleteCustomerTest extends BaseClass {
    @BeforeClass
    public void configBefore() throws IOException, InterruptedException {
        setUp();
        logger.info("Application started");
    }

    @Test
    public void verifyDeleteCustomer() throws IOException, InterruptedException {

        HomePage homePage=new HomePage(driver);
        WebDriverUtility webUtils=new WebDriverUtility(driver);
        webUtils.implicitOfSec();
        homePage.seleniumDropDown.click();
        DeleteCustomerFormPage deleteCustomerFormPage=new DeleteCustomerFormPage(driver);
        deleteCustomerFormPage.deletecustomerPage.click();
        Assert.assertTrue(webUtils.partialUrl(fileUtils.readData("deletecustomerpage")),"Delete customer form page validation failed");
        Assert.assertTrue(deleteCustomerFormPage.interaction(),"Deleting customer using cusId failed");
        logger.info("verifyDeleteCustomer testcase Executed");
    }

    @AfterClass
    public void configAfter(){
        termination();
        logger.info("Application Terminated ");
    }

}
