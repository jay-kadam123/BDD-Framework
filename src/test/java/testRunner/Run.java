package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions
        (
		//features={".//Features/Contact.feature"},
		//features= {".//Features/"},
        		
        features= {".//features/Contact.feature",".//features/LoginFeature.feature"},
		glue="stepdefinition",                       
		dryRun= false,     
		monochrome=true,
		//tags="@Sanity",
		//tags="@Regression",
		//tags="@Sanity or @Regression",   //all
		//tags="@Sanity and @Regression",   //both name should assign
		tags="@Sanity and not @Regression",
		
		//plugin= {"pretty","html:target/cucumber-reports/reports_html.html"}
		//plugin= {"pretty","json:target/cucumber-reports/reports_json.json"}
		plugin= {"pretty","junit:target/cucumber-reports/reports_xml.xml",
				   "html:target/cucumber-reports/reports_html.html",
				   "json:target/cucumber-reports/reports_json.json"}
		)


public class Run {
//this class will be empty
}
