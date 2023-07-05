package com.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement printproductscountincart;

	@FindBy(xpath = "//div[@class=\"cart_list\"]")
	WebElement printproductsincart;

	@FindBy(id = "remove-sauce-labs-bolt-t-shirt")
	WebElement removeproductincart;

	@FindBy(id = "continue-shopping")
	WebElement continueshopping;

	@FindBy(id = "checkout")
	WebElement clickoncheckout;
	
	

	public CartPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void productsCountInCart() {
		
		String printproductscount = printproductscountincart.getText();
		System.out.println("Products Count In cart:" +printproductscount);
	}

	public void productsInCart() {

		String printproducttext = printproductsincart.getText();
		System.out.println(printproducttext);
	}

	public void removeProduct() {
		removeproductincart.click();
	}

	public void continueShoppingbtn() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		continueshopping.click();

	}

	public void checkoutBtn() {
		clickoncheckout.click();
	}

}
