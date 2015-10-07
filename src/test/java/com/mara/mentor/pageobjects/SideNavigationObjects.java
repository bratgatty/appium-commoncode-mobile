package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SideNavigationObjects {
	
	@AndroidFindBy(id="com.mara.maramentor:id/iv_user")
    public MobileElement PROFILEIMAGE;
	
	@AndroidFindBy(id="com.mara.maramentor:id/bt_logout")
    public MobileElement LOGOUTBTN;
	
	
	


}
