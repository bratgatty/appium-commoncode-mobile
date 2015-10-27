package com.mara.mentor.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mara.mentor.pages.HomePage;
import com.mara.mentor.pages.MentorConnectPage;
import com.mara.mentor.pages.MentorConnectRequestCompose;
import com.mara.mentor.pages.SideNavigationPage;
import com.mara.mentor.pages.WelcomePage;
import com.mara.mentor.util.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MentorOnetoOneTest {

public AppiumDriver<MobileElement> driver;
	
	WelcomePage welcomePage;
	HomePage homePage;
	SideNavigationPage sideNavigationPage;
	
	@BeforeMethod(alwaysRun=true)
	public void startDriver() throws IOException, InterruptedException {
        driver = Utils.getDriver();
    	// before every test is executed, call this method to login on android phones and
		// avoid logging in on ios if already loggedin
		homePage = Utils.checkIfLoggedIn(driver);
	}
	
	@Test
	public void verifyCTA(){
		sideNavigationPage = homePage.sideNavigationTap(driver);
		MentorConnectPage oneonOnePage=sideNavigationPage.tapMentorOnetoOne(driver);
		Assert.assertTrue(oneonOnePage.verifyMentorConnect());
		MentorConnectRequestCompose composeRequest = oneonOnePage.createRequest();
		Assert.assertTrue(composeRequest.verifyMentorRequestPage());
		MentorConnectRequestCompose mentorConnectRequestCompose = composeRequest.addTextDesc().nextTap().addIndCountry().selectMentorFinish();
	}
	
	 @AfterMethod(alwaysRun=true)    
		//@AfterClass(alwaysRun = true)
	   public void afterClass() {
	       driver.quit();
	  }
}
