package com.qapitol.pages;

import com.qapitol.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Elements  extends BaseClass {
 WebDriver driver;

    public Elements(WebDriver driver){
        this.driver=driver;

    }
    public void UploadPopUp() throws AWTException, InterruptedException {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(8));
        Actions actions=new Actions(driver);
        driver.findElement(By.xpath("//span[text()='Upload and Download']")).click();
        wait.until(ExpectedConditions.urlContains("upload-download"));
        WebElement chooseFile=driver.findElement(By.id("uploadFile"));
        actions.scrollToElement(chooseFile).pause(2000).perform();
        Thread.sleep(3000);
        actions.moveToElement(chooseFile).pause(2000).click().build().perform();
        // Copy the file path to the system clipboard
        StringSelection path=new StringSelection("/.src/test/resources/Book.xlsx");
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Clipboard clipBoard=toolkit.getSystemClipboard();
        clipBoard.setContents(path,null);
        // simulate the key events to handle file upload pop-up
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
    }
}
