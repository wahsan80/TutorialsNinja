package com.qa.ninjatutorials.testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test(priority = 6)
	public void verifyLoginWithValidCredentials() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("http://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text() = 'My Account']")).click(); 
		// Investigate the xpath utility here. Why @class or text() or contains() didn't work? Compound Value error
		driver.findElement(By.linkText("Login")).click(); // No other attributes available like @id, @class, @name
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com"); // Straight forward
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123"); // Straight Forward
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click(); // No other option available
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		// Ensures that we are at the right page. 
		driver.quit();		
	}
	
	@Test(priority = 5)
	public void verifyLoginWithInvalidCredentials() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text() = 'My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda2@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@1234");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		// Understand what's the best way to capture the web element by using either, @id, @class, @name, xpath or 
		// cssSelector
		String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed.");
		// Ensuring that the warning message is displayed. 
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifyLoginWithNoCredentials() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text() = 'My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();	
		driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).isDisplayed();
		// Checks whether warning message has been displayed or not. 'True' if displayed, 'False' if not.
		
		String warningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		// Store the warning message text in a String
		System.out.println(warningMessage); // Just to confirm the text of the warning message by printing it. 
		
		driver.quit();
	}
	
	@Test(priority = 2)
	public void verifyInvalidEmailNoPassword() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text() = 'My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda1@gmail.com");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).isDisplayed();
		driver.quit();
	}
	
	@Test(priority = 3)
	public void verifyValidEmailNoPassword() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text() = 'My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).isDisplayed();
		driver.quit();
	}
	
	@Test(priority = 4)
	public void verifyValidEmailInvalidPassword() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text() = 'My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@1234");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).isDisplayed();
		driver.quit();
	}
	
	public void generateDateTimeStamp() {
		
		Date date = new Date();	
		System.out.println(date);
	}
}
