package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




public class landingPageObject {

	By productName = By.xpath("//h4[@class='product-name']");
	By search = By.xpath("//input[@type='search']");
	public WebDriver driver;
	public landingPageObject(WebDriver driver) {
		this.driver = driver;
	}
	@SuppressWarnings("deprecation")
	public void searchItem(String shortName) {
		RemoteWebDriver r = (RemoteWebDriver) driver;
		String c="document.getElementById('search').click()";
		r.executeScript(c);
		driver.findElement(search).sendKeys(shortName);
		WebElement s1 = driver.findElement(By.xpath("//input[@type='search']"));
		Point p = s1.getLocation();
		System.out.println("Xlocation is "+p.getX());
		System.out.println("Y Location is "+p.getY());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofHours(20));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Select s = new Select(s1);
		List <WebElement> list1 = s.getOptions();
	}
	public String getProductName() {
		return driver.findElement(productName).getText();
		
	}
	public void stop() {
		driver.quit();
	}
	
}
