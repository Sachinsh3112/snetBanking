package com.snetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	@FindBy(id="dismiss-button")
	private WebElement cancel;

	@FindBy(xpath="//a[text()='New Customer']")
	private WebElement NewC;
	
	@FindBy(name="name")
	private WebElement cn;
	
	@FindBy(name="rad1")
	private WebElement rdb;
	
	@FindBy(id="dob")
	private WebElement dob;
	
	@FindBy(name="addr")
	private WebElement add;
	
	@FindBy(name="city")
	private WebElement city;
	
	@FindBy(name="state")
	private WebElement state;
	
	@FindBy(name="pinno")
	private WebElement pin;
	
	@FindBy(name="telephoneno")
	private WebElement Mno;
	
	@FindBy(name="emailid")
	private WebElement emai;
	
	@FindBy(name="password")
	private WebElement pass;
	
	@FindBy(name="sub")
	private WebElement submit;
	
	public AddCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void cross() {
		cancel.click();
	}
	
	public void User() {
		NewC.click();
	}
	
	public void CN(String Cn) {
		cn.sendKeys(Cn);
	}
	
	public void radbt() {
		rdb.click();
	}
	
	public void dob(String mm,String dd,String yyyy) {
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yyyy);
	}
	
	public void Add(String Add) {
		add.sendKeys(Add);
	}
	
	public void City(String city1) {
		city.sendKeys(city1);
	}
	
	public void statee(String state1) {
		state.sendKeys(state1);
	}
	
	public void pinn(String pin1) {
		pin.sendKeys(pin1);
	}
	
	public void mobil(String mobile) {
		Mno.sendKeys(mobile);
	}
	
	public void emil(String email) {
		emai.sendKeys(email);
	}
	
	public void passs(String Pass) {
		pass.sendKeys(Pass);
	}
	
	public void sub() {
		submit.click();
	}
	
	
}
