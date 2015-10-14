package com.mara.mentor.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mara.mentor.pageobjects.ComposePageObjects;
import com.mara.mentor.pageobjects.HomePageObjects;
import com.mara.mentor.pages.ActivityPage;
import com.mara.mentor.pages.ComposePage;
import com.mara.mentor.pages.FollowersPage;
import com.mara.mentor.pages.FollowingPage;
import com.mara.mentor.pages.HomePage;
import com.mara.mentor.pages.ProfilePage;
import com.mara.mentor.pages.WelcomePage;
import com.mara.mentor.util.AppiumTestBase;
import com.mara.mentor.util.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ComposeTest 
{
	public AppiumDriver<MobileElement> driver;
	
	WelcomePage welcomePage;
	HomePage homePage;
	ComposePage composePage;
	ProfilePage profilePage;
	FollowersPage followersPage;
	FollowingPage followingPage;
	ActivityPage activityPage;
	HomePageObjects hmp;
	ComposePageObjects com;
	
	@BeforeMethod(alwaysRun=true)
	//@BeforeClass(alwaysRun = true)
	public void startDriver() throws IOException, InterruptedException {
        driver = Utils.getDriver();
	}
	
	@Test
	  public void composeTest() throws IOException, InterruptedException{
		welcomePage = new WelcomePage(driver);
		homePage = welcomePage.waitforWelcomePage(driver).clickonLogin(driver).waitforLoginPage(driver).enterValidCredentails(driver).waitforHomePage(driver);
		Assert.assertTrue(homePage.verifySearchBtnDisplayed(driver));
	    
		composePage=homePage.composeButtonTap(driver);
		Assert.assertTrue(composePage.verifyComposePageDisplayed());
		 homePage=composePage.composePost();
	     Assert.assertTrue(homePage.isPosted());
		}



  @Test
    public void composeImageTest() throws IOException, InterruptedException{
	welcomePage = new WelcomePage(driver);
	homePage = welcomePage.waitforWelcomePage(driver).clickonLogin(driver).waitforLoginPage(driver).enterValidCredentails(driver).waitforHomePage(driver);
	Assert.assertTrue(homePage.verifySearchBtnDisplayed(driver));
	composePage=homePage.composeButtonTap(driver);
	Assert.assertTrue(composePage.verifyComposePageDisplayed());
	 homePage=composePage.composeImagePost();
	 Assert.assertTrue(homePage.isPosted());
	}



   @Test
   public void composeVideoTest() throws IOException, InterruptedException{
	welcomePage = new WelcomePage(driver);
	homePage = welcomePage.waitforWelcomePage(driver).clickonLogin(driver).waitforLoginPage(driver).enterValidCredentails(driver).waitforHomePage(driver);
	Assert.assertTrue(homePage.verifySearchBtnDisplayed(driver));
	composePage=homePage.composeButtonTap(driver);
	Assert.assertTrue(composePage.verifyComposePageDisplayed());
	 homePage=composePage.composeVideoPost();
	Assert.assertTrue(homePage.isPosted());
	}
   
   
   
   @AfterMethod(alwaysRun=true)    
	//@AfterClass(alwaysRun = true)
   public void afterClass() {
       driver.quit();
   }
}
