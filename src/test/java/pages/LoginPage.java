package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	//Step 1: Defining the Locators as private
	private By userNameField = By.name("username");
	private By passwordField = By.name("password");
	private By loginButton = By.cssSelector("button[type='submit']");
	private By invalidCredentialError = By.cssSelector(".oxd-alert-content-text");
	
	//Step 2 Constructor - (Passes driver up to BasePage)
	public LoginPage(WebDriver driver) {
		super(driver);	
	}
	
	//Step 3 Define the actions this page can do
	public void enterUsername(String username) {
		type(userNameField, username);  //type method is from BasePage
	}
	
	public void enterPassword(String password) {
		type(passwordField, password);  //type method is from BasePage
	}
	
	public void clickLoginButton() {
		click(loginButton);              //click method comes from BasePage
	}
	
	//Combine all 3 into one convenient method
	public void loginAs(String username, String password) {
	enterUsername(username);
	enterPassword(password);
	clickLoginButton();
	}
	
	//method will return the invalid login error text
	public String getErrorMessage() {
		return getText(invalidCredentialError);
	}
	
	

}
