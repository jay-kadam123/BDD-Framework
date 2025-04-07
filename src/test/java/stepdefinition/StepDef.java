package stepdefinition;


import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.AddtoCartPage;
import pageobject.ContactPage;
import pageobject.Loginpage;

public class StepDef extends Base 
{
	
	@Given("User launch ChromeBrowser")
	public void user_launch_chrome_browser() {
	    WebDriverManager.chromedriver().clearDriverCache().setup();
	    //System.out.println(WebDriverManager.chromedriver().getDownloadedDriverVersion());
	     driver=new ChromeDriver();
	     driver.manage().window().maximize();
	      Llg=new Loginpage(driver);
	      ACP=new AddtoCartPage(driver);
	       cp=new ContactPage(driver);
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

	@Then("user will view Dashboard {string}")
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
	
	

@Then("user will view Dashboard")
public void user_will_view_dashboard() {

	String Actual_getTitle = ACP.gettitile();
	System.out.println("Actual_Title"+Actual_getTitle );
	String Expected_Title = "STORE";
	
	if(Actual_getTitle.equals(Expected_Title))
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertFalse(false);
	}

}

@When("User click on product")
public void user_click_on_product() throws InterruptedException {
	Thread.sleep(3000);
	ACP.clickonproduct();
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
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
}

@When("User click on Place order")
public void user_click_on_place_order() throws InterruptedException
{
	Thread.sleep(3000);
 ACP.clickonPlaceorderbutton();
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
	
}

@Then("Order will placed {string}")
public void order_will_placed(String string) throws InterruptedException {

	Thread.sleep(3000);
	String Actual_Conformation_text=ACP.Conformation_text();
	System.out.println(Actual_Conformation_text);
	String Expected_Conformation_text="Thank you for your purchase!";

	if(Actual_Conformation_text.equals(Expected_Conformation_text))
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
}

@Then("click on ok button")
public void click_on_ok_button() throws InterruptedException {
	Thread.sleep(3000);
	ACP.clickonokbutton();
}

@When("user click on contact")
public void user_click_on_contact() throws InterruptedException {
	Thread.sleep(3000);
   cp.clickonContactbutton();
}

@When("enter contact details")
public void enter_contact_details() throws InterruptedException {
	Thread.sleep(3000);
   cp.enterContactEmailTextbar("jay");
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
}



	
}
