package com.qa.osc.page;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.osc.base.OscBase;

import io.appium.java_client.windows.WindowsDriver;

public class OscLogin extends OscBase {

	WebDriverWait wait;

	public OscLogin() throws IOException {
		super();

	}

	/*
	 * ApplicationLogin Page Locators
	 */

	String userNameLocator = "username";
	String passwordLocator = "password";
	String loginBtnLocator = "loginbutton";

	/*
	 * BOT CREDS
	 */

	String OSCUsernameValue = prop.getProperty("OSCUsernameValue");
	String OSCPasswordValue = prop.getProperty("OSCPasswordValue");

	String safeLoginNoValue = "No";

	public WebElement userName() {

		return driver.findElementByAccessibilityId(userNameLocator);
	}

	public WebElement password() {

		return driver.findElementByAccessibilityId(passwordLocator);
	}

	public WebElement loginButton() {

		return driver.findElementByAccessibilityId(loginBtnLocator);
	}

	public WebElement safeLoginNoBtn() {

		return driver.findElementByName(safeLoginNoValue);
	}

	public void login() throws MalformedURLException, InterruptedException {

		wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOf(userName())).sendKeys(OSCUsernameValue);
		wait.until(ExpectedConditions.visibilityOf(password())).sendKeys(OSCPasswordValue);
		wait.until(ExpectedConditions.visibilityOf(loginButton())).click();

	}

	public boolean isDisplayed_SafeLoginNoBtn() {

		wait = new WebDriverWait(driver, 40);
		return wait.until(ExpectedConditions.visibilityOf(safeLoginNoBtn())).isDisplayed();

	}

	public void click_safeLogin() throws MalformedURLException {

		wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions.elementToBeClickable(safeLoginNoBtn())).click();

	}

}
