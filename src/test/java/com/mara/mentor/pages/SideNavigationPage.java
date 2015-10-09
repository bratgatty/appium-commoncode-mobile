package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mara.mentor.pageobjects.SideNavigationObjects;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;



public class SideNavigationPage extends AppiumTestBase{
	
	SideNavigationObjects sideNavigationObjects = new SideNavigationObjects();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	public SideNavigationPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver,5,TimeUnit.SECONDS),sideNavigationObjects);
	}

	//Wait for Side navigation page appears
	public SideNavigationPage waitForSideNavaigationPage(AppiumDriver<MobileElement> driver)
	{
		waitForPageToLoad(driver, sideNavigationObjects.LOGOUTBTN);
		return new SideNavigationPage(driver);
	}
	
	//To click on Profile Image
	public ProfilePage tapProfile(AppiumDriver<MobileElement> driver)
	{
		sideNavigationObjects.PROFILEIMAGE.click();
		return new ProfilePage(driver);
	}
	
	
	  //Method to logout
    public WelcomePage logout(AppiumDriver<MobileElement> driver){
    	sideNavigationObjects.LOGOUTBTN.click();
		sideNavigationObjects.YESOKBTN.click();
    	return new WelcomePage(driver);
    	
    }
}
