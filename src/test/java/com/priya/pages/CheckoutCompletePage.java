package com.priya.pages;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class CheckoutCompletePage {

	    WebDriver driver;

	    By successMsg = By.className("complete-header");

	    public CheckoutCompletePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean isOrderPlaced() {
	        return driver.findElement(successMsg).isDisplayed();
	    }
	}


