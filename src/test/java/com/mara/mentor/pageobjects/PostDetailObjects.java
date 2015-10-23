package com.mara.mentor.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PostDetailObjects {
	
	//MobileElement for text heading
	@AndroidFindBy(id="com.mara.maramentor:id/viewall_button")
    public MobileElement textHeading;
	
	//MobileElement for Detail heading(Delete this)
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Detail']")
	public MobileElement detailHeading1;
	
	//MobileElement for Detail heading
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.mara.maramentor:id/mainNewsLayout']//android.widget.TextView[@resource-id='com.mara.maramentor:id/heading_textview']")
	public MobileElement detailHeading;
	
	
	//ID for MobileElement for add comment button
	@AndroidFindBy(id="com.mara.maramentor:id/add_comment_button")
	public MobileElement addCommentButton;
	
	//xpath for MobileElement for add comment button
	@AndroidFindBy(xpath="//android.widget.Button[@text='Add Comment']")
	public MobileElement addcommentButton;
	
	
	//xpath for MobileElement for view all button
	@AndroidFindBy(xpath="//android.widget.Button[@text='View All']")
	public MobileElement viewAllButton;
	
	
	//MobileElement for viewall button
    @AndroidFindBy(id="com.mara.maramentor:id/viewall_button")
    public MobileElement viewallButton;
    
    //Mobile element for comment icon on post detail page
    @AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.mara.maramentor:id/mainNewsLayout']//android.widget.ImageView[@resource-id='com.mara.maramentor:id/commentcount_imageview']")
    public MobileElement commentIconButton;
  
    

}
