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
import org.testng.Assert;

public class Logout {
	WebDriver driver;

	@FindBy(id = "react-burger-menu-btn")
	WebElement clkbtn;

	@FindBy(id = "logout_sidebar_link")
	WebElement verifyLogout;

	@FindBy(id = "logout_sidebar_link")
	WebElement clklogout;

	public Logout(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void button() {
		clkbtn.click();

	}

	public void vfyLogout() throws InterruptedException {

		String s2 = verifyLogout.getText();

		Assert.assertNotEquals(s2, "Login");
		Thread.sleep(5000);
	}

	
	public void logout() throws InterruptedException, IOException {
		clklogout.click();
		Thread.sleep(5000);
		File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("/home/bharath/Pictures/Evidence/logout.png"));
		Thread.sleep(2000);
		
	}

}
