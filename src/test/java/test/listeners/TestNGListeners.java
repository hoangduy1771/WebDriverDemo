package test.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("********************** Test started " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("********************** Test successfully " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("********************** Test failed " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("********************** Test skipped " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("********************** Test failed on percentage  " + result.getName());
    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onFinish(ITestContext context) {
        System.out.println("********************** Test Completed " + context.getName());
    }
}
