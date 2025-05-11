package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.landingPageObject;
import utils.TextContextSetup;

public class searchProduct {
	
	public WebDriver driver;
	public String productName;
	public String offerProductName;
	TextContextSetup textContextSetup;
	
	public searchProduct(TextContextSetup textCOntextSetup) {
		this.textContextSetup=textCOntextSetup;
	}

	@Given("user is on greenkart landing page")
	public void user_is_on_greenkart_landing_page() {
		System.setProperty("webdriver.firefox.profile", "default");
		textContextSetup.driver = new FirefoxDriver();
		
//	    System.setProperty("webdriver.chrome.driver", "F://chromedriver-win64/chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
//	    textContextSetup.driver = new ChromeDriver();
	    textContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("user searched with short name {string} and extracted acutal name of product")
	public void user_searched_with_short_name_and_extracted_acutal_name_of_product(String shortName) throws InterruptedException {
		landingPageObject landingPg = new landingPageObject(textContextSetup.driver);
		landingPg.searchItem(shortName);
		Thread.sleep(2000);
		textContextSetup.productName=landingPg.getProductName().split("-")[0].trim();
		System.out.println("Product Name is :"+productName);
	}
}
