package com.mara.mentor.tests;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mara.mentor.pages.HomePage;
import com.mara.mentor.pages.WelcomePage;
import com.mara.mentor.util.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SignupTest {
	public AppiumDriver<MobileElement> driver;

    //Create a welcomepage object
    WelcomePage welcomePage;

    @BeforeClass(alwaysRun = true)
    public void startDriver() throws IOException {
        driver = Utils.getDriver();
    }
    
    @Test(priority = 1)
    public void validSignUp() throws InterruptedException, IOException {
        welcomePage = new WelcomePage(driver);
        // this test will validate the following conditions
        // wait for WelcomePage to appear
        // click on the Login button
        // Wait for the Login screen to appear
        // Enter valid credentials and tap Sign In button
        // Wait and assert for the Home screen to be displayed
        HomePage homePage = welcomePage.waitforWelcomePage(driver)
                .clickonSignup(driver).waitforSignUpPage(driver).enterValidCredentails(driver).waitforHomePage(driver);
        AssertJUnit.assertTrue(homePage.verifySearchBtnDisplayed(driver));
    }
    
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
}
