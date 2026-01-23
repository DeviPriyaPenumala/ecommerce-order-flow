package com.priya.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.priya.utils.WaitUtils;

public class ProductsPage {

	    WebDriver driver;
	    WaitUtils wait;

	    // Locator for Products title
	    By productsTitle = By.className("title");
	    By products = By.cssSelector(".inventory_item");
	    By productName =By.cssSelector(".inventory_item_name");
	    By addToCart= By.cssSelector("button.btn_inventory ");
	    By cartIcon= By.cssSelector(".shopping_cart_link");
	    
	   
	   

	    public ProductsPage(WebDriver driver) {
	        this.driver = driver;
	        wait= new WaitUtils(driver);
	    }

	    // Method to validate Products page
	    public boolean isProductsPageDisplayed() {
	    	WebElement element =wait.waitForElementVisible(productsTitle);
	    	  return element.isDisplayed();
	      //  return driver.findElement(productsTitle).isDisplayed();
	         }
	    //adding single product to the cart
	    public  void  addProductToCart(String name) {
	    	List<WebElement> items = driver.findElements(products);
	    	
	    	for(WebElement item : items) {
	    	 String itemName =	item.findElement(productName).getText();
	    	 
	    	 if(itemName.equalsIgnoreCase(name)) {
	    		 item.findElement(addToCart).click();
	    		 break;
	    	 }
	    	}
	    }
	    
	    //adding multiple items to the cart 
	    public  void  addMultipleProductsToCart(List<String> productNames) {
	    	for(String product : productNames) {
	    		addProductToCart(product);
	    	}
	    }
	    
	    public void clickCartIcon() {
	    	driver.findElement(cartIcon).click();
	    }
	    }
