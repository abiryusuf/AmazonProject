package com.qa.amazon.framework.utlis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CrossBrowserScript {

    private WebDriver driver = null;
    private ApplicationBase Amazon;

    private static final int DEFAULT_IMPLICITY_WAIT_TIME = 20;
    private static final int PAGE_LOAD_TIMEOUT = 20;

    @BeforeSuite
    public void beforeSiute(){
        System.out.println("********Before Suite Beging the test execute ****** ");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("*******This block executes before all test case only one once*****");
    }
    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("ch") String browser)throws Exception{
        if (browser.contentEquals("ch")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir" + "\\driver\\chromedriver.exe"));
            driver=new ChromeDriver();
        }else if (browser.contentEquals("ff")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
            driver=new FirefoxDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITY_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/");
       // log.info("navigate to homepage");
       // log.info("Driver initialized");


    } @AfterMethod
    public void tearDown() {
        System.out.println("****This block excutes after each test case*******");
        driver.close();
        driver.quit();
    }


    @AfterClass
    public void afterClass(){
        System.out.println("*****This block execute after all test once******");
    }




    @AfterSuite
    public void afterSuite(){
        System.out.println("*****After Suite End the test execute**********");
}
public ApplicationBase Amazon(){
        if (Amazon==null){
            Amazon=new ApplicationBase(driver);
        }
        return Amazon;
}
}