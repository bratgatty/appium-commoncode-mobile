package com.mara.mentor.pages;

import com.mara.mentor.pageobjects.HomePageObjects;
import com.mara.mentor.pageobjects.SideNavigationObjects;
import com.mara.mentor.util.AppiumTestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


import java.util.concurrent.TimeUnit;

/**
 * Created by maratest on 9/9/15.
 */
public class HomePage extends AppiumTestBase {
    HomePageObjects homePageObjects = new HomePageObjects();
    SideNavigationObjects sideNavigationObjects = new SideNavigationObjects();

    public HomePage(AppiumDriver<MobileElement> driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver,5, TimeUnit.SECONDS),homePageObjects);
    }

    public boolean verifySearchBtnDisplayed(AppiumDriver<MobileElement> driver) throws InterruptedException {
        return homePageObjects.SEARCHBTN.isDisplayed();
    }
    
    //Method to tap on side navigation
    public SideNavigationPage sideNavigationTap(AppiumDriver<MobileElement> driver)
    {

    	homePageObjects.SIDENAVIGATIONBTN.click();
    	return new SideNavigationPage(driver);
    }
    
  


}
