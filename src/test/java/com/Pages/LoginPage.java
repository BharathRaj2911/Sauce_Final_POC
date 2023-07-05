package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//div[text()='Swag Labs']")
	WebElement verifypagetitle;

	@FindBy(id = "login_credentials")
	WebElement printusername;

	@FindBy(xpath = "//div[@class=\"login_password\"]")
	WebElement printpassword;

	@FindBy(xpath = "//div[@class='error-message-container error']")
	WebElement printerrormessage;

	@FindBy(id = "user-name")
	WebElement enterusername;

	@FindBy(id = "password")
	WebElement enterpassword;

	@FindBy(id = "login-button")
	WebElement loginbtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void pageTitle() {
		String printpagetitle = verifypagetitle.getText();
		System.out.println("Page title: "+printpagetitle);

	}

	public void printUsername() {
		String username = printusername.getText();
		System.out.println(username);

	}

	public void printPassword() {
		String password = printpassword.getText();
		System.out.println(password);

	}

	public void enterUsername(String username) {
		enterusername.clear();
		enterusername.sendKeys(username);
	}

	public void enterPassword(String password) {
		enterpassword.clear();
		enterpassword.sendKeys(password);

	}
	
	public void printErrorMessage() {
		
	String printtheerrormessage = printerrormessage.getText();
	System.out.println(printtheerrormessage);
	
	}

	public void loginButton() {
		loginbtn.click();

	}
}
