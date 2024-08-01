package com.qa.ninjatutorials.testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test	
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

}
