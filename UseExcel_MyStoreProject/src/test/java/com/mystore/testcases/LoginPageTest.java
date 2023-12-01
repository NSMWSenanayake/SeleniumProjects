/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.ExcelApiTest;
import com.mystore.utility.ExcelReader1;
import com.mystore.utility.NewExcelLibrary;
import com.mystore.utility.excelReader;

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
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	
	
	
	
//	@Test(dataProvider="credentials", dataProviderClass = DataProviders.class)
//	public void loginTest1(String uname, String pswd) {
//		
//		indexPage=new IndexPage();
//		loginPage=indexPage.clickOnSignIn();
//		homePage=loginPage.login(uname,pswd);
//
//		
//		
//		
//	}
	
	
	
	
	
//	ExcelApiTest excelapitest;
//		
//	@Test
//	public void loginTest2() throws Exception {
//		
//		excelapitest =new ExcelApiTest("C:\\Users\\Sachin\\eclipse-workspace\\UseExcel_MyStoreProject\\src\\test\\resources\\TestData\\TestData.xlsx");
//		String USER_NAME = excelapitest.getCellData("credentials",0,1);
//	    String PASSWORD = excelapitest.getCellData("credentials",1,1);
//		
//			
//			indexPage=new IndexPage();
//			loginPage=indexPage.clickOnSignIn();
//			homePage=loginPage.login(USER_NAME,PASSWORD);
//	
//		}
	
	
	
	
	
	
//	@Test
//	public void loginTest3() {
//		
//		excelReader excel = new excelReader();
//		excel.setExcelFile("C:\\Users\\Sachin\\eclipse-workspace\\UseExcel_MyStoreProject\\src\\test\\resources\\TestData\\TestData.xlsx","credentials");	
//			
//		String USER_NAME = excel.getCellData("Username",1);
//	    String PASSWORD = excel.getCellData("Password",1);
//	    
//	    indexPage=new IndexPage();
//		loginPage=indexPage.clickOnSignIn();
//		homePage=loginPage.login(USER_NAME,PASSWORD);
//		
//		
//	}
	
	
	
	
	
	@Test
	public void loginTest4() {
		
		ExcelReader1 excel = new ExcelReader1();
		excel.setExcelFile("C:\\Users\\Sachin\\eclipse-workspace\\UseExcel_MyStoreProject\\src\\test\\resources\\TestData\\TestData.xlsx","credentials");	
	
		
		String USER_NAME = excel.getCellData(1,0);
	    String PASSWORD = excel.getCellData(1,1);
			
			indexPage=new IndexPage();
			loginPage=indexPage.clickOnSignIn();
			homePage=loginPage.login(USER_NAME,PASSWORD);
	
		}
	
	
	
	
	
	

}
