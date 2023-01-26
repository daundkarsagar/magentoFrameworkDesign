
package bbdIndia.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import bbdIndia.TestComponents.BaseTest;
import bbdIndia.pageobject.LandingPage;
import bbdIndia.pageobject.SignUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount extends BaseTest {
	@Test(description ="Account create page validation",priority = 0)
	public void createAccount() throws IOException {
		landingPage.createAcclink();
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.signUp();
		landingPage.waitForElements();
		String Expected = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
		assertMsg(signUpPage.getAccountCreatedMsg(), Expected);
	}
}
