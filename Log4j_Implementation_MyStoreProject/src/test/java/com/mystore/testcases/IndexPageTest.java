/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

/**
 * 
 */
public class IndexPageTest extends BaseClass {
	
IndexPage indexPage;  //declare page object here. So it can be used for all testases.
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyLogo() {
		//IndexPage indexpage = new IndexPage();
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		
	}
	
	@Test
	public void verifyTitle() {
		String actTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Shop");
	}

}
