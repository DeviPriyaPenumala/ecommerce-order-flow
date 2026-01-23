package com.priya.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage {
  By finishBtn=By.id("finish");
	WebDriver driver;
	WebDriverWait wait;
	public  CheckoutOverviewPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public void clickFinish() {
		WebElement finish = wait.until(ExpectedConditions.presenceOfElementLocated(finishBtn));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",finish);
	    wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
	 
	}
	
}
