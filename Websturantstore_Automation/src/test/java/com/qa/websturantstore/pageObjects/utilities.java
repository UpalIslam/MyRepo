package com.qa.websturantstore.pageObjects;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.websturantstore.testCases.BaseClass;


public class utilities extends BaseClass{
	WebDriver ldriver;
	
	public utilities(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	//********* This method will find the WebElement *********
	public WebElement getElement(By locator) {
		return driver.findElement(locator);

}
	//********* This method will find the WebElements *********
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
}
	
	//***** Action Method ***********
	public void doMoveToElement(By locator) {
		Actions action = new Actions (driver);
		action.moveToElement(getElement(locator)).click().build().perform();
	}
	//****** This method is for clicking on a locator *******
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	//******* This method will quit the browser********
	public static void doQuit() {
		driver.quit();
	}
	
	//****** This method will get the element and search based on the values entered******
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	// ***** This method will wait for element to visible ****
	public void implicitWait(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	// **** This method will take screenshot ******
	public void takeScreenshot(String fileName) throws IOException {
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("/Users/upalislam/eclipse-workspace/Websturantstore_Automation/Screenshots/"
		+fileName+".jpg"));
	}
	
	//***** This method will count the size of Elements ******
	public int getElementsCount(By locator) {
			return getElements(locator).size();
	}
	
	//**** This method will verify if the element is present *****
	public boolean verifyElementPresent(By locator) {
		int elementCount = getElementsCount(locator);
		System.out.println("Total elements found :" + elementCount);
		if(elementCount<=1) {
			System.out.println("Element Found " + locator);
			return true;
		}else {
			System.out.println("Element not found :" + locator);
		}return false;
	}
	
	//******* To get all the WebElements and add them to ArrayList
	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e:eleList) {
			String eleText = e.getText();
			if(!eleText.isEmpty()) {
				eleTextList.add(eleText);
			}
			
		}return eleTextList;
	}

	
	
	
	
	
}
