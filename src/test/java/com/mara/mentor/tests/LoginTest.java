package com.mara.mentor.tests;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import com.mara.mentor.pages.HomePage;
import com.mara.mentor.pages.WelcomePage;
import com.mara.mentor.util.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

/**
 * Created by maratest on 9/8/15.
 */
public class LoginTest {
    public AppiumDriver<MobileElement> driver;

    //Create a welcomepage object
    WelcomePage welcomePage;
    HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void startDriver() throws IOException {
        driver = Utils.getDriver();


    }

    @Test(priority = 1)
    public void validLogin() throws InterruptedException, IOException {
        // Check if user is logged in .
        // if not run the login method and check the test case
        homePage = Utils.checkIfLoggedIn(driver);

    }
    
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }


}
