package com.demoguru99.pages;

import com.demoguru99.utility.FileUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class DeleteCustomerFormPage {

    public WebDriver driver;
    FileUtility fileUtility = new FileUtility();
    WebDriverWait waits ;


    public DeleteCustomerFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    @FindBy(linkText = "Delete Customer Form")
    public WebElement deletecustomerPage;

    @FindBy(name = "cusid")
    public WebElement customerIdFeild;

    @FindBy(name = "submit")
    public WebElement submitOption;

    @FindBy(name = "res")
    public WebElement resetOption;

    public boolean interaction() throws IOException, InterruptedException {
        customerIdFeild.sendKeys(fileUtility.readData("customerid"));
        submitOption.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        //waits.until(ExpectedConditions.alertIsPresent()).accept();
        String responseAfter = driver.switchTo().alert().getText();
        if (responseAfter.equalsIgnoreCase(fileUtility.readData("deleteresponse"))) {
            driver.switchTo().alert().accept();
            return true;
        } else
            return false;

    }


}
