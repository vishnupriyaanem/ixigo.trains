package com.endtoend_prac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GroupBooking {
  @Test
  public void moreOptions() throws InterruptedException {
	  ChromeOptions options = new ChromeOptions();
	  options.setBinary("C:\\Users\\hp\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
	  WebDriver driver = new ChromeDriver(options);
	  driver.manage().window().maximize();
	  driver.get("https://www.ixigo.com/"); 
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  wait.withTimeout(Duration.ofSeconds(30));
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/div[1]/div/header/div/div[2]/div/span/span/span")).click();
//		Login
		driver.findElement(By.xpath("//div[@class='ixigo-login']/div/span/div/span")).click();
		driver.findElement(By.xpath("//div[@class='ixigo-login']/div[2]/span[2]/input")).sendKeys("9381282113");
//		Thread.sleep(000);
		driver.findElement(By.xpath("//div[@class='login-button']/button")).click();
//		Traversing multiple menus
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("More")));
		driver.findElement(By.linkText("More")).click();
  }
}
