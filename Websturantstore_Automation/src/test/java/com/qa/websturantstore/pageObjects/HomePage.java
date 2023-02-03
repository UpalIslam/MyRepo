package com.qa.websturantstore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver ldriver;
	
	
	public HomePage (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public String StainlessTableLable = "stainless work table";
	public String baseURL = "https://www.webstaurantstore.com"; 
	
	public static final String searchBar = "//input[@id='searchval']";
	public static final String searchButton = "(//button[@type='submit'])[1]";


	
	@FindBy(xpath="//input[@id='searchval']")
	WebElement searchBaR;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement SearchBtn;
	
	//**** This method will click on searchBar and search for product based on input ****
	public void doSearch(String productName) {
		searchBaR.sendKeys(productName);
		
	}
	//***** This method will click on submit button *******
	public void submitBtn() {
		SearchBtn.click();
	}
}
