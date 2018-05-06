package com.demo.tests;


import java.util.ArrayList;
import java.util.Collections;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.HomePage;

public class DemoTest extends BaseTest{
	
	HomePage homePage;
	
	//launching the browser with emirates url
	@BeforeClass
	public void setUp(){
		launchBrowser();
		homePage = new HomePage(getDriver());
	}
	
	
	@Test
	public void test() throws InterruptedException{
		
		// waiting for  the emirates home page should display and entering the departure airport
		elementPresence(homePage.departureAirportTxt,40);
		safeType(homePage.departureAirportTxt,"DXB");
		safeClick(homePage.departureAirportList);
		
		// Entering  the arrival airport
		elementPresence(homePage.arrivalAirportTxt,40);
		safeType(homePage.arrivalAirportTxt,"LHR");
		safeClick(homePage.arrivalAirportList);
		
		// clicking on the data picker text box for selecting the particular travel date
		safeClick(homePage.datePicker);
		
		// clicking on the particular travel date from the calender and its parameterized enter any date which one needs to travel
		scrollIntoElement(homePage.selectTravelDate("13  May 18"));
		safeClick(homePage.selectTravelDate("13  May 18"));
		Thread.sleep(1000);
		
		//clicking on the particular retunr travel date from the calender and its parameterized enter any date which one needs to travel
		scrollIntoElement(homePage.selectReturnDate("20  May 18"));
		safeClick(homePage.selectReturnDate("20  May 18"));
		Thread.sleep(1000);
		
		// clicking on into the Search button
		scrollIntoElement(homePage.searchFlightsBtn);
		safeClick(homePage.searchFlightsBtn);
		
		// waiting for the flights searcg results should display
		elementPresence(homePage.searchResultList,40);
		scrollIntoElement(homePage.searchResultList);
		
		// getting all the price into the Array list
		ArrayList<WebElement> price = (ArrayList<WebElement>) getDriver().findElements(homePage.searchResultList);
		
		System.out.println("the web elements are ::"+price);
		
		// getting the price from the search result page and adding into the array list
		ArrayList<String> priceLst = new ArrayList<String>();
		for(int i=0;i<price.size()-1;i++){
			String price1 = price.get(i).getText();
			priceLst.add(price1);
		}

		// sorting the array list with captured price from the search result page
		Collections.sort(priceLst);

		   System.out.println("After Sorting the price:");
		   for(String counter: priceLst){
				System.out.println(counter);
			}
		}

}
