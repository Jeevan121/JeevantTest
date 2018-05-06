package com.demo.tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class BaseTest {
	

	String Url = "https://www.emirates.com/ae/english/";

	private WebDriver driver;
	private Actions builder;

	// will launch the browser and the url
	public WebDriver launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Desktop\\drivers\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setBrowserName("firefox");
		capabilities.setVersion("59.0.3");
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver launchBrowserChrome(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\drivers\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	
		driver = new ChromeDriver(capabilities);
		
		driver.get(Url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	// getting the driver object
	public WebDriver getDriver() {
		return driver;
	}

	// getting actions object
	public Actions getActions() {
		builder = new Actions(getDriver());
		return builder;
	}
	
	public void elementPresence(By by, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	// this method will quite the browser instance after executing the script.
	//@AfterTest
	public void tearDown() {
		getDriver().quit();
	}
	
	public void safeType(By by, String Data) {
	    final WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	    getDriver().findElement(by).clear();
	    getDriver().findElement(by).sendKeys(Data);
	  }
	
	public void safeClick(By by) {
	    final WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	    getDriver().findElement(by).click();
	  }
	
	
	public String getCurrentDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate)); //2016/11/16
		String currentDate = dtf.format(localDate);
		
		String [] temp = currentDate.split("/");
		
		String currentDate1 = temp[temp.length-1];
		
		return currentDate1;
		
		
	}
	

}
