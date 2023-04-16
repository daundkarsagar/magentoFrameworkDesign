package bbdIndia.pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bbdIndia.Utility.CommonUtility;

public class SignInPage extends CommonUtility {

	WebDriver driver; // local variable driver

	public SignInPage(WebDriver driver) // constructor calling
	{
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement username;

	@FindBy(id = "pass")
	WebElement password;

	@FindBy(css = ".action.login.primary")
	WebElement signInButton;

	public void signInDetail(String uname, String passwrd) {
		scrollDown();
		username.sendKeys(uname);
		password.sendKeys(passwrd);
		signInButton.click();
	}

	public void signIn() throws InterruptedException {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.signIn();
		username.sendKeys("daundkarsagar@outlook.com");
		password.sendKeys("Sagar@12345");
		signInButton.click();
		Thread.sleep(2000);
	}
};
