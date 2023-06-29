package com.Features;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Overview {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class=\"summary_info_label summary_total_label\"]")
	WebElement totalprice;
	
	@FindBy(id="finish")
	WebElement clkfinish;
	
	
	public Overview(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void tPrice() throws IOException {
		
		String p = totalprice.getText();
		System.out.println(p);
		
		File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("/home/bharath/Pictures/Evidence/Overview.png"));
	}
	
	public void ckfinesh() {
		clkfinish.click();
	}

}
