package com.qa.ninjatutorials.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("http://tutorialsninja.com/demo");
	}
	
	@Test(priority = 1)
	public void verifySearchWithoutAnyContent() {
		
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'There is no product that matches the search criteria.']")).isDisplayed());
		System.out.println("Without contect - Assert True test.");
	}
	
	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {
		
		driver.findElement(By.name("search")).sendKeys("Dell");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'There is no product that matches the search criteria.']")).isDisplayed());
		System.out.println("With Invalid product - Assert true test");
	}
	
	@Test(priority = 3)
	public void verifySearchWithValidProduct() {
		
		driver.findElement(By.name("search")).sendKeys("Samsung");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Samsung SyncMaster 941BW")).isDisplayed());
		System.out.print("With Valid Product - Assert True Test.");
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
