package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty" ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				,"rerun:target/failedRerun.txt"},
		monochrome =true,
		glue = {"stepDefinitions","AppHooks"},
		features = {"@target/failedRerun.txt"}
		)
		


public class FailedRun {

}


