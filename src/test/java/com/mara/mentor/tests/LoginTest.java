package com.mara.mentor.tests;


import com.mara.mentor.pages.HomePage;
import com.mara.mentor.pages.LoginPage;
import com.mara.mentor.pages.WelcomePage;
import com.mara.mentor.util.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by maratest on 9/8/15.
 */
public class LoginTest {
    public AppiumDriver<MobileElement> driver;

    //Create a welcomepage object
    WelcomePage welcomePage;

    @BeforeClass(alwaysRun = true)
    public void startDriver() throws IOException {
        driver = Utils.getDriver();
    }

    @Test(priority = 1)
    public void validLogin() throws InterruptedException, IOException {
        welcomePage = new WelcomePage(driver);
        // this test will validate the following conditions
        // wait for WelcomePage to appear
        // click on the Login button
        // Wait for the Login screen to appear
        // Enter valid credentials and tap Sign In button
        // Wait and assert for the Home screen to be displayed
        HomePage homePage = welcomePage.waitforWelcomePage(driver)
                .clickonLogin(driver).waitforLoginPage(driver).enterValidCredentails(driver).waitforHomePage(driver);
        Assert.assertTrue(homePage.verifySearchBtnDisplayed(driver));
    }



    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }


}
