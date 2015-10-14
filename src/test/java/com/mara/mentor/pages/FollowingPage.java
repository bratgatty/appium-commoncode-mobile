package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.mara.mentor.pageobjects.FollowingPageObjects;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FollowingPage extends AppiumTestBase{
	
	FollowingPageObjects followingPageObjects = new FollowingPageObjects();
	public FollowingPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), followingPageObjects);
	}
	
	public boolean verifyFollowingDisplayed()
	{
		return followingPageObjects.FollowingScreenTitle.isDisplayed();
	}
	
	

}
