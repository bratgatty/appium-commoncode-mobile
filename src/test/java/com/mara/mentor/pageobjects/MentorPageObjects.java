package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MentorPageObjects
{
	
	
	//Mobile Element to get Mentor's Page Title
	@AndroidFindBy(name="Mentors")
    @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[4]")
     public MobileElement mentorPageTitle;
	
	//Mobile Element to get AdvanceSearch icon
	@AndroidFindBy(id="com.mara.maramentor:id/qa_action_search")
    @iOSFindBy(name="icn search")
     public MobileElement advanceSearchIcon;
	
	
																					
	
	
}
