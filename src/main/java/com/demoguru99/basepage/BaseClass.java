package com.demoguru99.basepage;

import com.demoguru99.utility.FileUtility;
import com.demoguru99.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;



public class BaseClass {
    public WebDriver driver;
    public  FileUtility fileUtils= new FileUtility();
    //public ActionsUtility actions=new ActionsUtility(driver);
    public Utility utility=new Utility(driver);

    public Logger logger= LogManager.getLogger(this.getClass());


    public void setUp() throws IOException, InterruptedException {
        String browserName = fileUtils.readData("browser");
        String envi = fileUtils.readData("environment");

        Properties props = System.getProperties();
        PropertyConfigurator.configure(props.getProperty("user.dir") + "//src//test//resources//log4j.properties");
        if (browserName.equalsIgnoreCase("chrome")) {
            if (envi.equalsIgnoreCase("remote")) {

                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setBrowserName(Browser.CHROME.browserName());
                driver = new RemoteWebDriver(new URL("http://192.168.2.76:4444/wd/hub"), dc);
                driver.manage().window().maximize();
                driver.get(fileUtils.readData("url"));
            } else if (envi.equalsIgnoreCase("local")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
                driver.get(fileUtils.readData("url"));
                Thread.sleep(2000);
            }


        } else if (browserName.equalsIgnoreCase("edge")) {
            if (envi.equalsIgnoreCase("remote")) {
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setBrowserName(Browser.EDGE.browserName());
                //@SuppressWarnings("deprecation")
                driver = new RemoteWebDriver(new URL("http://192.168.2.76:4444/wd/hub"), dc);
                driver.manage().window().maximize();
                driver.get(fileUtils.readData("url"));
            } else if (envi.equalsIgnoreCase("local")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
                driver.get(fileUtils.readData("url"));

            }
        }
    logger.info("Application Started");
    }

    public void termination(){
        driver.manage().window().minimize();
        driver.quit();
        logger.info("Application terminated");
    }

}
