package com.MainTest;

import org.testng.annotations.Test;
import com.BaseClass.Baseclass;
import com.Pages.CartPage;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.Pages.LogoutPage;
import com.Pages.CheckoutPage;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class MainTest {

	WebDriver driver;
	LoginPage verifyloginpage;
	HomePage verifyaddtocartproducts;
	CartPage verifyproductsoncart;
	CheckoutPage verifyproductsoncheckout;
	LogoutPage verifylogoutpage;

	@BeforeClass
	public void beforeclass() {

		driver = Baseclass.getdriver();

	}

	@BeforeMethod
	public void beforeMethod() {

		verifyloginpage = new LoginPage(driver);
		verifyaddtocartproducts = new HomePage(driver);
		verifyproductsoncart = new CartPage(driver);
		verifyproductsoncheckout = new CheckoutPage(driver);
		verifylogoutpage = new LogoutPage(driver);

	}

	@Test(priority = 0, dataProvider = "create")
	public void loginWithValidAndInvalidUserCredentials(String username, String password) {

		verifyloginpage.pageTitle();
		verifyloginpage.printUsername();
		verifyloginpage.printPassword();
		verifyloginpage.enterUsername(username);
		verifyloginpage.enterPassword(password);
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		verifyloginpage.loginButton();
	}

	@Test(priority = 1)
	public void AddProductsToCart() {

		verifyaddtocartproducts.menuButton();
		verifyaddtocartproducts.closeButton();
		verifyaddtocartproducts.productText();
		verifyaddtocartproducts.selectFilter();
		verifyaddtocartproducts.addToCartTShirt();
		verifyaddtocartproducts.addToCartTShirtRed();
		verifyaddtocartproducts.addToCartJacket();
		verifyaddtocartproducts.cartIcon();
	}

	@Test(priority = 2)
	public void removeProductsAndCheckoutProductsOnCart() {

		verifyproductsoncart.productsCountInCart();
		verifyproductsoncart.productsInCart();
		verifyproductsoncart.removeProduct();
		verifyproductsoncart.continueShoppingbtn();
		verifyaddtocartproducts.addToCartBackpack();
		verifyaddtocartproducts.cartIcon();
		verifyproductsoncart.productsInCart();
		verifyproductsoncart.productsCountInCart();
		verifyproductsoncart.checkoutBtn();

	}

	@Test(priority = 3)

	public void CompleteCheckout() {

		verifyproductsoncheckout.enterFirstName();
		verifyproductsoncheckout.enterLastname();
		verifyproductsoncheckout.enterPincode();
		verifyproductsoncheckout.continuebtn();
		verifyproductsoncheckout.TotalPrice();
		verifyproductsoncheckout.finishBtn();
		verifyproductsoncheckout.completeHeaderMessage();
		verifyproductsoncheckout.completeText();
		verifyproductsoncheckout.Title();
		verifyproductsoncheckout.backHomebtn();
	}

	@Test(priority = 4)

	public void logoutAsUser() {

		verifylogoutpage.menuBtn();
		verifylogoutpage.logoutBtn();

	}

	@AfterMethod
	public void afterMethod() {

		System.out.println("After Method");

	}

	@AfterClass
	public void afterClass() {

		driver.quit();

	}

	@DataProvider(name = "create")
	public Object[][] dataSet1() {

		return new Object[][] { { "", "" }, { "standard_user", "" }, { "user", "secret_sauce" },
				{ "standard_user", "secret_sauce" } };

	}
}
