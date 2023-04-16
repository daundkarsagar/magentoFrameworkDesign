
package bbdIndia.Test;
import java.io.IOException;
import org.testng.annotations.Test;
import bbdIndia.TestComponents.BaseTest;
import bbdIndia.pageobject.ClearCartPage;
import bbdIndia.pageobject.SignInPage;

public class ClearCart extends BaseTest {
	@Test(description = "clearCart", priority = -6)
	public void clearCart() throws InterruptedException, IOException {
		
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signIn();
		
		ClearCartPage clearCartPage = new ClearCartPage(driver);
		clearCartPage.emptyCart();
	}
}
