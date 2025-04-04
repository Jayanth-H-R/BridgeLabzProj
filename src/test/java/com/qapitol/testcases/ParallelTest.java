package com.qapitol.testcases;

import com.qapitol.util.FileUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ParallelTest {
    private ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    FileUtility utility = new FileUtility();
    public WebDriver driver;

    public void setDriver(WebDriver driver) {
        threadDriver.set(driver);
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

    @BeforeMethod
    public void configBefore() throws IOException {
        driver = new ChromeDriver();
        setDriver(driver);
        getDriver().get(utility.readData("url"));
        getDriver().manage().window().maximize();

    }

    @Test
    public void testParallel() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test
    public void testParallel1() throws InterruptedException {
        Thread.sleep(3000);
    }

    @AfterMethod
    public void configAfter() {
        getDriver().manage().window().minimize();
        getDriver().quit();
        threadDriver.remove();
    }
}
