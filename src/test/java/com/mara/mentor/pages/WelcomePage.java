package com.mara.mentor.pages;

import com.mara.mentor.pageobjects.LoginPageObjects;
import com.mara.mentor.pageobjects.WelcomePageObjects;
import com.mara.mentor.util.AppiumTestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by maratest on 9/8/15.
 */
public class WelcomePage extends AppiumTestBase {

    // create a welcomepageobject so that we can access all ids from the WelcomePageObjects class
    WelcomePageObjects welcomePageObjects = new WelcomePageObjects();

    public WelcomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        // This initElement method will create all mobile elements
        PageFactory.initElements(new AppiumFieldDecorator(driver,5, TimeUnit.SECONDS),welcomePageObjects);
    }


    // Once the application loads, wait for the Welcome screen to appear displaying Register and Login buttons
    public WelcomePage waitforWelcomePage(AppiumDriver<MobileElement> driver){
        waitForPageToLoad(driver,welcomePageObjects.LOGINBTN);
        return new WelcomePage(driver);
    }

    // click on the Login button
    public WelcomePage clickonLogin(AppiumDriver<MobileElement> driver){
        welcomePageObjects.LOGINBTN.click();
        return new WelcomePage(driver);
    }

    // wait for the Login screen to appear
    public LoginPage waitforLoginPage(AppiumDriver<MobileElement> driver) throws InterruptedException {
        Thread.sleep(5000);
        waitForPageToLoad(driver,welcomePageObjects.MOBILENUMBERFIELD);
        return new LoginPage(driver);

    }
    
    public boolean verifyLoginBtnDisplayed(AppiumDriver<MobileElement> driver){
        return welcomePageObjects.LOGINBTN.isDisplayed();
    }
}
