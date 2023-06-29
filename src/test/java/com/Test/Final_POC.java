package com.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Final_POC {
	WebDriver driver;

	@Test(priority = 1)
	public void login1() throws InterruptedException {

		driver.findElement(By.id("user-name")).sendKeys("");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("");
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);

		String invalid = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
		System.out.println(invalid);

		Assert.assertEquals(invalid, "Epic sadface: Username is required");

		driver.findElement(By.xpath("//button[@class=\"error-button\"]")).click();

		String login = driver.findElement(By.name("login-button")).getText();
		System.out.println(login);

	}

	@Test(priority = 2)
	public void login2() throws InterruptedException {

		WebElement uc = driver.findElement(By.id("user-name"));
		uc.clear();
		Thread.sleep(2000);
		uc.sendKeys("standard_user");
		Thread.sleep(2000);
		WebElement up = driver.findElement(By.id("password"));
		up.clear();
		// Thread.sleep(2000);
		up.sendKeys("");

		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);

		String invalid = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
		System.out.println(invalid);

		Assert.assertEquals(invalid, "Epic sadface: Password is required");
		driver.findElement(By.xpath("//button[@class=\"error-button\"]")).click();

	}

	@Test(priority = 3)
	public void login3() throws InterruptedException {

		WebElement uc = driver.findElement(By.id("user-name"));
		uc.clear();
		Thread.sleep(3000);
		uc.sendKeys("standard_user");
		Thread.sleep(3000);
		WebElement up = driver.findElement(By.id("password"));
		up.clear();
		Thread.sleep(3000);
		up.sendKeys("xyz");
		Thread.sleep(3000);
		driver.findElement(By.id("login-button")).click();

		Thread.sleep(5000);

		String invalid = driver.findElement(By.xpath("//div[@class=\"error-message-container error\"]")).getText();
		System.out.println(invalid);
		Assert.assertEquals(invalid, "Epic sadface: Username and password do not match any user in this service");
		driver.findElement(By.xpath("//button[@class=\"error-button\"]")).click();

	}

	@Test(priority = 4)
	public void login4() throws InterruptedException {

		WebElement uc = driver.findElement(By.id("user-name"));
		uc.clear();
		Thread.sleep(3000);
		uc.sendKeys("standard");
		Thread.sleep(3000);
		WebElement up = driver.findElement(By.id("password"));
		up.clear();
		Thread.sleep(3000);
		up.sendKeys("secret_sauce");
		Thread.sleep(3000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);

		String invalid = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
		System.out.println(invalid);

		Assert.assertEquals(invalid, "Epic sadface: Username and password do not match any user in this service");
		driver.findElement(By.xpath("//button[@class=\"error-button\"]")).click();

	}

	@Test(priority = 5)
	public void login5() throws InterruptedException {

		WebElement uc = driver.findElement(By.id("user-name"));
		uc.clear();
		Thread.sleep(2000);
		uc.sendKeys("standard_user");
		Thread.sleep(2000);
		WebElement up = driver.findElement(By.id("password"));
		up.clear();

		up.sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("react-burger-menu-btn")).click();

		Thread.sleep(5000);

		String menulist = driver.findElement(By.xpath("//nav[@class=\"bm-item-list\"]")).getText();

		System.out.println("Menu List " + menulist);

		String Accountlogin = driver.findElement(By.id("logout_sidebar_link")).getText();

		Assert.assertEquals(Accountlogin, "Logout");

		driver.findElement(By.id("react-burger-cross-btn")).click();

		String title1 = driver.findElement(By.xpath("//span[@class='title']")).getText();
		System.out.println("The Page Title is :" + title1);

		String flt = driver.findElement(By.xpath("//select[@class='product_sort_container']")).getText();
		System.out.println("Filter Items " + flt);

		Select filter = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		filter.selectByVisibleText("Price (low to high)");
		Thread.sleep(3000);

		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");

		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-500)", "");

		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

		String cart = driver.findElement(By.xpath("//div[@class=\"cart_list\"]")).getText();
		System.out.println(cart);

		driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();

		String cart1 = driver.findElement(By.xpath("//div[@class=\"cart_list\"]")).getText();
		System.out.println(cart1);

		driver.findElement(By.id("continue-shopping")).click();

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

		String cart2 = driver.findElement(By.xpath("//div[@class=\"cart_list\"]")).getText();
		System.out.println(cart2);

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,400)", "");

		driver.findElement(By.id("checkout")).click();

		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,-400)", "");

		driver.findElement(By.id("first-name")).sendKeys("Bharath");

		driver.findElement(By.id("last-name")).sendKeys("Raj");

		driver.findElement(By.id("postal-code")).sendKeys("560036");

		driver.findElement(By.id("continue")).click();

		String totalPrice = driver.findElement(By.xpath("//div[@class=\"summary_info_label summary_total_label\"]"))
				.getText();
		System.out.println("Total Products price is " + totalPrice);

		driver.findElement(By.id("finish")).click();

		String h1 = driver.findElement(By.xpath("//h2[@class=\"complete-header\"]")).getText();

		String h2 = driver.findElement(By.xpath("//div[@class=\"complete-text\"]")).getText();

		String h3 = driver.findElement(By.xpath("//span[@class=\"title\"]")).getText();

		System.out.println(h3 + h1 + h2);

		driver.findElement(By.id("back-to-products")).click();

		driver.findElement(By.id("react-burger-menu-btn")).click();

		Assert.assertNotEquals(Accountlogin, "Login");
		Thread.sleep(3000);

		driver.findElement(By.id("logout_sidebar_link")).click();

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
