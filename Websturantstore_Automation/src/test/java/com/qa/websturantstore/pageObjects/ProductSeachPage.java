package com.qa.websturantstore.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSeachPage {
	
WebDriver ldriver;

	public ProductSeachPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
	}
		
	public static final String listingTitles = "//a[@data-testid='itemDescription']";
	public static final String addToCartButton = "//div[60]/div[4]/form/div/div/input[2]";
	public static final String closePopupButton = "//button[@class='close p-2 mr-2 top-1']";
	public static final String paginate = "//*[@id='paging']/nav/ul/li";
	public static final String viewCartButton = "//a[@data-testid='cart-nav-link']";
	public static final String emptyCartButton = "//button[@class='emptyCartButton btn btn-mini btn-ui pull-right']";
	public static final String confirmEmptyCart = "//button[text()='Empty']";
	public static final String nextPageButton = "#paging > nav > ul > li.inline-block.leading-4.align-top.rounded-r-md > a > svg > use";
	
	By nextPageBtn = By.cssSelector(nextPageButton);
	By listingTitleLink =By.xpath(listingTitles);
	By addToCartBtnLink = By.xpath(addToCartButton);
	By closePopUp = By.xpath(closePopupButton);
	By viewCartBtn = By.xpath(viewCartButton);
	By emptyCartBtn = By.xpath(emptyCartButton);
	By confirmEmptyBtn = By.xpath(confirmEmptyCart);
	
	utilities ul = new utilities(ldriver);
	
	@FindBy(xpath="//a[@data-testid='itemDescription']")
	WebElement listingTitle;
	
	@FindBy(xpath="//div[60]/div[4]/form/div/div/input[2]")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//button[@class='close p-2 mr-2 top-1']")
	WebElement closePopupBtn;
	
	@FindBy(xpath="//*[@id='paging']/nav/ul/li")
		WebElement Paging;
	
	@FindBy(xpath="//a[@data-testid='cart-nav-link']")
		WebElement viewCart;
	
	@FindBy(xpath="//button[@class='emptyCartButton btn btn-mini btn-ui pull-right']")
	WebElement emptyCart;
	
	@FindBy(xpath="//button[text()='Empty']")
		WebElement confirmEmptyCartBtn;
	
	@FindBy(xpath= "#paging > nav > ul > li.inline-block.leading-4.align-top.rounded-r-md > a > svg > use")
		WebElement nxtPageBtn;
	
	
	//***** Verifying all page titles on Every Searched Page Logic ******
	public void verfiyTitlesOnAllSearchPages( By listing, By nextPage, String word){
		By totalPages =By.xpath(paginate);
		List<WebElement> totalPagesCount =ul.getElements(totalPages);
		int totalPageCount = (totalPagesCount.size()+1);
		System.out.println(totalPagesCount);
		
		for(int j = 1; j<totalPageCount;j++)
		{
		List<WebElement> list =	ul.getElements(listing);
			for(int i =0;i<list.size();i++)
			{
				String elementText = list.get(i).getText();
				System.out.println(elementText);
				if(elementText.trim().contains(word)) {
					System.out.println("The Word :"+ word + " is present");
				}
				else {
					
					System.out.println("The Word :"+ word + " is not present");
					
				}				
		}		
			ul.doMoveToElement(nextPage);		
			}		
}
	public void addToCart() {
		ul.doClick(addToCartBtnLink);
	}
	
	public void closePopup() {
		ul.doClick(closePopUp);
	}
	
	public void viewCart() throws InterruptedException{
		Thread.sleep(1000L);
		ul.implicitWait(viewCartBtn);
		ul.doClick(viewCartBtn);
	}
	
	public void EmptyCart() {
		ul.doClick(emptyCartBtn);
	}
	public void ConfirmEmptyCart() {
		ul.doClick(confirmEmptyBtn);
	}
	
}