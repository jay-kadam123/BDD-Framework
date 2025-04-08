package stepdefinition;
//parent class




import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;


import pageobject.AddtoCartPage;
import pageobject.ContactPage;
import pageobject.Loginpage;
import org.apache.logging.log4j.*;

public class Base {

	public WebDriver driver;
	public Loginpage Llg;
	public AddtoCartPage ACP;
	public ContactPage cp;
	public static Logger log;
	public Properties rc ;
	
	public String generaterandromnumber()
	{
		
		return RandomStringUtils.randomAlphabetic(5);
	}
	
}
