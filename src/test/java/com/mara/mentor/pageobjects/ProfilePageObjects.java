package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ProfilePageObjects {
	
	@AndroidFindBy(id="com.mara.maramentor:id/iv_user")
	@iOSFindBy(id = "Profile")
	public MobileElement PROFILEIMAGEICON;
	
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

	
	@AndroidFindBy(id="com.mara.maramentor:id/tv_no_of_following")
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIAStaticText[4]")
	public MobileElement NOOFFOLLOWING;
	
	@AndroidFindBy(id="com.mara.maramentor:id/tv_no_of_activity")
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIAStaticText[6]")
	public MobileElement NOOFACTIVITIES;
	

}
