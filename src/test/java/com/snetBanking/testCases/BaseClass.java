package com.snetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.snetBanking.pageObjects.LoginPage;
import com.snetBanking.utilities.ReadConfig;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;




public class BaseClass {
     ReadConfig Re=new ReadConfig();
     LoginPage l;
	public static WebDriver driver;
	 public static Logger log;
	 

	 @Parameters("browser")
	 
	 @BeforeClass
	 public void OpenBrowser(String br) {
		 log=Logger.getLogger("snetBAnking");
		 PropertyConfigurator.configure("log4j.properties");

		 if(br.equals("chrome")) {
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 }

		 else if(br.equals("fire")) {
			 driver=new FirefoxDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 }

		 else if(br.equals("ie")) {
			 driver=new EdgeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 }
	 }
	 
@BeforeMethod
public void Login() {
	String URL = Re.getApplicationURL();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get(URL);
	 log.info("URL is Opened");
}
	
	 @AfterMethod
	 public void Logout() throws InterruptedException {
//		l=new LoginPage(driver);
//		 log.info("Logout Passed");
//		 l.clickLogout();
//		 Thread.sleep(2000);
//			driver.switchTo().alert().accept();
//			driver.switchTo().defaultContent();
	 }

	 @AfterClass
	 public void CloseBrowser()  {
		 driver.close();
	 }
	 
	 
	 public String random() {
		 String generatorstring=RandomStringUtils.randomAlphabetic(8);
		 return generatorstring;
		 }

		 public static String randomno() {
		 String generator=	RandomStringUtils.randomNumeric(4);
		 return generator;
		 }
	 
	 public void CaptureScrrenshot(WebDriver driver, String tname) throws IOException {
		 TakesScreenshot t=(TakesScreenshot)driver;
			File source=t.getScreenshotAs(OutputType.FILE);
			File desti=new File("./Screenshots/"+ tname +".png");
				FileUtils.copyFile(source, desti);
	 }
}
