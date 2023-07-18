package driverFactoryPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	public WebDriver InitialiseWebDriver(String browser) {
		
		System.out.println(">>> Testing on Browser: " + browser);
		
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			threadLocalDriver.set(new ChromeDriver());
			
		}else if(browser.equals("safari")) {
			
			WebDriverManager.safaridriver().setup();
			threadLocalDriver.set(new SafariDriver());
			
		}else if(browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			threadLocalDriver.set(new FirefoxDriver());
			
		}else {
			
			System.out.println("!!! Please pass correct browser value");
			
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver() {
		
		return threadLocalDriver.get();
		
	}

}
