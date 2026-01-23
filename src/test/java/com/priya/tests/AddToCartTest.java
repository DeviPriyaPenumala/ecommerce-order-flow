package com.priya.tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.priya.base.BaseTest;
import com.priya.pages.CartPage;
import com.priya.pages.LoginPage;
import com.priya.pages.ProductsPage;

public class AddToCartTest  extends BaseTest{
	
	@Test
	public  void addMultipleItemsToCart() {
		LoginPage loginPage =new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		
		 ProductsPage productsPage = new ProductsPage(driver);
		List<String> items =Arrays.asList("Sauce Labs Bike Light","Sauce Labs Fleece Jacket");
		 productsPage.addMultipleProductsToCart(items);
		 productsPage.clickCartIcon();

		 wait.until(ExpectedConditions.urlContains("cart"));

		
	     CartPage cartPage =new CartPage(driver);
	     Assert.assertEquals(cartPage.getCartItemsCount(),items.size(),"Cart Items count mismatch");
	     Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Fleece Jacket"), "Expected product is not found in cart");
	     
	
	}

}
