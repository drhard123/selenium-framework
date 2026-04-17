package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

	//Step 1 locators
	
	private By dashboardHeading = By.cssSelector(".oxd-topbar-header-breadcrumb-module");
	
	//step 2 constructor
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	//methods
	public boolean isDashboardDisplayed() {
		return isDisplayed(dashboardHeading);
		
	}
}
