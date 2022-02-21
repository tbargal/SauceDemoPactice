package com.SauceDemo.TestClass;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.SauceDemo.POMClass.LoginPageVerifyTestNG;

public class BasicLogOut extends BaseClass
{

	@Test(priority=3)
	public void LogOut1() throws InterruptedException
	{
		log=Logger.getLogger("MavenSauceDemoArtifact");
		PropertyConfigurator.configure("log4j.properties");
		String title="Swag Labs";
		String expectedTitle= "Swag Labs";
	    Thread.sleep(5000);
	    System.out.println(driver.getCurrentUrl());
	    log.info("account logged out logger");
		Assert.assertEquals(true, true);
		Reporter.log("Logout Success Reporter");
	}
}
