package com.snetBanking.testCases;


import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.snetBanking.pageObjects.LoginPage;
import com.snetBanking.utilities.ExcelData;

import junit.framework.Assert;


public class TC_LoginDDT_002 extends BaseClass{
	@Test(dataProviderClass=ExcelData.class,dataProvider="loginData")
	public void LoginDDT(String Username, String Password) throws InterruptedException, IOException {
	LoginPage l=new LoginPage(driver);
	Thread.sleep(2000);
	l.setUn(Username);
	Thread.sleep(2000);
	l.setPw(Password);
	l.LogIn();	
	Thread.sleep(2000);
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
    	Assert.assertTrue(true);
    	log.info("Login Test Passed");
    }
    else {
    	CaptureScrrenshot(driver, "LoginTest");
    	Assert.assertTrue(false);
    	log.info("Login Test Failed");
    }
	if(isAlertPresent()==true) {
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		log.warn("Login failed");
	}
	else {
		Assert.assertTrue(true);
		log.info("Login Passed");
		l.clickLogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
	}
	
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
	}
		catch(NoAlertPresentException e) {
			return false;
		}
}
}
