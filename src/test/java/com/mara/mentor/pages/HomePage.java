package com.mara.mentor.pages;

import com.mara.mentor.pageobjects.CommentPageObjects;
import com.mara.mentor.pageobjects.ComposePageObjects;
import com.mara.mentor.pageobjects.HomePageObjects;
import com.mara.mentor.pageobjects.SideNavigationObjects;
import com.mara.mentor.util.AppiumTestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by maratest on 9/9/15.
 */
public class HomePage extends AppiumTestBase {
    HomePageObjects homePageObjects = new HomePageObjects();
    SideNavigationObjects sideNavigationObjects = new SideNavigationObjects();
    CommentPageObjects commentPageObjects = new CommentPageObjects();
    ComposePageObjects composePageObjects = new ComposePageObjects ();

    public HomePage(AppiumDriver<MobileElement> driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver,5, TimeUnit.SECONDS),homePageObjects);
    }

    public boolean verifySearchBtnDisplayed(AppiumDriver<MobileElement> driver) throws InterruptedException {
        return homePageObjects.SEARCHBTN.isDisplayed();
    }
    
    public HomePage waitForComposeButton(AppiumDriver<MobileElement> driver)
	{
		waitForPageToLoad(driver, homePageObjects.composeButton);
		return this;
	}
    
    //Method to tap on side navigation
    public SideNavigationPage sideNavigationTap(AppiumDriver<MobileElement> driver)
    {
    	homePageObjects.SIDENAVIGATIONBTN.click();
    	return new SideNavigationPage(driver);
    }
    
    //Adding comment from news and updates screen on 1st post
    public CommentPage clickFirstCommentIcon(AppiumDriver<MobileElement> driver)
    {
    	homePageObjects.commentIcon.click();
    	waitForPageToLoad(driver,commentPageObjects.postButton);
    	return new CommentPage(driver);
    }
    
    //Clicking on first post
    public PostDetailPage clickPost(AppiumDriver<MobileElement> driver)
    {
    	homePageObjects.postHeading.click();
    	return new PostDetailPage(driver);
    }
    
    //To get comment count
    public HomePage getCommentCount()
    {
    	homePageObjects.commentCount.getText();
    	return new HomePage(driver);
    }
    
    //Method to tap on compose icon
    public ComposePage composeButtonTap(AppiumDriver<MobileElement> driver)
    {
    	homePageObjects.composeButton.click();
    	return new ComposePage(driver);
    }
  		
    //Method to swipe page
    public HomePage swipePostPage()
    {
    	driver.context("NATIVE_APP");
    	Dimension size = driver.manage().window().getSize();
    	int startY = (int)(size.height*0.69);
    	int endY = (int)(size.height*0.40);
    	int startx = size.width/2;
    	driver.swipe(startx, startY, startx, endY, 1000);
    	return new HomePage(driver);

    }
  		
  	//Method to delete post
  		public HomePage deletePost() throws InterruptedException
  		{
  			//To check how many delete buttons available on page
  			
  			do
  			{
  				
  				Reporter.log("Before if"+homePageObjects.deletePostButton.size(), true);
  				
  	  			if(homePageObjects.deletePostButton.size()!=0)
  	  			{
  	  				Reporter.log("Inside if"+homePageObjects.deletePostButton.size(), true);
  	  				for(int i=0;i<1;i++)
  	  				{
  	  					String postHeading = homePageObjects.postHeading.getText();
  	  					Reporter.log(postHeading, true);
  	  					homePageObjects.deletePostButton.get(i).click();
  	  					Thread.sleep(5000);
  	  					if(!postHeading.equalsIgnoreCase(homePageObjects.postHeading.getText()))
  	  		  			{
  	  		  				Assert.assertTrue(true);
  	  		  				
  	  		  			}
  	  				}
  	  			}
  	  			else
  	  			{
  	  				Reporter.log("Inside else", true);
  	  				swipePostPage();
  	  			}
  			}while(homePageObjects.deletePostButton.size()==0);
  			
  			
  			
  			/*if(homePageObjects.deletePostButton.size()==0)
  			{
  				//set boolean = false
  				
  			
  				swipePostPage();
  				
  				for(int i=0;i<1;i++)
  				{
  					String postHeading = homePageObjects.postHeading.getText();
  					Reporter.log(postHeading, true);
  					homePageObjects.deletePostButton.get(i).click();
  					Thread.sleep(5000);
  					if(!postHeading.equalsIgnoreCase(homePageObjects.postHeading.getText()))
  		  			{
  		  				Assert.assertTrue(true);
  		  			}
  					Reporter.log("After swipe no post created by user on the page", true);
  				}
  			}
  			else
  				for(int i=0;i<1;i++)
  				{
  					String postHeading = homePageObjects.postHeading.getText();
  					Reporter.log(postHeading, true);
  					homePageObjects.deletePostButton.get(i).click();
  					Thread.sleep(5000);
  					if(!postHeading.equalsIgnoreCase(homePageObjects.postHeading.getText()))
  		  			{
  		  				Assert.assertTrue(true);
  		  				
  		  			}
  				}*/
  			return this;
  		}
  		
  		
  	//Method to click on abuse report post
  		public HomePage abuseReport()
  		{
  			homePageObjects.abuseReportButton.click();
  			return new HomePage(driver);
  		}
  		
  	
  	//Method to click on copy right report post
  		public HomePage copyRightReport()
  		{
  			homePageObjects.copyRightReportButton.click();
  			return new HomePage(driver);
  		}
  		
  		
  	//Method to click on spam report post
  		public HomePage spamReport()
  		{
  			homePageObjects.spamReportButton.click();
  			return new HomePage(driver);
  		}
  		
  	//Method to abuse report of a post
  		public HomePage clickAbuseReport() throws InterruptedException
  		{
  			do
  			{
  				Reporter.log("Before if"+homePageObjects.reportPostButton.size(), true);
  	  			if(homePageObjects.reportPostButton.size()!=0)
  	  			{
  	  				Reporter.log("Inside if"+homePageObjects.reportPostButton.size(), true);
  	  				for(int i=0;i<1;i++)
  	  				{
  	  					String postHeading = homePageObjects.postHeading.getText();
  	  					Reporter.log(postHeading, true);
  	  					homePageObjects.reportPostButton.get(i).click();
  	  					homePageObjects.abuseReportButton.click();
  	  					Thread.sleep(5000);
  	  				}
  	  			}
  	  			else
  	  			{
  	  				Reporter.log("Inside else", true);
  	  				swipePostPage();
  	  			}
  			}while(homePageObjects.reportPostButton.size()==0);
  			return this;
  		}
  		
  	//Method to copy right report of a post
  		public HomePage clickCopyRightReport() throws InterruptedException
  		{
  			do
  			{
  				Reporter.log("Before if"+homePageObjects.reportPostButton.size(), true);
  	  			if(homePageObjects.reportPostButton.size()!=0)
  	  			{
  	  				Reporter.log("Inside if"+homePageObjects.reportPostButton.size(), true);
  	  				for(int i=0;i<1;i++)
  	  				{
  	  					String postHeading = homePageObjects.postHeading.getText();
  	  					Reporter.log(postHeading, true);
  	  					homePageObjects.reportPostButton.get(i).click();
  	  					homePageObjects.copyRightReportButton.click();
  	  					Thread.sleep(5000);
  	  				}
  	  			}
  	  			else
  	  			{
  	  				Reporter.log("Inside else", true);
  	  				swipePostPage();
  	  			}
  			}while(homePageObjects.reportPostButton.size()==0);
  			return this;
  		}
  		
  	//Method to spam report of a post
  		public HomePage clickSpamReport() throws InterruptedException
  		{
  			do
  			{
  				Reporter.log("Before if"+homePageObjects.reportPostButton.size(), true);
  	  			if(homePageObjects.reportPostButton.size()!=0)
  	  			{
  	  				Reporter.log("Inside if"+homePageObjects.reportPostButton.size(), true);
  	  				for(int i=0;i<1;i++)
  	  				{
  	  					String postHeading = homePageObjects.postHeading.getText();
  	  					Reporter.log(postHeading, true);
  	  					homePageObjects.reportPostButton.get(i).click();
  	  					homePageObjects.spamReportButton.click();
  	  					Thread.sleep(5000);
  	  				}
  	  			}
  	  			else
  	  			{
  	  				Reporter.log("Inside else", true);
  	  				swipePostPage();
  	  			}
  			}while(homePageObjects.reportPostButton.size()==0);
  			return this;
  		}
  		
  
    //Rahul - Need to implement Search API assertion to compare with results shown on screen
    public HomePage search(AppiumDriver<MobileElement> driver)
    {
          homePageObjects.SEARCHBTN.click();
          homePageObjects.searchTextField.sendKeys(homePageObjects.searchtext);
          homePageObjects.searchIcon.click();
          
  
  
          List<MobileElement> searchResults= driver.findElements(By.id("com.mara.maramentor:id/search_name_textview"));
          Random random = new Random();
          
		if (searchResults.size() > 0) {
			int randomvalue = random.nextInt(searchResults.size());
			String username = searchResults.get(randomvalue).getText();
			if (username.contains(homePageObjects.searchtext)) {
				System.out.println(username + " " + homePageObjects.searchtext);
			} else {
				System.out.println(username + " " + homePageObjects.searchtext);
				Assert.fail();
			}
		} else {
			Reporter.log("No Data found", true);
		}
		return this;

    }   
    
    // To Verify Whether Post is Created Successfully
    public boolean isPosted()
	   {
		    if(homePageObjects.postHeading.getText().equalsIgnoreCase(composePageObjects.title))
		{
			   Reporter.log("Post successfully created",true);
			   System.out.println(homePageObjects.postHeading.getText() + composePageObjects.title );
			    return true;
		}
		    else
		{
			   Reporter.log("Post creation Failed",true);
			   Reporter.log("Actual Value : "+homePageObjects.postHeading.getText(),true);
			   Reporter.log("Expected Value : "+composePageObjects.title,true);
			   return false;
		 }
	   }
}
