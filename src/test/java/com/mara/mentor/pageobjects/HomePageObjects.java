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
    public MobileElement SIDENAVIGATIONBTN;
}
