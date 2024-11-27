package com.generic.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class BaseClass {
    public AppiumDriver driver;
    public FileUtility fileUtils = new FileUtility();

   public static Logger log = Logger.getLogger(BaseClass.class.getName());
   public  ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/ExtentReports/Spark.html");


    public BaseClass() {

    }

    public void setUp() throws IOException {
        Properties props = System.getProperties();
        PropertyConfigurator.configure(props.getProperty("user.dir") + "\\src\\test\\resources\\log4j.properties");
        DesiredCapabilities dCapability = new DesiredCapabilities();
        dCapability.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 7a");
        dCapability.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        dCapability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15");
        dCapability.setCapability("appPackage", fileUtils.readData("appPackage"));
        dCapability.setCapability("appActivity", fileUtils.readData("appActivity"));
        //to handle permission
        //dCapability.setCapability("autoGrantPermissions",true);

        //to handle Animations
        dCapability.setCapability("disableAndroidAnimations", true);
        //dCapability.setCapability(MobileCapabilityType.UDID, fileUtils.readData("udid"));  // Device UDID

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dCapability);
        log.info("Application started");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Myntra mobile Testing");
        extent.attachReporter(spark);


    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("Application closed");
        }
    }

}
