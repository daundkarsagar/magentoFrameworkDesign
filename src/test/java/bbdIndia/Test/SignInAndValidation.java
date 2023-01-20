package bbdIndia.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bbdIndia.TestComponents.BaseTest;
import bbdIndia.Utility.CommonUtility;
import bbdIndia.pageobject.AccountHomePage;
import bbdIndia.pageobject.LandingPage;
import bbdIndia.pageobject.SignInPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignInAndValidation extends BaseTest {

	@DataProvider(name = "InvalidLoginCredentials")
	public Object[][] log() {
		return new Object[][] { { "sagardaundkar@outlook.com", "Sagar@1234" }, { "sagardaundkar@mail.com", "Sagar@12345" },
				{ "daundkarsagar@outlook.com", "Sagar@123" }, { "daundkarsagar2@outlook.com", "Sagar@12345" } };
	}

	@Test
	public void SignIn() throws InterruptedException, IOException {

		landingPage.signIn();
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signInDetail("daundkarsagar@outlook.com", "Sagar@12345");
		Thread.sleep(3000);
		AccountHomePage accountHomePage = new AccountHomePage(driver);
		assertMsg("Welcome, Sagar Daundkar!", accountHomePage.getLoginSuccessMsg());
		accountHomePage.signOut();
		landingPage.waitForElements();
		assertMsg(landingPage.getLogoutSuccessMsg(),"You are signed out");
	}
	
	@Test(dataProvider = "InvalidLoginCredentials")
	public void logincheck(String username, String password) throws InterruptedException, IOException {
		landingPage.signIn();
		SignInPage signInPage = new SignInPage(driver);
		signInPage.signInDetail(username, password);
		landingPage.waitForElements();
		assertMsg(landingPage.getErrorMsg(),"The account sign-in was incorrect or your account is "
				+ "disabled temporarily. Please wait and try again later.");
		
	}
}
