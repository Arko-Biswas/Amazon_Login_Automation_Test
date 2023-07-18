package stepDefinitionPackage;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import driverFactoryPackage.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageElementsPackage.Amazon_Login_pageElements;
import utilitiesPackage.ExcelReader;

public class Amazon_Login_and_Customer_Page_Verify_stepDefinition {
	
	String username = "";
	String password = "";
	private Amazon_Login_pageElements Amazon_Login_pageElements_obj = new Amazon_Login_pageElements(DriverFactory.getDriver());
	
	@Given("I am on Amazon website")
	public void i_am_on_amazon_website() {
	    
		DriverFactory.getDriver().get("https://www.amazon.in/");
		System.out.println(">>> Amazon url launched");
		System.out.println(">>> Page Title: "+ Amazon_Login_pageElements_obj.getPageTitle());
	    
	}
	@When("I click on Hello! Sign In link at the top-right corner")
	public void i_click_on_hello_sign_in_link_at_the_top_right_corner() {
	    
		if(Amazon_Login_pageElements_obj.landingPageSignInButtonClick()) {
			
			System.out.println(">>> Clicked on Hello! Sign In link at the top-right corner");
			
		}else {
			System.out.println("XXX Couldn't click on Hello! Sign In link at the top-right corner");
		}
	    
	}
	@When("I am navigated to Amazon Sign-In page")
	public void i_am_navigated_to_amazon_sign_in_page() {
	    
		if(Amazon_Login_pageElements_obj.verifyAmazonSignInPage()) {
			
			System.out.println(">>> Navigated to Amazon Sign-In page: Verified");
			
		}else {
			System.out.println("XXX Couldn't navigate to Amazon Sign-In page");
		}
	    
	}
	@When("I get Amazon Sign-In details from excel data sheet with sheetname {string} and row-number {int}")
	public void i_get_amazon_sign_in_details_from_excel_data_sheet_with_sheetname_and_row_number(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException{
	    
		ExcelReader ExcelReader_obj = new ExcelReader();
		
		List<Map<String, String>> testData = 
				ExcelReader_obj.getData("/Users/arkobiswas/Developer/eclipse-workspace/Amazon_Login_Automation/src/test/resources/amazonLoginTestData.xlsx", sheetName);
		
		username = testData.get(rowNumber).get("username");
		password = testData.get(rowNumber).get("password");
		
		
	}
	@Then("I place my username or phone number and click on Continue button")
	public void i_place_my_username_or_phone_number_and_click_on_continue_button() {
	    
		if(Amazon_Login_pageElements_obj.inputUserName(username)) {
			
			System.out.println(">>> Username or phone number entered");
			
		}else {
			System.out.println("XXX Couldn't enter username");
		}
		
		if(Amazon_Login_pageElements_obj.continueButtonClick()) {
			
			System.out.println(">>> Continue button clicked");
			
		}else {
			System.out.println("XXX Couldn't click continue button");
		}
		
	}
	@Then("I am navigated to password input page and verify page")
	public void i_am_navigated_to_password_input_page_and_verify_page() {
	    
		if(Amazon_Login_pageElements_obj.verifyPasswordInputPage()) {
			
			System.out.println(">>> Navigated to password input page: Verified");
			
		}else {
			System.out.println("XXX Couldn't navigate to password page");
		}
	    
	}
	@Then("I place my password and tick keep me signed in and click on Sign in button")
	public void i_place_my_password_and_tick_keep_me_signed_in_and_click_on_sign_in_button() {
	    
		if(Amazon_Login_pageElements_obj.inputPassword(password)) {
			
			System.out.println(">>> Password entered");
			
		}else {
			System.out.println("XXX Couldn't enter password");
		}
		
		if(Amazon_Login_pageElements_obj.signInButtonClick()) {
			
			System.out.println(">>> Sign IN button clicked");
			
		}else {
			System.out.println("XXX Couldn't click Sign IN button");
		}
		
	}
	@Then("I verify my Amazon account is logged in")
	public void i_verify_my_amazon_account_is_logged_in() {
	    
		if(Amazon_Login_pageElements_obj.verifyCustomerPage()) {
			
			System.out.println(">>> Customer page verified");
			
		}else {
			System.out.println("XXX Couldn't verify customer page");
		}
		
	}

}
