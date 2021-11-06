package finalProject.mm;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SmokeTest extends Base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(SmokeTest.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initialiseDriver();
		log.info("Driver is initialized");
		url = initializeURL();
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String password) {
		driver.get(url);
		LandingPage l = new LandingPage(driver);
		l.clickLogin();
		LoginPage lp = new LoginPage(driver);
		lp.login(driver, userName, password);
		log.info("User is tried to login with provided credentials");
	}

	@Test
	public void verifyFeaturedCoursesPresent() {
		driver.get(url);
		LandingPage l = new LandingPage(driver);
		assertEquals(l.getTitle().getText().toUpperCase(), "FEATURED COURSES",
				"Featured Courses text is not presented");
	}

	@Test
	public void verifyNavigationBar() {
		driver.get(url);
		LandingPage l = new LandingPage(driver);
		List<String> navigationBarData = Arrays.asList("HOME", "COURSES", "VIDEOS", "INTERVIEW GUIDE", "PRACTICE",
				"BLOG", "ABOUT", "CONTACT");
		assertTrue(navigationBarData.equals(l.getNavigationBarData()));
	}
	
	@Test
	public void logJavaScriptErrors() {
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.partialLinkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "username1";
		data[0][1] = "password1";

		data[1][0] = "username2";
		data[1][1] = "password2";

		return data;
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}