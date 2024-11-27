package com.myntra.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenTshirtsPage {

    public AppiumDriver driver;

    public  MenTshirtsPage(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.myntra.android:id/ll_react_container\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
    public WebElement roundNeckT;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.myntra.android:id/ll_react_container\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    public WebElement cottonT;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.myntra.android:id/ll_react_container\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[1]")
    public WebElement searchIcon;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"view_info_container\"])[2]")
    public WebElement mastAndHarbourTee;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"search_default_search_text_input\"]")
    public WebElement searchFeild;


}
