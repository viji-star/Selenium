package com.start.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Annot {

	@Test(enabled = false)
	public void message()
	{
		System.out.println("Hello");
	}
	
	@Test(enabled = true)
	public void zoo()
	{
		System.out.print("Animal");
	}
	
	@Test()
	public void park()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.yourdictionary.com/link");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		WebElement elemenet = driver.findElement(By.xpath("//a[contains(text(),'links')]"));
		String str = Keys.chord(Keys.ARROW_DOWN,Keys.ENTER);
		act.contextClick(elemenet).sendKeys(str).build().perform();
		
	}
	
}
