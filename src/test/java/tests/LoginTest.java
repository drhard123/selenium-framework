package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest {
	
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeMethod  //runs before each test
	public void setUp() {
		//WebDriver Manager downloads the right ChromeDriver automatically
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		loginPage = new LoginPage(driver);
		
		//WebDriver manager setup cheythu, driver initialise cheythu, maximised, opened url, initialised the loginPage Object
	}
	
	@Test
	public void validLoginTest() {
		loginPage.loginAs("Admin", "admin123");
		
		//After login, dashboard header should be visible
		//we check the URL contains "dashboard" as simple assertion
		//Syncronization issue faced, fix: added explicit wait 
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("dashboard"));
		
		/*String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("dashboard"),"Login Failed- Dashboard in URL is not found");*/
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard not displayed after login");
		
		
		
	}
	
	@AfterMethod //runs after each test
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
