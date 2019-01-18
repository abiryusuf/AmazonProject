package com.qa.amazon.framework.reporting;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;

public class ExtantManager {

    private static ExtentReports extent;

    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private static ExtantManager instance = null;

    private ExtantManager() {
    }
    /*A Singleton class in java can have only instant and hence all its methods and variable belong to just one instance.
     * Singleton class concept is useful for the situation when there is a need to limit the number of objects for a class*/

    public static ExtantManager getInstance() {
        if (instance == null) {
            instance = new ExtantManager();
        }
        return instance;
    }
    public ExtantManager init(String fileName){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Selenium Webdriver Report");
        htmlReporter.setAppendExisting(true);


        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setAnalysisStrategy(AnalysisStrategy.SUITE);

        return this;
    }

    public ExtentTest createParentTest(String name){
        ExtentTest parent = extent.createTest(name);
        parentTest.set(parent);
        return parent;
    }

    public ExtentTest createChildTest(String name, String description){
        ExtentTest child = parentTest.get().createNode(name,description);
        test.set(child);
        return child;
    }

    public void testSuccess(ITestResult result){
        test.get().pass("Test passed");
    }
    public void testFailure(ITestResult result){

        test.get().fail(result.getThrowable());
    }
    public void testSkipped(ITestResult result){

        test.get().skip(result.getThrowable());
    }

    public void log(String detail){
        test.get().log(Status.INFO,detail);
    }

    public void flush(){

        extent.flush();
    }
}
