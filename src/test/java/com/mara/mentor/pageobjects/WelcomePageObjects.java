package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WelcomePageObjects {


    public static final String RESOURCEID = "com.mara.maramentor:id/";

    @AndroidFindBy(id = RESOURCEID + "login_btn")
    @iOSFindBy(name = "LOG IN")
    public MobileElement LOGINBTN;

	 @AndroidFindBy(id = RESOURCEID + "siginup_btn")
	 @iOSFindBy(name = "SIGN UP")
	  public MobileElement SIGNUPBTN;
	 
    // Next screen object needs to be defined in the current screen when waitForPageToLoad method is called
    @AndroidFindBy(id = RESOURCEID + "mobile_no_editext")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]")
    public MobileElement MOBILENUMBERFIELD;



}
