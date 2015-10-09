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

	WelcomePage welcomePage;
	HomePage homePage;
	ProfilePage profilePage;
	FollowersPage followersPage;
	FollowingPage followingPage;
	ActivityPage activityPage;
	
	@BeforeMethod(alwaysRun=true)
	//@BeforeClass(alwaysRun = true)
	public void startDriver() throws IOException {
        driver = Utils.getDriver();
	}
	
	@Test
	public void ValidSearch() throws IOException, InterruptedException{
		welcomePage = new WelcomePage(driver);
		HomePage homePage = welcomePage.waitforWelcomePage(driver)
                .clickonLogin(driver).waitforLoginPage(driver).enterValidCredentails(driver).waitforHomePage(driver).search(driver);
		}
		
		@AfterMethod(alwaysRun=true)    
		//@AfterClass(alwaysRun = true)
	    public void afterClass() {
	        driver.quit();
	}
}
