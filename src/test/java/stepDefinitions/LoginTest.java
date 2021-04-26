package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{
	
	public WebDriver driver;
	public LandingPage lp;
	public LoginPage login;
	public AccountPage ap;
	
	@Given("^open any Browser$")
	public void open_any_Browser() throws IOException {
		driver=initializeDriver();
	}
	
	@And("^Navigate to login page$")
	public void navigate_to_login_page() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		
		lp = new LandingPage(driver);
		lp.myAccountDropDown().click();
		lp.loginOption().click();
		
		Thread.sleep(3000);
	}
	
	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_and_password(String email, String pwd) {
		
		login = new LoginPage(driver);
		
		login.emailField().sendKeys(email);
		login.passwordField().sendKeys(pwd);
		
		
	}
	
	@And("^user clicks on Login button$")
	public void user_clicks_on_Login_button() {
		
		login.loginbtn().click();
	}
	
	@Then("^verify user is able to successfully Login$")
	public void verify_user_is_able_to_successfully_login() {
		
		 ap = new AccountPage(driver);
		 
		 Assert.assertTrue(ap.editAccountInfo().isDisplayed());
		
		
	}
	
	@After
	public void tearDown() {
		
		driver.close();
	}

}
