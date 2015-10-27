package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.mara.mentor.pageobjects.MentorConnectObjects;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MentorConnectPage extends AppiumTestBase {
	
	MentorConnectObjects mentorConnectObjects = new MentorConnectObjects();
	
	public MentorConnectPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), mentorConnectObjects);
	}
	
	public boolean verifyMentorConnect()
	{
		return mentorConnectObjects.connectWithMentorButton.isDisplayed();
	}
	
	
	public MentorConnectRequestCompose createRequest()
	{
		mentorConnectObjects.composeRequestButton.click();
		return new MentorConnectRequestCompose(driver);
	}
	
	
	
	
	
}
