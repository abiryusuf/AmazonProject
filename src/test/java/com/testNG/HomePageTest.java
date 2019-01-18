package com.testNG;

import com.qa.amazon.framework.utlis.TestNGScript;
import org.testng.annotations.Test;

public class HomePageTest extends TestNGScript {

    @Test
    public void homePageTest(){
        Amazon().homePage().navigateToLogin();
    }


}
