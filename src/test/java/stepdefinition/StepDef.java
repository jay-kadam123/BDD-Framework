package stepdefinition;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.AddtoCartPage;
import pageobject.ContactPage;
import pageobject.Loginpage;

public class StepDef extends Base 
{
	
	@Before("@Sanity")
	public void setup1() throws IOException
	{
	
		
		 FileInputStream file=new FileInputStream("config.properties");
		 rc =new Properties();
		 rc.load(file);
		 
		 
		log = LogManager.getLogger("StepDef");
		
		 WebDriverManager.chromedriver().clearDriverCache().setup();
		    //System.out.println(WebDriverManager.chromedriver().getDownloadedDriverVersion());
		 System.out.println("it will run for sanity scenario");
		     driver=new ChromeDriver();
		     log.info("Setup1 executed");
	}
	
	@Before("@Regression")
	public void setup2()
	{
		 WebDriverManager.chromedriver().clearDriverCache().setup();
		 System.out.println("it will run for regression scenario");
		    //System.out.println(WebDriverManager.chromedriver().getDownloadedDriverVersion());
		     driver=new ChromeDriver();
		     log.info("Setup2 executed");
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	@Given("User launch ChromeBrowser")
	public void user_launch_chrome_browser() {
	   
	     driver.manage().window().maximize();
	      Llg=new Loginpage(driver);
	      ACP=new AddtoCartPage(driver);
	       cp=new ContactPage(driver);
	       log.info("user launch chrome browser");
	}

	@When("user opens URL {string}")
	public void user_opens_url(String URL) {
	    driver.get(URL);
	    log.info("url launch");
	}

	@When("click on loginbutton")
	public void click_on_loginbutton() {
		Llg.clickonloginbutton();
		   log.info("user click on login button");
	}

	@When("User enter Username as {string} and Password as {string}")
	public void user_enter_username_as_and_password_as(String username, String password) throws InterruptedException {
	
		Thread.sleep(2000);
		Llg.enterusername(username);
		Thread.sleep(2000);
		Llg.enterpassword(password);
		   log.info("user enter username and password");
	}

	@When("click on login")
	public void click_on_login() {
		Llg.clickonlogin();
		   log.info("user clcik on loginbutton");
	}

	@Then("user will view Dashboard {string}")
	public void page_title_will_be(String ExpectedTitle) {
	    
		String ActualTitle = driver.getTitle();
		System.out.println("Tiltle"+ ":"+ActualTitle);
		if(ActualTitle.equals(ExpectedTitle))
		{
			   log.warn("tile is showing");
			Assert.assertTrue(true);
		}
		else
		{
			log.warn("tile is showing");
			Assert.assertTrue(false);
		}
	}

	@When("User click on logout button")
	public void user_click_on_logout_button() throws InterruptedException {
		Thread.sleep(3000);
		Llg.ClickonLogout();
		   log.info("user click on logout button");
	}

	@Then("page will logout")
	public void page_will_logout() {
		 driver.close();
		   log.info("Browser close");
	}

	@Then("Browser will close")
	public void browser_will_close() {
		
		// driver.quit();
	}
	
	

@Then("user will view Dashboard")
public void user_will_view_dashboard() {

	String Actual_getTitle = ACP.gettitile();
	System.out.println("Actual_Title"+Actual_getTitle );
	String Expected_Title = "STORE";
	
	if(Actual_getTitle.equals(Expected_Title))
	{
		   log.warn("user get title");
		Assert.assertTrue(true);
	}
	else
	{
		   log.warn("user not get tile");
		Assert.assertFalse(false);
	}

}

@When("User click on product")
public void user_click_on_product() throws InterruptedException {
	Thread.sleep(3000);
	ACP.clickonproduct();
	   log.info("user click on product button");
}

@When("click on add to cart")
public void click_on_add_to_cart() throws InterruptedException {
	Thread.sleep(3000);
	ACP.clickonaddtocartbutton();
	try {
	WebDriverWait waits= new WebDriverWait(driver,Duration.ofSeconds(2000));
	 Alert alert = waits.until(ExpectedConditions.alertIsPresent());
	 alert.dismiss();
	}
	catch(NoAlertPresentException e)
	{
		System.err.println("no alert"+ e.getMessage());
	}
	Thread.sleep(3000);
}

@When("go to the cartlisting")
public void go_to_the_cartlisting() throws InterruptedException {

	ACP.clickoncartbutton();
	   log.info("user click on cart button");
	Thread.sleep(3000);
	
}

@Then("product will list")
public void product_will_list() throws InterruptedException {

	Thread.sleep(3000);
	String Actual_Text = ACP.productlistdetails();
	System.out.println(Actual_Text);
	String Expected_Text = "Samsung galaxy s6";
	
	if(Actual_Text.equals(Expected_Text))
	{
		   log.info("user see the product list");
		Assert.assertTrue(true);
	}
	else
	{
		   log.info("user not see the product list");
		Assert.assertTrue(false);
	}
}

@When("User click on Place order")
public void user_click_on_place_order() throws InterruptedException
{
	Thread.sleep(3000);
 ACP.clickonPlaceorderbutton();
 log.info("user click on product button");
}


@When("enter Customer data")
public void enter_customer_data() throws InterruptedException {
	Thread.sleep(3000);
	ACP.enternametextbar("jay");
	ACP.entercountrytextbar("india");
	ACP.entercitytextbarr("test");
	ACP.entercardtextbar("44444");
	ACP.entermonthtextbar("may");
	ACP.enteryeartextbar("48484");
	ACP.clickonPurchase();
	   log.info("user enetr customer data ");
	
}

@Then("Order will placed {string}")
public void order_will_placed(String string) throws InterruptedException {

	Thread.sleep(3000);
	String Actual_Conformation_text=ACP.Conformation_text();
	System.out.println(Actual_Conformation_text);
	String Expected_Conformation_text="Thank you for your purchase!";

	if(Actual_Conformation_text.equals(Expected_Conformation_text))
	{
		   log.info("order is placed");
		Assert.assertTrue(true);
		
	}
	else
	{
		   log.info("order is not placed ");
		Assert.assertTrue(false);
	}
}

@Then("click on ok button")
public void click_on_ok_button() throws InterruptedException {
	Thread.sleep(3000);
	ACP.clickonokbutton();
	log.info("user click on ok button");
}

@When("user click on contact")
public void user_click_on_contact() throws InterruptedException {
	Thread.sleep(3000);
   cp.clickonContactbutton();
	log.info("user click on contact button");
}

@When("enter contact details")
public void enter_contact_details() throws InterruptedException {
	Thread.sleep(3000);
   cp.enterContactEmailTextbar("jay");
	log.info("user enter email textbar");
}

@When("click on Send Message button")
public void click_on_send_message_button() throws InterruptedException {
	Thread.sleep(3000);
	cp.clickonSendMessagebutton();
	driver.switchTo().alert().dismiss();
	Thread.sleep(3000);
}


@When("enter contact details with name")
public void enter_contact_details_with_name() throws InterruptedException {
	Thread.sleep(3000);
	cp.enterContactNameTextbar("basu");
	log.info("user enter contact textbar");
}
/////////////////////////////////////////////////////////////////////////////////////

@After(order=1)
public void teardown1(Scenario sc) 
{
	
	if(sc.isFailed()==true)
	{
		
		TakesScreenshot ts=((TakesScreenshot)driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String screenpath="C:\\Users\\Jaywant\\eclipse-workspace\\DemoBlaze\\Screenshot\\test1.png";
		File newdes=new File(screenpath);
		try {
			FileUtils.copyFile(src, newdes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	driver.quit();
}




//@After(order=2)
//public void teardown2()
//{
//	driver.quit();
//}
//
//@BeforeStep
//public void beforestep()
//{
//	System.out.println("this will run before each step");
//}
//
//@AfterStep
//public void afterstep()
//{
//	System.out.println("this will run after each step");
//}
	
}
