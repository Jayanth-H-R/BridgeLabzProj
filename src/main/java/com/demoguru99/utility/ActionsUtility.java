package com.demoguru99.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility {
Actions actions;
    public ActionsUtility(WebDriver driver){
        actions= new Actions(driver);
    }

    public void moveToEle(WebElement ele){
        actions.moveToElement(ele).pause(2000).build().perform();
    }

    public void scrollTo(WebElement ele){
        actions.scrollToElement(ele).pause(2000).build().perform();
    }

}
