package com.demoguru99.pages;

import com.demoguru99.utility.FileUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ToolTipPage {
    public WebDriver driver;
    FileUtility fileUtility = new FileUtility();
    WebDriverWait waits ;
    Actions actions;


    public ToolTipPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waits=new WebDriverWait(driver, Duration.ofSeconds(8));
       actions= new Actions(driver);
    }

    @FindBy(linkText = "Tooltip")
    public WebElement toolTipOption;

   /* @FindBy(xpath = "//a[@ href=\"/release-notes\"]")
    public WebElement toolTipDownloadLink; */

    @FindBy(id = "download_now")
    public WebElement downloadToolTip;

    public String interAct() throws InterruptedException {
        Thread.sleep(3000);
        actions.scrollToElement(downloadToolTip).pause(3000).build().perform();
        actions.moveToElement(downloadToolTip).pause(2000).build().perform();
        String toolTipText = driver.findElement(By.xpath("//a[@ href=\"/release-notes\"]")).getText();
        System.out.println(toolTipText);

        return toolTipText;
    }



}
