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


public class ValidateTitle extends Base {
	public WebDriver driver;
	public static Logger log =  LogManager.getLogger(Base.class.getName());
	
	@Test
	public void validationTitle() throws IOException {
		LandingPage lp = new LandingPage(driver);
		lp.getcloseNegativeModal().click();
		Assert.assertEquals(lp.getFeatureCourses().getText(), "FEATURED COURSES");
		log.info("Succesfully validated Text Message");

	}
	
	@BeforeTest
	public void setUp() throws IOException
	{
		 driver = setUpDriver();
		 log.info("Driver is initialized");
		 driver.get(prop.getProperty("url"));
		 log.info("Navigated to Home Page");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
