package pankajpak.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRepoterNG {


    public static  ExtentReports getObjectReport(){
        String path = System.getProperty("user.dir")+"/report/index.HTML";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("web Automation result");
        reporter.config().setDocumentTitle("Test Result");

       ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Pankaj");
        return extent;


    }

}
