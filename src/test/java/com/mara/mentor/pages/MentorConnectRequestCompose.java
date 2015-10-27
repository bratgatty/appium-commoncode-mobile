package com.mara.mentor.pages;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.mara.mentor.pageobjects.MentorConnectObjects;
import com.mara.mentor.pageobjects.MentorConnectRequestObjects;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MentorConnectRequestCompose extends AppiumTestBase{
	
	MentorConnectRequestObjects mentorConnectRequestObjects = new MentorConnectRequestObjects();
	
	public MentorConnectRequestCompose(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), mentorConnectRequestObjects);
	}
	//Verify page
	public boolean verifyMentorRequestPage(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return mentorConnectRequestObjects.nextButtonHeader.isDisplayed();
	}
	
	//verify second page of request compose
	public boolean verifyMentorRequestContinue(){
		return mentorConnectRequestObjects.almostDoneText.isDisplayed();
	}

	//To add text and desc for request
	public MentorConnectRequestCompose addTextDesc()
	{
		mentorConnectRequestObjects.queryText.sendKeys("Sharath test");
		mentorConnectRequestObjects.addDescription.sendKeys(mentorConnectRequestObjects.details);
		return new MentorConnectRequestCompose(driver);
	}
	
	//To add images from gallery on compose
	public MentorConnectRequestCompose addImageViaGallery()
	{
		mentorConnectRequestObjects.addAttachmentIcon.click();
		mentorConnectRequestObjects.pictureButton.click();
		mentorConnectRequestObjects.galleryButton.click();
		if(mentorConnectRequestObjects.galleryImages.size()>0)
		{
			for(int i=0;i<3;i++)
			{
				mentorConnectRequestObjects.galleryImages.get(i).click();
			}
			mentorConnectRequestObjects.galleryOkButton.click();
		}
		else
		{
			driver.navigate().back();
			Reporter.log("No images present in Gallery");
		}
		
		return new MentorConnectRequestCompose(driver); 
	}
	
	//To add video for the request
	public MentorConnectRequestCompose addVideo()
	{
		mentorConnectRequestObjects.videoButton.click();
		mentorConnectRequestObjects.videoURLField.sendKeys(mentorConnectRequestObjects.videoURL);
		mentorConnectRequestObjects.postVideoButton.click();
		return new MentorConnectRequestCompose(driver);
	}
	
	//To tap on 'Next' button on compose
	public MentorConnectRequestCompose nextTap()
	{
		mentorConnectRequestObjects.nextButtonHeader.click();
		return new MentorConnectRequestCompose(driver);
	}
	
	//To select country and Industries
	public MentorConnectRequestCompose addIndCountry(){
		mentorConnectRequestObjects.allCountries.click();
		mentorConnectRequestObjects.algeriaCountry.click();
		mentorConnectRequestObjects.allIndustries.click();
		mentorConnectRequestObjects.agriIndustry.click();
		return new MentorConnectRequestCompose(driver);
	}
	
	//To select mentor
	public MentorConnectRequestCompose selectMentorFinish(){
		mentorConnectRequestObjects.chooseMentor.click();
		mentorConnectRequestObjects.searchTextField.sendKeys(mentorConnectRequestObjects.searchMentor);
		mentorConnectRequestObjects.searchIcon.click();
        Random random = new Random();
		if (mentorConnectRequestObjects.listMentors.size() > 0) {
			int randomvalue = random.nextInt(mentorConnectRequestObjects.listMentors.size());
			Reporter.log(mentorConnectRequestObjects.listMentors.get(randomvalue).getText(), true);
			mentorConnectRequestObjects.listMentors.get(randomvalue).click();
		} else {
			Reporter.log("No Data found", true);
		}
		mentorConnectRequestObjects.finishButton.click();
		return new MentorConnectRequestCompose(driver);
	}
	
	
	
	
}
