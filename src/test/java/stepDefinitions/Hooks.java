package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Hooks {
	@Test(threadPoolSize = 2, invocationCount = 8)
	public void hooks(){
		System.out.println(""+Thread.currentThread().getId());
	}

}
