package stepDefinitions;

import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
 
	private static String title  ;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	   DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {		    
		    Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkPresent());
	}

	@When("User enters username {string}")
	public void user_enters_username(String username) {
	    loginPage.enterUsername(username);
	}

	@When("User enters password {string}")
	public void user_enters_password(String pwd) {
	    loginPage.enterPassword(pwd);
	}

	@When("User clicks on Sign In button")
	public void user_clicks_on_sign_in_button() {
	   loginPage.clickOnSIgnINButton();
	}

	@Then("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		 title = loginPage.getLoginPageTitle();
		 System.out.println("Title of the login Page=>"+title);
	}



}
