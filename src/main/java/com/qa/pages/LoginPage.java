package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//By locators
	private By emailID = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotYourPasswordLink = By.linkText("Forgot your password?");
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//PageActions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkPresent() {
		return driver.findElement(forgotYourPasswordLink).isDisplayed();
	}
	
	public void enterUsername(String username) {
		driver.findElement(emailID).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public AccountPage doLogin(String user, String pwd) {
		driver.findElement(emailID).sendKeys(user);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		//Page chaining , here accountpage object is returned after login , so login page is launching and initiating accountpage.java
		return new AccountPage(driver);
	}

	public void clickOnSIgnINButton() {
		driver.findElement(signInButton).click();
		
	}
}
