package hooksPackage;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverFactoryPackage.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilitiesPackage.BrowserConfigReader;

public class ApplicationHooks {
	
	private DriverFactory DriverFactory_obj;
	private BrowserConfigReader BrowserConfigReader_obj;
	private WebDriver driver;
	Properties properties;	
	
	@Before( order = 0 )
	public void GetProperties() {
		
		BrowserConfigReader_obj = new BrowserConfigReader();
		
		properties = BrowserConfigReader_obj.InitialiseProperties();
		
	}
	
	@Before( order = 1 )
	public void GetBrowserAndLaunch() {
		
		String browserName = properties.getProperty("browser");
		
		DriverFactory_obj = new DriverFactory();
		
		driver = DriverFactory_obj.InitialiseWebDriver(browserName);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
	}
	
	@After( order = 1 )
	public void TearDown(Scenario Scenario_obj) {
		
		System.out.println(">>> Status of Scenario: "+ Scenario_obj.getStatus());
		
		if(Scenario_obj.isFailed()) {
			
			// take screenshot
			String screnShotName = Scenario_obj.getName().replaceAll(" ", "_");
			
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			Scenario_obj.attach(sourcePath, "image/png", screnShotName);
			
		}
		
	}
	
	@After( order = 0 )
	public void QuitBrowser() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.quit();
		
	}

}
