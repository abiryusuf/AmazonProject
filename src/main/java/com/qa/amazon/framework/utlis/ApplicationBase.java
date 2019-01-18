package com.qa.amazon.framework.utlis;

import com.qa.amazon.framework.pages.AmazonHomePage;
import com.qa.amazon.framework.pages.AmazonLoginPage;
import org.openqa.selenium.WebDriver;

public class ApplicationBase {

    private WebDriver driver = null;
    private AmazonHomePage homePage;
    private AmazonLoginPage loginPage;

    public ApplicationBase(WebDriver driver) {
        this.driver = driver;
    }

    public AmazonHomePage homePage(){
        if (homePage==null){
            homePage=new AmazonHomePage(driver);
        }
        return homePage;
    }
    public AmazonLoginPage loginPage(){
        if (loginPage ==null){
            loginPage = new AmazonLoginPage(driver);
        }
        return loginPage;
    }
}
