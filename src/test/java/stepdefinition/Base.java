package stepdefinition;
//parent class

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageobject.AddtoCartPage;
import pageobject.ContactPage;
import pageobject.Loginpage;

public class Base {

	public WebDriver driver;
	public Loginpage Llg;
	public AddtoCartPage ACP;
	public ContactPage cp;
	
	
	public String generaterandromnumber() {
		
		return RandomStringUtils.randomAlphabetic(5);
	}
	
}
