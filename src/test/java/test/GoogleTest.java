package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class GoogleTest extends Base{

	@Test
	public void launchGoogle() throws IOException {
		
		WebDriver driver = initializeDriver();
		driver.get("https://www.google.com/");
		System.out.println("Edited in Git-hub by surendra Reddy")
		System.out.println("Navigated to google page");
		String actualtitle = driver.getTitle();
		String expectedTitle="Google";
		Assert.assertEquals(actualtitle, expectedTitle);	
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
