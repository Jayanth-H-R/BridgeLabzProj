package com.qapitol.base;

import com.qapitol.util.FileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {
public   WebDriver driver;

FileUtility fileUtils=new FileUtility();
   @BeforeMethod
    public   void configBeforeMethod() throws IOException {
    String browserName=fileUtils.readData("browser");
       if(browserName.equalsIgnoreCase("chrome")){
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
           driver.get(fileUtils.readData("url"));
       }else if(browserName.equalsIgnoreCase("edge")){
           WebDriverManager.edgedriver().setup();
           driver= new EdgeDriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
           driver.get(fileUtils.readData("url"));

       }



    }



    @AfterMethod
    public void configAfterMethod(){

       driver.manage().window().minimize();
        driver.quit();
    }
}
