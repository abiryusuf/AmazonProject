package com.qa.amazon.framework.pages;

import com.qa.amazon.framework.utlis.TestNGScript;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AmazonLoginPage {

    WebDriver driver = null;

    public static Logger log = Logger.getLogger(TestNGScript.class);

    public AmazonLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

  /*  public void loging(){
        WebElement element = driver.findElement(By.xpath("//input[@type='email']"));
        element.sendKeys();
    }*/

    @FindBy(xpath = "//input[@type='email']")
    protected WebElement EmailId;

    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    protected WebElement Password;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    protected WebElement signIn;


    public void SignIn(String UserId, String password) {
        EmailId.sendKeys(UserId);
        Password.sendKeys(password);
        signIn.click();

    }
    public void verfityMyAccount(String accountName){
        WebElement ele=driver.findElement(By.xpath("//span[@class='nav-line-1']"));
       String actualText= ele.getText();
        Assert.assertEquals(accountName, actualText);
        log.info("Hello");

    }
}