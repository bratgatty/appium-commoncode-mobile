package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;


/**
 * Created by maratest on 9/9/15.
 */
public class HomePageObjects {

    //public static final String RESOURCEID = "com.mara.maramentor:id/";

	//MobileElement for Searchbutton
    @AndroidFindBy(id = "com.mara.maramentor:id/action_search")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[5]")
    public MobileElement SEARCHBTN;
    
    //MobileElement for SideNavigation
    @AndroidFindBy(xpath="//android.widget.ImageButton[1]")
    public MobileElement SIDENAVIGATIONBTN;
    
    //MobileElement for first post commenticon
    @AndroidFindBy(id="com.mara.maramentor:id/commentcount_imageview")
    public MobileElement commentIcon;
    
    //MobileElement for second post commentIcon
    @AndroidFindBy(id="com.mara.maramentor:id/commentcount_imageview_bottom")
    public MobileElement commentIconBottom;
    
    //MobileElement for title heading
    @AndroidFindBy(id="com.mara.maramentor:id/heading_textview")
    public MobileElement postHeading;
    
    //MobileElement for comment count
    @AndroidFindBy(id="com.mara.maramentor:id/commentcount_textview")
    public MobileElement commentCount;
    
    
    
    
}
