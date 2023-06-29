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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


  
public class Login {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[text()='Swag Labs']")
	WebElement verifytext;
	
	@FindBy(id="login_credentials")
	WebElement getUsername;
	
	@FindBy(xpath="//div[@class=\"login_password\"]")
	WebElement getPassword;
		
	@FindBy(id="user-name")
	WebElement uname;
	
	@FindBy(id="password")
	WebElement upass;
	
	@FindBy(id="login-button")
	WebElement clogin;
	
	
				
	public Login(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver =driver;
	}
	public void gText() {
		String title = verifytext.getText();
		System.out.println(title);
		Assert.assertEquals(title, "Swag Labs");

	}
	
	public void gUsername() {
		String user = getUsername.getText();
		System.out.println(user);
		
	}
	public void gPassword() {
		String pass = getPassword.getText();
		System.out.println(pass);
		
	}
	
	@Test(dataProvider = "create")
	public void usname(String username) {
		
		uname.sendKeys(username);
	}
	public void uspass(String password) {
		upass.sendKeys(password);
		
	}
	public void cklogin() throws InterruptedException, IOException {
		clogin.click();
		Thread.sleep(5000);
		
		File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("/home/bharath/Pictures/Evidence/login.png"));
	}
	
	

	}
