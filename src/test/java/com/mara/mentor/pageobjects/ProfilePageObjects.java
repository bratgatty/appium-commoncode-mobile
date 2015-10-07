package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfilePageObjects {
	
	@AndroidFindBy(id="com.mara.maramentor:id/iv_user")
	public MobileElement PROFILEIMAGEICON;
	
	@AndroidFindBy(id="com.mara.maramentor:id/tv_no_of_followers")
	public MobileElement NOOFFOLLOWERS;
	
	@AndroidFindBy(id="com.mara.maramentor:id/tv_no_of_following")
	public MobileElement NOOFFOLLOWING;
	
	@AndroidFindBy(id="com.mara.maramentor:id/tv_no_of_activity")
	public MobileElement NOOFACTIVITIES;
	

}
