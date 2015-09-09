package com.mara.mentor.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by maratest on 9/8/15.
 */
public class Utils {
    private static AppiumDriver<MobileElement> driver;
    public static Properties prop = new Properties();
    static InputStream input = null;

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
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", System.getProperty("deviceOS"));
        capabilities.setCapability("app", System.getProperty("user.dir") + "/build/MaraMentor.apk");
        capabilities.setCapability("appPackage", "com.mara.maramentor");
        capabilities.setCapability("appActivity", "com.mara.maramentor.ui.SplashActivity");
        //driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:" + System.getProperty("environment") + "/wd/hub"), capabilities);

    }

    public static void iosSetup() throws MalformedURLException{
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/build/");
        File app = new File(appDir, "MaraMentorDebug.ipa");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("udid","2dc3bf20559d41565d9f1fd08f738183d9a54ead");
        capabilities.setCapability("platformVersion", "8.3");
        capabilities.setCapability("bundleId","com.maraMentor");
        capabilities.setCapability("deviceName", "iPhone 4S");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
