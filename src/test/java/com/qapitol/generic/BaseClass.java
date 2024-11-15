package com.qapitol.generic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qapitol.pomrepos.LoginPage;
import com.qapitol.utility.FileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    FileUtility fileUtils = new FileUtility();
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/ExtentReport");

    public BaseClass() {

    }

    @BeforeMethod
    public void configBeforeMethod() throws IOException, InterruptedException {
        String browserName = fileUtils.readData("browser");
        String envi = fileUtils.readData("environment");

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Page Object Model");
        extent.attachReporter(spark);

        if (browserName.equalsIgnoreCase("chrome")) {
            if (envi.equalsIgnoreCase("remote")) {

                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setBrowserName(Browser.CHROME.browserName());
                driver = new RemoteWebDriver(new URL("http://192.168.2.76:4444/wd/hub"), dc);
                driver.manage().window().maximize();
                driver.get(fileUtils.readData("url"));
            } else if (envi.equalsIgnoreCase("local")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
                driver.get(fileUtils.readData("url"));
                Thread.sleep(2000);
            }


        } else if (browserName.equalsIgnoreCase("edge")) {
            if (envi.equalsIgnoreCase("remote")) {
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setBrowserName(Browser.EDGE.browserName());
                //@SuppressWarnings("deprecation")
                driver = new RemoteWebDriver(new URL("http://192.168.2.76:4444/wd/hub"), dc);
                driver.manage().window().maximize();
                driver.get(fileUtils.readData("url"));
            } else if (envi.equalsIgnoreCase("local")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
                driver.get(fileUtils.readData("url"));

            }
        }
    }

    @AfterMethod
    public void configAfterMethod() {
        extent.flush();
        driver.manage().window().minimize();
        driver.quit();
    }
}
