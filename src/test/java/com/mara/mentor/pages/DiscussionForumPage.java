package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.mara.mentor.pageobjects.ComposePageObjects;
import com.mara.mentor.pageobjects.DiscussionForumPageObject;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DiscussionForumPage  extends AppiumTestBase 
{
	ComposePageObjects composePageObjects = new ComposePageObjects();

	DiscussionForumPageObject discussionForumPageObject = new DiscussionForumPageObject();

	public DiscussionForumPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), discussionForumPageObject);
	}
	
	//To verify DiscussionForum page displayed
	public String verifyDiscussionForumIsDisplayed()
	{
		return discussionForumPageObject.discussionForumPageTitle.getText();
	}

	
	public ComposePage composeButtonTap(AppiumDriver<MobileElement> driver)
		{
		    discussionForumPageObject.composeButton.click();
			return new ComposePage(driver);
		}
	
	
	  // To Verify Whether Post is Created Successfully
    public boolean isQuestionPosted()
	   {
    	
    	 //String actualValue=   discussionForumPageObject.questionHeading.getText();
    	  //actualValue.replaceAll("  ", " ");
    	   Reporter.log("Actual Value : "+discussionForumPageObject.questionHeading.getText().replaceAll("  ", " "),true);
    	
		    if(discussionForumPageObject.questionHeading.getText().replaceAll("  ", " ").contains(composePageObjects.hastags))
		{
			   Reporter.log("Question successfully created",true);
			   Reporter.log("Actual Value : "+discussionForumPageObject.questionHeading.getText(),true);
			   Reporter.log("Expected Value : "+composePageObjects.hastags,true);
			   return true;
		}
		    else
		{
			   Reporter.log("Question creation Failed",true);
			   Reporter.log("Actual Value : "+discussionForumPageObject.questionHeading.getText(),true);
			   Reporter.log("Expected Value : "+composePageObjects.hastags,true);
			   return false;
		 }
	   }
    
}
