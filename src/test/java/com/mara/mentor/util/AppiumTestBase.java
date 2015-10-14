package com.mara.mentor.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by maratest on 9/8/15.
 */
public abstract class AppiumTestBase {
    public static AppiumDriver<MobileElement> driver;

    public AppiumTestBase(AppiumDriver<MobileElement> driver)
    {
        this.driver = driver;
    }


    public static void waitForPageToLoad(WebDriver driver, MobileElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    public static WebElement waitForElement(WebDriver driver, MobileElement arg) {
        waitForPageToLoad(driver, arg);
        WebElement el = arg;
        return el;
    }

    public static int randomFunc(int n)
	{
		Random random=new Random();
		return random.nextInt(n);
	}
}
