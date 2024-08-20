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
	
	@Test(priority = 1)
	public void verifyRegistrationWithoutFillingAnyDetails() {
		
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).isDisplayed());
		// One way of ensuring the error message
		System.out.println("First Policy Error Assert");
		
		// Another way of confirming the error message by comparison
		String actualPolicyErrorMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		
		Assert.assertTrue(actualPolicyErrorMessage.contains(actualPolicyErrorMessage)); // This works
		System.out.println("2nd Policy Error Assert");
		
		Assert.assertTrue(actualPolicyErrorMessage.contains("Warning: You must agree to the Privacy Policy!"), "First Name must be entered.");
		// This also works. Need to dig deeper. 
		System.out.println("3rd Policy Error Assert");
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'First Name must be between 1 and 32 characters!']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'Last Name must be between 1 and 32 characters!']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'E-Mail Address does not appear to be valid!']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'Telephone must be between 3 and 32 characters!']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'Password must be between 4 and 20 characters!']")).isDisplayed());
		
		System.out.println("Testing.");
	}
	
	@Test(priority = 2)
	public void verifyRegistrationWithMandatoryFields() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("Selenium");
		driver.findElement(By.id("input-lastname")).sendKeys("Testing");
		driver.findElement(By.id("input-email")).sendKeys("seleniumtesting22@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("123-456-789");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Selenium@123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String accountSuccess = driver.findElement(By.xpath("//div[@id = 'content']/h1")).getText();
		Assert.assertEquals(accountSuccess, "Your Account Has Been Created!", "Account success message did not appear.");
	}
	
	@Test(priority = 3)
	public void verifyRegistrationWithAllFields() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("Selenium");
		driver.findElement(By.id("input-lastname")).sendKeys("Testing");
		driver.findElement(By.id("input-email")).sendKeys("seleniumtesting32@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("123-456-789");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Selenium@123");
		driver.findElement(By.xpath("//input[@name = 'newsletter'][@value = '1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		// Assert.assertTrue(driver.findElement(By.xpath("//div[@id = 'content']/h1")).isDisplayed());
		// Didn't executed as expected. Logical error
		
		String accountSuccess = driver.findElement(By.xpath("//div[@id = 'content']/h1")).getText();
		Assert.assertEquals(accountSuccess, "Your Account Has Been Created!", "Account success message did not appear.");		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}
