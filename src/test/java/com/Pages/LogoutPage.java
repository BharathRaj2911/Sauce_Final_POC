package com.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	WebDriver driver;

	@FindBy(id = "react-burger-menu-btn")
	WebElement menubutton;

	@FindBy(id = "logout_sidebar_link")
	WebElement logoutbutton;

	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void menuBtn() {
		menubutton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	public void logoutBtn() {
		logoutbutton.click();

	}

}
