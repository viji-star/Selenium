package com.again.soft;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTable extends BrowserLaunch{

	BrowserLaunch brow =new BrowserLaunch();
	
	
	@BeforeClass
	public void setup()
	{
		brow.browser();
	}
	
	@Test()
	public void sample()
	{
		//System.out.println("Hello");
		brow.scrolldown();
	}
	
	@Test
	public void structuralValues()
	{
		boolean bool = brow.structuralvalue();
		Assert.assertTrue(bool);
		System.out.println("There are only 4 structure values present in the table with Selenium");
		
	}
	
	
	@Test
	public void lastrowcolTest()
	{
		Assert.assertEquals(brow.lastrowcol(), 2);
		System.out.println("6th row of the table (Last Row) has only two columns with Selenium");
	}
	
	@Test
	public void heightTest()
	{
		String tallest = brow.height();
		Assert.assertEquals(tallest, "Burj Khalifa");
		System.out.println("The tallest structure in the table with Selenium is " + tallest);
	}
}
