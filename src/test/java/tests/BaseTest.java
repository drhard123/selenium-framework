package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
    //protected WebDriver driver;
	//commenting our the above line.
	//for parallel execution, Each thread gets its own WebDriver instance
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	//Getter - every class uses this to get their thread's driver
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	
	@BeforeMethod (alwaysRun = true) 
	public void setUp() {
		//WebDriver manager downloads the right chromedriver automatically
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver()); //Set driver for THIS thread.
		getDriver().manage().window().maximize();
		//WebDriver manager setup done, driver initialised and maximised. Initially the driver.get statement was also here, later removed it to BeforeMethod as the same url is required before each test method.
	}
	
	/*
	 * @AfterMethod(alwaysRun = true) public void clearSession() { //Navigate to
	 * logoutUrl to properly end the session
	 * getDriver().get("https://opensource-demo.orangehrmlive.com" +
	 * "/web/index.php/auth/logout"); }
	 */ //When parallel is methods, each test gets its own fresh browser anyway, so logout is no longer needed.
	//The browser is created fresh per test and destroyed after.
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if(getDriver() != null) {
			getDriver().quit();
			driver.remove(); //important - removes thread's driver from memory
		}
	}
	

}
