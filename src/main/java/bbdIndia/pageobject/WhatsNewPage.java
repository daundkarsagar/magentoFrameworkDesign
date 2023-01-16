package bbdIndia.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bbdIndia.Utility.CommonUtility;

public class WhatsNewPage extends CommonUtility {
	WebDriver driver; // local variable driver

	public WhatsNewPage(WebDriver driver) // constructor calling
	{
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// pageFactory
	// driver.findElement(By.linkText("Jackets")).click();
	@FindBy(linkText = "Jackets")
	WebElement jacketsTab;

	// driver.findElement(By.linkText("Olivia 1/4 Zip Light Jacket")).click();
	@FindBy(linkText = "Olivia 1/4 Zip Light Jacket")
	WebElement oliviaZipJacketImg;

	public void jackets() {
		jacketsTab.click();
	}

	public void oliviaZipJacket() {
		oliviaZipJacketImg.click();
	}
}
