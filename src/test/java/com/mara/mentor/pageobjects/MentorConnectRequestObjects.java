package com.mara.mentor.pageobjects;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MentorConnectRequestObjects {
	
	
	//Youtube Video url
	//public static String videoURL = "https://www.youtube.com/watch?v=2E4UpyTvBfs";
	
	//Adding topic to discuss
	public String title = "Why should I connect to mentor";
	
	//Adding topic to details to topic
	public String details = "Still thinking";
	
	//Adding search text for mentor
	public String searchMentor = "sharath";
	
	//Video URL
	public String videoURL = "https://www.youtube.com/watch?v=zYxkezUr8MQ&list=RDzYxkezUr8MQ";
	
	//Creating new mentor request
		//Mobileelement for query add field 
		@AndroidFindBy(xpath="//android.widget.EditText[1]")
		public MobileElement queryText;
		
		//Mobileelement for add description field
		@AndroidFindBy(xpath="//android.widget.EditText[2]")
		public MobileElement addDescription;
		
		//Mobileelement for add attachment icon
		@AndroidFindBy(id="com.mara.maramentor:id/relativeLayout1")
		public MobileElement addAttachmentIcon;
		
		//Mobileelement for mentor connect header text
		@AndroidFindBy(id="com.mara.maramentor:id/toolbar_header_tv")
		public MobileElement mentorConnectHeader;
		
		//Mobileelement for next button on header
		@AndroidFindBy(id="com.mara.maramentor:id/action_one_next")
		public MobileElement nextButtonHeader;
		
		//Mobileelement for close button on header
		@AndroidFindBy(xpath="//android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.ImageButton[1]")
		public MobileElement closeButtonHeader;
		
		//MobileElements for adding attachments
		//Mobileelements for Picture 
		@AndroidFindBy(id="com.mara.maramentor:id/mPicture")
		public MobileElement pictureButton;
		
		//Mobileelements for Video
		@AndroidFindBy(id="com.mara.maramentor:id/mVideo")
		public MobileElement videoButton;
		
		//Mobileelements for Video
		@AndroidFindBy(id="com.mara.maramentor:id/mCancel")
		public MobileElement cancelButton;
		
		//Mobileelements for camera button
		@AndroidFindBy(xpath="//android.widget.Button[@text='Camera']")
		public MobileElement cameraButton;
		
		//Mobileelements for camera button
		@AndroidFindBy(xpath="//android.widget.Button[@text='Gallery']")
		public MobileElement galleryButton;
		
		//Mobile element for + button on images 
		@AndroidFindBy(id = "com.mara.maramentor:id/imgQueueMultiSelected")  
		public List<MobileElement> galleryImages;
		
		//Mobile element for OK button in gallery 
		@AndroidFindBy(id = "com.mara.maramentor:id/btnGalleryOk")   
		public MobileElement galleryOkButton;
		
		//Mobile element for video URL on Posting video 
		@AndroidFindBy(id = "com.mara.maramentor:id/mVideoLink")   
		public MobileElement videoURLField;
		
		//Mobile element for post video 
		@AndroidFindBy(id = "com.mara.maramentor:id/mVideoLink")   
		public MobileElement postVideoButton;
		
		//Mobile element for cancel video 
		@AndroidFindBy(id = "com.mara.maramentor:id/mCancelVideo")   
		public MobileElement cancelPostVideoButton;
		
		//Compose second page
		//Mobile element for Almost Done text on second compose page 
		@AndroidFindBy(id = "//android.widget.TextView[@text='ALMOST DONE']")   
		public MobileElement almostDoneText;
		
		//Mobile element for allIndustries
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='All Industries']")   
		public MobileElement allIndustries;
		
		//Mobile element for All countries
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='All Countries']")   
		public MobileElement allCountries;
		
		//Mobile element for choosing mentor
		@AndroidFindBy(id = "com.mara.maramentor:id/tvChooseMentor")   
		public MobileElement chooseMentor;
		
		//Mobile element for Finish button
		@AndroidFindBy(id = "com.mara.maramentor:id/bRequestMentorFinish")   
		public MobileElement finishButton;
		
		//Mobile Element for selecting agriculture as Industry
		@AndroidFindBy(name = "Agriculture")
	    public MobileElement agriIndustry;
		
		//Mobile Element for selecting Algeria as country
		@AndroidFindBy(name = "Algeria")
	    public MobileElement algeriaCountry;
		
		//Mobile Element for search text field
		@AndroidFindBy(xpath = "//android.widget.FrameLayout[3]//android.widget.EditText[@resource-id='com.mara.maramentor:id/search_view']")
		public MobileElement searchTextField;
		
		//Mobile Element for search icon
		@AndroidFindBy(id = "com.mara.maramentor:id/search")
		public MobileElement searchIcon;
		
		//Mobile element for search results
		@AndroidFindBy(id = "com.mara.maramentor:id/search_name_textview")
		public List<MobileElement> listMentors;
		
		
		
		
	    
		
		
		
		
		

}
