package com.electronclusterdup.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	public void waitForLoginPageToLoad(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("login_form")));
	}
	public WebElement getUsernameTextbox(){
		WebElement un = driver.findElement(By.id("email"));
		return un;
	}
	public WebElement getPasswordTextbox(){
		WebElement pass = driver.findElement(By.id("pass"));
		return pass;
	}
	public WebElement getLoginButton(){
		WebElement button = driver.findElement(By.id("u_0_r"));
		return button;
	}


}
