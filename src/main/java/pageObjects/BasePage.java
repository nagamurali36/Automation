package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	WebDriverWait wait;
	private static WebDriverWait jsWait;
	private static WebDriverWait loadingWait;
	private static JavascriptExecutor jsExec;
	private static WebDriver jsWaitDriver;
	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(150));
		jsWaitDriver = driver;
		jsWait = new WebDriverWait(driver,Duration.ofSeconds(150));
		loadingWait = new WebDriverWait(driver,Duration.ofSeconds(150));
		jsExec = (JavascriptExecutor) jsWaitDriver;
	}
	/*
	 * Objective : This function will highlight the element
	 */
	
	public void hightLighterMethod(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	}
	
	/*
	 * Objective : This function will hover to element
	 */
	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.print("Moved to the "+element);
		
	}
	public void switchToLastWindow() {
			for(String window: driver.getWindowHandles()) {
				driver.switchTo().window(window);
			}
	}
	public void switchToreqWindow(int number) {
		int i=0;
		for(String allwindows:driver.getWindowHandles()) {
			driver.switchTo().window(allwindows);
			i++;
			if(i==number) {
				break;
			}
		}
	}
	public void switchToparentWIndow(String mainWindow) {
		//get the main window id
		for(String window : driver.getWindowHandles()) {
			driver.switchTo().window(mainWindow);
//			opens new tab 
//			driver.switchTo().newWindow(WindowType.TAB);
//			opens new window
//			driver.switchTo().newWindow(WindowType.WINDOW);
		}
	}

}
