package stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.Loginpage;

public class StepDef {

	WebDriver driver;
	Loginpage Llg;
	
	
	@Given("User launch ChromeBrowser")
	public void user_launch_chrome_browser() {
	    WebDriverManager.chromedriver().clearDriverCache().setup();
	    //System.out.println(WebDriverManager.chromedriver().getDownloadedDriverVersion());
	     driver=new ChromeDriver();
	     driver.manage().window().maximize();
	      Llg=new Loginpage(driver);
	}

	@When("user opens URL {string}")
	public void user_opens_url(String URL) {
	    driver.get(URL);
	}

	@When("click on loginbutton")
	public void click_on_loginbutton() {
		Llg.clickonloginbutton();
	}

	@When("User enter Username as {string} and Password as {string}")
	public void user_enter_username_as_and_password_as(String username, String password) throws InterruptedException {
	
		Thread.sleep(2000);
		Llg.enterusername(username);
		Thread.sleep(2000);
		Llg.enterpassword(password);
	}

	@When("click on login")
	public void click_on_login() {
		Llg.clickonlogin();
	}

	@Then("Page title will be {string}")
	public void page_title_will_be(String ExpectedTitle) {
	    
		String ActualTitle = driver.getTitle();
		System.out.println("Tiltle"+ ":"+ActualTitle);
		if(ActualTitle.equals(ExpectedTitle))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	@When("User click on logout button")
	public void user_click_on_logout_button() throws InterruptedException {
		Thread.sleep(3000);
		Llg.ClickonLogout();
	}

	@Then("page will logout")
	public void page_will_logout() {
		 driver.close();
	}

	@Then("Browser will close")
	public void browser_will_close() {
		
		 driver.quit();
	}
}
