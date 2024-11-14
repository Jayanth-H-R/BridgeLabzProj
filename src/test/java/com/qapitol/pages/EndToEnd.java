package com.qapitol.pages;

import com.qapitol.base.BaseClass;
import com.qapitol.util.FileUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

public class EndToEnd extends BaseClass {
    public WebDriver driver;
    FileUtility utility=new FileUtility();
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));

    public EndToEnd(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void forminteraction() throws InterruptedException, IOException, AWTException {
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
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,280)");
        WebElement hobbieCheckBox=driver.findElement(By.cssSelector("input[id='hobbies-checkbox-1']"));
        actions.scrollToElement(hobbieCheckBox).pause(2000).build().perform();
        actions.moveToElement(hobbieCheckBox).click().perform();
    WebElement calendarPopup=driver.findElement(By.id("dateOfBirthInput"));
    actions.scrollToElement(calendarPopup).pause(2000).build().perform();
    calendarPopup.click();
    //wait.until(ExpectedConditions.elementToBeClickable(calendarPopup)).click();

    //actions.scrollByAmount(0,150).pause(2000).perform();

    WebElement monthDropDown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
    Select selectMonth=new Select(monthDropDown);
        Thread.sleep(2000);
    selectMonth.selectByVisibleText("September");
        Thread.sleep(2000);
    WebElement yearDropDown=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
    Select selectYear= new Select(yearDropDown);
    selectYear.selectByValue("1999");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--020')]")).click();
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@id='uploadPicture']")));

        // Copy the file path to the system clipboard

        Robot robot=new Robot();
        robot.delay(2000);
        StringSelection ss = new StringSelection("C:\\Users\\Qapitol QA\\Downloads\\Book.xlsx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        // simulate the key events to handle file upload pop-up

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
       actions.scrollToElement( driver.findElement(By.xpath("//button[@id='submit']"))).click().perform();
       Thread.sleep(2000);
  }
}
