package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeClass  
	public void setUp() {
		//WebDriver manager downloads the right chromedriver automatically
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//WebDriver manager setup done, driver initialised and maximised. Initially the driver.get statement was also here, later removed it to BeforeMethod as the same url is required before each test method.
	}
	
	@AfterMethod
	public void clearSession() {
		//Navigate to logoutUrl to properly end the session
		driver.get("https://opensource-demo.orangehrmlive.com" + "/web/index.php/auth/logout");
	}
	
	@AfterClass  
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
	

}
