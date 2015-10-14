package com.mara.mentor.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.mara.mentor.pageobjects.HomePageObjects;
import com.mara.mentor.pageobjects.SignUpPageObjects;
import com.mara.mentor.util.AppiumTestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage extends AppiumTestBase{
    public static Properties prop = new Properties();
    public static InputStream input = null;

    SignUpPageObjects signupPageObjects = new SignUpPageObjects();
    HomePageObjects homePageObjects = new HomePageObjects();

    public SignUpPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), signupPageObjects);

    }

    public SignUpPage enterValidCredentails(AppiumDriver<MobileElement> driver) throws IOException {
        selectCountryCode();
        enterSignUpDetails();
        clickOnSignInButton();
        clickOnNextCancel();
       return new SignUpPage(driver);
    }
    
 // select country code .. at the moment the first country in the list Algeria is selected
    public void selectCountryCode() throws IOException{
    	 input = new FileInputStream("property/platform.properties");
         prop.load(input);
         if(prop.getProperty("platform").equals("android")){
        	 signupPageObjects.COUNTRYCODE.click();
             signupPageObjects.COUNTRYNAME.click();
             waitForPageToLoad(driver,signupPageObjects.MOBILENUMBERFIELD);
             
         }
         else if(prop.getProperty("platform").equals("ios"))
         {
             System.out.println("Country Code is already pre-selected for iOS app if the sim is installed");
         }

    }
    // enter the mobile number, password,user name and industry
    public void enterSignUpDetails(){
        if(prop.getProperty("platform").equals("android"))
        {
            // Directly sending strings to a text field sometimes does not dimiss the keyboard .
            // So, its a safe option to first click on the field,send keys and then hide the keyboard.
        	//Enter mobile number
        	//Generate random number for SignUp, radom function is called from AppiumTestBase.java file
        	int rand= randomFunc(1000000000);
        	//Convert integer to string
        	String str=Integer.toString(rand);
        	signupPageObjects.MOBILENUMBERFIELD.click();
            signupPageObjects.MOBILENUMBERFIELD.sendKeys(str);
            //driver.hideKeyboard();
          
            //Enter Password
            signupPageObjects.PWD.click();
            signupPageObjects.PWD.sendKeys(signupPageObjects.PASSWORD);
            driver.hideKeyboard();

            //Confirm Password
            signupPageObjects.CONFIRMPWDFIELD.click();
            signupPageObjects.CONFIRMPWDFIELD.sendKeys(signupPageObjects.PASSWORD);
            driver.hideKeyboard();
            
            //Enter First Name
            signupPageObjects.FIRSTNAME.click();
            signupPageObjects.FIRSTNAME.sendKeys(signupPageObjects.FNAME);
            driver.hideKeyboard();
            
            //Enter Last Name
            signupPageObjects.LASTNAME.click();
            signupPageObjects.LASTNAME.sendKeys(signupPageObjects.LNAME);
            driver.hideKeyboard();
            
            // Choose Industry
            signupPageObjects.INDUSTRY.click();
            signupPageObjects.IND.click();
           
            //Choose Where Did you hear about us
            signupPageObjects.WHEREDIDYOUHEAR.click();
            signupPageObjects.HEAR.click();
        } 
        
        else if(prop.getProperty("platform").equals("ios"))
            {
            	//Enter mobile number
            	//Generate random number for SignUp, radom function is called from AppiumTestBase.java file
            	int rand= randomFunc(1000000000);
            	//Convert integer to string
            	String str=Integer.toString(rand);
            	signupPageObjects.MOBILENUMBERFIELD.click();
                signupPageObjects.MOBILENUMBERFIELD.sendKeys(str);
                
                //Password
                signupPageObjects.PWD.click();
                signupPageObjects.PWD.sendKeys(signupPageObjects.PASSWORD);

                //Confirm Password
                signupPageObjects.CONFIRMPWDFIELD.click();
                signupPageObjects.CONFIRMPWDFIELD.sendKeys(signupPageObjects.PASSWORD);
                
                //Enter First Name
                signupPageObjects.FIRSTNAME.click();
                signupPageObjects.FIRSTNAME.sendKeys(signupPageObjects.FNAME);
                
                //Enter Last Name
                signupPageObjects.LASTNAME.click();
                signupPageObjects.LASTNAME.sendKeys(signupPageObjects.LNAME);
              
                // Choose Industry
                signupPageObjects.INDUSTRY.click();
                signupPageObjects.IND.click();
               
               /* CANNOT CLOSE THE LIST,HENCE NOT EXECUTING THIS	
                * //Choose Where Did you hear about us
                signupPageObjects.WHEREDIDYOUHEAR.click();
                signupPageObjects.HEAR.click();
             */
            }
    }

    // click on the sign up button
    public void clickOnSignInButton()
    {
    	if(prop.getProperty("platform").equals("android"))
        {
    		signupPageObjects.SIGNUPBTN.click();
        }
    	else if(prop.getProperty("platform").equals("ios")){
    		signupPageObjects.CONTINUE.click();
    	}
    }

    //click on next button and then on cancel button to land in news and updates page
    public void clickOnNextCancel(){
    		signupPageObjects.NEXTBTN.click();
    		signupPageObjects.SKIP.click();
    }
    
    // once Signup button is pressed and successful signup happens, then wait for the Search button to appear
    public HomePage waitforHomePage(AppiumDriver<MobileElement> driver){
        waitForPageToLoad(driver,signupPageObjects.SEARCHBTN);
        return new HomePage(driver);
    }
}
