package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ActivityPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Activity']")
	@iOSFindBy(id="Activity")
	public MobileElement ACTIVITYSCREENTITLE;

	@AndroidFindBy(id="com.mara.maramentor:id/main_parent_lay")
	public MobileElement ACTIVITIESLIST;
}
