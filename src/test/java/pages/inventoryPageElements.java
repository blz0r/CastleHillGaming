package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class inventoryPageElements {
	
WebDriver driver;
	
	public inventoryPageElements() {
	}
	
	public inventoryPageElements(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAppLogo() {
		
		WebElement appLogo = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div"));
		return appLogo;
	}

}
