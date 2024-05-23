package com.snetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
 
	public static FileInputStream fis;
	public static Properties p;
	
	public ReadConfig() {
		File src=new File("./TestData/Guru17.property");
		
		try {
			fis=new FileInputStream(src);
			p=new Properties();
			p.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url=p.getProperty("Url");
		return url;
	}
	
	
	public String getPassword() {
		String pa=p.getProperty("Pasw");
		return pa;
	}

	public String getUserName() {
		String us=p.getProperty("User");
		return us;
	}
	
	
}
