package finalProject.mm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.emulation.Emulation;
import org.openqa.selenium.devtools.v95.fetch.Fetch;
import org.openqa.selenium.devtools.v95.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v95.network.Network;
import org.openqa.selenium.devtools.v95.network.model.ConnectionType;
import org.openqa.selenium.devtools.v95.network.model.ErrorReason;
import org.openqa.selenium.devtools.v95.network.model.Request;
import org.openqa.selenium.devtools.v95.network.model.Response;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class CDPTask {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		// devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true,
		// Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
		// Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
		// Optional.empty()));

		/*
		 * //executeCdpCommand Map params = new HashMap(); params.put("width", 600);
		 * params.put("height", 1000); params.put("deviceScaleFactor", 50);
		 * params.put("mobile", true);
		 * driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", params);
		 */

		// devTools.send(Emulation.setGeolocationOverride(Optional.of(40),
		// Optional.of(3), Optional.of(1)));

		/*
		 * driver.get("https://rahulshettyacademy.com");
		 * driver.get("http://google.com/");
		 * driver.findElement(By.cssSelector(".navbar-toggle")).click();
		 * Thread.sleep(3000);
		 * driver.findElement(By.linkText("Learning paths")).click();
		 */

// Network Responses and status codes with Selenium CDP Listeners
		/*
		 * devTools.send(Network.enable(Optional.empty(), Optional.empty(),
		 * Optional.empty()));
		 * 
		 * devTools.addListener(Network.requestWillBeSent(), request -> { Request req =
		 * request.getRequest(); System.out.println(req.getUrl()); });
		 * 
		 * devTools.addListener(Network.responseReceived(), response -> { Response res =
		 * response.getResponse(); //System.out.println(res.getStatus());
		 * //System.out.println(res.getUrl()); //System.out.println(res.getStatus());
		 * 
		 * if (res.getStatus().toString().startsWith("4")) {
		 * System.out.println(res.getUrl() + " is failing with status code " +
		 * res.getStatus()); } });
		 * driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		 * Thread.sleep(3000);
		 * driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		 */

//Network Mocking - Intercept Network /API Responses with Selenium Chrome dev tools
		/*
		 * devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		 * devTools.addListener(Fetch.requestPaused(), request -> { if
		 * (request.getRequest().getUrl().contains("AuthorName=shetty")) { String
		 * mockedUrl = request.getRequest().getUrl().replace("AuthorName=shetty",
		 * "=BadGuy"); System.out.println(mockedUrl);
		 * 
		 * devTools.send(Fetch.continueRequest(request.getRequestId(),
		 * Optional.of(mockedUrl), Optional.of(request.getRequest().getMethod()),
		 * Optional.empty(), Optional.empty(), Optional.empty())); } else {
		 * devTools.send(Fetch.continueRequest(request.getRequestId(),
		 * Optional.of(request.getRequest().getUrl()),
		 * Optional.of(request.getRequest().getMethod()), Optional.empty(),
		 * Optional.empty(), Optional.empty())); } });
		 * 
		 * driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		 * Thread.sleep(3000);
		 * driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		 * Thread.sleep(3000);
		 * System.out.println(driver.findElement(By.cssSelector("p")).getText());
		 */
		
//Fail Network request calls with Selenium CDP Commands
		/*
		Optional<List<RequestPattern>>	patterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty())));
		
		devTools.send(Fetch.enable(patterns, Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request ->
		{
			
			devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
			
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();*/
		
//Block unwanted Network
		/*
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		//2763 2532 */
		
//Emulate network speed
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.WIFI)));
		
		devTools.addListener(Network.loadingFailed(), loadingFailed->
		{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
			
			
		});
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		driver.close();
		//15148  2525
	}

}
