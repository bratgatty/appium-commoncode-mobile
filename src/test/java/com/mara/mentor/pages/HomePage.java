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
