package com.kart.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.kart.objectrepository.OR;

public class TestBase extends OR{
	public XlReader x=new XlReader();
	public static WebDriver driver;
	public FileInputStream f=null;
	public static Properties p=null;
	
	public static void initialize(String browser){
		if(browser.equals("ff")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/com/kart/drivers/chromedriver.exe");
			driver=new FirefoxDriver();
		}else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/com/kart/drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}	
		
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
		
	}


	public TestBase(){
		try{
			f=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/kart/config/config.properties");
			p=new Properties();
			p.load(f);
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

}
