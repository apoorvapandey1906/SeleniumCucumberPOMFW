package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.AccountPage;
import com.qa.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage ;
	
	
	@Given("User has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
	   
		List<Map<String,String>> credentialsList = credTable.asMaps();
		String username = credentialsList.get(0).get("Username");
		String password = credentialsList.get(0).get("Password");
				
	   DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
	   accountPage = loginPage.doLogin(username, password);
	}

	@Given("User is on Accounts page")
	public void user_is_on_accounts_page() {
	    String title = accountPage.getAccountPageTitle();
	    System.out.println("Accounts Page title => "+title);
	}

	@Then("User gets account section")
	public void user_gets_account_section(DataTable sectionList) {
		
		List<String> expectedAccountSectionList = sectionList.asList();
		System.out.println("expectedAccountSectionList=>"+expectedAccountSectionList);
	   List<String> actualAccountSectionList = accountPage.getAccountSectionList();
	   System.out.println("actualAccountSectionList=>"+actualAccountSectionList);
	   
	   Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
	}

	@Then("Account section count should be {int}")
	public void account_section_count_should_be(Integer expectedAccountSectionSize) {
	   Assert.assertTrue(accountPage.getAccountSectionSize()==expectedAccountSectionSize);
	}

}
