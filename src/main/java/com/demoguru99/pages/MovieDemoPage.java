package com.demoguru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MovieDemoPage {

    WebDriver driver;
    public MovieDemoPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//font[text()='DEMO Flash Movie']")
    public WebElement demotext;
}
