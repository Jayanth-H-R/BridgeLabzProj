package com.qapitol.testcases;

import com.qapitol.base.BaseClass;
import com.qapitol.pages.FormsPage;
import com.qapitol.pages.LoginPage;
import com.qapitol.util.ExcelUtility;
import org.testng.annotations.Test;

public class TestExecution extends BaseClass {

    @Test(dataProviderClass = ExcelUtility.class, dataProvider = "readStringData")
    public void formFilling(Object firstN, Object secondN, Object number) throws InterruptedException {
        System.out.println(firstN+" "+secondN+" "+number);
        LoginPage log=new LoginPage(driver);
        log.forms();
        FormsPage fPage=new FormsPage(driver);
        fPage.practiceForm(firstN,secondN,number);

    }
}
