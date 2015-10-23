package com.mara.mentor.tests;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mara.mentor.pageobjects.CommentPageObjects;
import com.mara.mentor.pages.CommentPage;
import com.mara.mentor.pages.HomePage;
import com.mara.mentor.pages.PostDetailPage;
import com.mara.mentor.pages.WelcomePage;
import com.mara.mentor.util.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
public class HomePageTest {
	
public AppiumDriver<MobileElement> driver;

	
	WelcomePage welcomePage;
	HomePage homePage;
	PostDetailPage postDetailPage;
	CommentPage commentPage;
	CommentPageObjects commentPageObjects;
	
	@BeforeMethod(alwaysRun=true)
	//@BeforeClass(alwaysRun = true)
	public void startDriver() throws IOException {
        driver = Utils.getDriver();
	}
	
	@Test
	public void test_AddComment() throws IOException, InterruptedException{
		welcomePage = new WelcomePage(driver);
		commentPageObjects = new CommentPageObjects();
		homePage = welcomePage.waitforWelcomePage(driver).clickonLogin(driver).waitforLoginPage(driver).enterValidCredentails(driver).waitforHomePage(driver);
		Assert.assertTrue(homePage.verifySearchBtnDisplayed(driver));
		postDetailPage = homePage.clickPost(driver);
		//Assert.assertTrue(postDetailPage.verifyPostDetailDisp(driver));
		commentPage = postDetailPage.clickCommentIcon();
		Assert.assertTrue(commentPage.verifyPostButtonDisp(driver));
		commentPage = commentPage.addComment(driver);
	}
	
	 @AfterClass(alwaysRun = true)
	 public void afterClass() {
		 driver.quit();
	    }


}
