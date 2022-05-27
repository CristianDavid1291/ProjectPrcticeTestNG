package base_classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver setUpDriver() throws IOException {
		prop = new Properties();
		String localDir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(localDir + "\\src\\main\\resources\\data.properties");
		prop.load(fis);
		//String browser = prop.getProperty("browser");
		String timeOut = prop.getProperty("timeout");
		
		//mvn test -Dbrowser = chrome
		String browser = System.getProperty("browser");
		ChromeOptions options = new ChromeOptions();
		
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "headless":
			WebDriverManager.chromedriver().setup();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(timeOut)));
		driver.manage().window().maximize();

		return driver;

	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
