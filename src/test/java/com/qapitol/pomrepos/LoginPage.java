package com.qapitol.pomrepos;

import com.qapitol.generic.BaseClass;
import com.qapitol.utility.FileUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class LoginPage extends BaseClass {
    WebDriver driver;
    FileUtility fileUtility=new FileUtility();
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

   /* @FindBy(xpath = "//span[text()='✕']")
    public WebElement closePopUp;*/

    @FindBy(xpath = "//input[contains(@title,'Search for Products')]")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='KzDlHZ']")
    public List<WebElement> searchResults;

    public void searchContextInteraction() throws IOException {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        searchBox.sendKeys(fileUtility.readData("searchvalidation"));
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        for(WebElement e:searchResults){
            String text= e.getText();
            Assert.assertTrue(text.contains(fileUtility.readData("searchvalidation")),"Results are not valid " +text);

        }
    }


}
