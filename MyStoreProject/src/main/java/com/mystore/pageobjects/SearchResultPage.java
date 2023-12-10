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
public class SearchResultPage extends BaseClass {
	
	//PAGE OBJECTS ARE WRITTEN USING PAGE FACTORY METHOD.
		//All web elements are written in the form of page objects.
		
	
		@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
		WebElement productResult;
		

		//Initialize all web objects. use constructor for this.
		//when we create a object in other class to call a method in this class, all page objects will be initialized using this constructor.
		
		
		public SearchResultPage() {
			PageFactory.initElements(driver,this);  //this keyword initialize all the page objects.
		}
		
		public boolean isProductAvailable() {		
			return Action.isDisplayed(driver, productResult);   
			
		}
		
		public AddToCartPage clickOnProduct() {
			Action.click(driver, productResult);
			return new AddToCartPage();
			
		}

}
