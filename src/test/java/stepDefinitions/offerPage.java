package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TextContextSetup;

public class offerPage {
	
	public WebDriver driver;
	public String productName;
	public String offerProductName;
	TextContextSetup textCOntextSetup;
	
	public offerPage(TextContextSetup textCOntextSetup) {
		this.textCOntextSetup=textCOntextSetup;
	}

	@Then("user search {string} short name in offers page to check if product exist")
	public void user_search_same_short_name_in_offers_page_to_check_if_product_exist(String shortName) {
		textCOntextSetup.driver.findElement(By.linkText("Top Deals")).click();
		Set<String> s1=textCOntextSetup.driver.getWindowHandles();
		Iterator <String> l1 =s1.iterator();
		String parentWindow = l1.next();
		String childWindow = l1.next();
		textCOntextSetup.driver.switchTo().window(childWindow);
		textCOntextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		offerProductName=textCOntextSetup.driver.findElement(By.xpath("//tbody/tr/td")).getText();
		System.out.println("The offer page product Name "+offerProductName);
		Assert.assertTrue(textCOntextSetup.productName.equals(offerProductName));
		textCOntextSetup.driver.quit();
	}
}
