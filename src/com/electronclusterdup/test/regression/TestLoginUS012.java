package com.electronclusterdup.test.regression;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.electronclusterdup.test.config.CreateWebDriver;
import com.electronclusterdup.ui.HomePage;
import com.electronclusterdup.ui.LoginPage;


public class TestLoginUS012
{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	@BeforeMethod
	public void setUp()
	{
		driver = CreateWebDriver.instance();
		login = new LoginPage(driver);
		home = new HomePage(driver);
	}
	@Test(enabled = false)
	public void testLoginTC053()
	{
		login.waitForLoginPageToLoad();
		login.getUsernameTextbox().sendKeys("admin");
		login.getPasswordTextbox().sendKeys("manager");
		login.getLoginButton().click();
		
		home.waitForHomePageToLoad();
		boolean acutalStatus = home.getLogoutButton().isDisplayed();
		boolean expectedStatus = true;
		Assert.assertEquals(acutalStatus, expectedStatus);
		System.out.println("runned second test case");
		home.getLogoutButton().click();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}

