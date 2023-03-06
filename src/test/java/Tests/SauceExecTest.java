package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BasePage.BasePageClass;

public class SauceExecTest extends BasePageClass{
	
	WebDriver driver;
	
	
	@Test
	@Parameters({"browser","platform"})
	public void verifyHomePageTest(String browser, String platform) {
		driver = initWebDriver(browser, platform, Test.class.getName());
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.xpath("//input[@id='user-name']")).clear();
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Assert.assertEquals("Swag Labs",driver.getTitle());
		
	}
	
	
	@Test
	@Parameters({"browser","platform"})
	public void verifyHomePageTestDup(String browser, String platform) {
		driver = initWebDriver(browser, platform, Test.class.getName());
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.xpath("//input[@id='user-name']")).clear();
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Assert.assertEquals("Swag Labs",driver.getTitle());
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
