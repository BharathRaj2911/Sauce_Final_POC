package com.Features;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class AddToCart {

	WebDriver driver;
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement clktshirt;
	
	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
	WebElement clktshirtred;
	
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
	WebElement clkjacket;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement clkcart;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement clkbackpack;
	
	public AddToCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clktsht() {
		clktshirt.click();
	}
	public void clktshtred() {
		clktshirtred.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
	}
	public void clkjac() {
		clkjacket.click();
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,-500)", "");
	}
	
	public void clkcrt() {
		
		clkcart.click();
	}
	
	public void clkpack() {
		
		clkbackpack.click();
	}

}
