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
import com.mara.mentor.pages.WelcomePage;
import com.mara.mentor.util.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ProfilePageTest {
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
	public void FollowersClick() throws IOException, InterruptedException{
		welcomePage = new WelcomePage(driver);
		homePage = welcomePage.waitforWelcomePage(driver).clickonLogin(driver).waitforLoginPage(driver).enterValidCredentails(driver).waitforHomePage(driver);
		Assert.assertTrue(homePage.verifySearchBtnDisplayed(driver));
		profilePage = homePage.sideNavigationTap(driver).tapProfile(driver);
		Assert.assertTrue(profilePage.verifyProfilePageDisplayed());
		followersPage = profilePage.clickFollowers();
		Assert.assertTrue(followersPage.verifyFollowersDisplayed());
	}
	
	@Test
	public void FollowingClick() throws IOException, InterruptedException{
		welcomePage = new WelcomePage(driver);
		homePage = welcomePage.waitforWelcomePage(driver).clickonLogin(driver).waitforLoginPage(driver).enterValidCredentails(driver).waitforHomePage(driver);
		Assert.assertTrue(homePage.verifySearchBtnDisplayed(driver));
		profilePage = homePage.sideNavigationTap(driver).tapProfile(driver);
		Assert.assertTrue(profilePage.verifyProfilePageDisplayed());
		followingPage = profilePage.clickFollowing();
		Assert.assertTrue(followingPage.verifyFollowingDisplayed());
	}
	
	@Test
	public void ActivityClick() throws IOException, InterruptedException{
		welcomePage = new WelcomePage(driver);
		homePage = welcomePage.waitforWelcomePage(driver).clickonLogin(driver).waitforLoginPage(driver).enterValidCredentails(driver).waitforHomePage(driver);
		Assert.assertTrue(homePage.verifySearchBtnDisplayed(driver));
		profilePage = homePage.sideNavigationTap(driver).tapProfile(driver);
		Assert.assertTrue(profilePage.verifyProfilePageDisplayed());
		activityPage = profilePage.clickActivity();
		Assert.assertTrue(activityPage.verifyActivityDisplayed());
	}
    
	@AfterMethod(alwaysRun=true)    
	//@AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

}
