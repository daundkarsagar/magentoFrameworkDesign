package bbdIndia.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bbdIndia.Utility.CommonUtility;

public class SignUpPage extends CommonUtility {
	WebDriver driver; // local variable driver

	public SignUpPage(WebDriver driver) // constructor calling
	{
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstname")
	WebElement name;

	@FindBy(id = "lastname")
	WebElement surname;

	@FindBy(xpath = "//input[@id='email_address']")
	WebElement emailId;

	@FindBy(css = "[title='Password']")
	WebElement password;

	@FindBy(name = "password_confirmation")
	WebElement conformPassword;

	@FindBy(xpath = "(//button[@type='submit']/span)[2]")
	WebElement createAccButton;
	
	@FindBy(xpath="(//div[@class='messages'])[1]/div/div")
	WebElement accountCreatedMsg;

	public void signUp() {
		name.sendKeys("Sagar");
		surname.sendKeys("Daundkar");
		emailId.sendKeys("daundkarsagar@outlook.com");
		password.sendKeys("Sagar@12345");
		conformPassword.sendKeys("Sagar@12345");
		createAccButton.click();
	}
	
	public String getAccountCreatedMsg()
	{
		return accountCreatedMsg.getText();
	}

}
