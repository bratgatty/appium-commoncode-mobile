package com.mara.mentor.pageobjects;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ComposePageObjects 
{
	   @AndroidFindBy(id = "com.mara.maramentor:id/compose_title_editext")
	   @iOSFindBy(xpath="//UIATextField[@value='What is it all about?']")
       public MobileElement  postTitleField;
	   
	   public String title="Automation Test for Post";
	
	   @AndroidFindBy(id = "com.mara.maramentor:id/compose_content_editext")
	   @iOSFindBy(xpath="//UIATextView[@value='Enter the content here']")
       public MobileElement  postContentField;
	   
	   public String content="Simple Automation test";
	   
	   @AndroidFindBy(id = "com.mara.maramentor:id/compose_camera_button")
	   @iOSFindBy(name="icn camera")
       public MobileElement  imageAttachmentButton;
	   
	   @AndroidFindBy(id = "com.mara.maramentor:id/compose_video_button")
	   @iOSFindBy(name="icn video")
       public MobileElement  videoAttachmentButton;
	   
	   @AndroidFindBy(id = "com.mara.maramentor:id/compose_link_button")
	   @iOSFindBy(name="icn link")
       public MobileElement  linkAttachmentButton;
	   
	   public String url="https://www.mentor.mara.com";
	   
	   public String videoUrl="https://www.youtube.com/watch?v=yZANpa78Tzg";
	   
	   @AndroidFindBy(id = "com.mara.maramentor:id/edittext")
	   @iOSFindBy(xpath="//UIAAlert[1]/UIAImage[1]/UIATextField[1]")
       public MobileElement  linkTextField;																				//Link text field is same for both video and link attachment  since we have the same resource ID
	   
	   	@AndroidFindBy(id = "android:id/button1")
	   	@iOSFindBy(name="Post")
       public MobileElement  OkButton;																					//Ok Botton is same for both video and link attachment  since  we have the same resource ID
	   
	   
	   @AndroidFindBy(id = "com.mara.maramentor:id/toolbar_header_tv")
	   @iOSFindBy(name="Compose")
       public MobileElement  pageHeader;                                                                             //page Header/title is compose
	   
	   @AndroidFindBy(id = "com.mara.maramentor:id/action_submit")
	   @iOSFindBy(name="icn tick")
       public MobileElement  submitButton;																				//tap on tick button
	   
	   @AndroidFindBy(id = "com.mara.maramentor:id/compose_post_button")
	   @iOSFindBy(name="News & Updates")
       public MobileElement  newsAndUpdateButton;															//news and update button in compose screen/page
	   
	   @AndroidFindBy(id = "com.mara.maramentor:id/compose_question_button")
	   @iOSFindBy(name="Question")
       public MobileElement  askQuestionButton;                                                               //Ask a Question button in Compose screen/page
	   	  
	   @AndroidFindBy(id = "android:id/message")
       public MobileElement  headerMessage;  																//After tapping on camera button a dialogue box  appears with header "Choose a source to upload image"
	   
	   @AndroidFindBy(id = "android:id/button2")
	   @iOSFindBy(name="Add from Gallery")
       public MobileElement  galleryButton;
	   
	   @AndroidFindBy(id = "android:id/button1")
	   @iOSFindBy(name="Take a Photo")
       public MobileElement  cameraButton;
	   
	   @AndroidFindBy(id = "com.mara.maramentor:id/imgQueueMultiSelected")
	   @iOSFindBy(xpath="//UIACollectionCell[1]")
	   public List<MobileElement> galleryImages;
	   
	   @AndroidFindBy(id = "com.mara.maramentor:id/imgQueue")
	   @iOSFindBy(xpath="//UIACollectionCell[@value='0']")                              //UIACollectionCell[@value='0']
	   public List<MobileElement> galleryQImages;
	   
	   
	   @AndroidFindBy(id = "com.mara.maramentor:id/btnGalleryOk")   
	   @iOSFindBy(name="icn plus")
	   public MobileElement galleryOkButton;
	   
	   @AndroidFindBy(id = "com.android.camera2:id/shutter_button")
	   @iOSFindBy(name="PhotoCapture")
	   public MobileElement imageCaptureButton;
	   
	   
	   @AndroidFindBy(id = "com.android.camera2:id/done_button")
	   @iOSFindBy(name="Use Photo")
	   public MobileElement selectCapturedImageButton;
	 	   
	   
	   @AndroidFindBy(name= "What is your question?")
	   @iOSFindBy(xpath="//UIATextField[@value='What is your question?']")
	   public MobileElement questionTitleField;
	   
	   public String questionTitle="Automation Test for Question";
	   
	   @AndroidFindBy(id = "com.mara.maramentor:id/compose_content_editext")
	   @iOSFindBy(xpath="//UIATextView[@value='Include hash tags (#)']")
	   public MobileElement questionHastagContentField ;
	   
	   public String hastags="#Africa #India #Dubai #MaraMentor #MaraChat";
	   
	   
	   
	
}
