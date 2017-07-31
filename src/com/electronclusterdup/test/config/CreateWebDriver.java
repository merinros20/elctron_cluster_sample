package com.electronclusterdup.test.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.electronclusterdup.utils.GetData;

public class CreateWebDriver {
	public static WebDriver instance()
	{
		WebDriver driver = null;
		String browserName = 
				GetData.fromProperties("configuration", "browser");
		String url = 
				GetData.fromProperties("configuration", "URL");
		String timeOut = 
				GetData.fromProperties("configuration", "timeouts");
		Integer timeouts = new Integer(timeOut);
		if(browserName.equalsIgnoreCase("firefox"))
		{
	/*System.setProperty("webdriver.firefox.marionette",
					"./browser-drivers/geckodriver.exe");*/
			/*System.setProperty("webdriver.gecko.driver",
					"./browser-drivers/geckodriver.exe");*/
			System.setProperty("webdriver.gecko.driver",
					"G:/IFB-Testing/Studies/geckodriver.exe"); 
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"./browser-drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.err.print("Improper Browser Selection");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().
		implicitlyWait(timeouts, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

}
