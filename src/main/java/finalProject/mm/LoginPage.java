package finalProject.mm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;	
	public By userNameField = By.id("user_email");
	public By passwordField = By.id("user_password");
	public By loginButton = By.name("commit");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(WebDriver driver, String userName, String password) {
		driver.findElement(userNameField).sendKeys(userName);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
		
	}

}
