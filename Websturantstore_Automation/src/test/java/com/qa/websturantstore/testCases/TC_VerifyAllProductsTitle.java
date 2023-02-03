package com.qa.websturantstore.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.qa.websturantstore.pageObjects.HomePage;
import com.qa.websturantstore.pageObjects.ProductSeachPage;

public class TC_VerifyAllProductsTitle extends BaseClass{

	public String PrductSearchName = "stainless work table";	
	public String verifyTitlePresentWord = "Table";
	By nextPageBtn = By.cssSelector(nextPageButton);
	By listingTitle =By.xpath(listingTitles);

	@Test
	public void VerifyAllProducts() throws InterruptedException{
		
		//** This will navigate to URL
		driver.get(baseURL);
		HomePage hp = new HomePage(driver);
		
		//** This will Search given product name***
		hp.doSearch(PrductSearchName);
		//** This method will hit submit btn after entering the product on the search bar **
		hp.submitBtn();

		ProductSeachPage ps = new ProductSeachPage(driver);
			
		//*** This method will verify product titles on every pages ****
		ps.verfiyTitlesOnAllSearchPages( listingTitle, nextPageBtn, verifyTitlePresentWord);
		
		//*** This method will add the last item to cart ***
		ps.addToCart();
		//*** This method will close the popup ***
		ps.closePopup();
		//*** This method will view cart after adding the product ***
		ps.viewCart();
		
		//**** This method will empty the cart ****
		ps.EmptyCart();
		
		//**** This method will click on confirm btn to empty the cart ****
		ps.ConfirmEmptyCart();
	}
	
	
	
}
