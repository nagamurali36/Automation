package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class landingPageObject {

	By productName = By.xpath("//h4[@class='product-name']");
	By search = By.xpath("//input[@type='search']");
	public WebDriver driver;
	public landingPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void searchItem(String shortName) {
		driver.findElement(search).sendKeys(shortName);
	}
	public String getProductName() {
		return driver.findElement(productName).getText();
		
		
	}
}
