package com.demoguru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//li[@class='dropdown']//a[@class='dropdown-toggle']")
    public WebElement seleniumDropDown;

    @FindBy(xpath = "//a[text()='Radio & Checkbox Demo']")
    public WebElement radioAndCheckBox;
    @FindBy(xpath = "//a[text()='File Upload using Sikuli Demo']")
    public WebElement fileUploadOption;

    @FindBy(xpath = "//a[text()='File Upload']")
    public WebElement fileUploadOption1;

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement loginPage;

    @FindBy(xpath = "//a[text()='Flash Movie Demo']")
    public WebElement movieDemo;


}
