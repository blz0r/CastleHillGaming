package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPageElements {
	
WebDriver driver;
	
	public loginPageElements() {
	}
	
	public loginPageElements(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public WebElement getUserName() {
		
		WebElement userName = driver.findElement(By.id("user-name"));
		
		return userName;
	}
	
	public WebElement getUserPassword() {
		
		WebElement userPassword = driver.findElement(By.id("password"));
		
		return userPassword;
	}
	
	public WebElement getLogInButton() {
		
		WebElement logInButton = driver.findElement(By.id("login-button"));
		
		return logInButton;
	}
	
	public String getErrorMessage() {
		
		String errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
		
		return errorMessage;
	}
	
}
