package com.mara.mentor.pageobjects;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ProfilePageObjects {
	
	@AndroidFindBy(id="com.mara.maramentor:id/iv_user")
	@iOSFindBy(id = "Profile")
	public MobileElement PROFILEIMAGEICON;
	
	//Webelement for Number of followers
	@AndroidFindBy(id="com.mara.maramentor:id/tv_no_of_followers")
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIAStaticText[2]")
	public MobileElement NOOFFOLLOWERS;

	@AndroidFindBy(id = "com.mara.maramentor:id/followers")
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIAButton[1]")
	public MobileElement FOLLOWERSBTN;


	@AndroidFindBy(id = "com.mara.maramentor:id/following")
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIAButton[2]")
	public MobileElement FOLLOWINGSBTN;

	@AndroidFindBy(id = "com.mara.maramentor:id/activity")
	@iOSFindBy(xpath = " //UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIAButton[3]")
	public MobileElement ACTIVITYBTN;

	
	//Webelement for Number of following
	@AndroidFindBy(id="com.mara.maramentor:id/tv_no_of_following")
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIAStaticText[4]")
	public MobileElement NOOFFOLLOWING;
	
	//Webelement for Number of activities
	@AndroidFindBy(id="com.mara.maramentor:id/tv_no_of_activity")
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIAStaticText[6]")
	public MobileElement NOOFACTIVITIES;
	
	//Webelement to get username
	@AndroidFindBy(id="com.mara.maramentor:id/tv_user_name")
	public MobileElement userName;
	
	//Webelement to get Profession/jobtitle
	@AndroidFindBy(id="com.mara.maramentor:id/tv_user_profession")
	public MobileElement jobTitle;
	
	//Webelement to get the Industry
	@AndroidFindBy(id="com.mara.maramentor:id/industry_name")
	public MobileElement getIndustry;
	
	//Webelement to get Country
	@AndroidFindBy(id="com.mara.maramentor:id/tv_place")
	public MobileElement getCountry;
	
	//Webelement to get About Me
	@AndroidFindBy(id="com.mara.maramentor:id/about_me_description_text")
	public MobileElement getAboutMe;
	
	//Webelement to get About Me
	//@AndroidFindBy(id="com.mara.maramentor:id/experience_list")
	//public MobileElement getExperience;
	
	//Webelement to get list of skills 
	@AndroidFindBy(xpath="//android.widget.LinearLayout[2]/android.widget.LinearLayout[2]//android.widget.TextView")
	public List<MobileElement> getSkillsList;
	
	//Webelement to get all experience
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]")
	public List<MobileElement> getExperienceList;
	
	//Webelement to get all experience
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id='com.mara.maramentor:id/experience_list']/android.widget.LinearLayout")
	public List<MobileElement> getExperienceList1;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id='com.mara.maramentor:id/experience_list']/android.widget.LinearLayout/android.widget.TextView")
	public List<MobileElement> getExperiencetest12;
	
	
	//Webelement to get each experience text
	//Webelement to get titleheading
	@AndroidFindBy(xpath=".//android.widget.TextView[@id='com.mara.maramentor:id/title_heading']")
	public List<MobileElement> getTitleHeadingExperience;
	
	//Webelement to get companyheading
	@AndroidFindBy(xpath=".//android.widget.TextView[@id='com.mara.maramentor:id/company_name']")
	public List<MobileElement> getCompanyHeadingExperience;
	
	//Webelement to get duration
	@AndroidFindBy(xpath=".//android.widget.TextView[@id='com.mara.maramentor:id/timeline']")
	public List<MobileElement> getDurationExperience;

	
	
	
}
