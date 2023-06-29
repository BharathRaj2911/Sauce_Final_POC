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
import org.openqa.selenium.support.ui.Select;

public class Home {

	WebDriver driver;

	@FindBy(id = "react-burger-menu-btn")
	WebElement clkmenu;

	@FindBy(xpath = "//nav[@class='bm-item-list']")
	WebElement gmenulist;

	@FindBy(id = "logout_sidebar_link")
	WebElement verifyLogin;

	@FindBy(id = "react-burger-cross-btn")
	WebElement clkcls;
	
	@FindBy(xpath="//span[@class='title']")
	WebElement verifytext;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	WebElement getitems;

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement selfilter;
	
	@FindBy(xpath="//option[text()='Price (low to high)']")
	WebElement verifyfilter;
	
	
	

	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	public void clikmenu() throws InterruptedException {

		clkmenu.click();
		Thread.sleep(5000);


	}

	public void getmenu() {

		String glist = gmenulist.getText();
		System.out.println(glist);
	}

	public void vfyLogin() {

		String s1 = verifyLogin.getText();

		Assert.assertEquals(s1, "Logout");
	}

	public void clkclose() {
		clkcls.click();

	}
	
	public void gText() {
		String txt =verifytext.getText();
		System.out.println(txt);
	}
	
	public void getFilter() throws IOException {
		String list =getitems.getText();
		System.out.println(list);
		
		File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("/home/bharath/Pictures/Evidence/WithoutFilters1.png"));
		
	}

	public void selefilter() throws InterruptedException, IOException {

		Select filter = new Select(selfilter);
		filter.selectByVisibleText("Price (low to high)");
		Thread.sleep(3000);
		
		File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("/home/bharath/Pictures/Evidence/withFilters1.png"));
		
		
		
		}
	public void vFilter() {
		String vf = verifyfilter.getText();
	System.out.println(vf);
	
	Assert.assertEquals(vf, "Price (low to high)");
	}
}
