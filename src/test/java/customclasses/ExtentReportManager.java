package customclasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.demoguru99.basepage.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.time.LocalDateTime;

public class ExtentReportManager extends BaseClass implements ITestListener {

    public ExtentSparkReporter sparkReporter; //Used for UI of the report
    public ExtentReports extent; //Used for populating common info on the report
    public ExtentTest test; //creating test case entries and update status of test methods in the reports


    public void onStart(ITestContext context) {
        String dateStamp = LocalDateTime.now().toString().replace(':', '-');
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/errorshots/testReort.html");
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("End to End");
        sparkReporter.config().setTheme(Theme.DARK);
        extent=new ExtentReports();
        extent.attachReporter(sparkReporter); //attaching the spark report to
        extent.setSystemInfo("browser", "chrome");
        extent.setSystemInfo("environment", "local");
        extent.setSystemInfo("Tester", "Jayanth");

    }

    public  void onTestSuccess(ITestResult result) {
        test=extent.createTest(result.getName()); //creates new entry in report
        test.log(Status.PASS,"Test case passed "+ result.getName());
    }

    public void onTestFailure(ITestResult result) {
        test=extent.createTest(result.getName());
        test.log(Status.FAIL,"Test case failed"+ result.getName());
        test.log(Status.FAIL, "Test case failed "+result.getThrowable());
        try {
            utility.screenSnap(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result) {
        test=extent.createTest(result.getName());
        test.log(Status.SKIP,"Test case skip "+ result.getName());
    }

    public void onFinish(ITestContext context) {
       extent.flush();
    }



}
