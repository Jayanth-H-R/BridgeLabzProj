package com.myntra.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class ProductPage {

    public AppiumDriver driver;

    public ProductPage(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"buy_button\"]/android.view.ViewGroup")
    public WebElement addToBag;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"size_select_M\"]")
    public WebElement mSizeTee;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"buy_done_button\"]")
    public WebElement sizeSelectionDone;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"bag\"]/android.view.ViewGroup")
    public WebElement bagIcon;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.myntra.android:id/ll_react_container\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[1]")
    public WebElement searchIcon;

    @FindBy(xpath = "//android.widget.TextView[@text=\"1/1 ITEMS SELECTED\"]")
    public WebElement itemsList;



}
