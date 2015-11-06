package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.mara.mentor.pageobjects.AdvanceSearchPageObjects;
import com.mara.mentor.pageobjects.MentorPageObjects;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MentorPage extends AppiumTestBase 
{
        MentorPageObjects  mentorPageObjects= new MentorPageObjects(); 
       AdvanceSearchPageObjects advanceSearchPageObjects= new AdvanceSearchPageObjects();
   //     AdvanceSearchPage advanceSearchPage= new AdvanceSearchPage(driver);
        
        
	   public MentorPage(AppiumDriver<MobileElement> driver)
	    {
	        super(driver);
	        PageFactory.initElements(new AppiumFieldDecorator(driver,5, TimeUnit.SECONDS),mentorPageObjects);
	    }
	   
	   
	   
	 //To verify MentorsPage displayed
		public boolean verifyMentorsPageIsDisplayed()	
		{
						
			if(mentorPageObjects.mentorPageTitle.getText().equals("Mentors") || mentorPageObjects.mentorPageTitle.isDisplayed())
			{
				Reporter.log("Page Title : "+mentorPageObjects.mentorPageTitle.getText(),true);
			    return true;  
			}
			else
			{
				Reporter.log("Expected Page Title : Mentors");
				Reporter.log("Actual Page Title : "+mentorPageObjects.mentorPageTitle.getText(),true);
				return false;
			}
		}
	   
	   
		//Tapping on SearchIcon on advance search Page
		public AdvanceSearchPage advanceSearchButtonTap()
		{
				
			mentorPageObjects.advanceSearchIcon.click();
			return new AdvanceSearchPage(driver);
		}
	   

	   
	   
	   
	   
}
