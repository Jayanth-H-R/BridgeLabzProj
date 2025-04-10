package com.qapitol.pages;

import com.qapitol.base.BaseClass;
import com.qapitol.util.FileUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;

public class FormsPage extends BaseClass {
public WebDriver driver;
FileUtility utility=new FileUtility();
public FormsPage(WebDriver driver){
    this.driver=driver;

}
public void practiceForm(Object firstName, Object lastName , Object number ) throws InterruptedException, IOException {
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
    actions.moveToElement(driver.findElement(By.id("gender-radio-1"))).click().build().perform();
    mobileNumber.sendKeys(number1);
    Thread.sleep(3000);
    WebElement emailTextField=driver.findElement(By.id("userEmail"));
    emailTextField.sendKeys(utility.readData("mail"));
    WebElement hobbieCheckBox=driver.findElement(By.cssSelector("input[id='hobbies-checkbox-1']"));
    actions.moveToElement(hobbieCheckBox).click().pause(2000).build().perform();
    WebElement calendarPopup=driver.findElement(By.id("dateOfBirthInput"));
    actions.moveToElement(calendarPopup).click().pause(2000).build().perform();
    WebElement monthDropDown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
    Select selectMonth=new Select(monthDropDown);
    selectMonth.selectByVisibleText("September");
   WebElement yearDropDown=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
    Select selectYear= new Select(yearDropDown);
    selectYear.deselectByValue("1999");

}

}
