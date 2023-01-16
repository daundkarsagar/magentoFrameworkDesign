package bbdIndia.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bbdIndia.Utility.CommonUtility;

public class AddToCartPage extends CommonUtility {

	WebDriver driver;

	public AddToCartPage(WebDriver driver) // constructor calling
	{
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "product-addtocart-button")
	WebElement addToCartTab;

	public void addcart() throws InterruptedException {
		addToCartTab.click();
		Thread.sleep(3000);
	}

}
