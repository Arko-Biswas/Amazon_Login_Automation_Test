package pageElementsPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Amazon_Login_pageElements {
	
	private WebDriver driver;
	
	private By LandingPageSignOnButton = By.xpath("//span[contains(text(), 'Hello, sign in')]");
	private By VerifyAmazonSignInPage = By.xpath("//label[@for='ap_email']");
	private By InputUserName = By.xpath("//input[@id='ap_email']");
	private By ContinueButton = By.xpath("//input[@id='continue']");
	private By VerifyPasswordInputPage = By.xpath("//label[@for='ap_password']");
	private By InputPassword = By.xpath("//input[@id='ap_password']");
	private By SignInButtonClick = By.xpath("//input[@id='signInSubmit']");
	private By VerifyCustomerPage = By.xpath("//span[contains(text(), 'Hello, sign in')]");
	
	public Amazon_Login_pageElements(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void customWait() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	public String getPageTitle() {
		
		customWait();
		return driver.getTitle();
		
	}
	
	public boolean landingPageSignInButtonClick() {
		
		boolean clicked = false;
		try {
			
			customWait();
			driver.findElement(LandingPageSignOnButton).click();
			clicked = true;
			
		}catch(Exception e) {
			System.out.println("!!! Exception occured: while clicking landing page sign in button");
		}
		
		return clicked;
	}
	
	public boolean verifyAmazonSignInPage() {
		
		boolean verify = false;
		
		try {
			
			customWait();
			driver.findElement(VerifyAmazonSignInPage).isDisplayed();
			verify = true;
			
		}catch(Exception e) {
			System.out.println("!!! Exception occured: while verifying amazon sign in page");
		}
		
		return verify;
		
	}
	
	public boolean inputUserName(String username) {
		
		boolean input = false;
		
		try {
			
			customWait();
			driver.findElement(InputUserName).sendKeys(username);
			input = true;
			
		}catch(Exception e) {
			System.out.println("!!! Exception occured: while entering username");
		}
		
		return input;
		
	}
	
	public boolean continueButtonClick() {
		
		boolean clicked = false;
		
		try {
			
			customWait();
			driver.findElement(ContinueButton).click();
			clicked = true;
			
		}catch(Exception e) {
			System.out.println("!!! Exception occured: while clicking continue button");
		}
		
		return clicked;
		
	}
	
	public boolean verifyPasswordInputPage() {
		
		boolean verify = false;
		
		try {
			
			customWait();
			driver.findElement(VerifyPasswordInputPage).isDisplayed();
			verify = true;
			
		}catch(Exception e) {
			System.out.println("!!! Exception occured: while verifying password page");
		}
		
		return verify;
		
	}
	
	public boolean inputPassword(String password) {
		
		boolean input = false;
		
		try {
			
			customWait();
			driver.findElement(InputPassword).sendKeys(password);
			input = true;
			
		}catch(Exception e) {
			System.out.println("!!! Exception occured: while entering password");
		}
		
		return input;
		
	}
	
	public boolean signInButtonClick() {
		
		boolean clicked = false;
		
		try {
			
			customWait();
			driver.findElement(SignInButtonClick).click();
			clicked = true;
			
		}catch(Exception e) {
			System.out.println("!!! Exception occured: while clicking Sign In button");
		}
		
		return clicked;
		
	}
	
	public boolean verifyCustomerPage() {
		
		boolean verify = false;
		
		try {
			
			customWait();
			driver.findElement(VerifyCustomerPage).isDisplayed();
			
		}catch(Exception e) {
			verify = true;
		}
		
		return verify;
		
	}

}







