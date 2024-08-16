package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	//Thread local and parallel execution setup
	public static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();
	
	/*This method is used to initialize the Threadlocal driver on the basis of given browser*/
	public WebDriver init_driver(String browser) {
		
		System.out.println("Browser is =>"+browser);
		
		switch(browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			tDriver.set(new ChromeDriver());
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			tDriver.set(new FirefoxDriver());
			break;
		case "safari":
			tDriver.set(new SafariDriver());
			break;
		default:
			System.out.println("Please pass the correct browser value=>"+browser);
			break;
		
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	
	/*
	 * This is used to get the webdriver with Threadlocal
	 * */
	public static synchronized WebDriver getDriver() {
		return tDriver.get();
	}

}
