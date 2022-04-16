package MyRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

//import com.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import managers.FileReaderManager;
//import managers.FileReaderManager;

	@RunWith(Cucumber.class)
	
		@CucumberOptions(
				//features = "E:/MarketOne -V1/src/main/java/Features/login.feature", //the path of the feature files
				features = "classpath:Features/login.feature",
				
						//E:\MarketOne -V1\src\test\resources\Features\login.feature
						///MarketOnce/src/test/resources/Features/login.feature
				// classpath
				glue={"stepDefinitions"}, //the path of the step definition files
				//format= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
				//plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
						//tags = {"@Login"},
				plugin = { "pretty","html:target/cucumber-reports.html", "json:target/cucumber.json", "junit:target/cucumber.xml" },
				monochrome = true, //display the console output in a proper readable format
				strict = true, //it will check if any step is not defined in step definition file
				
				
				dryRun = false //to check the mapping igherkins proper between feature file and step def file
				//tags = {"~@SmokeTest" , "~@RegressionTest", "~@End2End"}			
						
			//	plugin = { "pretty","html:target/cucumber-reports.html", "json:target/cucumber.json", "junit:target/cucumber.xml","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }
			
				)
	 
	public class TestRunner {
		
		// adding method to write the report.
		
		@AfterClass
		public static void writeExtentReport() {
			//Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
			//Reporter.loadXMLConfig(new File("E:/MarketOne -V1/configs/extent-config.xml"));
		}
		
	}
	
	//ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
	//ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest
	

