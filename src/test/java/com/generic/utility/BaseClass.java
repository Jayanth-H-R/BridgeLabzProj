package com.generic.utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class BaseClass {
    public AppiumDriver driver;
    public FileUtility fileUtils = new FileUtility();


    public BaseClass() {

    }

    public void setUp() throws IOException {
        DesiredCapabilities dCapability = new DesiredCapabilities();
        dCapability.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 7a");
        dCapability.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        dCapability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15");
        dCapability.setCapability("appPackage", fileUtils.readData("appPackage"));
        dCapability.setCapability("appActivity", fileUtils.readData("appActivity"));
        //dCapability.setCapability(MobileCapabilityType.UDID, fileUtils.readData("udid"));  // Device UDID

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dCapability);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
