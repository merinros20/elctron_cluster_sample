package com.electronclusterdup.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.electronclusterdup.test.config.CreateWebDriver;
import com.electronclusterdup.ui.HomePage;
import com.electronclusterdup.ui.LoginPage;

public class TestLoginUS013
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
	@Test(priority = 0)
	public void testLoginTC054()
	{
		login.waitForLoginPageToLoad();
		login.getUsernameTextbox().sendKeys("merinros20@gmail.com");
		login.getPasswordTextbox().sendKeys("reenaros");
		login.getLoginButton().click();
		
		home.waitForHomePageToLoad();
		boolean acutalStatus = home.getLogoutButton().isDisplayed();
		boolean expectedStatus = true;
		Assert.assertEquals(acutalStatus, expectedStatus);
		System.out.println("runned first test case");
		home.getLogoutButton().click();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}

