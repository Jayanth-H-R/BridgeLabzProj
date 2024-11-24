package com.myntra.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public AppiumDriver driver;

    public LoginPage(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

   /* @FindBy(id = "com.flipkart.android:id/phone_input")
    public WebElement phoneNumbTextField;
    @FindBy(xpath = "(//android.widget.RelativeLayout[@resource-id=\"com.flipkart.android:id/locale_icon_layout\"])[13]")
    public WebElement englishlang;*/

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.myntra.android:id/closeDialog\"]")
    public WebElement pushNotificationPopup;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"BANNER_2\"]/android.widget.ImageView")
    public WebElement myntraStoreBanner;








}
