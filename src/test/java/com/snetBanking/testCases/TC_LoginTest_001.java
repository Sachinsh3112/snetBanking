package com.snetBanking.testCases;


import org.testng.annotations.Test;

import com.snetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void LoginTest() throws Throwable {
		String Us = Re.getUserName();
		String Pa = Re.getPassword();
	LoginPage l=new LoginPage(driver);
		l.setUn(Us);
		log.info("Entered Username");
		l.setPw(Pa);
		log.info("Entered Password");
		l.LogIn();
		log.info("Login Successfull");
		
		
    if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
    	Assert.assertTrue(true);
    	log.info("Login Test Passed");
    }
    else {
    	CaptureScrrenshot(driver, "LoginTest");
    	Assert.assertTrue(false);
   	log.info("Login Test Failed");
    }	
		l.clickLogout();
		driver.switchTo().alert().accept();
	}
}
