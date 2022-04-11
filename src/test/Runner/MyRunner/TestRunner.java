package MyRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
		@CucumberOptions(
				//features = "E:/MarketOne -V1/src/main/java/Features/login.feature", //the path of the feature files
				features = "classpath:Features/login.feature",
				
				glue={"stepDefinitions"}, //the path of the step definition files
				//format= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
				monochrome = true, //display the console output in a proper readable format
				strict = true, //it will check if any step is not defined in step definition file
				dryRun = false, //to check the mapping igherkins proper between feature file and step def file
				//tags = {"~@SmokeTest" , "~@RegressionTest", "~@End2End"}			
						//tags = {@Login}
				plugin = { "pretty","html:target/cucumber-reports.html", "json:target/cucumber.json", "junit:target/cucumber.xml" }
				)
	 
	public class TestRunner {
		
	}
	
	//ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
	//ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest
	

