package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class DiscussionForumPageObject
{
	
	@AndroidFindBy(id = "com.mara.maramentor:id/action_compose")
	@iOSFindBy(name="icn compose")
    public MobileElement composeButton;

	
	@AndroidFindBy(name ="Discussion Forums")
    @iOSFindBy(name="Discussion Forums")
    public MobileElement discussionForumPageTitle;
	
	@AndroidFindBy(id = "com.mara.maramentor:id/qa_heading_textview")
    @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIATextView[1]")
    public MobileElement questionHeading;
	
	
	
}
