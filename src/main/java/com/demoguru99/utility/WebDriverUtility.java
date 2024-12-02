package com.demoguru99.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverUtility {
    WebDriver driver;


    public WebDriverUtility(WebDriver driver){
        this.driver=driver;

    }

    public void implicitOfSec(){
        WebDriverWait waits=new WebDriverWait(driver, Duration.ofSeconds(8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    public boolean partialUrl(String partil){
        WebDriverWait waits=new WebDriverWait(driver, Duration.ofSeconds(8));
        return waits.until(ExpectedConditions.urlContains(partil));
    }

    public WebElement elementClicable(WebElement ele){
        WebDriverWait waits=new WebDriverWait(driver, Duration.ofSeconds(8));
        return waits.until(ExpectedConditions.elementToBeClickable(ele));
    }
}
