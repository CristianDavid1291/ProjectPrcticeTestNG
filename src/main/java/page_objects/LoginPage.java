package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		 this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user_email")
	WebElement userEmail;
	
	@FindBy(id = "user_password")
	WebElement userPassword;

	@FindBy(css = "input[name='commit']")
	WebElement logIn;
	
	public WebElement getUserEmail() {
		return userEmail;
	}
	
	public WebElement getUserPassword() {
		return userPassword;
	}
	
	public WebElement getLogIn() {
		return logIn;
	}
	

	
}
