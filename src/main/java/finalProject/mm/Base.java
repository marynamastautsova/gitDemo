package finalProject.mm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.netty.handler.ssl.OptionalSslHandler;

public class Base {
	WebDriver driver;
	String url;

	public WebDriver initialiseDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\maris\\eclipse-workspace\\mm\\data.properties");
		prop.load(fis);
		String browser = System.getProperty("browser");
		//String browser = prop.getProperty("browser");
		switch (browser) {
		case "edge":
			System.setProperty("webdriver.edge.driver", "D://Selenium//msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "D://Selenium//IEDriverServer_x64_2.39.0/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "D://Selenium//geckodriver-v0.30.0-win64/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D://Selenium/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "chromeheadless":
			System.setProperty("webdriver.chrome.driver", "D://Selenium/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			break;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	
	public String initializeURL() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\data.properties");
		prop.load(fis);
		return prop.getProperty("url");
	}
	
	public String takeScreenshot(WebDriver driver, String testMethodName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testMethodName;
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
