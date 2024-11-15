package com.qapitol.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qapitol.generic.BaseClass;
import com.qapitol.pomrepos.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestExecution extends BaseClass {

    ExtentReports extent = new ExtentReports();
    //ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/Reports/Spark.html");

    public final static Logger logger = LogManager.getLogger(TestExecution.class);
    @Test()
    public void searchContext() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Login to Application").assignAuthor("Jayanth")
                .assignCategory("Automation Test").assignDevice("Window");
        test.info("Validating Search Results");
        LoginPage lPage=new LoginPage(driver);
        lPage.searchContextInteraction();
        System.out.println(Thread.currentThread().getName()+" searchContext ");
        Thread.sleep(5000);
        logger.debug("Executed search context test");
        test.info("Executed search context test");
    }

    @Test()
    public void searchContext1() throws InterruptedException, IOException {
        LoginPage lPage=new LoginPage(driver);
        lPage.searchContextInteraction();
        System.out.println(Thread.currentThread().getName()+" searchContext1 ");
        Thread.sleep(5000);
    }
}
