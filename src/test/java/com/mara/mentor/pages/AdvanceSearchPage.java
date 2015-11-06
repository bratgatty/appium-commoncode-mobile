package com.mara.mentor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.mara.mentor.pageobjects.AdvanceSearchPageObjects;
import com.mara.mentor.pageobjects.HomePageObjects;
import com.mara.mentor.pageobjects.MentorPageObjects;
import com.mara.mentor.pageobjects.ProfilePageObjects;
import com.mara.mentor.pageobjects.SideNavigationObjects;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

  public class AdvanceSearchPage extends AppiumTestBase
	{
	AdvanceSearchPageObjects advanceSearchPageObjects= new AdvanceSearchPageObjects();
	ProfilePageObjects profilePageObjects = new ProfilePageObjects();
	//SideNavigationObjects sideNavigationObjects=new SideNavigationObjects();
  // MentorPageObjects mentorPageObjects=new  MentorPageObjects();
  //ProfilePageObjects profilePageObjects = new ProfilePageObjects() ;
//HomePageObjects homePageObjects = new HomePageObjects();
	
  public AdvanceSearchPage(AppiumDriver<MobileElement> driver)
  {
	  super(driver);
	  PageFactory.initElements(new AppiumFieldDecorator(driver,5, TimeUnit.SECONDS),advanceSearchPageObjects);
}
  
  
  
 //Search a Mentor by Name
 	public AdvanceSearchPage searchByName() {
			advanceSearchPageObjects.searchNameTextField.sendKeys(advanceSearchPageObjects.mentorName);
			advanceSearchPageObjects.searchButton.click();
			hideKeyboard();
			nameValidationFunction();
			return this;
 		}
  
  //Search a Mentor by Country
   public ProfilePage searchByCountry() throws InterruptedException
 {
  		advanceSearchPageObjects.selectCountryButton.click();
  		
  		try 
  		{
  			advanceSearchPageObjects.selectCountryName.click();
		}
  		catch (Exception e)
  		{
			scrollTo(advanceSearchPageObjects.country1);
			advanceSearchPageObjects.selectCountryName.click();
		}
	  		advanceSearchPageObjects.searchButton.click();
	  		
	  		advanceSearchPageObjects.mentorProfileImageTap.click();
	  		countryValidationFunction();

	  		return new ProfilePage(driver);
}
  
  
  //Search a Mentor by Industry
	public AdvanceSearchPage searchByIndustry() {
				advanceSearchPageObjects.selectIndustry.click();
				try 
				{
					advanceSearchPageObjects.industryName.click();
				} 
				catch (Exception e)
				{
					scrollTo(advanceSearchPageObjects.industry);
					advanceSearchPageObjects.industryName.click();
				}
				advanceSearchPageObjects.searchButton.click();
				hideKeyboard();
				industryValidationFunction();
				
				return new AdvanceSearchPage(driver);
	}


//Search a Mentor by Name and Industry
public AdvanceSearchPage searchByNameAndIndustry() throws InterruptedException
{
    	advanceSearchPageObjects.searchNameTextField.sendKeys(advanceSearchPageObjects.mentorName);
    	
		advanceSearchPageObjects.selectIndustry.click();
		try 
		{
			advanceSearchPageObjects.industryName.click();
		} catch (Exception e) {
			
			driver.scrollTo(advanceSearchPageObjects.industry);
			advanceSearchPageObjects.industryName.click();
		}
		advanceSearchPageObjects.searchButton.click();
		hideKeyboard();
    	
    	Thread.sleep(2000);
    	nameValidationFunction();
    	
    	Thread.sleep(2000);
    	industryValidationFunction();

	      return this;
}


//Search a Mentor by Name and country
public AdvanceSearchPage searchByNameandCountry()
{
	advanceSearchPageObjects.searchNameTextField.sendKeys(advanceSearchPageObjects.mentorName);
	advanceSearchPageObjects.selectCountryButton.click();
	advanceSearchPageObjects.selectCountryName.click();
	
	return this;
}

  
   //To Verify Title advance search page is displayed
  public boolean advanceSearchPageIsDisplayed()
  {
		if (advanceSearchPageObjects.advanceSearchPageTitle.getText().equalsIgnoreCase("Search Mentor") ||            
			(advanceSearchPageObjects.advanceSearchPageTitle.getText().equalsIgnoreCase("Search"))	 ) {
			Reporter.log("Page Title : "+advanceSearchPageObjects.advanceSearchPageTitle.getText());
			return true;
		} else {
			Reporter.log("Page Title : "+advanceSearchPageObjects.advanceSearchPageTitle.getText());
			return true;
		}
	}
  

  
  //============================================================================================================
  
  //Common Function to be used for searching a user by name
  public void nameValidationFunction()
  {
	        if(advanceSearchPageObjects.mentorsResultList.isDisplayed())
	        {
	            String searchedMentorsName =  advanceSearchPageObjects.mentorsResultList.getAttribute("name");
			    if (searchedMentorsName.contains(advanceSearchPageObjects.mentorName.toUpperCase())) {
				Reporter.log("Actual Mentor Name : " + searchedMentorsName, true);
				Reporter.log("Expected MentorName : " + advanceSearchPageObjects.mentorName, true);
			} else {
				Reporter.log("Actual and Expected Result does not match", true);
				Reporter.log("Actual Mentor Name : " + searchedMentorsName, true);
				Reporter.log("Expected MentorName : " + advanceSearchPageObjects.mentorName, true);
				Assert.fail();
			}
			} else {
			Reporter.log("No Mentors Found Using this Name", true);
		}
  }
  
  //Common Function to be used for searching a user by its industry
  public void industryValidationFunction()
  {
		if (advanceSearchPageObjects.mentorsResultListByIndustry.isDisplayed()) {	
		    String industryName = advanceSearchPageObjects.mentorsResultListByIndustry.getText();
		if (industryName.equalsIgnoreCase(advanceSearchPageObjects.industry)) {
			Reporter.log("Actual Result : " + industryName, true);
			Reporter.log("Expected Result : " + advanceSearchPageObjects.industry, true);
		} else {
			Reporter.log("Actual and Expected Result does not match for Industry", true);
			Reporter.log("Actual Result : " + industryName, true);
			Reporter.log("Expected Result : " + advanceSearchPageObjects.industry, true);
			Assert.fail();
			}
		} else {
			Reporter.log("No Mentors Found from this Industry", true);
   }
  }
  
  
  
//Common Function to be used for searching a user by its country -----This function needs modification both for IOS and android
  public void countryValidationFunction()
  {
	  
		if(advanceSearchPageObjects.mentorProfileImageTap.isDisplayed())
		{
			if(profilePageObjects.getCountry.getText().equalsIgnoreCase(advanceSearchPageObjects.country))
		{
	       Reporter.log("Actual Country value : "+profilePageObjects.getCountry.getText(),true);
	       Reporter.log("Expected Country value : "+advanceSearchPageObjects.country,true);
		}
			else
       {
	   Reporter.log("Actual and Expected Result does not match for country", true);
	   Reporter.log("Actual Country value : "+profilePageObjects.getCountry.getText(),true);
       Reporter.log("Expected Country value : "+advanceSearchPageObjects.country,true);
       Assert.fail();
      }
		}
		else
		{
			Reporter.log("No Mentors Found from this Country", true);
		}
  }
  
  
  // To hide Keyboard
  public void hideKeyboard()
  {
	  try {
		driver.hideKeyboard();
	} catch (Exception e) {
		
	}
  }
  
  
	}
  
  
  
  
  
  
  

