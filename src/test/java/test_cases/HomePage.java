package test_cases;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base_classes.Base;
import page_objects.LandingPage;
import page_objects.LoginPage;

public class HomePage extends Base{
	public WebDriver driver;
	public static Logger log =  LogManager.getLogger(Base.class.getName());
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		 driver = setUpDriver();
		 driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String userName, String password, String type) throws IOException 
	{

		 LandingPage lp = new LandingPage(driver);
		 lp.getcloseNegativeModal().click();
		 lp.getLoginButton().click();
		 LoginPage logIn = new LoginPage(driver);
		 logIn.getUserEmail().sendKeys(userName);
		 logIn.getUserPassword().sendKeys(password);
		 log.info(type);
		 logIn.getLogIn().click();
		 
	}

	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = {{"cristian@gmail.com","123456","Restricted User"},
						   {"restricteduser@.com","123456","Restricted User"},
						   {"david@gmail.com","123456","Non Restricted User"}};
		
		return data;
		//Object[][] data = new Object[1][2];
		
	}
	

}
