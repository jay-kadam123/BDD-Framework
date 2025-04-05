package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions
        (
		features={".//Features/LoginFeature.feature"},  
		glue="stepdefinition",                       
		dryRun= false,     
		monochrome=true,
		plugin= {"pretty","html:target/cucumber-reports/reports_html.html"}
		)












public class Run {
//this class will be empty
}
