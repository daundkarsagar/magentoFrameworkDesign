package bbdIndia.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bbdIndia.Utility.CommonUtility;

public class GearPage extends CommonUtility {

	WebDriver driver; // local variable driver

	public GearPage(WebDriver driver) // constructor calling
	{
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Watches")
	WebElement watchTab;

	@FindBy(xpath = "(//li[@class='item'])[5]")
	WebElement minprice;

	@FindBy(xpath = "(//div[@aria-selected='false'])[4]")
	WebElement price;

	@FindBy(xpath = "(//div[@aria-selected='false'])[5]")
	WebElement material;

	@FindBy(xpath = "(//div[@aria-hidden='false'])//ol//child::li[3]/a")
	WebElement rubber;

	@FindBy(css = "img[alt='Endurance Watch']")
	WebElement enduranceWatch;

	public void watches() {
		watchTab.click();
	}

	public void selectMinPrice() {
		waitForElementToAppear(price);
		price.click();
		minprice.click();

	}

	public void selectRubberMaterial() {
		waitForElementToAppear(material);
		material.click();
		rubber.click();
	}

	public void enduranceWatch() {
		enduranceWatch.click();
	}

}
