package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
	
	private WebDriver driver;	
	private By successMessage = By.xpath("//p[@class='alert alert-success']");
	private By email = By.id("email");
	private By messageTextArea = By.xpath("//textarea[@id='message']");
    private By sendMessageButton = By.id("submitMessage");
    private By subjectHeading = By.id("id_contact");
    private By orderReference = By.name("id_order");
    
    public ContactUsPage(WebDriver driver) {
    	this.driver = driver;
    }
    
    public String getTitlegetContactUsPageTitle() {
    	return driver.getTitle();
    }
    
    public void clickOnSendButton() {
    	driver.findElement(sendMessageButton).click();
    }
    
    public String getSuccessMessage() {
    	return driver.findElement(successMessage).getText();
    }
    
    

    public void fillContactUsPageForm(String heading,String emailId,String message) {
    	Select select = new Select(driver.findElement(subjectHeading));
    	select.selectByVisibleText(heading);
    	driver.findElement(email).clear();
    	driver.findElement(email).sendKeys(emailId);
    	driver.findElement(messageTextArea).sendKeys(message);
    }

}
