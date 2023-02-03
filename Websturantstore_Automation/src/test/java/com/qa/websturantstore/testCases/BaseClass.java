package com.qa.websturantstore.testCases;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.qa.websturantstore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	
	public static Logger logger;
	
	public static final String searchBar = "//input[@id='searchval']";
	public static final String searchButton = "(//button[@type='submit'])[1]";
	public static final String listingTitles = "//a[@data-testid='itemDescription']";
	public static final String addToCartButton = "//div[60]/div[4]/form/div/div/input[2]";
	public static final String closePopupButton = "//button[@class='close p-2 mr-2 top-1']";
	public static final String paginate = "//*[@id='paging']/nav/ul/li";
	public static final String viewCartButton = "//a[@data-testid='cart-nav-link']";
	public static final String emptyCartButton = "//button[@class='emptyCartButton btn btn-mini btn-ui pull-right']";
	public static final String confirmEmptyCart = "//button[text()='Empty']";
	public static final String nextPageButton = "#paging > nav > ul > li.inline-block.leading-4.align-top.rounded-r-md > a > svg > use";
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		logger = Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();

	}
}

