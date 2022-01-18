package com.again.soft;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {
	WebDriver driver;
	
	int j;
	public void browser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.navigate().to("https://www.techlistic.com/p/demo-selenium-practice.html");

	}
	
	public void scrolldown()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//table[@summary='Sample Table']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public boolean structuralvalue()
	{
	boolean flag = false;
	
		int rowcountexcludingheadfoot= driver.findElements(By.xpath("//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[4]/table/tbody/tr")).size();
		//System.out.println("Row count excluding header footer is " + rowcountexcludingheadfoot);
		
		if(rowcountexcludingheadfoot==4)
		{
			flag = true;
			return flag;
		}
		else
			return flag;
	}
	
	public int lastrowcol()
	{
		int colcountexcludingfirstcol = driver.findElements(By.xpath("//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[4]/table/tfoot/tr/td")).size();
		return (colcountexcludingfirstcol +1);
	}
	
	
	public String height()
	{
		int colcountexcludingfirstcol = driver.findElements(By.xpath("//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[4]/table/thead/tr/th")).size();
		String first_part = "//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[4]/table/thead/tr/th[";
		String second_part = "]";
		for (j= 1;j<colcountexcludingfirstcol;j++)
		{
			String final_xpath = first_part + j +second_part;
			String colname = driver.findElement(By.xpath(final_xpath)).getText();
			if(colname.equals("Height"))
			{
				break;
			}
		}
		
		HashMap<String,String> hash = new HashMap<String,String> ();
		int rowcountexcludingheadfoot= driver.findElements(By.xpath("//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[4]/table/tbody/tr")).size();
		for (int p = 1;p<=rowcountexcludingheadfoot;p++)
		{
			//*[@id="post-body-5867683659713562481"]/div[1]/div[4]/table/tbody/tr[1]/td[3]
			String key_path = "//*[@id='post-body-5867683659713562481']/div[1]/div[4]/table/tbody/tr[" + p + "]/th";
			String key = driver.findElement(By.xpath(key_path)).getText();
			String value_xpath = "//*[@id='post-body-5867683659713562481']/div[1]/div[4]/table/tbody/tr[" + p + "]/td[" + (j-1) +"]";
			String value = driver.findElement(By.xpath(value_xpath)).getText();
			hash.put(value,key);
		}
		
	TreeMap data = new TreeMap(hash);
	return (data.get(data.lastKey())).toString();
	}

}
