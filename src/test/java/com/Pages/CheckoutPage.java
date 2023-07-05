package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	WebDriver driver;

	@FindBy(id = "first-name")
	WebElement enterfirstname;

	@FindBy(id = "last-name")
	WebElement enterlastname;

	@FindBy(id = "postal-code")
	WebElement enterpincode;

	@FindBy(id = "continue")
	WebElement continuebtn;

	@FindBy(xpath = "//div[@class=\"summary_info_label summary_total_label\"]")
	WebElement printtotalprice;

	@FindBy(id = "finish")
	WebElement finishbtn;

	@FindBy(xpath = "//h2[@class=\"complete-header\"]")
	WebElement completeheadermessage;

	@FindBy(xpath = "//div[@class=\"complete-text\"]")
	WebElement completetext;

	@FindBy(xpath = "//span[@class=\"title\"]")
	WebElement checkouttitle;

	@FindBy(id = "back-to-products")
	WebElement backhome;

	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void enterFirstName() {
		enterfirstname.sendKeys("Bharath Raj");
	}

	public void enterLastname() {
		enterlastname.sendKeys("C");
	}

	public void enterPincode() {
		enterpincode.sendKeys("631205");

	}

	public void continuebtn() {
		continuebtn.click();
	}

	public void TotalPrice() {

		String totalprice = printtotalprice.getText();
		System.out.println(totalprice);

	}

	public void finishBtn() {
		finishbtn.click();
	}

	public void completeHeaderMessage() {
		String printheadermessage = completeheadermessage.getText();
		System.out.println(printheadermessage);
	}

	public void completeText() {
		String printcompletetextmessage = completetext.getText();
		System.out.println(printcompletetextmessage);
	}

	public void Title() {
		String printcheckouttitlemessage = checkouttitle.getText();
		System.out.println(printcheckouttitlemessage);

	}

	public void backHomebtn() {

		backhome.click();
	}

}
