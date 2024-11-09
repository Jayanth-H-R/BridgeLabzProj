package com.qapitol.pages;

import com.qapitol.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class FormsPage extends BaseClass {
public WebDriver driver;
public FormsPage(WebDriver driver){
    this.driver=driver;

}
public void practiceForm(Object firstName, Object lastName , Object number ) throws InterruptedException {
    Actions actions=new Actions(driver);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    String number1= String.valueOf(number);
    driver.findElement(By.xpath("//span[text()='Practice Form']//ancestor::li[@id='item-0']")).click();
   WebElement first=driver.findElement(By.id("firstName"));
    WebElement last=driver.findElement(By.id("lastName"));
    WebElement mobileNumber=driver.findElement(By.id("userNumber"));
    first.sendKeys((String)firstName);
    Thread.sleep(3000);
    last.sendKeys((String)lastName);
    Thread.sleep(3000);
    mobileNumber.sendKeys(number1);




}

}
