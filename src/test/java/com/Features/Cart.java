package com.Features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Cart {

	WebDriver driver;

	@FindBy(xpath = "//div[@class=\"cart_list\"]")
	WebElement prdlist1;

	@FindBy(id = "remove-sauce-labs-bolt-t-shirt")
	WebElement prdremove;

	@FindBy(xpath = "//div[@class=\"cart_list\"]")
	WebElement prdlist2;

	@FindBy(id = "continue-shopping")
	WebElement clkcontinue;

	@FindBy(id = "checkout")
	WebElement clkcheckout;

	public Cart(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void productlist1() throws IOException {

		String list1 = prdlist1.getText();
		System.out.println(list1);
		File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("/home/bharath/Pictures/Evidence/addtocart1.png"));
	}

	public void productremove() {
		prdremove.click();
	}

	public void productlist2() throws IOException, InterruptedException {
		String list2 = prdlist2.getText();
		System.out.println(list2);
		Thread.sleep(3000);
		File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("/home/bharath/Pictures/Evidence/addtocart2.png"));

	}

	public void ckContinue() {
		clkcontinue.click();

	}

	public void ckcheckout() {
		clkcheckout.click();
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,-400)", "");
	}

}