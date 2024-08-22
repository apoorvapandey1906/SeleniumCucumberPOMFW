package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.AccountPage;
import com.qa.pages.ContactUsPage;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageSteps {
	
	private AccountPage accountPage = new AccountPage(DriverFactory.getDriver());
	private ContactUsPage contactUsPage;
	
	@Given("User navigates to contact Us Page")
	public void user_navigates_to_contact_us_page() {
		contactUsPage=accountPage.navigateToContactUsPage();
	    
	}

	@When("User fills the form from the given {string} and rowNumber {int}")
	public void user_fills_the_form_from_the_given_and_row_number(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	   ExcelReader excelReader = new ExcelReader();
	   List<Map<String,String>> testData = excelReader.getData("/Users/Lenovo pc/eclipse-workspace/EclipseWorkspace2/Automation.xlsx", sheetName);
	
	   String heading = testData.get(rowNumber).get("subjectheading");
	   String email = testData.get(rowNumber).get("email");
	   String orderRef = testData.get(rowNumber).get("orderref");
	   String message = testData.get(rowNumber).get("message");
	   
	   contactUsPage.fillContactUsPageForm(heading, email, message);
	}

	@When("User clicks on send button")
	public void user_clicks_on_send_button() {
		contactUsPage.clickOnSendButton();
	}

	@Then("It shows a success message {string}")
	public void it_shows_a_success_message(String message) {
		Assert.assertTrue(contactUsPage.getSuccessMessage().contains(message));
	}
	
	    


}
