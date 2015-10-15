package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CommentPageObjects {
	
	
//	Comment text
	public static String commentText = "Adding new comment";

	//MobileElement for Post button
	@AndroidFindBy(id="com.mara.maramentor:id/send_comment")
	public MobileElement postButton;
	
	//MobileElement for addtext field
	@AndroidFindBy(id="com.mara.maramentor:id/comment_content_editext")
	public MobileElement addTextField;
	
	//MobileElement for addtext field
	@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@resource-id='com.mara.maramentor:id/recycler_view']//android.widget.RelativeLayout[1]//android.widget.TextView[@resource-id='com.mara.maramentor:id/comment_textview']")
	public MobileElement verifyAddedComment;
	
	
}
