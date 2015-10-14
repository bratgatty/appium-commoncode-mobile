package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class FollowingPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Following']")
	@iOSFindBy(id = "Following")
	public MobileElement FollowingScreenTitle;


	@AndroidFindBy(id="com.mara.maramentor:id/mentor_follow_button")
	public MobileElement FOLLOWBTN;



}
