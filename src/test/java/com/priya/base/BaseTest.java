package com.priya.base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseTest {

	    protected WebDriver driver;
	    protected WebDriverWait wait;
	    
	    @BeforeMethod
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        
	        ChromeOptions options = new ChromeOptions();
       // Run in incognito
	     options.addArguments("--incognito");
      // Disable notifications this are required for other pop ups and notifications when running through jenkins bcoz its doesn't support incognito
	     options.addArguments("--disable-notifications");
	     // Extra hard-disable password features
	     options.addArguments("--disable-features=PasswordManagerOnboarding");
	     options.addArguments("--disable-infobars");
	     // Disable Chrome password manager
	            Map<String, Object> prefs = new HashMap<>();
	            prefs.put("credentials_enable_service", false);
	            prefs.put("profile.password_manager_enabled", false);

	            options.setExperimentalOption("prefs", prefs);
	            

	            driver = new ChromeDriver(options); 

	         wait=new WebDriverWait(driver,Duration.ofSeconds(40));
	        driver.manage().window().maximize();
	        driver.get("https://www.saucedemo.com/");
	    }

	    @AfterMethod
	    public void tearDown() {
	       // driver.quit();
	    }
	    
	    // add getter method
	    public WebDriver getDriver() {
	        return driver;
	    }
	}



