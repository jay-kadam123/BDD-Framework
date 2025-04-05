package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartPage {

	WebDriver driver;
	
	
	public AddtoCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
		 
	 @FindBy(xpath="(//img[@class='card-img-top img-fluid'])[1]")
	 private WebElement product_button;
	 
	 @FindBy(xpath="//a[@onclick='addToCart(1)']")
	 private WebElement addtocartbutton;
	 
	 @FindBy(id="cartur")
	 private WebElement cartbutton;
	 
	 @FindBy(xpath="//button[@class='btn btn-success']")
	 private WebElement Placeorderbutton;
	 	 
	 @FindBy(xpath="//td[text()='Samsung galaxy s6']")
	 private WebElement productdetails;
	 
	 @FindBy(id="name")
	 private WebElement nametextbar; 
	 
	 @FindBy(id="country")
	 private WebElement countrytextbar;
	 
	 @FindBy(id="city")
	 private WebElement citytextbar; 
	 
	 @FindBy(id="card")
	 private WebElement cardtextbar;
	 
	 @FindBy(id="month")
	 private WebElement monthtextbar;
	 
	 @FindBy(id="year")
	 private WebElement yeartextbar;
	 
	 @FindBy(xpath="(//button[@class='btn btn-primary'])[3]")
	 private WebElement Purchase;
	 
	 @FindBy(xpath="//button[@class='confirm btn btn-lg btn-primary']")
	 private WebElement okbutton;
	 
	 @FindBy(xpath="//h2[text()='Thank you for your purchase!']")
	 private WebElement Conformation_text;
	 
	 public String gettitile()
	 {
		 return driver.getTitle();
	 }
	 
	 public void clickonproduct()
	 {
		 product_button.click();
	 }
	 
	 public void clickonaddtocartbutton()
	 {
		 addtocartbutton.click();
	 }
	 
	 public void clickoncartbutton()
	 {
		 cartbutton.click();
	 }
	 
	 public String productlistdetails()
	 {
		 return productdetails.getText();
	 }
	 
	 public void clickonPlaceorderbutton()
	 {
		 Placeorderbutton.click();
	 }
	 
	 public void enternametextbar(String Username)
	 {
		 nametextbar.sendKeys(Username);
	 }
	 
	 public void entercountrytextbar(String country)
	 {
		 countrytextbar.sendKeys(country);
	 }
	 
	 public void entercitytextbarr(String city)
	 {
		 citytextbar.sendKeys(city);
	 }

	 public void entercardtextbar(String card)
	 {
		 cardtextbar.sendKeys(card);
	 }
	 
	 public void entermonthtextbar(String month)
	 {
		 monthtextbar.sendKeys(month);
	 }
	 
	 public void enteryeartextbar(String year)
	 {
		 yeartextbar.sendKeys(year);
	 }
	 
	 public String Conformation_text()
	 {
		 return Conformation_text.getText();
	 }
	 
	 public void clickonPurchase()
	 {
		 Purchase.click();
	 }
	 
	 public void clickonokbutton()
	 {
		 okbutton.click();
	 }
	
	
	
	
	
	
	
	
	
	
}
