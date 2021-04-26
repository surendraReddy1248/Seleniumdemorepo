package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class OmayoTest extends Base {

	public WebDriver driver;
	
	@Test
	public void launchOmayo() throws IOException {
		
		driver = initializeDriver();
		driver.get("http://omayo.blogspot.com/");
		String actualtitle = driver.getTitle();
		String expectedTitle="omayo (QAFox.com)1123";
		Assert.assertEquals(actualtitle, expectedTitle);	
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
