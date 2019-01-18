package com.qa.amazon.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

    private WebDriver driver =null;

 //Constructor
    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement SignInLink;

    public void navigateToLogin(){
        SignInLink.click();
    }
}


