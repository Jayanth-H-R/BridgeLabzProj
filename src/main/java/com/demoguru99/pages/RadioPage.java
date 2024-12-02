package com.demoguru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioPage {

    public WebDriver driver;

    public RadioPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "vfb-7-1")
    public WebElement radioOption1;
    @FindBy(id = "vfb-7-2")
    public WebElement radioOption2;

    @FindBy(id = "vfb-7-3")
    public WebElement radioOption3;

    @FindBy(id = "vfb-6-0")
    public WebElement checkBox1;

    @FindBy(id = "vfb-6-1")
    public WebElement checkBox2;

    @FindBy(id = "vfb-6-2")
    public WebElement checkBox3;


    public void selectRadio() {
        radioOption1.click();
    }

    public void selectCheckBox(){
        checkBox1.click();
    }



}
