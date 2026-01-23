package com.priya.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	WebDriver driver;

	public WaitUtils(WebDriver driver) {
		this.driver = driver;
	}

	// Wait for element visibility using By
	public  WebElement  waitForElementVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Wait for element to be clickable
	public  WebElement  waitForElementClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Wait for URL to contain text
	public  boolean  waitForUrlContains(String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		return wait.until(ExpectedConditions.urlContains(text));
	}
}
