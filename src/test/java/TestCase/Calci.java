package TestCase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Calci {

    public AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dCapability = new DesiredCapabilities();
        dCapability.setCapability(MobileCapabilityType.DEVICE_NAME, "Nothing Phone (2a)");
        dCapability.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        dCapability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15");
        dCapability.setCapability("appPackage", "com.google.android.calculator");
        dCapability.setCapability("appActivity", "com.android.calculator2.Calculator");
        dCapability.setCapability(MobileCapabilityType.UDID, "00077348D000292");  // Device UDID
//            dCapability.setCapability("ignoreHiddenApiPolicyError", true);  // Custom capability
//            dCapability.setCapability("automationName", "UIAutomator2");  // UI Automator 2
//            dCapability.setCapability("appium:noReset", true);  // Don't reset app state

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dCapability);
    }

    @Test
    public void testCalci() {
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"2\"]")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        String results = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        Assert.assertEquals(results, "6");
        System.out.println("Results are verified " + results);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
