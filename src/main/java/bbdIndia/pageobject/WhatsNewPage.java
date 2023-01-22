package bbdIndia.pageobject;

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

	@FindBy(linkText = "Jackets")
	WebElement jacketsTab;

	@FindBy(linkText = "Olivia 1/4 Zip Light Jacket")
	WebElement oliviaZipJacketImg;
	
	@FindBy(css="div#option-label-size-143-item-167")
	WebElement sizeS;
	
	@FindBy(css="div#option-label-color-93-item-57")
	WebElement colorPurple;
	
	public void jackets() {
		jacketsTab.click();
	}

	public void oliviaZipJacket() {			
		oliviaZipJacketImg.click();
		sizeS.click();
		colorPurple.click();
	}
}
