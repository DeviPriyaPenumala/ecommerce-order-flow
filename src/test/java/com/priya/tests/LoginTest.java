package com.priya.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.priya.base.BaseTest;
import com.priya.pages.LoginPage;
import com.priya.pages.ProductsPage;

public class LoginTest extends BaseTest {

	@Test
	public void validLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");

		ProductsPage productsPage = new ProductsPage(driver);
		
		
	Assert.assertTrue(productsPage.isProductsPageDisplayed(), "Login failed: Products page not displayed");
	//Negative login test 
    //Assert.assertFalse(loginPage.InvalidCredentialsErrorMessageDisplayed(),"Error message is not  displayed when  invalid credentials are entered in login page ");
	
	
	}
}
