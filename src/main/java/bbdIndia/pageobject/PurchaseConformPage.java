package bbdIndia.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bbdIndia.Utility.CommonUtility;

public class PurchaseConformPage extends CommonUtility {

	WebDriver driver; // local variable driver

	public PurchaseConformPage(WebDriver driver) // constructor calling
	{
		super(driver); // initialization

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".action.print")
	WebElement printReceipt;

	@FindBy(xpath = "//h1[@class='page-title']")
	WebElement actualMsg;

	@FindBy(css = ".order-number strong")
	WebElement orderNumber;

	public void waitForElements() {
		waitForElementToAppear(printReceipt);
	}

	public String orderPlaceMsg() {
		return actualMsg.getText();
	}

	public boolean isOrderNumberDisplayed() {
		return orderNumber.isDisplayed();
	}

}
