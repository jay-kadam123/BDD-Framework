package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	WebDriver driver;
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
   @FindBy(xpath="//a[text()='Contact']")
   private WebElement Contactbutton;
	
   @FindBy(id="recipient-email")
   private WebElement ContactEmailTextbar;
	
   @FindBy(xpath="//button[text()='Send message']")
   private WebElement SendMessagebutton;

   @FindBy(id="recipient-name")
   private WebElement ContactNameTextbar;
   
   public void clickonContactbutton()
   {
	   Contactbutton.click();
   }
   
   public void enterContactEmailTextbar(String Email)
   {
	   ContactEmailTextbar.sendKeys("Email");
   }
   
   public void enterContactNameTextbar(String Name)
   {
	   ContactNameTextbar.sendKeys("Name");
   }
   public void clickonSendMessagebutton()
   {
	   SendMessagebutton.click();
   }
   
   
   
}
