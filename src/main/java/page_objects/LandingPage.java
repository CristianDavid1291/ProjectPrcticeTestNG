package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;
	// Login Button
	@FindBy(css = "a[href*='sign_in']")
	private WebElement loginButton;

	// Close Modal
	@FindBy(xpath = "//button[contains(.,'NO THANKS')]")
	private WebElement closeNegativeModal;

	// h2 validation
	@FindBy(xpath = "//h2[contains(.,'Featured Courses')]")
	private WebElement featureCourses;
	
	//navigation var
	@FindBy(css = "ul.nav")
	private WebElement navigationBar;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getcloseNegativeModal() {
		return closeNegativeModal;
	}

	public WebElement getFeatureCourses() {
		return featureCourses;
	}
	
	public WebElement getNavigationBar() {
		return navigationBar;
	}
}
