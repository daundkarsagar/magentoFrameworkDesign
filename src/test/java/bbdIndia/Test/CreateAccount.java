
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
	@Test
	public void createAccount() throws IOException {
		landingPage.createAcclink();

		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.signUp();
		
		assertMsg(signUpPage.getAccountCreatedMsg(),"Account already created");
	}
}
