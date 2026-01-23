package com.priya.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	By cartItems = By.cssSelector(".cart_item");
	By cartItemNames =By.cssSelector(".inventory_item_name");
	By checkoutBtn=By.cssSelector(".checkout_button");
	
	public   CartPage(WebDriver driver) {
		this.driver = driver;
	}
	// Get total number of products in cart
	public int getCartItemsCount() {
		 return driver.findElements(cartItems).size();
	}
	 // Get all product names in cart
	public List<String> getCartProductNames(){
		 List<String> productNames = new ArrayList<>();
		 
		List<WebElement>  items =driver.findElements(cartItemNames);
		for(WebElement item :items) {
			productNames.add(item.getText());
		}
		return productNames;
	}
	
	public boolean isProductInCart(String expectedProduct) {
		return getCartProductNames().contains(expectedProduct);
	}
	public void clickCheckoutButton() {
		driver.findElement(checkoutBtn).click();
	}
}
