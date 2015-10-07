package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.mara.mentor.pageobjects.ActivityPageObjects;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ActivityPage extends AppiumTestBase {
	ActivityPageObjects activityPageObjects = new ActivityPageObjects();
	
	public ActivityPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), activityPageObjects);
	}
	
	public boolean verifyActivityDisplayed()
	{
		return activityPageObjects.ACTIVITIESLIST.isDisplayed();
	}
	

}
