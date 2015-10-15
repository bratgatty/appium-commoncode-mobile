package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mara.mentor.pageobjects.CommentPageObjects;
import com.mara.mentor.pageobjects.HomePageObjects;
import com.mara.mentor.util.AppFeed;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommentPage extends AppiumTestBase{

	HomePageObjects homePageObjects = new HomePageObjects();
	CommentPageObjects commentPageObjects = new CommentPageObjects();
	
	public CommentPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), commentPageObjects);
	}
	
	public boolean verifyPostButtonDisp(AppiumDriver<MobileElement> driver)
	{
		return commentPageObjects.postButton.isDisplayed();
	}
	
	public CommentPage addComment(AppiumDriver<MobileElement> driver) throws InterruptedException
	{
		commentPageObjects.addTextField.sendKeys(AppFeed.commentText);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		commentPageObjects.postButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//AppiumTestBase.waitForElement(driver, commentPageObjects.verifyAddedComment);
		Assert.assertEquals(AppFeed.commentText, commentPageObjects.verifyAddedComment.getText());
		return new CommentPage(driver);
	}
	
}
