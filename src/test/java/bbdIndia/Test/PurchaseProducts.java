
package bbdIndia.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import bbdIndia.TestComponents.BaseTest;
import bbdIndia.pageobject.AccountHomePage;
import bbdIndia.pageobject.AddToCartPage;
import bbdIndia.pageobject.GearPage;
import bbdIndia.pageobject.LandingPage;
import bbdIndia.pageobject.MenPage;
import bbdIndia.pageobject.PurchaseConformPage;
import bbdIndia.pageobject.ShippingAddressPage;
import bbdIndia.pageobject.ShoppingCartPage;
import bbdIndia.pageobject.SignInPage;
import bbdIndia.pageobject.WhatsNewPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PurchaseProducts extends BaseTest {

	@Test
	public void purchaseProduct() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn();

		AccountHomePage accountHomePage = new AccountHomePage(driver);
		accountHomePage.whatsNew();

		WhatsNewPage whatsNewPage = new WhatsNewPage(driver);
		whatsNewPage.jackets();
		whatsNewPage.oliviaZipJacket();

		Thread.sleep(5000);
		AddToCartPage addToCart = new AddToCartPage(driver);
		addToCart.addcart();

		accountHomePage.gearTabNewWin();
		accountHomePage.switchToChild();

		GearPage gearPage = new GearPage(driver);
		gearPage.watches();
		gearPage.selectMinPrice();
		gearPage.selectRubberMaterial();
		gearPage.enduranceWatch();

		addToCart.addcart();
		gearPage.close();

		gearPage.switchToParent();
		accountHomePage.refresh();

		MenPage mens = new MenPage(driver);
		mens.mensAction();
		mens.bottomsAction();
		mens.pantAction();
		mens.select34GreenPant();

		addToCart.addcart();
		Assert.assertEquals(mens.select34GreenPantAddedMsg(), "You added Mithra Warmup Pant to your shopping cart.");

		accountHomePage.cartIcon();

		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		shoppingCartPage.qntOfProduct();
		shoppingCartPage.viewEditCart();

		shoppingCartPage.proceedCheckout();
		ShippingAddressPage shippingAddPage = new ShippingAddressPage(driver);
		shippingAddPage.waitForElements();

		Thread.sleep(5000);
		shippingAddPage.fillAddress();

		Assert.assertEquals(shippingAddPage.noOfItems(), "4");
		shippingAddPage.placeOrderClick();

		PurchaseConformPage purchaseConformPage = new PurchaseConformPage(driver);
		purchaseConformPage.waitForElements();

		Assert.assertEquals(purchaseConformPage.orderPlaceMsg(), "Thank you for your purchase!");

	}
}
