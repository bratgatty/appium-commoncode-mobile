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
    public void startDriver() throws IOException,InterruptedException {
        driver = Utils.getDriver();
        homePage = Utils.checkIfLoggedIn(driver);
    }

    @Test(priority = 1)
    public void logout() throws InterruptedException, IOException {

        //To logout
        welcomePage = homePage.sideNavigationTap(driver)
                .waitForSideNavaigationPage(driver).logout(driver).waitforWelcomePage(driver);
        Assert.assertTrue(welcomePage.verifyLoginBtnDisplayed(driver));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }


}
