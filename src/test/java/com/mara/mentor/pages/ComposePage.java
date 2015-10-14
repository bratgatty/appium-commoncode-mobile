package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.mara.mentor.pageobjects.ComposePageObjects;
import com.mara.mentor.pageobjects.HomePageObjects;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ComposePage extends AppiumTestBase 
{
        ComposePageObjects composePageObjects=new ComposePageObjects();
        HomePageObjects homePageObjects = new   HomePageObjects();
	
	public ComposePage()
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver,5, TimeUnit.SECONDS),composePageObjects);
	}
	
	
	//To verify compose page displayed
		public boolean verifyComposePageDisplayed()
		{
			return composePageObjects.newsAndUpdateButton.isDisplayed();
		}
	
	  
		
		
	/*	public void getHeading() throws InterruptedException
		{
			Thread.sleep(10);
			if(homePageObjects.postHeading.isDisplayed())
			{
			System.out.println(homePageObjects.postHeading.getText());
			}
			else
			{
				System.out.println("Element Not FOUND");
			}
		}
		*/
		
		
		//Creating A Simple Post and link Without Any attachments
		public HomePage composePost() throws InterruptedException
	{
		
		   composePageObjects.postTitleField.sendKeys(composePageObjects.title);
		   composePageObjects.postContentField.sendKeys(composePageObjects.content);
		   
		//   composePageObjects.linkAttachmentButton.click();
		//     composePageObjects.linkTextField.click();
		//     composePageObjects.linkTextField.sendKeys(composePageObjects.url);
		//     composePageObjects.OkButton.click();
		  
		   composePageObjects.submitButton.click();
		   return new HomePage(driver);
		   
	}
	   
		//Creating A  Post and link With image attachments
	   public HomePage composeImagePost()
		{
		      
			   composePageObjects.postTitleField.sendKeys(composePageObjects.title);
			   composePageObjects.postContentField.sendKeys(composePageObjects.content);
			   composePageObjects.imageAttachmentButton.click();
			   composePageObjects.galleryButton.click();
			   
			   if(composePageObjects.galleryImages.size()>0)
			   {
				   for(int i=0;i<=1;i++)
				   {
					   composePageObjects.galleryImages.get(i).click();
				   }
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
			   
			//  	   composePageObjects.linkAttachmentButton.click();
			//  	   composePageObjects.linkTextField.click();
			//  	   composePageObjects.linkTextField.sendKeys(composePageObjects.url);
			//  	   composePageObjects.OkButton.click();
			   
			   composePageObjects.submitButton.click();
			   
			   return new HomePage(driver);
  		      }
	   
	   
	 //Creating A  Post and link With video attachments
	   public HomePage composeVideoPost()
		{
			 
			   composePageObjects.postTitleField.sendKeys(composePageObjects.title);
			   composePageObjects.postContentField.sendKeys(composePageObjects.content);
			   composePageObjects.videoAttachmentButton.click();
			   composePageObjects.linkTextField.sendKeys(composePageObjects.videoUrl);
			   composePageObjects.OkButton.click();
			//   composePageObjects.linkAttachmentButton.click();
		
			//  composePageObjects.linkTextField.click();
			//     composePageObjects.linkTextField.sendKeys(composePageObjects.url);
			//     composePageObjects.OkButton.click();
			     composePageObjects.submitButton.click();
			   return new HomePage(driver);
    		}
	   
	   
	
	   
	   
	   
}
