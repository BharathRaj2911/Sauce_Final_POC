package main;

import org.testng.annotations.Test;

import com.Features.AddToCart;
import com.Features.Cart;
import com.Features.Complete;
import com.Features.Home;
import com.Features.Login;
import com.Features.Logout;
import com.Features.Overview;
import com.Features.YourInformation;
import org.apache.commons.io.FileUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MainTest {

	WebDriver driver;

	Login l;
	Home hm;
	AddToCart atc;
	Cart ct;
	YourInformation yi;
	Overview view;
	Complete cpt;
	Logout lg;

	@BeforeClass
	public void beforeClass()

	{

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

	}

	@BeforeMethod
	public void beforeMethod() {

		l = new Login(driver);
		hm = new Home(driver);
		atc = new AddToCart(driver);
		ct = new Cart(driver);
		yi = new YourInformation(driver);
		view = new Overview(driver);
		cpt = new Complete(driver);
		lg = new Logout(driver);

	}

	@Test(priority = 0, dataProvider = "create")
	public void login(String username, String password) throws InterruptedException, IOException {

		l.gText();
		l.gUsername();
		l.gPassword();
		l.usname(username);
		l.uspass(password);
		l.cklogin();

	}

	@Test(priority = 1)
	public void Home() throws InterruptedException, IOException {

		hm.clikmenu();

		hm.getmenu();

		hm.vfyLogin();

		hm.clkclose();

		hm.gText();
		hm.getFilter();

		hm.selefilter();
		hm.vFilter();
	}

	@Test(priority = 2)
	public void addCart() {
		atc.clktsht();
		atc.clktshtred();
		atc.clkjac();
		atc.clkcrt();
	}

	@Test(priority = 3)
	public void cart() throws IOException, InterruptedException {
		ct.productlist1();

		ct.productremove();
		ct.productlist2();

		ct.ckContinue();
		atc.clkpack();
		atc.clkcrt();
		ct.productlist1();

		ct.ckcheckout();

	}

	@Test(priority = 4)
	public void yourInfo() throws IOException, InterruptedException {
		yi.enName();
		yi.lname();
		yi.pinc();
		yi.ckcnt();
	}

	@Test(priority = 5)
	public void overView() throws IOException {

		view.tPrice();
		view.ckfinesh();

	}

	@Test(priority = 6)
	public void complt() throws IOException, InterruptedException {

		cpt.ctitle();
		cpt.comp();
		cpt.comptxt();
		cpt.clickback();

	}

	@Test(priority = 7)
	public void logout() throws InterruptedException, IOException {
		lg.button();
		lg.vfyLogout();
		lg.logout();
	}

	@DataProvider(name = "create")
	public Object[][] dataSet1() {

		return new Object[][] { { "standard_user", "secret_sauce" }

//				{ "problem_user", "secret_sauce" }, { "performance_glitch_user", "secret_sauce" },
//				{ "locked_out_user", "secret_sauce" }
			};
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {

		driver.close();

	}

}
