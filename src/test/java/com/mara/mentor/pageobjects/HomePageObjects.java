package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;


/**
 * Created by maratest on 9/9/15.
 */
public class HomePageObjects {

    //public static final String RESOURCEID = "com.mara.maramentor:id/";


    @AndroidFindBy(id = "com.mara.maramentor:id/action_search")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[5]")
    public MobileElement SEARCHBTN;
    
    @AndroidFindBy(xpath="//android.widget.ImageButton[1]")
    @iOSFindBy(xpath = "//UIAButton[4]")
    public MobileElement SIDENAVIGATIONBTN;
    
    
    @AndroidFindBy(id = "com.mara.maramentor:id/search_view")
    //@iOSFindBy()
    public MobileElement searchTextField;
    
    @AndroidFindBy(id = "com.mara.maramentor:id/search")
    @iOSFindBy(name="name: icn search")
     public MobileElement searchIcon;
    
    
    public String searchtext="sharath";
    
    @AndroidFindBy(id = "com.mara.maramentor:id/action_compose")
    @iOSFindBy(name="icn compose")
    public MobileElement composeButton;
    
    
    @AndroidFindBy(id = "com.mara.maramentor:id/heading_textview")
    @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[6]")
    public MobileElement postHeading;
    
    
    
   


}
