package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	//No driver declaration - inherited from BaseTest
	//No setUp - Inherited from BaseTest
	//no teardown - Inherited from BaseTest
	LoginPage loginPage;
	
	@BeforeMethod  //runs before each test
	public void initPages() {
		loginPage = new LoginPage(driver); // initialising the loginPage Object, driver comes from the BaseTest
	}
	
	@Test
	public void validLoginTest() {
		loginPage.loginAs("Admin", "admin123");
		
		//After login, dashboard header should be visible
		//we check the URL contains "dashboard" as simple assertion
		//Syncronization issue faced, fix: added explicit wait 
		//new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("dashboard"));
		/*String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("dashboard"),"Login Failed- Dashboard in URL is not found");*/
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard not displayed after login");
		
	}

}
