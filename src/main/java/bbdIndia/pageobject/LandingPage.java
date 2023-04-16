package bbdIndia.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bbdIndia.Utility.CommonUtility;

public class LandingPage extends CommonUtility {

	WebDriver driver; // local variable driver

	public LandingPage(WebDriver driver) // constructor calling
	{
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// pageFactory

	@FindBy(linkText = "Create an Account")
	WebElement createAccount;

	@FindBy(linkText = "Sign In")
	WebElement signIn;

	@FindBy(xpath = "//div//h1")
	WebElement ele;

	@FindBy(xpath = "//div//h1")
	WebElement logoutSuccessMsg;
	
	@FindBy(css = ".message-error.error.message")
	WebElement loginFailMsg;

	public void homePageUrl() {
		//driver.get("https://magento.softwaretestingboard.com/");
		driver.get("https://magento2-demo.magebit.com/");
	}

	public void createAcclink() {

		createAccount.click();
	}

	public void signIn() {
		signIn.click();
	}

	public void waitForElements() {
		waitForElementToAppear(ele);
	}

	public String getLogoutSuccessMsg() {
		return logoutSuccessMsg.getText();
	}
	
	public String getErrorMsg() {
		return loginFailMsg.getText();
	}

}
