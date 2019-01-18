package com.qa.amazon.framework.utlis;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestNGScript {

    WebDriver driver = null;
    public ApplicationBase Amazon;

    private static final int DEFAULT_IMPLICITY_WAIT_TIME = 20;
    private static final int PAGE_LOAD_TIMEOUT = 20;

    public static Logger log = Logger.getLogger(TestNGScript.class);

    public WebDriver getX() {

        return driver;
    }

    @BeforeSuite
    public void beforeSuite() {

        System.out.println("******before suite will executes first*******");
    }

    @BeforeClass
    public void beforeClass() {

        System.out.println("This block executes before all test case");
    }

    @BeforeMethod
    @Parameters({"browserName"})
    public void setUp() {
        System.out.println("******This block executes before each test case********");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        log.info("lunching chrome");
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITY_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        driver.navigate().to("https://www.amazon.com/");
       log.info("navigate to homepage");
       log.info("Driver initialized");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("****This block excutes after each test case*******");
        driver.close();
        driver.quit();
    }

    @AfterClass
    public void afterClass() {

        System.out.println("This block executes after all test case");
    }

    @AfterSuite
    public void afterSuite() {

        System.out.println("after suite will executes last");
    }
    /*A Singleton class in java can have only instant and hence all its methods and variable belong
     * to just one instance.
     * Singleton class concept is useful for the situation when there is a need to limit the number of objects for a class*/

    public ApplicationBase Amazon() {
        if (Amazon == null) {
            Amazon = new ApplicationBase(driver);
        }
        return Amazon;
    }

}
