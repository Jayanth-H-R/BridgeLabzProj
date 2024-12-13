package com.generic.utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class WebDriverUtility {
    public AppiumDriver driver;

    public WebDriverUtility(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void  implicitlyWaitOfSec(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

    }

    public void Pinching() throws InterruptedException {
        TouchAction finger1 = new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(300, 1300))  // First finger's starting point
                .moveTo(PointOption.point(150, 1600))     // Move it apart for zooming in
                .release();
        // Touch action for the second finger (for zoom gesture)
        TouchAction finger2 = new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(650, 850))  // Second finger's starting point
                .moveTo(PointOption.point(780, 650))      // Move it apart for zooming in
                .release();

        // Create MultiTouchAction for zooming
        MultiTouchAction multiTouch = new MultiTouchAction((PerformsTouchActions) driver);
        multiTouch.add(finger1).add(finger2).perform();  // Perform zoom gesture
        // Wait for zoom effect to apply
        Thread.sleep(2000);

    }


}
