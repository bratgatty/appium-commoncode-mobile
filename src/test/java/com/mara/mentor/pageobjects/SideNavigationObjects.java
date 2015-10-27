package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SideNavigationObjects {
	
	//MobileElement for profileimage
	@AndroidFindBy(id="com.mara.maramentor:id/iv_user")
    @iOSFindBy(xpath = "//UIAButton[1]")
    public MobileElement PROFILEIMAGE;
	
	//MobileElement for logout button
	@AndroidFindBy(id="com.mara.maramentor:id/bt_logout")
    @iOSFindBy(accessibility = "LOGOUT")
    public MobileElement LOGOUTBTN;

	//MobileElement for yes/ok button
    @AndroidFindBy(id="android:id/button1")
    @iOSFindBy(name = "YES")
    public MobileElement YESOKBTN;


    //MobileElement for mentor connect button
    @AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id='com.mara.maramentor:id/layout_left_menu']//android.widget.LinearLayout[3]//android.widget.TextView[@resource-id='com.mara.maramentor:id/tv_title']")
    public MobileElement MENTORCONNECTBTN;
    
    //Mobileelement for Discussion Forums 
    @AndroidFindBy(name="Discussion Forums")
    @iOSFindBy(name="Discussion Forums")
    public MobileElement discussionForumButton;
}
