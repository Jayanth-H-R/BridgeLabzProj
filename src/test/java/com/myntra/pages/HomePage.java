package com.myntra.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    public AppiumDriver driver;

    public HomePage(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"TOPNAV_CAROUSEL_1_2\"])[2]/android.view.ViewGroup")
    public WebElement menTshirts;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"65956b8c11fff1ba9da17a1f\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.ImageView\n")
    public WebElement categoryIcon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"leftElement\"]")
    public  WebElement navigateBack;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.myntra.android:id/ll_react_container\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[1]")
    public WebElement profileIcon;





//    public WebElement trends = driver.findElement(MobileBy.AndroidUIAutomator(
        //    "new UiSelector().className(\"android.view.ViewGroup\").instance(96)"));
   /* @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Account\"]")
    public WebElement accountIcon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Log Out\"]")
    public WebElement logOutIcon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Logout from this device\"]")
    public WebElement logoutFromThisDevice;

    @FindBy(xpath ="//android.widget.TextView[@text=\"Log In\"]")
    public WebElement loginButton;*/


}
