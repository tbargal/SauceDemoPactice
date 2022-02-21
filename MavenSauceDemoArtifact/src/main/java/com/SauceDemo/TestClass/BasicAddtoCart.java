package com.SauceDemo.TestClass;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.SauceDemo.POMClass.LoginPageVerifyTestNG;

public class BasicAddtoCart extends BaseClass
{

	Logger log;
	
	@Test(priority=2)
	public void AddToCart() throws InterruptedException
	{
		log=Logger.getLogger("MavenSauceDemoArtifact");
		PropertyConfigurator.configure("log4j.properties");
		LoginPageVerifyTestNG login=new LoginPageVerifyTestNG(driver);
		login.SelectElement();
		Thread.sleep(2000);
		login.addCart();
		log.info("Added to cart logger");
		Reporter.log("Added to cart reporter");
	}

}
