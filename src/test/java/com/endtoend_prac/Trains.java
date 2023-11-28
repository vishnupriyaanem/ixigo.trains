package com.endtoend_prac;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Trains {
  @Test
  public void trains() throws InterruptedException {
	  ChromeOptions options = new ChromeOptions();
	  options.setBinary("C:\\Users\\hp\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
	  WebDriver driver = new ChromeDriver(options);
	  driver.manage().window().maximize();
	  driver.get("https://www.ixigo.com/"); 
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  Thread.sleep(3000);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='left-wrapper ']/span[2]/nav/span[2]/a ")));
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='left-wrapper ']/span[2]/nav/span[2]/a ")));
	  driver.findElement(By.xpath("//div[@class='left-wrapper ']/span[2]/nav/span[2]/a ")).click();
	  WebElement from=driver.findElement(By.xpath("(//div[text()='From']/following::input)[1]"));
		from.clear();
		from.sendKeys("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
		from.sendKeys("Ahmedabad Jn (ADI)");
		Thread.sleep(2000);
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ARROW_UP);
		from.sendKeys(Keys.ENTER);
		WebElement to =driver.findElement(By.xpath("(//div[text()='From']/following::input)[2]"));
		to.sendKeys("New Delhi ");
		wait.withTimeout(Duration.ofSeconds(20));
		to.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='rd-days']/tbody/tr[1]/td[6]")));
		driver.findElement(By.xpath("//table[@class='rd-days']/tbody/tr[1]/td[6]")).click();
		driver.findElement(By.xpath("(//button[text()='Search'])[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Show Availability'])[1]")));
		driver.findElement(By.xpath("//div[text()='Sat, 02 Dec']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='1A']")));
		driver.findElement(By.xpath("//span[text()='1A']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Ladies']")));
		driver.findElement(By.xpath("//span[text()='Tatkal']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='06:00 - 12:00']")));
		driver.findElement(By.xpath("//button[text()='06:00 - 12:00']")).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='nav-right ixi-icon-chevron u-ib']")));
		driver.findElement(By.xpath("//div[@class='data-wrapper']/div[3]")).click();
		Thread.sleep(2000);
		//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='nav-left ixi-icon-chevron u-rotate-180 u-ib']")));
		driver.findElement(By.xpath("//div[@class='data-wrapper']/div[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='ARRIVAL TIME']")));
		driver.findElement(By.xpath("//span[text()='ARRIVAL TIME']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Show Availability']")));
        try {
        	driver.findElement(By.xpath("//button[text()='Show Availability']")).click();
		}catch(org.openqa.selenium.StaleElementReferenceException ex) {
			driver.findElement(By.xpath("//button[text()='Show Availability']")).click();
		}
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-text']")));
		WebElement error = driver.findElement(By.xpath("//div[@class='error-text']"));
	    System.out.println(error.getText());

		
}
}
















