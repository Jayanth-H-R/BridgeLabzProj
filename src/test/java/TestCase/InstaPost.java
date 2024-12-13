package TestCase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.generic.utility.BaseClass;
import com.generic.utility.FileUtility;
import com.generic.utility.MobileActionss;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class InstaPost {
    public AppiumDriver driver;
    public FileUtility fileUtils = new FileUtility();
    WebElement logOut;
   // TouchAction action = new TouchAction((PerformsTouchActions) driver);

    public static Logger log = Logger.getLogger(InstaPost.class.getName());
    public ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/ExtentReports/Spark.html");

    @BeforeTest
    public void setUp() throws IOException {
        DesiredCapabilities dCapability = new DesiredCapabilities();
        dCapability.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6a");
        dCapability.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        dCapability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15");
        dCapability.setCapability("appPackage", fileUtils.readData("instaAppPack"));
        dCapability.setCapability("appActivity", fileUtils.readData("instaAppAct"));
        dCapability.setCapability(MobileCapabilityType.NO_RESET, false);
        //to handle permission
        dCapability.setCapability("autoGrantPermissions", true);
        //to handle Animations
        dCapability.setCapability("disableAndroidAnimations", true);
        //dCapability.setCapability(MobileCapabilityType.UDID, fileUtils.readData("udid"));  // Device UDID
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dCapability);
        log.info("Application started");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Instagram mobile Testing");
        extent.attachReporter(spark);

    }

    @Test
    public void zoomIn() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(12));
       /* WebElement userNameField = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.instagram.android:id/layout_container_main\"]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText"));
        userNameField.sendKeys(fileUtils.readData("username"));
        WebElement passwordField = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.instagram.android:id/layout_container_main\"]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText"));
        passwordField.sendKeys(fileUtils.readData("password"));
        WebElement logInButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Log in\"]/android.view.ViewGroup"));
        logInButton.click();*/
        Thread.sleep(3000);
        //WebElement continueWithoutLogin = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Log in\"]"));
        WebElement loginWithContiune=driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Continue\"]/android.view.ViewGroup"));
        loginWithContiune.click();
        //continueWithoutLogin.click();
        Thread.sleep(3000);
        WebElement notNowSavepass = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Not now\"]")));
        if (notNowSavepass.isDisplayed()) {
            notNowSavepass.click();
        }
        Thread.sleep(3000);
        WebElement profileIcon = waits.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"com.instagram.android:id/tab_avatar\"]"))));
        profileIcon.click();
        Thread.sleep(2000);
        MobileActionss actionss = new MobileActionss(driver);
        actionss.swipe(334, 1983, 334, 1104);
        WebElement firstPost = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Photo by Priya at Row 1, Column 1\"]"));
        //Actions actions=new Actions(driver);
        //actions.scrollToElement(firstPost).pause(2000).click().build().perform();
        //waits.until(ExpectedConditions.elementToBeClickable(firstPost)).click();
        firstPost.click();
        Thread.sleep(3000);
        WebElement opendedPost = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.instagram.android:id/row_feed_photo_imageview\"]/android.widget.ImageView")));
        actionss.zoomIn(opendedPost);
        Thread.sleep(2000);
        actionss.zoomOut(opendedPost);
        WebElement navigateBack = waits.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/action_bar_button_back")));
        navigateBack.click();
        WebElement options = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Options\"]")));
        options.click();
        for (int i = 0; i < 4; i++) {


            try {
                // Wait for the "Log out" button to be visible
                logOut = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text=\"Log out\"]")));
                if (logOut != null) {
                    System.out.println("Log out button found!");
                    logOut.click();
                    break;
                }
            } catch (Exception e) {
                // Element not found, perform swipe action
                System.out.println("Log out button not found, performing swipe...");
            }

            // Perform the swipe action
            actionss.swipe(334, 2145, 334, 700);
        }
        WebElement notnow = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.instagram.android:id/negative_button\"]")));
        notnow.click();
        WebElement logOutLast = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.instagram.android:id/primary_button\"]")));
        logOutLast.click();
    }


    @AfterTest
    public void termination() {
        driver.manage().window().minimize();
        driver.quit();
    }

//    public void scrollingAct() {
//        // Start swipe (scroll up) from near the bottom of the screen
//
//
//        while (true) {
//            try {
//                logOut = driver.findElement(By.xpath("//android.widget.Button[@text=\"Log out\"]"));
//                if (logOut.isDisplayed()) {
//                    System.out.println("Log out button found!");
//                    break; // Stop scrolling if the element is found
//                }
//            } catch (Exception e) {
//                action.press(PointOption.point(500, 1500)) // Start position
//                        .moveTo(PointOption.point(500, 500)) // End position (move to top)
//                        .release().perform();
//
//            }
//
//
//        }
//    }
}
