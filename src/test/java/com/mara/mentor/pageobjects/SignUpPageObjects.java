package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SignUpPageObjects {
	    public static final String RESOURCEID = "com.mara.maramentor:id/";

	    @AndroidFindBy(id = RESOURCEID + "country_code_tv")
	    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")
	    public static MobileElement COUNTRYCODE;
	    
	    @AndroidFindBy(name = "Algeria")
	    public static MobileElement COUNTRYNAME;
	    
	    @AndroidFindBy(id = RESOURCEID + "mobile_text_tv")
	    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]")
	    public MobileElement MOBILENUMBERFIELD;
	    
	    @AndroidFindBy(id = "com.mara.maramentor:id/password_editext")
	    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]")
	    public MobileElement PWD;
	    
	    @AndroidFindBy(id = RESOURCEID + "mEdt_confirm_pass")
	    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[2]")
	    public MobileElement CONFIRMPWDFIELD;
	    
	    @AndroidFindBy(id = RESOURCEID + "name_editext")
	    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[3]")
	    public MobileElement FIRSTNAME;
	    
	    @AndroidFindBy(id = RESOURCEID + "lastname_editext")
	    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[4]")
	    public MobileElement LASTNAME ;

	    @AndroidFindBy(id = "industry_autocompletetv")
	    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]")
	    public MobileElement INDUSTRY;
	    
	    @AndroidFindBy(name = "Agriculture")
	    @iOSFindBy(name = "Agriculture")
	    public static MobileElement IND;
	   
	    @AndroidFindBy(id = RESOURCEID + "heard_about_us_spinner")
	    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[5]")
	    public MobileElement WHEREDIDYOUHEAR;
	    
	    @AndroidFindBy(name = "Campaign")
	    @iOSFindBy(xpath = "Campaign")
	    public static MobileElement HEAR;
	   
	    @AndroidFindBy(id = RESOURCEID + "sign_up_btn")
	    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]")
	    public MobileElement SIGNUPBTN;
	    
	    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]")
	    public MobileElement CONTINUE;

	    @AndroidFindBy(id = RESOURCEID + "next")
	    @iOSFindBy(name = "NEXT")
	    public MobileElement NEXTBTN;

	    @AndroidFindBy(id = RESOURCEID + "skip_tv")
	    @iOSFindBy(xpath ="//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	    public MobileElement SKIP;
	   
	    public static final String PASSWORD = "mara@123";
	    
	    public static final String FNAME = "Meghana";

	    public static final String LNAME = "Automation";
	    
	    //Next screen object needs to be defined in the current screen when waitForPageToLoad method is called
	    @AndroidFindBy(id = RESOURCEID + "action_search")
	    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[5]")
	    public MobileElement SEARCHBTN;


}
