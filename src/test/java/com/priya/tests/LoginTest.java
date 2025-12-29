package com.priya.tests;

import org.testng.annotations.Test;
import com.priya.base.BaseTest;
import com.priya.pages.LoginPage;

	public class LoginTest extends BaseTest {

	    @Test
	    public void validLoginTest() {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("standard_user", "secret_sauce");
	    }
	}



