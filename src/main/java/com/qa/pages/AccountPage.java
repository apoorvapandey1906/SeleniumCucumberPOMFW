package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

	private WebDriver driver;
	
	private By accountSections = By.xpath("//div[@id='center_column']//span");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	
	public int getAccountSectionSize() {
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountSectionList() {
		
		List<String> accountsList = new ArrayList<String>();
		List<WebElement> accountHeaderList = driver.findElements(accountSections);
		
		for(WebElement e : accountHeaderList) {
			accountsList.add(e.getText());
		}
		
		return accountsList;
	}
	
	
	
	
	
	
}
