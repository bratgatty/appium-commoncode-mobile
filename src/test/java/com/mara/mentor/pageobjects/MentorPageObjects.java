package com.mara.mentor.pageobjects;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import java.util.List;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MentorPageObjects {
	
	//Mobile element for Mentor header text
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mentors']")   
	public MobileElement mentorHeader;
	
	//Mobile element for Mentor follow text
	@AndroidFindBy(xpath = "//android.widget.Button[@text='FOLLOW']")   
	public List<MobileElement> mentorFollowList;
	
	//Mobile element for Mentor follow/unfollow 
	@AndroidFindBy(xpath = "//android.widget.Button[@index='4']")   
	public List<MobileElement> mentorFollowUnfollowTextList;
	
	//Mobile element for following 
	@AndroidFindBy(xpath = "//android.widget.Button[@text='FOLLOWING']")   
	public List<MobileElement> mentorFollowingTextList;
	
	//Mobile element for username of mentor 
	@AndroidFindBy(id = "com.mara.maramentor:id/mentor_name_textview")   
	public List<MobileElement> mentorProfileNameTextList;
	
	//Mobile Element to get Mentor's Page Title
	@AndroidFindBy(name="Mentors")
    @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[4]")
     public MobileElement mentorPageTitle;
	
	//Mobile Element to get AdvanceSearch icon
	@AndroidFindBy(id="com.mara.maramentor:id/qa_action_search")
    @iOSFindBy(name="icn search")
     public MobileElement advanceSearchIcon;

	
}
