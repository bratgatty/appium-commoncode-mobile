package com.mara.mentor.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mara.mentor.pages.HomePage;
import com.mara.mentor.pages.MentorsPage;
import com.mara.mentor.pages.SideNavigationPage;
import com.mara.mentor.pages.WelcomePage;
import com.mara.mentor.util.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MentorTest {
	
public AppiumDriver<MobileElement> driver;
	
	WelcomePage welcomePage;
	HomePage homePage;
	SideNavigationPage sideNavigationPage;
	
	@BeforeMethod(alwaysRun=true)
	public void startDriver() throws IOException, InterruptedException {
        driver = Utils.getDriver();
    	// before every test is executed, call this method to login on android phones and
		// avoid logging in on ios if already loggedin
	}
	
	@Test
	public void tapFollow() throws InterruptedException, IOException{
		WelcomePage welcomePage = new WelcomePage(driver);
		homePage = welcomePage.waitforWelcomePage(driver).clickonSignup(driver).waitforSignUpPage(driver).enterValidCredentails(driver).waitforHomePage(driver);
        AssertJUnit.assertTrue(homePage.verifySearchBtnDisplayed(driver));
		sideNavigationPage = homePage.sideNavigationTap(driver);
		MentorsPage mentorsPage=sideNavigationPage.tapMentors(driver);
		Assert.assertTrue(mentorsPage.verifyMentorPage());
		mentorsPage = mentorsPage.followTap();
	}
	

	@Test
	public void tapUnFollow() throws InterruptedException, IOException{
		welcomePage = new WelcomePage(driver);
        homePage = welcomePage.waitforWelcomePage(driver).clickonLogin(driver).waitforLoginPage(driver).enterValidCredentails(driver).waitforHomePage(driver);
        AssertJUnit.assertTrue(homePage.verifySearchBtnDisplayed(driver));
		sideNavigationPage = homePage.sideNavigationTap(driver);
		MentorsPage mentorsPage=sideNavigationPage.tapMentors(driver);
		Assert.assertTrue(mentorsPage.verifyMentorPage());
		mentorsPage = mentorsPage.unFollowTap();
	}
	
	
	@Test
	public void tapMentor() throws InterruptedException, IOException{
		welcomePage = new WelcomePage(driver);
        homePage = welcomePage.waitforWelcomePage(driver).clickonLogin(driver).waitforLoginPage(driver).enterValidCredentails(driver).waitforHomePage(driver);
        AssertJUnit.assertTrue(homePage.verifySearchBtnDisplayed(driver));
		sideNavigationPage = homePage.sideNavigationTap(driver);
		MentorsPage mentorsPage=sideNavigationPage.tapMentors(driver);
		Assert.assertTrue(mentorsPage.verifyMentorPage());
		mentorsPage = mentorsPage.followTap();
	}
	
	 @AfterMethod(alwaysRun=true)    
	 //@AfterClass(alwaysRun = true)
	 public void afterClass() {
		 driver.quit();
	  }

}
