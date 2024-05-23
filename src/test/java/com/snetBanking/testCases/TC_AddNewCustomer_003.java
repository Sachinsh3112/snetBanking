package com.snetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.snetBanking.pageObjects.AddCustomerPage;
import com.snetBanking.pageObjects.LoginPage;


public class TC_AddNewCustomer_003 extends BaseClass{
@Test
public void LoginDDT() throws InterruptedException, IOException {
	String Us = Re.getUserName();
	String Pa = Re.getPassword();
LoginPage l=new LoginPage(driver);
Thread.sleep(1000);
	l.setUn(Us);
	Thread.sleep(1000);
	log.info("Entered Username");
	l.setPw(Pa);
	Thread.sleep(1000);
	log.info("Entered Password");
l.LogIn();	

	AddCustomerPage a=new AddCustomerPage(driver);
	log.info("Providing Customer details.....!");
//	a.cross();
	a.User();
	a.CN("sachin");
	a.radbt();
	a.dob("12","04","2001");
	a.Add("Banshakri");
	a.City("Bengaluru");
	a.statee("karnataa");
	a.pinn("542463");
	a.mobil("6354785445");
	String emaill=random()+"@gmail.com";
	a.emil(emaill);
	a.passs("absds42");
	a.sub();
	Thread.sleep(2000);
	
	log.info("validation started......!");
	boolean result=driver.getPageSource().contains("Customer Registered Successfully!!!");
	
	if(result==true) {
		log.info("Testcase Passed");
		junit.framework.Assert.assertTrue(true);
	}else {
		log.info("TestCase failed");
		CaptureScrrenshot(driver, "AddNewCustomer");
		junit.framework.Assert.assertTrue(false);
	}
	l=new LoginPage(driver);
	 log.info("Logout Passed");
	 l.clickLogout();
	 Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
}

}
