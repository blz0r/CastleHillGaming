package stepDef;



import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.inventoryPageElements;
import pages.loginPageElements;

public class loginPage {
	
	WebDriver driver;
	loginPageElements login;
	inventoryPageElements inventory;
	
	@Before
	public void testSetup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		login = new loginPageElements(driver);
		inventory = new inventoryPageElements(driver);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);		
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
	}
	
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		
		driver.get("https://www.saucedemo.com/");
	}

	@When("user enters valid username")
	public void user_enters_valid_username() {
		
		login.getUserName().sendKeys("standard_user");
	}

	@When("user enters valid password")
	public void user_enters_valid_password() {
		
		login.getUserPassword().sendKeys("secret_sauce");
	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		
		login.getLogInButton().click();
	}

	@Then("user is redirected to the Sauce Demo Main Page")
	public void user_is_redirected_to_the_sauce_demo_main_page() {
		
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		String actualURL = driver.getCurrentUrl();
		
		Assert.assertEquals(expectedURL, actualURL);
	}

	@Then("user verifies the App Logo exists")
	public void user_verifies_the_app_logo_exists() {
		
		boolean appLogoDisplayed = inventory.getAppLogo().isDisplayed();
		
		Assert.assertEquals(appLogoDisplayed, true);
	}

	@When("user enters locked out user username")
	public void user_enters_locked_out_user_username() {
		
		login.getUserName().sendKeys("locked_out_user");
	}

	@When("user enters locked out user password")
	public void user_enters_locked_out_user_password() {
		
		login.getUserPassword().sendKeys("secret_sauce");
	}

	@Then("user verifies the Error Message {string}")
	public void user_verifies_the_error_message(String string) {
		
		String actualErrorMessage = login.getErrorMessage();
		
		Assert.assertEquals(string, actualErrorMessage);
	}
	
	
	

}
