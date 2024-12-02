package customclasses;

import com.demoguru99.basepage.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class CustomListeners extends BaseClass implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        // Log or perform any pre-test actions
        Reporter.log("Test Started: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        Reporter.log("Test Passed: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        try {
            utility.screenSnap(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result) {
        try {
            utility.screenSnap(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
