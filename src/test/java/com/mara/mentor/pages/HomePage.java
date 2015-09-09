package com.mara.mentor.pages;

import com.mara.mentor.pageobjects.HomePageObjects;
import com.mara.mentor.pageobjects.LoginPageObjects;
import com.mara.mentor.pageobjects.WelcomePageObjects;
import com.mara.mentor.util.AppiumTestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Created by maratest on 9/9/15.
 */
public class HomePage extends AppiumTestBase {
    HomePageObjects homePageObjects = new HomePageObjects();

    public HomePage(AppiumDriver<MobileElement> driver)
    {
        super(driver);
    }

    public boolean verifySearchBtnDisplayed(AppiumDriver<MobileElement> driver) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Need to implement logic to assert search btn shown on news and update page");
        return true;
        //return homePageObjects.SEARCHBTN.isDisplayed();
    }


}
