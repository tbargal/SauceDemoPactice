package com.SauceDemo.TestClass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.SauceDemo.POMClass.LoginPageVerifyTestNG;


public class BaseClass 
{
	WebDriver driver;
	Logger log;
	@Parameters("browserName")
	@BeforeClass
	public  void TestNGMethod(String browserName) throws InterruptedException  
	{
		
		if(browserName.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\TheOne\\Desktop\\Velocity\\Selenium\\Browsers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		else if(browserName.equals("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\TheOne\\Desktop\\Velocity\\Selenium\\Browsers\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			log= Logger.getLogger("MavenSauceDemoArtifact");
			PropertyConfigurator.configure("log4j.properties");
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			log.info("Browser Opened");
		}
		
	}
	@BeforeMethod
	public void login() throws InterruptedException
	{
		log=Logger.getLogger("MavenSauceDemoArtifact");
		PropertyConfigurator.configure("log4j.properties");
		LoginPageVerifyTestNG login=new LoginPageVerifyTestNG(driver);
		login.SendUserName();
		log.info("username Entered");
		login.SendPassword();
		log.info("Password entered");
		login.SubmitButton();
		log.info("Entered");
		log.info("Signed In");
		
	}

	
	@AfterMethod
	public void LogOut() throws InterruptedException
		{
		Thread.sleep(5000);
			log=Logger.getLogger("MavenSauceDemoArtifact");
			PropertyConfigurator.configure("log4j.properties");
			LoginPageVerifyTestNG login=new LoginPageVerifyTestNG(driver);
			login.menu();
			login.LogOut();
			log.info("Signed Out");
			driver.quit();
		}	
	@AfterClass
	private void closeBrowser()
	{		
		  System.out.println("Browser Closed"); 
			
	}		
		
	
	
}
