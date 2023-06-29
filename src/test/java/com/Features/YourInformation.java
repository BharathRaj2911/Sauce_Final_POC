package com.Features;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformation {

	WebDriver driver;

	@FindBy(id = "first-name")
	WebElement entName;

	@FindBy(id = "last-name")
	WebElement entLname;

	@FindBy(id = "postal-code")
	WebElement pscode;

	@FindBy(id = "continue")
	WebElement clkcnt;

	public YourInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void enName() {
		entName.sendKeys("Bharath Raj");
	}

	public void lname() {
		entLname.sendKeys("C");
	}

	public void pinc() throws IOException, InterruptedException {
		pscode.sendKeys("631205");
		Thread.sleep(3000);
		File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("/home/bharath/Pictures/Evidence/information.png"));
	
	}

	public void ckcnt() {
		clkcnt.click();
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,400)", "");
	}

}
