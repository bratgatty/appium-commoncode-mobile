package com.mara.mentor.tests;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import com.mara.mentor.pages.HomePage;
import com.mara.mentor.pages.WelcomePage;
import com.mara.mentor.util.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

import java.io.IOException;

/**
 * Created by maratest on 9/8/15.
 */
public class LogoutTest {
    public AppiumDriver<MobileElement> driver;

    //Create a welcomepage object
    WelcomePage welcomePage;
    HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void startDriver() throws IOException {
        driver = Utils.getDriver();
    }

    @Test(priority = 1)
    public void logout() throws InterruptedException, IOException {


        ///***********Need to write a logic to check if the user is already logged in.
        // If not, then go ahead and login else skip the below code***************

        welcomePage = new WelcomePage(driver);
        homePage = new HomePage(driver);
        // this test will validate the following conditions
        // wait for WelcomePage to appear
        // click on the Login button
        // Wait for the Login screen to appear
        // Enter valid credentials and tap Sign In button
        // Wait and assert for the Home screen to be displayed
        homePage = welcomePage.waitforWelcomePage(driver).
                clickonLogin(driver).waitforLoginPage(driver).enterValidCredentails(driver).waitforHomePage(driver);
        Assert.assertTrue(homePage.verifySearchBtnDisplayed(driver));

        //To logout
        //Wait for welcomepage to appear
        welcomePage = homePage.sideNavigationTap(driver)
                .waitForSideNavaigationPage(driver).logout(driver).waitforWelcomePage(driver);
        Assert.assertTrue(welcomePage.verifyLoginBtnDisplayed(driver));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }


}
