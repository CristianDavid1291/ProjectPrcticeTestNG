package test_cases;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base_classes.Base;
import page_objects.LandingPage;

public class ValidateNavigationBar extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@Test
	public void basePageNavigation() throws IOException {

		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Navigation bar is displayed");

	}
	
	@BeforeTest
	public void setUp() throws IOException
	{
		 driver = setUpDriver();
		 driver.get(prop.getProperty("url"));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
