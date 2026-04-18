package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	// Every page needs a driver. So BasePage holds it
	WebDriver driver;
	
	//Constructor, When every page is created, it receives the driver
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//Waits until element is visible, then type into it
	public void type(By locator, String text) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).sendKeys(text);
	}
	
	//Waits until element is clickable, then click it
	public void click(By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
	}
	
	
	//Check if an element is visible on screen
	public boolean isDisplayed(By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator).isDisplayed();
	}
	
	//returns the text of the element as String
	public String getText(By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator).getText();
	}
}
