package qapitolkdd.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qapitolkdd.keyengine.KeyEngine;

import java.io.IOException;

public class TestExecut {
    public WebDriver driver;
KeyEngine keyEng;
    @BeforeMethod
    public void configBeforeMethod(){
        keyEng=new KeyEngine(driver);
    }
    @Test
    public void loginTest() throws IOException {
        String pathFile="./src/test/resources/KDDBook.xlsx";
       keyEng.service(pathFile);
    }

    @AfterMethod
    public void configAfterMethod(){
    keyEng.termination();
    }
}
