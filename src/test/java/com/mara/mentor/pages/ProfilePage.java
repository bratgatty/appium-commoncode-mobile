package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.mara.mentor.pageobjects.ProfilePageObjects;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage extends AppiumTestBase{
	
	ProfilePageObjects profilePageObjects = new ProfilePageObjects();
	
	
	public ProfilePage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS),profilePageObjects);
	}
	
	//To verify profile page displayed
	public boolean verifyProfilePageDisplayed()
	{
		return profilePageObjects.PROFILEIMAGEICON.isDisplayed();
	}
	
	
	//To get number of followers and click on it
	public FollowersPage clickFollowers()
	{
		Reporter.log(profilePageObjects.NOOFFOLLOWERS.getText(), true);
		if(Integer.parseInt(profilePageObjects.NOOFFOLLOWERS.getText()) > 0)
		{
			profilePageObjects.NOOFFOLLOWERS.click();
			return new FollowersPage(driver);
		}
		else
		{
			// If there are no followers, then we need to return null because
			// we have pre-defined return types of clickFollowers method
			Reporter.log("No Followers for the user", true);
			return null;
		}

	}

	//To get number of following and click on it
	public FollowingPage clickFollowing()
	{
		Reporter.log(profilePageObjects.NOOFFOLLOWING.getText(), true);
		if(Integer.parseInt(profilePageObjects.NOOFFOLLOWING.getText()) > 0)
		{
			profilePageObjects.NOOFFOLLOWING.click();
			return new FollowingPage(driver);
		}

		else
		{
			Reporter.log("Following by Nobody", true);
			return null;
		}
	}


	//To get number of activity and click on it
	public ActivityPage clickActivity()
	{
		Reporter.log(profilePageObjects.NOOFACTIVITIES.getText(), true);
		if(Integer.parseInt(profilePageObjects.NOOFACTIVITIES.getText()) > 0)
		{
			profilePageObjects.NOOFACTIVITIES.click();
			return new ActivityPage(driver);
		}
		else
		{
			Reporter.log("No Activities by the User", true);
			return null;
		}

	}

}
