package com.qapitol.pages;

import com.qapitol.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;


public class LoginPage  extends BaseClass {
public WebDriver driver;
public LoginPage(WebDriver driver){
this.driver=driver;
}
public void forms() throws InterruptedException {
    Actions actions=new Actions(driver);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    actions.scrollByAmount(0,250);
    WebElement formEle=driver.findElement(By.xpath("//h5[text()='Forms']//ancestor::div[@class='card mt-4 top-card']"));
    actions.moveToElement(formEle).pause(2000).click().build().perform();
    Thread.sleep(2000);

}
 public void elements() throws InterruptedException {

     Actions actions=new Actions(driver);
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
     actions.scrollByAmount(0,250);
     WebElement elements=driver.findElement(By.xpath("//h5[text()='Elements']//ancestor::div[@class='card mt-4 top-card']"));
     actions.moveToElement(elements).pause(2000).click().build().perform();

 }
 public void alerts(){
     Actions actions=new Actions(driver);
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
     actions.scrollByAmount(0,250);
    WebElement alertsTab=driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']//ancestor::div[@class='card mt-4 top-card']"));
     actions.moveToElement(alertsTab).click().pause(2000).perform();
 }




}
