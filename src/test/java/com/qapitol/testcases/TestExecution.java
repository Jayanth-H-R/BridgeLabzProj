package com.qapitol.testcases;

import com.qapitol.base.BaseClass;
import com.qapitol.pages.*;
import com.qapitol.util.ExcelUtility;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class TestExecution extends BaseClass {

    @Test(dataProviderClass = ExcelUtility.class, dataProvider = "readStringData")
    public void formFilling(Object firstN, Object secondN, Object number) throws InterruptedException, IOException {
        System.out.println(firstN+" "+secondN+" "+number);
        LoginPage log=new LoginPage(driver);
        log.forms();
        FormsPage fPage=new FormsPage(driver);
        fPage.practiceForm(firstN,secondN,number);

    }
    @Test
    public void formInteraction() throws InterruptedException, IOException, AWTException {
        LoginPage log=new LoginPage(driver);
        log.forms();
        EndToEnd toEnd=new EndToEnd(driver);
        toEnd.forminteraction();
    }

    @Test
    public void uploadPopUp() throws InterruptedException, AWTException {
        LoginPage log=new LoginPage(driver);
        log.elements();
        Elements ele=new Elements(driver);
        ele.UploadPopUp();

    }
@Test
    public void handlingAlerts() throws InterruptedException {
        LoginPage log=new LoginPage(driver);
        log.alerts();
        HandlingAlerts alerts=new HandlingAlerts(driver);
        alerts.alertsInteraction();
    }
}
