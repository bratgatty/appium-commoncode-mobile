package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.mara.mentor.pageobjects.MentorPageObjects;
import com.mara.mentor.pageobjects.ProfilePageObjects;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MentorsPage extends AppiumTestBase {
	
	MentorPageObjects mentorPageObjects=new MentorPageObjects();
	ProfilePageObjects profilePageObjects = new ProfilePageObjects();
	
	public MentorsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), mentorPageObjects);
	}

	public boolean verifyMentorPage()
	{
		return mentorPageObjects.mentorHeader.isDisplayed();
	}
	
	public MentorsPage followTap() throws InterruptedException
	{
		if(mentorPageObjects.mentorFollowList.size()==0)
			Reporter.log("No followers displayed", true);
		else
		{
			for(int i=0; i<1; i++)
			{
				mentorPageObjects.mentorFollowList.get(i).click();
				Thread.sleep(5000);
				Assert.assertEquals(mentorPageObjects.mentorFollowUnfollowTextList.get(i).getText(), "FOLLOWING");
			}
		}
		return new MentorsPage(driver);
	}
	
	public MentorsPage unFollowTap() throws InterruptedException
	{
		if(mentorPageObjects.mentorFollowingTextList.size()==0)
			Reporter.log("All users are in unfollow state already, Please run other testcase :D", true);
		else
		{
			for(int i=0;i<mentorPageObjects.mentorFollowingTextList.size();i++)
			{
				mentorPageObjects.mentorFollowingTextList.get(i).click();
				Thread.sleep(5000);
				Assert.assertEquals(mentorPageObjects.mentorFollowUnfollowTextList.get(i).getText(), "FOLLOW");
			}
		}
		return new MentorsPage(driver);
	}
	
	public ProfilePage tapMentor() throws InterruptedException
	{
		if(mentorPageObjects.mentorProfileNameTextList.size()==0)
			Reporter.log("Numbers of Users"+mentorPageObjects.mentorProfileNameTextList.size(), true);
		else
		{
			for(int i=0;i<1;i++)
			{
				String userName = mentorPageObjects.mentorProfileNameTextList.get(i).getText();
				mentorPageObjects.mentorProfileNameTextList.get(i).click();
				Thread.sleep(5000);
				Assert.assertEquals(profilePageObjects.userName.getText(), userName);
			}
			
		}
		return new ProfilePage(driver);
	}
	
	
	
}
