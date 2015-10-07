package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;


public class LoginPageObjects {

    public static final String RESOURCEID = "com.mara.maramentor:id/";

    @AndroidFindBy(id = RESOURCEID + "mobile_no_editext")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]")
    public MobileElement MOBILENUMBERFIELD;

    @AndroidFindBy(id = RESOURCEID + "pass_word_editext")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]")
    public MobileElement PASSWORDFIELD;

    @AndroidFindBy(id = RESOURCEID + "log_btn_logpage")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]")
    public MobileElement SIGNINBTN;

    @AndroidFindBy(id = RESOURCEID + "country_code_tv")
    public MobileElement COUNTRYCODE;

    @AndroidFindBy(name = "India")
    public MobileElement COUNTRYNAME;

    public static final String MOBILENUMBER = "9739739792";

    public static final String MOBILENUMBERiOS = "9964069506";

    public static final String PASSWORD = "aaa111";

    //Next screen object needs to be defined in the current screen when waitForPageToLoad method is called
    @AndroidFindBy(id = RESOURCEID + "action_search")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[5]")
    public MobileElement SEARCHBTN;

}
