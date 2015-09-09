package com.mara.mentor.pages;

import com.mara.mentor.pageobjects.HomePageObjects;
import com.mara.mentor.pageobjects.LoginPageObjects;
import com.mara.mentor.util.AppiumTestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by maratest on 9/8/15.
 */
public class LoginPage extends AppiumTestBase {

    public static Properties prop = new Properties();
    public static InputStream input = null;

    LoginPageObjects loginPageObjects = new LoginPageObjects();
    HomePageObjects homePageObjects = new HomePageObjects();

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), loginPageObjects);

    }

    public LoginPage enterValidCredentails(AppiumDriver<MobileElement> driver) throws IOException {
        selectCountryCode();
        enterLoginDetails();
        clickOnSignInButton();
        return new LoginPage(driver);
    }

    // select country code .. at the moment the first country in the list Algeria is selected
    public void selectCountryCode() throws IOException{

        input = new FileInputStream("property/platform.properties");
        prop.load(input);
        if(prop.getProperty("platform").equals("android")){
            loginPageObjects.COUNTRYCODE.click();
            waitForPageToLoad(driver,loginPageObjects.COUNTRYNAME);
            loginPageObjects.COUNTRYNAME.click();
            waitForPageToLoad(driver,loginPageObjects.MOBILENUMBERFIELD);
        }
        else if(prop.getProperty("platform").equals("ios"))
        {
            System.out.println("Country Code is already pre-selected for iOS app if the sim is installed");
        }

    }

    // enter the mobile number and password
    public void enterLoginDetails(){
        if(prop.getProperty("platform").equals("android"))
        {
            // Directly sending strings to a text field sometimes does not dimiss the keyboard .
            // So, its a safe option to first click on the field,send keys and then hide the keyboard.
            loginPageObjects.MOBILENUMBERFIELD.click();
            loginPageObjects.MOBILENUMBERFIELD.sendKeys(loginPageObjects.MOBILENUMBER);
            driver.hideKeyboard();

            // Directly sending strings to a text field sometimes does not dimiss the keyboard .
            // So, its a safe option to first click on the field,send keys and then hide the keyboard.
            loginPageObjects.PASSWORDFIELD.click();
            loginPageObjects.PASSWORDFIELD.sendKeys(loginPageObjects.PASSWORD);
            driver.hideKeyboard();

        }
        else if(prop.getProperty("platform").equals("ios"))
        {
            loginPageObjects.MOBILENUMBERFIELD.sendKeys(loginPageObjects.MOBILENUMBERiOS);
            loginPageObjects.PASSWORDFIELD.sendKeys(loginPageObjects.PASSWORD);
            driver.hideKeyboard();

        }


    }

    // click on the sign in button
    public void clickOnSignInButton()
    {
        loginPageObjects.SIGNINBTN.click();
    }

    // once login button is pressed and successfull login happens, then wait for the search button to appear
    public HomePage waitforHomePage(AppiumDriver<MobileElement> driver){
        waitForPageToLoad(driver,loginPageObjects.SEARCHBTN);
        return new HomePage(driver);
    }


}
