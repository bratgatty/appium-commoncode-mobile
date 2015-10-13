package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.mara.mentor.pageobjects.FollowersPageObjects;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FollowersPage extends AppiumTestBase {
	
	FollowersPageObjects followersPageObjects = new FollowersPageObjects();
	public FollowersPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), followersPageObjects);
	}
	
	public boolean verifyFollowersDisplayed()
	{
		return followersPageObjects.FollowersScreenTitle.isDisplayed();
	}
	
	
}
