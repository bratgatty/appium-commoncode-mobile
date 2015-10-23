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
import com.mara.mentor.pages.DiscussionForumPage;
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
	DiscussionForumPage discussionForumPage;
	
	@BeforeMethod(alwaysRun=true)
	//@BeforeClass(alwaysRun = true)
	public void startDriver() throws IOException, InterruptedException {
        driver = Utils.getDriver();
    	// before every test is executed, call this method to login on android phones and
		// avoid logging in on ios if already loggedin
		homePage = Utils.checkIfLoggedIn(driver);

	}
	
	@Test
	  public void composeTest() throws IOException, InterruptedException{
		composePage=homePage.composeButtonTap(driver);
		Assert.assertTrue(composePage.verifyComposePageDisplayed());
		 homePage=composePage.composePost();
	     Assert.assertTrue(homePage.isPosted());
		}



//  @Test
//    public void composeImageTest() throws IOException, InterruptedException{
//	composePage=homePage.composeButtonTap(driver);
//	Assert.assertTrue(composePage.verifyComposePageDisplayed());
//	 homePage=composePage.composeImagePost();
//	 Assert.assertTrue(homePage.isPosted());
//	}



   @Test
   public void composeVideoTest() throws IOException, InterruptedException{
	composePage=homePage.composeButtonTap(driver);
	Assert.assertTrue(composePage.verifyComposePageDisplayed());
	 homePage=composePage.composeVideoPost();
	Assert.assertTrue(homePage.isPosted());
	}

   
	@Test
	public void composeQuestionTest() throws InterruptedException
	{
		   discussionForumPage = homePage.sideNavigationTap(driver)
         .waitForSideNavaigationPage(driver).discussionForumTap(driver);
         Assert.assertEquals(discussionForumPage.verifyDiscussionForumIsDisplayed(),"Discussion Forums");
          composePage=discussionForumPage.composeButtonTap(driver);
         Assert.assertTrue(composePage.verifyComposePageDisplayed());
        discussionForumPage = composePage.composeQuestion();
        Assert.assertTrue(discussionForumPage.isQuestionPosted());
      
	}
	
//	@Test
//	public void composeImageQuestionTest() throws InterruptedException
//	{
//		   discussionForumPage = homePage.sideNavigationTap(driver)
//         .waitForSideNavaigationPage(driver).discussionForumTap(driver);
//         Assert.assertEquals(discussionForumPage.verifyDiscussionForumIsDisplayed(),"Discussion Forums");
//          composePage=discussionForumPage.composeButtonTap(driver);
//         Assert.assertTrue(composePage.verifyComposePageDisplayed());
//        discussionForumPage = composePage.composeImageQuestion();
//        Assert.assertTrue(discussionForumPage.isQuestionPosted());
//  	}

//	@Test
//	public void composeCameraImageQuestionTest() throws InterruptedException
//	{
//		   discussionForumPage = homePage.sideNavigationTap(driver)
//         .waitForSideNavaigationPage(driver).discussionForumTap(driver);
//         Assert.assertEquals(discussionForumPage.verifyDiscussionForumIsDisplayed(),"Discussion Forums");
//          composePage=discussionForumPage.composeButtonTap(driver);
//         Assert.assertTrue(composePage.verifyComposePageDisplayed());
//        discussionForumPage = composePage.composeCameraImageQuestion();
//        Assert.assertTrue(discussionForumPage.isQuestionPosted());
//   	}
	
	
	@Test
	public void composeVideoQuestionTest() throws InterruptedException
	{
		   discussionForumPage = homePage.sideNavigationTap(driver)
         .waitForSideNavaigationPage(driver).
         
         discussionForumTap(driver);
         Assert.assertEquals(discussionForumPage.verifyDiscussionForumIsDisplayed(),"Discussion Forums");
          composePage=discussionForumPage.composeButtonTap(driver);
         Assert.assertTrue(composePage.verifyComposePageDisplayed());
        discussionForumPage = composePage.composeVideoUrlQuestion();
        Assert.assertTrue(discussionForumPage.isQuestionPosted());
      
	}
	
	
	
	
   
   @AfterMethod(alwaysRun=true)    
	//@AfterClass(alwaysRun = true)
   public void afterClass() throws InterruptedException 
   {
	   Thread.sleep(3000);
	   homePage.sideNavigationTap(driver).waitForSideNavaigationPage(driver).logout(driver).waitforWelcomePage(driver);
	   Thread.sleep(2000);
       driver.quit();
   }
}
