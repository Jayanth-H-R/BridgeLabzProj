package com.demoguru99.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utility {
    WebDriver driver;

    public  Utility(WebDriver driver){
        this.driver=driver;
    }
    public void screenSnap(String snapName) throws IOException {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File temp = ts.getScreenshotAs(OutputType.FILE).getAbsoluteFile();
            File perm = new File("./src/main/resources/errorshots/" + snapName + ".png");
            FileUtils.copyFile(temp, perm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
