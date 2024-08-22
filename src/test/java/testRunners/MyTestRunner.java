package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty" ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		
		//tags = "not @Skip",
		monochrome = true,
		glue = {"stepDefinitions","AppHooks"},
		features = {"src/test/resources/AppFeatures/LoginPage.feature"}
)
		
public class MyTestRunner {

}
