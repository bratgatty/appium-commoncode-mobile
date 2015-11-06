package com.mara.mentor.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mara.mentor.pageobjects.SideNavigationObjects;
import com.mara.mentor.pages.AdvanceSearchPage;
import com.mara.mentor.pages.HomePage;
import com.mara.mentor.pages.MentorPage;
import com.mara.mentor.pages.ProfilePage;
import com.mara.mentor.pages.SideNavigationPage;
import com.mara.mentor.util.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AdvanceSearchPageTest 
{
	public AppiumDriver<MobileElement> driver;
	
	    HomePage homePage;
	    AdvanceSearchPage advanceSearchPage;
	   ProfilePage profilePage;
	  //  MentorPage MentorPage;
	 //   SideNavigationPage sideNavigationPage;
	//    SideNavigationObjects sideNavigationObjects;
	    
	   
	    
	    
	    @BeforeMethod(alwaysRun=true)
		//@BeforeClass(alwaysRun = true)
		public void startDriver() throws IOException, InterruptedException {
	        driver = Utils.getDriver();
	    	// before every test is executed, call this method to login on android phones and
			// avoid logging in on ios if already loggedin
			homePage = Utils.checkIfLoggedIn(driver);

		}
	
	@Test
	public void searchMentorByName()
	{
		advanceSearchPage=homePage.sideNavigationTap(driver).mentorsTap(driver).advanceSearchButtonTap();
        Assert.assertTrue(advanceSearchPage.advanceSearchPageIsDisplayed());
		advanceSearchPage = advanceSearchPage.searchByName();
	}
	
	@Test
	public void searchMentorByIndustry()
	{
		advanceSearchPage= homePage.sideNavigationTap(driver).mentorsTap(driver).advanceSearchButtonTap();
		Assert.assertTrue(advanceSearchPage.advanceSearchPageIsDisplayed());
	   advanceSearchPage = advanceSearchPage.searchByIndustry();
	}
	
//	@Test																																//This function needs modification both for IOS and android
//	public void searchMentorByCountry() throws InterruptedException
//	{
//			advanceSearchPage=homePage.sideNavigationTap(driver).mentorsTap(driver).advanceSearchButtonTap();
//	        Assert.assertTrue(advanceSearchPage.advanceSearchPageIsDisplayed());
//			 profilePage= advanceSearchPage.searchByCountry();
//	}
//	
//	
	
	@Test
	public void searchMentorByNameAndIndustry() throws InterruptedException
	{
		advanceSearchPage=homePage.sideNavigationTap(driver).mentorsTap(driver).advanceSearchButtonTap();
        Assert.assertTrue(advanceSearchPage.advanceSearchPageIsDisplayed());
		advanceSearchPage = advanceSearchPage.searchByNameAndIndustry();
	}
//	
//	@Test
//	public void searchMentorByNameAndCountry()
//	{
//		
//	}
//	
//	@Test
//	public void searchMentorByCountryAndIndustry()
//	{
//		
//	}
//	
//	@Test
//	public void searchMentorByNameAndCountryAndIndustry()
//	{
//		
//	}
//	
	
	
	   @AfterMethod(alwaysRun=true)    
		//@AfterClass(alwaysRun = true)
	   public void afterClass() throws InterruptedException 
	   {
	//	   Thread.sleep(2000);
//		   homePage.sideNavigationTap(driver).logout(driver);
	//	   Thread.sleep(2000);
	       driver.quit();
	   }
	
	
}
