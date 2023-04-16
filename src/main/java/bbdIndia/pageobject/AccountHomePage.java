package bbdIndia.pageobject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bbdIndia.Utility.CommonUtility;

public class AccountHomePage extends CommonUtility {
	WebDriver driver; // local variable driver

	public AccountHomePage(WebDriver driver) // constructor calling
	{
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// pageFactory

	@FindBy(xpath = "(//button[@class='action switch'])[1]")
	WebElement signOutArro;

	@FindBy(linkText = "Sign Out")
	WebElement signOut;

	@FindBy(css = ".logged-in")
	WebElement loginSuccessMsg;

	@FindBy(linkText = "What's New")
	WebElement whatsNewTab;

	@FindBy(id = "ui-id-6")
	WebElement gearTab;
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement cartIcon;
	
	@FindBy(css=".logo img")
	WebElement logo;

	public void signOut() {
		signOutArro.click();
		signOut.click();
	}
	
	public void waitforlogo() throws InterruptedException {
		waitForElementToAppear(logo);
		Thread.sleep(3000);
	}

	public String getLoginSuccessMsg() {
		return loginSuccessMsg.getText();
	}

	public void whatsNew() {
		whatsNewTab.click();
	}
	
	public void gearTabNewWin() {
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		gearTab.sendKeys(selectLinkOpeninNewTab);
	
	}
	public void cartIcon() {
		cartIcon.click();
	}

}
