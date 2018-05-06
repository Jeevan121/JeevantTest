package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	
	public By departureAirportTxt = By.name("Departure airport");
	
	
	public By searchResultList = By.xpath("//div[@class='ts-fbr-option__price-detail']//strong[@class='ts-fbr-option__price']");

				
	public By departureAirportList = By.xpath("//a[contains(@aria-label,'Dubai International Airport (DXB), Dubai, United Arab Emirates')]");
	
	
	
	public By arrivalAirportTxt = By.name("Arrival airport");
	
	public By arrivalAirportList = By.xpath("//a[contains(@aria-label,'London Heathrow Airport (LHR), London, United Kingdom')]");
	
	public By continueBtn = By.xpath("//a[contains(@class,'cta cta--large cta--primary js-continue-search-flight search-flight__continue--cta')]");
	
	
	public By datePicker = By.id("search-flight-date-picker--depart");
	
	
	
	public By selectTravelDate(String date){
		 By selectTravelDate = By.xpath("//a[@aria-label="+"'"+date+"'"+"]");
		return selectTravelDate;
	}
	
	public By selectReturnDate(String date){
		 By selectReturnDate = By.xpath("//a[@aria-label="+"'"+date+"'"+"]");
		return selectReturnDate;
	}
	
	
	public By searchFlightsBtn = By.xpath("//button/span[text()='Search flights']");
	
	
}
