package com.qapitol.pages;

import com.qapitol.base.BaseClass;
import com.qapitol.util.FileUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;

public class EndToEnd extends BaseClass {
    public WebDriver driver;
    FileUtility utility=new FileUtility();

    public EndToEnd(WebDriver driver){
        this.driver=driver;
    }

    public void forminteraction() throws InterruptedException, IOException {
    Actions actions=new Actions(driver);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

    driver.findElement(By.xpath("//span[text()='Practice Form']//ancestor::li[@id='item-0']")).click();
    WebElement first=driver.findElement(By.id("firstName"));
    WebElement last=driver.findElement(By.id("lastName"));
    WebElement mobileNumber=driver.findElement(By.id("userNumber"));
    first.sendKeys("firstName");
    Thread.sleep(2000);
    last.sendKeys("lastName");
    Thread.sleep(2000);
    actions.moveToElement(driver.findElement(By.id("gender-radio-1"))).click().build().perform();
    mobileNumber.sendKeys("1234567");
    Thread.sleep(2000);
    WebElement emailTextField=driver.findElement(By.id("userEmail"));
    emailTextField.sendKeys(utility.readData("mail"));
    WebElement hobbieCheckBox=driver.findElement(By.cssSelector("input[id='hobbies-checkbox-1']"));
    actions.moveToElement(hobbieCheckBox).click().pause(2000).build().perform();
    WebElement calendarPopup=driver.findElement(By.id("dateOfBirthInput"));
    actions.moveToElement(calendarPopup).click().pause(2000).build().perform();
    //actions.scrollByAmount(0,150).pause(2000).perform();
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,280)");
    WebElement monthDropDown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
    Select selectMonth=new Select(monthDropDown);
    selectMonth.selectByVisibleText("September");
    WebElement yearDropDown=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
    Select selectYear= new Select(yearDropDown);
    selectYear.deselectByValue("1999");
}
}
