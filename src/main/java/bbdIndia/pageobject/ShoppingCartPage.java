package bbdIndia.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bbdIndia.Utility.CommonUtility;

public class ShoppingCartPage extends CommonUtility {

	WebDriver driver; // local variable driver

	public ShoppingCartPage(WebDriver driver) // constructor calling
	{
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='item-qty cart-item-qty']")
	WebElement qty;
	
	@FindBy(xpath = "//button[@class='update-cart-item']")
	WebElement update;
	
	@FindBy(linkText ="View and Edit Cart")
	WebElement viewEditCart;
	
	@FindBy (xpath="//td[@class='amount']/strong/span")
	WebElement actualTotalAmount;
	
	@FindBy (css="button[title='Proceed to Checkout'] span")
	WebElement proceedCheckout;

	public void qntOfProduct() {
		qty.click();
		qty.sendKeys(Keys.chord(Keys.CONTROL + "a", Keys.BACK_SPACE));
		qty.sendKeys("4");
		update.click();
	}
	
	public void viewEditCart()
	{
		viewEditCart.click();
	}
	
	public String actualTotalAmount()
	{
		return actualTotalAmount.getText();
	}
	public void proceedCheckout()
	{
		proceedCheckout.click();
	}

}
