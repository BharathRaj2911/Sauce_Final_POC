package com.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class HomePage {

	WebDriver driver;

	@FindBy(id = "react-burger-menu-btn")
	WebElement menubtn;

	@FindBy(id = "react-burger-cross-btn")
	WebElement closebtn;

	@FindBy(xpath = "//span[@class='title']")
	WebElement producttext;

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement filter;

	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement tshirt;

	@FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
	WebElement tshirtred;

	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	WebElement jacket;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement carticon;

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement backpack;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	public void menuButton() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		menubtn.click();

	}

	public void closeButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		closebtn.click();

	}

	public void productText() {
		String printproducttext = producttext.getText();
		System.out.println(printproducttext);
	}

	public void selectFilter() {

		Select selectfilter = new Select(filter);
		selectfilter.selectByVisibleText("Price (low to high)");

	}

	public void addToCartTShirt() {
		tshirt.click();
	}

	public void addToCartTShirtRed() {
		tshirtred.click();
	}

	public void addToCartJacket() {
		jacket.click();
	}

	public void cartIcon() {
		carticon.click();
	}

	public void addToCartBackpack() {
		backpack.click();
	}
}
