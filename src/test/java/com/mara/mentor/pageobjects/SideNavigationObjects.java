package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SideNavigationObjects {
	
	@AndroidFindBy(id="com.mara.maramentor:id/iv_user")
    @iOSFindBy(xpath = "//UIAButton[1]")
    public MobileElement PROFILEIMAGE;
	
	@AndroidFindBy(id="com.mara.maramentor:id/bt_logout")
    @iOSFindBy(accessibility = "LOGOUT")
    public MobileElement LOGOUTBTN;

    @AndroidFindBy(id="android:id/button1")
    @iOSFindBy(name = "YES")
    public MobileElement YESOKBTN;

    @AndroidFindBy(name="Discussion Forums")
    @iOSFindBy(name="Discussion Forums")
    public MobileElement discussionForumButton;
    
    @AndroidFindBy(name="Mentors")
    @iOSFindBy(name="Mentors")
    public MobileElement mentorsButton;
}
