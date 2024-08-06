package com.qa.ninjatutorials.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text() = 'My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}
	
	@Test
	public void verifyRegistrationWithMandatoryFields() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("Selenium");
		driver.findElement(By.id("input-lastname")).sendKeys("Testing");
		driver.findElement(By.id("input-email")).sendKeys("seleniumtesting5@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("123-456-789");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Selenium@123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String accountSuccess = driver.findElement(By.xpath("//div[@id = 'content']/h1")).getText();
		Assert.assertEquals(accountSuccess, "Your Account Has Been Created!", "Account success message did not appear.");
	}
	
	@Test
	public void verifyRegistrationWithAllFields() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("Selenium");
		driver.findElement(By.id("input-lastname")).sendKeys("Testing");
		driver.findElement(By.id("input-email")).sendKeys("seleniumtesting11@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("123-456-789");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Selenium@123");
		driver.findElement(By.xpath("//input[@name = 'newsletter'][@value = '1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		
		String accountSuccess = driver.findElement(By.xpath("//div[@id = 'content']/h1")).getText();
		Assert.assertEquals(accountSuccess, "Your Account Has Been Created!", "Account success message did not appear.");
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}
