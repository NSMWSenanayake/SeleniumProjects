/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * 
 */
public class LoginPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void loginTest() {
		
		Log.startTestCase("loginTest");
		indexPage=new IndexPage();
		
		Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		
		Log.info("Enter Username and Password");
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL=homePage.getCurrURL();
		String expectedURL="http://www.automationpractice.pl/index.php?controller=my-account";
		
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		
		
		Log.info("Login is Sucess");

		
		Log.endTestCase("loginTest");
	}
	
	

}
