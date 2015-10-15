package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.mara.mentor.pageobjects.HomePageObjects;
import com.mara.mentor.pageobjects.PostDetailObjects;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PostDetailPage extends AppiumTestBase {
	
	PostDetailObjects postDetailObject = new PostDetailObjects();
	HomePageObjects homePageObjects = new HomePageObjects();
	HomePage homePage = new HomePage(driver);
	
	public PostDetailPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), postDetailObject);
	}
	
	//To verify post detail page
	public boolean verifyPostDetailDisp(AppiumDriver<MobileElement> driver)
	{
		return postDetailObject.detailHeading.isDisplayed();
	}
	
	//To add comment using comment icon
	public CommentPage clickCommentIcon()
	{
		postDetailObject.commentIconButton.click();
		return new CommentPage(driver);
	}
	
	//To add comment(Donot use)
	public CommentPage toAddComment()
	{
		if(Integer.parseInt(homePageObjects.commentCount.getText())==0)
		{
			Reporter.log("No previous comments to the post", true);
			homePage.clickPost(driver);
			//AppiumTestBase.waitForPageToLoad(driver, postDetailObject.detailHeading);
			Reporter.log("No previous comments to the post", true);
			postDetailObject.addcommentButton.click();
		}
		else
		{
			homePage.clickPost(driver);
			AppiumTestBase.waitForPageToLoad(driver, postDetailObject.detailHeading);
			Reporter.log("previous comments exists", true);
			postDetailObject.viewAllButton.click();
		}
		
		return new CommentPage(driver);
	}
	
	

}
