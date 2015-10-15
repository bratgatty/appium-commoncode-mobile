package com.mara.mentor.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mara.mentor.pages.ActivityPage;
import com.mara.mentor.pages.FollowersPage;
import com.mara.mentor.pages.FollowingPage;
import com.mara.mentor.pages.HomePage;
import com.mara.mentor.pages.ProfilePage;
import com.mara.mentor.pages.WelcomePage;
import com.mara.mentor.util.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SearchTest
{
	public AppiumDriver<MobileElement> driver;

	HomePage homePage;

	
	@BeforeMethod(alwaysRun=true)
	public void startDriver() throws IOException,InterruptedException{
        driver = Utils.getDriver();
		// before every test is executed, call this method to login on android phones and
		// avoid logging in on ios if already loggedin
		homePage = Utils.checkIfLoggedIn(driver);
	}
	
	@Test
	public void ValidSearch() throws IOException, InterruptedException{
		homePage.search(driver);
		}
		
	@AfterMethod(alwaysRun=true)
	//@AfterClass(alwaysRun = true)
	public void afterClass()
	{
		driver.quit();
	}
}
