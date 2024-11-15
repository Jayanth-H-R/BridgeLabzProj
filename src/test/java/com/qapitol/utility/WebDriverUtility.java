package com.qapitol.utility;

import com.qapitol.generic.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverUtility extends BaseClass {
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    public WebDriverUtility(){

    }
    public WebElement elementToBeClickable(WebDriver driver, WebElement element) {

        WebElement	ele=wait.until(ExpectedConditions.elementToBeClickable(element));
        return ele;
    }
}
