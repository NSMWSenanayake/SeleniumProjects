/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;

import com.mystore.base.BaseClass;

/**
 * 
 */
public class IndexPage extends BaseClass {
	
	//PAGE OBJECTS ARE WRITTEN USING PAGE FACTORY METHOD.
		//All web elements are written in the form of page objects.
		
		
		@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
		WebElement signInBtn;
		
		@FindBy(xpath="//*[@id=\"header_logo\"]/a/img")
		WebElement myStoreLogo;
		
		@FindBy(xpath="//*[@id=\"search_query_top\"]")
		WebElement searchProductBox;
		
		@FindBy(xpath="//*[@id=\"searchbox\"]/button")
		WebElement searchButton;
		
		//Initialize all web objects. use constructor for this.
		//when we create a object in other class to call a method in this class, all page objects will be initialized using this constructor.
		
		
		public IndexPage() {
			PageFactory.initElements(driver,this);  //this keyword initialize all the page objects.
		}
		
		public LoginPage clickOnSignIn() {
			Action.click(driver, signInBtn);
			return new LoginPage();   //new keyword is used to create object. It will return the LoginPage object.
			
		}
		
		public boolean validateLogo() {
			return Action.isDisplayed(driver, myStoreLogo);
		}
		
		public String getMyStoreTitle() {
			String myStoreTitle=driver.getTitle();
			return myStoreTitle;	
		}
		
		public SearchResultPage searchProduct(String productName) {
			Action.type(searchProductBox,productName);
			Action.click(driver, searchButton);
			return new SearchResultPage();
		}

}
