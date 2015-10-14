package com.mara.mentor.pages;

import com.mara.mentor.pageobjects.HomePageObjects;

import com.mara.mentor.pageobjects.SideNavigationObjects;
import com.mara.mentor.util.AppiumTestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
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
  


}
