package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.mara.mentor.pageobjects.ComposePageObjects;
import com.mara.mentor.pageobjects.HomePageObjects;
import com.mara.mentor.util.AppiumTestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ComposePage extends AppiumTestBase 
{
        ComposePageObjects composePageObjects=new ComposePageObjects();
        HomePageObjects homePageObjects = new   HomePageObjects();
	
	public ComposePage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver,5, TimeUnit.SECONDS),composePageObjects);
	}
	
	
	//To verify compose page displayed
			public boolean verifyComposePageDisplayed()
			{
				return composePageObjects.newsAndUpdateButton.isDisplayed();
			}
		
	
		
		//Creating A Simple Post and link Without Any attachments
		public HomePage composePost() throws InterruptedException
	{
		
		   composePageObjects.postTitleField.sendKeys(composePageObjects.title);
		   composePageObjects.postContentField.sendKeys(composePageObjects.content);
		   
		   linkAttachment();
		  
		   composePageObjects.submitButton.click();
		   return new HomePage(driver);
		   
	}
	   
		//Creating A  Post and link With image attachments
	   public HomePage composeImagePost() throws InterruptedException
		{		
			   composePageObjects.postTitleField.sendKeys(composePageObjects.title);
			   composePageObjects.postContentField.sendKeys(composePageObjects.content);
			   composePageObjects.imageAttachmentButton.click();
			   composePageObjects.galleryButton.click();
			   
			   if(composePageObjects.galleryImages.size()>0)
			   {
				   Reporter.log("Image present in gallery "+composePageObjects.galleryImages.size(),true);
				   	
				   for(int i=0;i<=1;i++)
				   {
					   composePageObjects.galleryImages.get(i).click();
				   }
				   																									//				   TouchAction element=new TouchAction(driver);
				   																									//				   element.tap(10, 165);
				   composePageObjects.galleryOkButton.click();
			   }
			   else
			   {
				   driver.navigate().back();
				   Reporter.log("No images present in Gallery");
			   }
	
			   composePageObjects.imageAttachmentButton.click();
			   composePageObjects.cameraButton.click();
			   composePageObjects.imageCaptureButton.click();
			   composePageObjects.selectCapturedImageButton.click();
			   linkAttachment();
			   composePageObjects.submitButton.click();
			   Thread.sleep(5000);
			   
			   return new HomePage(driver);
  		      }
	   
	   
	 //Creating A  Post and link With video attachments
	   public HomePage composeVideoPost()
		{
			 
			   composePageObjects.postTitleField.sendKeys(composePageObjects.title);
			   composePageObjects.postContentField.sendKeys(composePageObjects.content);
			   
			   videolinkAttachment();
			   
			   linkAttachment();			    
			   composePageObjects.submitButton.click();
			   return new HomePage(driver);
    		}
	   
	//===============================================================Compose Question============================================================================
	   
	   
		//To verify compose page displayed
		public boolean verifyAskQuestionButtonDisplayed()
		{
			return composePageObjects.askQuestionButton.isDisplayed();
		}
		
	   
		//Composing a Simple Question with Link attachment 
		public DiscussionForumPage composeQuestion() throws InterruptedException
		{
			   composePageObjects.askQuestionButton.click();
			   composePageObjects.questionTitleField.sendKeys(composePageObjects.questionTitle);
			   composePageObjects.questionHastagContentField.sendKeys(composePageObjects.hastags);

			   linkAttachment();
			   composePageObjects.submitButton.click();
			   return new DiscussionForumPage(driver);
			   
		}
		
		
		//Composing a Question with Link  and  Image Attachment from Gallery
		 public DiscussionForumPage composeImageQuestion() throws InterruptedException
		 {
			    composePageObjects.askQuestionButton.click();
			    composePageObjects.questionTitleField.sendKeys(composePageObjects.questionTitle);
			    composePageObjects.questionHastagContentField.sendKeys(composePageObjects.hastags);
			    
			    composePageObjects.imageAttachmentButton.click();
				composePageObjects.galleryButton.click();
				
			    if(composePageObjects.galleryQImages.size()>0)
				   {
			    	   int randomImage=randomFunc(composePageObjects.galleryQImages.size());
			    	   Thread.sleep(2000);
					   composePageObjects.galleryQImages.get(randomImage).click();
				   }
				   else
				   {
					   driver.navigate().back();
					   Reporter.log("No images present in Gallery",true);
				   }
			         linkAttachment();
			         
			          composePageObjects.submitButton.click();
			          Thread.sleep(6000);
			  
			    return new DiscussionForumPage(driver);

		 }
		
		//Composing a Question with Link And Image Attachment from Camera
		 public DiscussionForumPage composeCameraImageQuestion() throws InterruptedException
		 {
			       composePageObjects.askQuestionButton.click();
			       composePageObjects.questionTitleField.sendKeys(composePageObjects.questionTitle);
			       composePageObjects.questionHastagContentField.sendKeys(composePageObjects.hastags);
			      
			       composePageObjects.imageAttachmentButton.click();
				   composePageObjects.cameraButton.click();
				   composePageObjects.imageCaptureButton.click();
				   composePageObjects.selectCapturedImageButton.click();
				 
				   linkAttachment();
				   composePageObjects.submitButton.click();
				   Thread.sleep(5000);
			       return new DiscussionForumPage(driver);
		 }
		
		
		//Composing a Question with VideoLink  and Link attachment
		 public DiscussionForumPage composeVideoUrlQuestion() throws InterruptedException
		 {
			   composePageObjects.askQuestionButton.click();
		       composePageObjects.questionTitleField.sendKeys(composePageObjects.questionTitle);
		       composePageObjects.questionHastagContentField.sendKeys(composePageObjects.hastags);
			  videolinkAttachment();
			  linkAttachment()	;
			  composePageObjects.submitButton.click();
			  return new DiscussionForumPage(driver);
		 }
		   
		
		//===========================================================================================================================================	
		
		public void linkAttachment()																							//Common Function to Attach a Link for a Post or a Question
		{
			     composePageObjects.linkAttachmentButton.click();
			     composePageObjects.linkTextField.click();
			     composePageObjects.linkTextField.sendKeys(composePageObjects.url);
			     composePageObjects.OkButton.click();
		}
		
		public void videolinkAttachment()																					//Common Function to Attach a VideoLink for a Post or a Question
		{
			   composePageObjects.videoAttachmentButton.click();
			   composePageObjects.linkTextField.sendKeys(composePageObjects.videoUrl);
			   composePageObjects.OkButton.click();
		}
		
}
