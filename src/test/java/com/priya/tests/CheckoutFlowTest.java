package com.priya.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.priya.base.BaseTest;
import com.priya.pages.CartPage;
import com.priya.pages.CheckoutCompletePage;
import com.priya.pages.CheckoutInformationPage;
import com.priya.pages.CheckoutOverviewPage;
import com.priya.pages.LoginPage;
import com.priya.pages.ProductsPage;

public class CheckoutFlowTest extends BaseTest {
	
	@Test
	public void completeOrderTest() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		
		ProductsPage productsPage=new ProductsPage(driver);
		List<String> items =Arrays.asList("Sauce Labs Bike Light","Sauce Labs Fleece Jacket");
		productsPage.addMultipleProductsToCart(items);
		productsPage.clickCartIcon();
		
		CartPage cartPage =new CartPage(driver);
		cartPage.getCartProductNames();
		 Assert.assertEquals(cartPage.getCartItemsCount(), 2);
		cartPage.clickCheckoutButton();
		
		CheckoutInformationPage checkoutInformationPage =new CheckoutInformationPage(driver);
		checkoutInformationPage.userDetails("Revik", "Rao", "1234");
		checkoutInformationPage.clickContinue();
		
		CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutOverviewPage.clickFinish();
		
		CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
	    Assert.assertTrue(completePage.isOrderPlaced(), "Order was not placed");
	}

}
