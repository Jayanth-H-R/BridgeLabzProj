package com.qapitol.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class GridExecution1 {

    @Test
    public void Test1() {

        try {
            System.out.println("Test1 started...");
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setBrowserName(Browser.CHROME.browserName());

            @SuppressWarnings("deprecation")
            WebDriver driver = new RemoteWebDriver(new URL("http://192.168.2.76:4444"), dc);
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
            Thread.sleep(10000);
            System.out.println("Test1 ended...");
            driver.quit();

        } catch (Exception e) {
            System.out.println("Exception is:"+e);
        }
    }


    @Test
    public void Test2() {

        try {
            System.out.println("Test2 started...");
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setBrowserName(Browser.EDGE.browserName());

            @SuppressWarnings("deprecation")
            WebDriver driver = new RemoteWebDriver(new URL("http://192.168.2.76:4444"), dc);
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
            Thread.sleep(10000);
            System.out.println("Test2 ended...");
            driver.quit();

        } catch (Exception e) {
            System.out.println("Exception is:"+e);
        }
    }


    @Test
    public void Test3() {

        try {
            System.out.println("Test3 started...");
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setBrowserName(Browser.EDGE.browserName());

            @SuppressWarnings("deprecation")
            WebDriver driver = new RemoteWebDriver(new URL("http://192.168.2.76:4444/"), dc);
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
            Thread.sleep(10000);
            System.out.println("Test3 ended...");
            driver.quit();

        } catch (Exception e) {
            System.out.println("Exception is:"+e);
        }
    }

}
