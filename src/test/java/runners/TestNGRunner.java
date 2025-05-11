package runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import pageObjects.landingPageObject;

@CucumberOptions(features="src/test/resources/features",
glue="stepDefinitions",
monochrome=false,
tags="@searchProduct",
//stepNotifications=true,
plugin= {"html:target/Cucumber-report/cucumber.html",
		"json:target/Cucumber-report/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
})
public class TestNGRunner extends AbstractTestNGCucumberTests {
//	WebDriver driver = new ChromeDriver();
//	landingPageObject l=new landingPageObject(driver);
	    public void testSignup() {
//	        driver.get("https://example.com/signup");
//	        l.searchItem("Hi");
	    }
}
