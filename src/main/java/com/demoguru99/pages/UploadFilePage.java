package com.demoguru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class UploadFilePage {
    public WebDriver driver;
    WebDriverWait waits;

    public UploadFilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waits=new WebDriverWait(driver, Duration.ofSeconds(8));
    }


    @FindBy(xpath = "//input[@id='photoimg']")
    public WebElement uploadFileButton;
    @FindBy(id = "uploadfile_0")
    public WebElement uploadFileButton1;

    @FindBy(xpath = "//input[@id='terms']")
    public WebElement termsAndCondition;

    @FindBy(id = "submitbutton")
    public WebElement submitFileButton;

    @FindBy(xpath = "//font[@color='black']")
    public WebElement successMessage;

    public String interaction() throws InterruptedException, AWTException {
        Thread.sleep(6000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();",uploadFileButton);
        uploadFileButton.sendKeys("C:\\Users\\Qapitol QA\\Downloads\\Book.xlsx");
        waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//font[@color='black']")));
        return successMessage.getText();

    }

    public void interaction1() throws InterruptedException {
        Thread.sleep(6000);
        String filePath = System.getProperty("user.dir") + "/src/test/resources/Screenshot 2024-11-20 161714.png";
        uploadFileButton1.sendKeys(filePath);
        Thread.sleep(2000);
        termsAndCondition.click();
        submitFileButton.click();

    }


}
