package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="(//li[@class='nav-item'])[4]")
	private WebElement login_button;
	
	@FindBy(xpath="(//button[text()='Close'])[3]")
	private WebElement close_button;
	
	@FindBy(xpath="//input[@id='loginusername']")
	private WebElement Username_textbar;
	
	@FindBy(xpath="//input[@id='loginpassword']")
	private WebElement password_textbar;
	
	@FindBy(xpath="//button[@onclick='logIn()']")
	private WebElement Submit_button;
	
	@FindBy(xpath="//a[@onclick='logOut()']")
	private WebElement Logout_button;	

	
	public void clickonloginbutton()
	{
		login_button.click();
	}
	
	public void clickonclosebutton()
	{
		close_button.click();
	}
	
	public void enterusername(String LoginUsername)
	{
		Username_textbar.sendKeys(LoginUsername);
	}
	
	public void enterpassword(String LoginPassword)
	{
		password_textbar.sendKeys(LoginPassword);
	}
	
	public void clickonlogin()
	{
		Submit_button.click();
		
    }
	
	public void ClickonLogout()
	{
		Logout_button.click();
	}
	
	
	
}
