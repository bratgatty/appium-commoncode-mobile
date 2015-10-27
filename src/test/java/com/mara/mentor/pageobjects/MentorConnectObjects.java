package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MentorConnectObjects {
	
	//Mobilelement for Mentor Connect Header
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Mentor Connect']")
	public MobileElement mentorConnectHeaderText;
	
	//Mobileelement for Connect with Mentor Button
	@AndroidFindBy(id="com.mara.maramentor:id/Ask_oneOnone")
	public MobileElement connectWithMentorButton;
	
	//Mobileelement for create request Button
	@AndroidFindBy(id="com.mara.maramentor:id/action_compose_one_on_one")
	public MobileElement composeRequestButton;
	
}
