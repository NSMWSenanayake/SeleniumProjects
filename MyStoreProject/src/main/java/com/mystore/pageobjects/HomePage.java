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
public class HomePage extends BaseClass {
	
	//PAGE OBJECTS ARE WRITTEN USING PAGE FACTORY METHOD.
			//All web elements are written in the form of page objects.
	        @FindBy(xpath="//*[@id=\"center_column\"]/p[1]")
	        WebElement validateAccountCreatedMessage;
			
			@FindBy(xpath="//*[@id=\"center_column\"]/div/div/ul/li[1]/a/span")
			WebElement myWishList;
			
			@FindBy(xpath="//*[@id=\"center_column\"]/div/div/ul/li[2]/a/span")
			WebElement orderHitory;
			
			
			
			//Initialize all web objects. use constructor for this.
			//when we create a object in other class to call a method in this class, all page objects will be initialized using this constructor.
			
			
			public HomePage() {
				PageFactory.initElements(driver,this);  //this keyword initialize all the page objects.
			}
			
			public boolean validateMyWishList() {		
				return Action.isDisplayed(driver, myWishList);  
				
			}
			
			public String getCurrURL() {
				String homePageURL=driver.getCurrentUrl();
				return homePageURL;
			}

}
