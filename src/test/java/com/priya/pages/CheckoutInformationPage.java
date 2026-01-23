package com.priya.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CheckoutInformationPage {
	
	By firstName=By.id("first-name");
	By lastName=By.id("last-name");
	By postalCode=By.id("postal-code");
	By continueBtn=By.id("continue");
	
	WebDriver driver;
	 WebDriverWait wait;
	public  CheckoutInformationPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void userDetails(String fName,String lName,String zip) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
		driver.findElement(lastName).sendKeys(lName);
		driver.findElement(postalCode).sendKeys(zip);
		
	}
	public void clickContinue() {
		WebElement  continueButton =wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		continueButton.click();
	}
	
}
	
