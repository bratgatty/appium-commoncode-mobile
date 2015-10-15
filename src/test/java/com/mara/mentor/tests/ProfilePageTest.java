package com.mara.mentor.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import com.mara.mentor.pages.ActivityPage;
import com.mara.mentor.pages.FollowersPage;
import com.mara.mentor.pages.FollowingPage;
import com.mara.mentor.pages.HomePage;
import com.mara.mentor.pages.ProfilePage;
import com.mara.mentor.util.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ProfilePageTest {
	public AppiumDriver<MobileElement> driver;
	HomePage homePage;
	ProfilePage profilePage;
	FollowersPage followersPage;
	FollowingPage followingPage;
	ActivityPage activityPage;
	
	@BeforeMethod(alwaysRun=true)
	public void startDriver() throws IOException, InterruptedException {
        driver = Utils.getDriver();

		// before every test is executed, call this method to login on android phones and
		// avoid logging in on ios if already loggedin
		homePage = Utils.checkIfLoggedIn(driver);

	}


	@Test
	public void FollowersClick() throws IOException, InterruptedException{
		profilePage = homePage.sideNavigationTap(driver).tapProfile(driver);
		Assert.assertTrue(profilePage.verifyProfilePageDisplayed());
		followersPage = profilePage.clickFollowers();
		if(followersPage!=null)
		{
			Assert.assertTrue(followersPage.verifyFollowersDisplayed());
		}

	}
	
	@Test
	public void FollowingClick() throws IOException, InterruptedException{
		profilePage = homePage.sideNavigationTap(driver).tapProfile(driver);
		Assert.assertTrue(profilePage.verifyProfilePageDisplayed());
		followingPage = profilePage.clickFollowing();
		if(followingPage!=null)
		{
			Assert.assertTrue(followingPage.verifyFollowingDisplayed());
		}

	}
	
	@Test
	public void ActivityClick() throws IOException, InterruptedException{
		profilePage = homePage.sideNavigationTap(driver).tapProfile(driver);
		Assert.assertTrue(profilePage.verifyProfilePageDisplayed());
		activityPage = profilePage.clickActivity();
		if(activityPage!=null)
		{
			Assert.assertTrue(activityPage.verifyActivityDisplayed());
		}

	}
	
	@Test
	public void test_GetUserDetails() throws IOException, InterruptedException
	{
		profilePage = homePage.sideNavigationTap(driver).tapProfile(driver);
		Assert.assertTrue(profilePage.verifyProfilePageDisplayed());
		profilePage = profilePage.getUserNameDetails();
		//Need to assert userdata with response got from API
	}
	
    
	@AfterMethod(alwaysRun=true)
    public void afterClass()
	{
        driver.quit();
    }

}
