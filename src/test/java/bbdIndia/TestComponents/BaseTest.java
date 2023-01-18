package bbdIndia.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import bbdIndia.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	public static String fileWithPath = System.getProperty("user.dir") + "\\screenShot";

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\main\\java\\bbdIndia\\" + "resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			// edge
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		return driver;
	}

	public void assertMsg(String ActualMsg, String ExpectedMsg) throws IOException {
		takeSnapShot(driver);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualMsg, ExpectedMsg);
	}

	public static void takeSnapShot(WebDriver webdriver) throws IOException {
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		TakesScreenshot scrShot = (TakesScreenshot) webdriver;
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath + "\\" + fileName + ".png");
		FileUtils.copyFile(SrcFile, DestFile);
	}

	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.homePageUrl();
		return landingPage;
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
