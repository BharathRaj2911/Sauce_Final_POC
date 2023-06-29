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

public class Complete {

	WebDriver driver;

	@FindBy(xpath = "//h2[@class=\"complete-header\"]")
	WebElement complete;

	@FindBy(xpath = "//div[@class=\"complete-text\"]")
	WebElement completetxt;

	@FindBy(xpath = "//span[@class=\"title\"]")
	WebElement title;

	@FindBy(id = "back-to-products")
	WebElement clkback;

	public Complete(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void comp() {
		String h1 = complete.getText();
		System.out.println(h1);
	}

	public void comptxt() {
		String h2 = completetxt.getText();
		System.out.println(h2);
	}

	public void ctitle() throws IOException, InterruptedException {
		String h3 = title.getText();
		System.out.println(h3);
		Thread.sleep(3000);

	}

	public void clickback() throws IOException {

		clkback.click();
	}

}
