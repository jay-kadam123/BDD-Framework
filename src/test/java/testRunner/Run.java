package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions
        (
		features={".//Features/Addtocart.feature"},  
		glue="stepdefinition",                       
		dryRun= false,     
		monochrome=true,
		//plugin= {"pretty","html:target/cucumber-reports/reports_html.html"}
		//plugin= {"pretty","json:target/cucumber-reports/reports_json.json"}
		plugin= {"pretty","junit:target/cucumber-reports/reports_xml.xml",
				   "html:target/cucumber-reports/reports_html.html",
				   "json:target/cucumber-reports/reports_json.json"}
		)



public class Run {
//this class will be empty
}
