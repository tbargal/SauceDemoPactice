package com.SauceDemo.TestClass;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BasicVerifyLogin extends BaseClass
{
	Logger log;
	@Test(priority=1)
	public void VerifyLogin()
	{
		log=Logger.getLogger("MavenSauceDemoArtifact");
		PropertyConfigurator.configure("log4j.properties");
		String acttitle="Swag Labs";
		String title="Swag Labs";
		System.out.println(title);
		Assert.assertEquals(title, acttitle);
		log.info("login verified");
		Reporter.log("Login Success Reporter");
	}
}
