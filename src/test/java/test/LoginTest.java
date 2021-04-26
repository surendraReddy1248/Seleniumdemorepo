package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	public WebDriver driver;
	Logger log;
	
	
	@BeforeMethod
	public void setup() throws IOException {
		
	log = LogManager.getLogger(LoginTest.class.getName());
	
		 driver = initializeDriver();
		 log.debug("Browser got Launched");
		 driver.get(prop.getProperty("url"));
		 log.debug("Navigated to the application");
	}
	
	@DataProvider
	
	public Object[][] getLoginData() {
		
		Object[][] data= {{"arun.selenium@gmail.com","Second@123","Success"	},
				           {"arun.selenium5@gmail.com","Second@123","Success"},
				           {"dummt.test@gmail.com","test123","Failure"}};
		
		return data;
		
		
		}
	
	@Test(dataProvider = "getLoginData")
	public void login(String email, String pwd, String expectedStatus) {
		
		
		LandingPage landing = new LandingPage(driver);
		landing.myAccountDropDown().click();
		log.debug("clicked on my account DropDown");
		landing.loginOption().click();
		log.debug("clicked on LoginOption");
		
		LoginPage loginPage= new LoginPage(driver);
		loginPage.emailField().sendKeys(email);
		log.debug("Entered UserName");
		loginPage.passwordField().sendKeys(pwd);
		log.debug("Entered Password");
		loginPage.loginbtn().click();
		log.debug("clicked on login button");
		
		AccountPage account = new AccountPage(driver);
		String actualResult = null;
		
		try {
			if(account.editAccountInfo().isDisplayed()) {
				actualResult="Success";
				log.info("User Logged in successfully");
			}
		} catch (Exception e) {
			
			actualResult="Failure";
			log.error("Invalid UserName and password ");
		}
		
		Assert.assertEquals(actualResult, expectedStatus);
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		log.debug("Browser closed");
	}
	
	
	

}
