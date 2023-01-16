package bbdIndia.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import bbdIndia.Utility.CommonUtility;

public class ShippingAddressPage extends CommonUtility {

	WebDriver driver; // local variable driver
	
	public ShippingAddressPage(WebDriver driver) {
		super(driver);// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='action action-show-popup']/span")
	WebElement newAddButton;

	@FindBy(name = "firstname")
	WebElement name;

	@FindBy(name = "lastname")
	WebElement lastname;

	@FindBy(name = "company")
	WebElement company;

	@FindBy(name = "street[0]")
	WebElement street;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "country_id")
	WebElement country;

	@FindBy(xpath = "//select[@name='region_id']")
	WebElement region;

	@FindBy(name = "postcode")
	WebElement postcode;

	@FindBy(name = "telephone")
	WebElement telephone;

	@FindBy(id = "shipping-save-in-address-book")
	WebElement checkBoxSaveAdd;

	@FindBy(xpath = "//button[@class='action primary action-save-address']/span")
	WebElement shipHereButton;

	@FindBy(xpath = "//div//button[@class='button action continue primary']")
	WebElement nextButton;
	
	@FindBy(xpath = "//span[@data-bind='text: getCartSummaryItemsCount()']")
	WebElement cartitems;
	
	@FindBy(xpath = "//span[text()='Place Order']")
	WebElement placeOrder;

	public void fillAddress() {
		waitForElementToAppear(newAddButton);
		newAddButton.click();
		name.sendKeys("Adem");
		lastname.sendKeys("Smith");
		company.sendKeys("bbd");
		street.sendKeys("34/56 Mountbatton Road");
		city.sendKeys("Mumbai");
		dropDownByVisibleText(country, "India");
		dropDownByVisibleText(region, "Maharashtra");
		postcode.sendKeys("400001");
		telephone.sendKeys("9028531494");
		checkBoxSaveAdd.click();
		shipHereButton.click();
		waitForElementToAppear(nextButton);
		nextButton.click();
	}
	public void waitForElements() {
		waitForElementToAppear(newAddButton);
	}
	
	public String noOfItems()
	{
		return cartitems.getText();
	}
	
	public void placeOrderClick() throws InterruptedException
	{
		Thread.sleep(5000);
		placeOrder.click();
		Thread.sleep(5000);
	}

}
