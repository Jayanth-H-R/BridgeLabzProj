package com.qapitol.pages;

import com.qapitol.util.FileUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;

public class Widgets {
    WebDriver driver;


    public Widgets(WebDriver driver) {
        this.driver = driver;
    }


    public void toolTip() throws InterruptedException, IOException {
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        FileUtility utility = new FileUtility();
        WebElement toolTipTab = driver.findElement(By.xpath("//span[text()='Tool Tips']/.."));
        actions.scrollToElement(toolTipTab).pause(2000).build().perform();
        js.executeScript("arguments[0].click();", toolTipTab);
        Thread.sleep(3000);
        WebElement toolTipButton = driver.findElement(By.id("toolTipButton"));
        js.executeScript("window.scrollBy(250,320)");
        actions.scrollToElement(toolTipButton).perform();
        actions.moveToElement(toolTipButton).pause(4000).perform();
        String toolTiptext = driver.findElement(By.xpath("//div[@class='tooltip-inner']")).getText();
        Assert.assertEquals(utility.readData("tooltiptext"), toolTiptext);


    }

    public void slider() throws InterruptedException {
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement sliderTab = driver.findElement(By.xpath("//span[text()='Slider']"));
        actions.scrollToElement(sliderTab).perform();
        js.executeScript("arguments[0].click();", sliderTab);
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,230)");
        Thread.sleep(2000);
        WebElement sliderValue = driver.findElement(By.id("sliderValue"));
        String previousValue = sliderValue.getAttribute("value");
        Thread.sleep(2000);
        WebElement sliderEle = driver.findElement(By.xpath("//input[contains(@class,'range-slide')]"));
        Thread.sleep(2000);
        actions.moveToElement(sliderEle, 200, 16).pause(2000).click().build().perform();
        String currentValue = sliderValue.getAttribute("value");
        Assert.assertTrue(!(previousValue.equals(currentValue)), "Comparisson Fails");
        Thread.sleep(2000);


    }
}
