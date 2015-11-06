package com.mara.mentor.pageobjects;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;


public class AdvanceSearchPageObjects 
{
 
	//Mobile Element to get page title
	@AndroidFindBy(id ="com.mara.maramentor:id/search_view")
	@iOSFindBy(name="Search Mentor")
    public MobileElement  advanceSearchPageTitle;															
	
	//Mobile Element to get Search text field to enter userName
	@AndroidFindBy(id ="com.mara.maramentor:id/search_view")
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]")
    public MobileElement  searchNameTextField;															  
	
	public String mentorName="Bharat";
	
	//Mobile Element to get select a country field
	@AndroidFindBy(name="Select a Country")
	@iOSFindBy(name="Select a country")
    public MobileElement  selectCountryButton;	
	
	// Mobile element to select industry from CountryList
	@AndroidFindBy(name="South Africa")
	@iOSFindBy(name="South Africa")
    public MobileElement  selectCountryName;	
	
	public String country="South Africa";
	public String country1="+27";
	
	//Mobile Element to get select a Industry field
	@AndroidFindBy(name="Select a Industry")
	@iOSFindBy(name="Select a Industry")
    public MobileElement  selectIndustry;																		
	
	// Mobile element to select industry from IndustryList
	@AndroidFindBy(name="Tourism")
	@iOSFindBy(name="Tourism")
    public MobileElement  industryName;																		
	
	public String industry="Tourism";
	
	//Mobile Element to get Search Button 
	@AndroidFindBy(id="com.mara.maramentor:id/btn_search")
	@iOSFindBy(name="SEARCH")
    public MobileElement  searchButton;			
	
	
	@AndroidFindBy(id="com.mara.maramentor:id/mentor_name_textview")
	@iOSFindBy(xpath="//UIACollectionView//UIACollectionCell")
    public MobileElement mentorsResultList;	                                                      //Mentor search results
	
	
	
	@AndroidFindBy(id="com.mara.maramentor:id/mentor_industry_textview")
	@iOSFindBy(xpath="//UIACollectionView//UIACollectionCell//UIAStaticText[@label='TOURISM']")
    public MobileElement mentorsResultListByIndustry;
	
		
	@AndroidFindBy(id="com.mara.maramentor:id/mentor_imageview")
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]")
    public MobileElement mentorProfileImageTap;

	
	

	
	
}
