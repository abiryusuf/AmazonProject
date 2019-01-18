package com.testNG;

import com.qa.amazon.framework.utlis.TestNGScript;
import org.testng.annotations.Test;

public class LoginTest extends TestNGScript{


    @Test(groups = {"funtional-test"},priority = 1)
    public void LoginTest(){
        Amazon().homePage().navigateToLogin();
        Amazon().loginPage().SignIn("mim2064@yahoo.com", "mim135786");
        Amazon().loginPage().verfityMyAccount("Hello");



    }
}
