package pankajpak.TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import pankajpak.resources.ExtentRepoterNG;

import java.io.IOException;

public class Listeners extends BaseTest  implements ITestListener {
    ExtentTest test;
    ExtentReports extent= ExtentRepoterNG.getObjectReport();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();//prevention from parralel test case running error



    @Override
    public void onTestStart(ITestResult result){
        test =  extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);//it create unique thread id
    }
    @Override
    public void onTestSuccess(ITestResult result){
        extentTest.get().log(Status.PASS,"Test Pass");

    }
    @Override
    public void onTestFailure(ITestResult result){

        extentTest.get().fail(result.getThrowable());


        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        String filePath = null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }
    @Override
    public void onFinish(ITestContext context){
        extent.flush();

    }



}
