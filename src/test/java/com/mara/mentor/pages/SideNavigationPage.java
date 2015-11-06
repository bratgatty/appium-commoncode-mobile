package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mara.mentor.pageobjects.SideNavigationObjects;
import com.mara.mentor.util.AppiumTestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SideNavigationPage extends AppiumTestBase{
	
	SideNavigationObjects sideNavigationObjects = new SideNavigationObjects();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	public SideNavigationPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver,5,TimeUnit.SECONDS),sideNavigationObjects);
	}

	//Wait for Side navigation page appears
	public SideNavigationPage waitForSideNavaigationPage(AppiumDriver<MobileElement> driver)
	{
		waitForPageToLoad(driver, sideNavigationObjects.LOGOUTBTN);
		return new SideNavigationPage(driver);
	}
	
	//To click on Profile Image
	public ProfilePage tapProfile(AppiumDriver<MobileElement> driver)
	{
		sideNavigationObjects.PROFILEIMAGE.click();
		return new ProfilePage(driver);
	}
	
	//To click on Mentor One to One
	public MentorConnectPage tapMentorOnetoOne(AppiumDriver<MobileElement> driver)
	{
		sideNavigationObjects.MENTORCONNECTBTN.click();
		return new MentorConnectPage(driver);
	}
	
	//To click on Mentors 
	public MentorsPage tapMentors(AppiumDriver<MobileElement> driver)
	{
		sideNavigationObjects.mentorsButton.click();
		return new MentorsPage(driver);
	}
	
	  //Method to logout
    public WelcomePage logout(AppiumDriver<MobileElement> driver){
    	sideNavigationObjects.LOGOUTBTN.click();
		sideNavigationObjects.YESOKBTN.click();
    	return new WelcomePage(driver);
    }

    //To click on mentors button	
	  public MentorPage mentorsTap(AppiumDriver<MobileElement> driver){
     	sideNavigationObjects.mentorsButton.click();
     	return new MentorPage(driver);
	  }

    //To click on DiscussionForum 
    public DiscussionForumPage discussionForumTap(AppiumDriver<MobileElement> driver){
    	sideNavigationObjects.discussionForumButton.click();
    	return new DiscussionForumPage(driver);

    	
    }
}
