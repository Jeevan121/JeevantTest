package com.demo.tests;


import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.HomePage;

public class DemoTest extends BaseTest{
	
	HomePage homePage;
		
	@BeforeClass
	public void setUp(){
		launchBrowser();
		homePage = new HomePage(getDriver());
	}
	
	@Test
	public void test(){
		
		elementPresence(homePage.departureAirportTxt,40);
		safeType(homePage.departureAirportTxt,"DXB");
		safeClick(homePage.departureAirportList);
		
		
		elementPresence(homePage.arrivalAirportTxt,40);
		safeType(homePage.arrivalAirportTxt,"LHR");
		safeClick(homePage.arrivalAirportList);
		
		
		//safeClick(homePage.continueBtn);
		
		safeClick(homePage.datePicker);
		
		getActions().moveToElement(getDriver().findElement(homePage.selectTravelDate)).click().build().perform();
		
		getActions().moveToElement(getDriver().findElement(homePage.selectReturnDate)).click().build().perform();
	
		getActions().moveToElement(getDriver().findElement(homePage.searchFlightsBtn)).click().build().perform();
		
		ArrayList<WebElement> price = (ArrayList<WebElement>) getDriver().findElements(By.xpath("//div[@class='ts-fbr-option__price-detail']/strong[@class='ts-fbr-option__price']"));
		
		ArrayList<String> priceLst = new ArrayList<String>();
		for(int i=0;i<price.size()-1;i++){
			String price1 = price.get(i).getText();
			priceLst.add(price1);
		}

		
		Collections.sort(priceLst);

		   System.out.println("After Sorting the price:");
		   for(String counter: priceLst){
				System.out.println(counter);
			}
		}
		
	




}
