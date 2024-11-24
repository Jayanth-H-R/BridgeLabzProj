package com.myntra.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public AppiumDriver driver;

    public ProfilePage(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Orders\"]")
    public WebElement ordersSections;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.view.ViewGroup")
    public WebElement loginButton;

    @FindBy(className = "android.widget.EditText")
    public WebElement mobileNumberTextField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"form-button\"]")
    public WebElement continueButton;
}
