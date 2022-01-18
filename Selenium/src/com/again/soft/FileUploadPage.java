package com.again.soft;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage extends FileBase {

	@FindBy(xpath="//span[@class='btn btn-success fileinput-button']//span")
	WebElement AddFiles;
	
	FileUploadPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void image()
	{
		AddFiles.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
