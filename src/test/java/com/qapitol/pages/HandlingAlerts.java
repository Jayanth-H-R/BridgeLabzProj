package com.qapitol.pages;

import com.qapitol.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandlingAlerts extends BaseClass {
    WebDriver driver;

    public HandlingAlerts(WebDriver driver){
        this.driver=driver;

    }

    public void alertsInteraction() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        Actions actions=new Actions(driver);
        driver.findElement(By.xpath("//div[text()='Alerts, Frame & Windows']")).click();
            Thread.sleep(2000);
            driver.navigate().to("https://demoqa.com/alerts");
        /*WebElement alertOpt=driver.findElement(By.xpath("//span[text()='Alerts']/.."));
        actions.moveToElement(alertOpt).pause(2000).click().build().perform(); */
        WebElement alert1=driver.findElement(By.id("alertButton"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,60)");
        actions.scrollToElement(alert1).pause(2000).click().build().perform();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

    }

}
