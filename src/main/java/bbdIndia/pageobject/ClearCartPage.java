package bbdIndia.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bbdIndia.Utility.CommonUtility;

public class ClearCartPage extends CommonUtility {

	WebDriver driver;

	public ClearCartPage(WebDriver driver) // constructor calling
	{
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".action.viewcart")
	WebElement viewAndEditCart;

	@FindBy(css = "a[class='action showcart']")
	WebElement cartIcon;

	@FindBy(css = "div[class='cart-empty']")
	WebElement cart_empty_msg;

	@FindBy(css = "button[title='Update Shopping Cart']")
	WebElement update_ShopCart_Button;

	public boolean isDisplay() {

		try {
			WebElement element = driver.findElement(By.xpath("//a[@class='action action-delete']"));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void emptyCart() throws InterruptedException {
		Thread.sleep(4000);
		cartIcon.click();
		viewAndEditCart.click();

		while (isDisplay()) {
			WebElement element = driver.findElement(By.xpath("//a[@class='action action-delete']"));
			element.click();
			Thread.sleep(3000);
		}

	}
}
