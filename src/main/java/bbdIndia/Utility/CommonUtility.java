
package bbdIndia.Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {
	WebDriver driver; // local variable driver

	public CommonUtility(WebDriver driver) // constructor calling
	{
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void dropDownByVisibleText(WebElement WebElement, String text) {
		Select select = new Select(WebElement);
		select.selectByVisibleText(text);
	}

	public void waitForElementToAppear(WebElement ele) {
		WebElement signOutMsg = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(ele));

	}

	public void switchToChild() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
	}
	
	public void switchToParent() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		driver.switchTo().window(parentId);
	}

	public void switchToDefault() {

		driver.switchTo().defaultContent();
	}

	public void close() {
		driver.close();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

}
