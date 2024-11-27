package com.generic.utility;

import io.appium.java_client.AppiumDriver;
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


}
