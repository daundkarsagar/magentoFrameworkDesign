package bbdIndia.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bbdIndia.Utility.CommonUtility;

public class MenPage extends CommonUtility {

	WebDriver driver; // local variable driver

	public MenPage(WebDriver driver) // constructor calling
	{
		super(driver);
		// initialization
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ui-id-5")
	WebElement mens;

	@FindBy(xpath = "//li[contains(@class,'level1 nav-3-2')]")
	WebElement bottoms;

	@FindBy(id = "ui-id-23")
	WebElement pants;

	@FindBy(xpath = "(//div[@aria-selected='false'])[5]")
	WebElement price;

	@FindBy(xpath = "(//div[@aria-hidden='false']//ol//li//a)[1]")
	WebElement lowestPrice;

	@FindBy(xpath = "//img[@alt='Mithra Warmup Pant']")
	WebElement mithraPant;

	@FindBy(id = "option-label-size-143-item-177")
	WebElement sizePant;

	@FindBy(id = "option-label-color-93-item-53")
	WebElement colorPant;
	
	@FindBy(xpath="//div[@class='messages']//div//div")
	WebElement actualtmsg;

	public void mensAction() {
		Actions actions = new Actions(driver);
		actions.moveToElement(mens).perform();
	}

	public void bottomsAction() {
		waitForElementToAppear(bottoms);
		Actions actions = new Actions(driver);
		actions.moveToElement(bottoms).perform();
	}

	public void pantAction() {

		pants.click();
	}

	public void select34GreenPant() throws InterruptedException {
		price.click();
		lowestPrice.click();
		waitForElementToAppear(mithraPant);
		mithraPant.click();
		sizePant.click();
		colorPant.click();
	}
	
	public String select34GreenPantAddedMsg()
	{
		return actualtmsg.getText();
	}

}
