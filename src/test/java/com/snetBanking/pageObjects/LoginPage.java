package com.snetBanking.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage{


	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;

	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setUn(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPw(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	
	public void LogIn()
	{
	btnLogin.click();
	}	
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
		
	}
	