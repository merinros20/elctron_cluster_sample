package com.electronclusterdup.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	public void waitForHomePageToLoad(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoutMenu")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("logoutMenu")));
	}
public WebElement getLogoutButton(){
	WebElement ele = driver.findElement(By.id("userNavigationLabel"));
	Actions act = new Actions(driver);
	act.moveToElement(ele).perform();
	//<span class="_54nh">
	WebElement logout = driver.findElement(By.xpath("(//span[@class='_54nh'])[9]"));
	return logout;
	
}

}
