package finalProject.mm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver driver;
	private By loginButtonLocator = By.cssSelector("a[href*='sign_in']");
	private By featuredCoursesTextLocator = By.cssSelector(".text-center h2");
	private By navigationBarLocator = By.cssSelector(".navbar-nav li a");
		
	
	public LoginPage clickLogin() {
		driver.findElement(loginButtonLocator).click();
		return new LoginPage(driver);
	}
	
	public WebElement getTitle() {
		return driver.findElement(featuredCoursesTextLocator);
	}
	
	public List<String> getNavigationBarData() {
		List<WebElement> nb= driver.findElements(navigationBarLocator);
		List<String> navigationBarData = new ArrayList<String>();
		nb.stream().forEach(s -> navigationBarData.add(s.getText().toString()));
		return navigationBarData;
	}
	
}
