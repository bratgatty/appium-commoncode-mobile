package com.mara.mentor.util;

import com.mara.mentor.pageobjects.WelcomePageObjects;
import com.mara.mentor.pages.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by maratest on 9/8/15.
 */
public class Utils {
    private static AppiumDriver driver;
    public static Properties prop = new Properties();
    static InputStream input = null;
    private static WelcomePage welcomePage;
    private static HomePage homePage;
    private static WelcomePageObjects welcomePageObjects;

    public static AppiumDriver<MobileElement> getDriver() throws IOException{
        input = new FileInputStream("property/platform.properties");
        prop.load(input);
        if(prop.getProperty("platform").equals("android")){
            androidSetup();


        }else if (prop.getProperty("platform").equals("ios")){
            iosSetup();
        }
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        return driver;
    }

    public static void androidSetup() throws MalformedURLException{
        //System.out.println("Appium Server Ports**********" + System.getProperty("environment"));
        //System.out.println("device ID**********" + System.getProperty("deviceId"));
        //System.out.println("device OS**********" + System.getProperty("deviceOS"));
        //System.out.println("http://127.0.0.1:" + System.getProperty("environment") + "/wd/hub");
        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability("deviceName", "Samsung");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", System.getProperty("deviceOS"));
        capabilities.setCapability("app", System.getProperty("user.dir") + "/build/MaraMentor.apk");
        capabilities.setCapability("appPackage", "com.mara.maramentor");
        capabilities.setCapability("appActivity", "com.mara.maramentor.ui.SplashActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:" + System.getProperty("environment") + "/wd/hub"), capabilities);

    }

    public static void iosSetup() throws MalformedURLException{
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/build/");
        File app = new File(appDir, "MaraMentorDebug.ipa");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("udid","2dc3bf20559d41565d9f1fd08f738183d9a54ead");
        capabilities.setCapability("platformVersion", "8.4");
        capabilities.setCapability("bundleId","com.maraMentor");
        capabilities.setCapability("deviceName", "Brattys");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }




    public static HomePage checkIfLoggedIn(AppiumDriver<MobileElement> driver) throws IOException, InterruptedException
    {
        input = new FileInputStream("property/platform.properties");
        prop.load(input);
        if(prop.getProperty("platform").equals("android"))
        {
            // For android platform, for every tests, app starts from login screen.
            // So, it makes sense to call the login method directly
           doDirectLogin();
        }else if (prop.getProperty("platform").equals("ios"))
        {
            // In case of iOS, we need to check if the user is already logged in
            // If already logged  in, return homepage driver
            if(checkIfUserhasAlreadyLoggedIn())
            {
                return new HomePage(driver);
            }
            else
            {
                // Else, go ahead and login with existing credentials
                doDirectLogin();
            }

        }
        return new HomePage(driver);

    }

    private static boolean checkIfUserhasAlreadyLoggedIn()
    {
        // If LOG IN button is not present isEmpty method wil return true
        // This means user has already logged in
        return driver.findElements(By.name("LOG IN")).isEmpty();

    }

    public static void doDirectLogin() throws InterruptedException,IOException
    {
        welcomePage = new WelcomePage(driver);
        homePage = welcomePage.waitforWelcomePage(driver).clickonLogin(driver).waitforLoginPage(driver).enterValidCredentails(driver).waitforHomePage(driver);
        Assert.assertTrue(homePage.verifySearchBtnDisplayed(driver));
    }
}

