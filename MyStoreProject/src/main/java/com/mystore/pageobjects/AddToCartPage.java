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
public class AddToCartPage extends BaseClass {
	
	//PAGE OBJECTS ARE WRITTEN USING PAGE FACTORY METHOD.
			//All web elements are written in the form of page objects.
			
			
			@FindBy(xpath="//*[@id=\"quantity_wanted\"]")
			WebElement quantity;
			
			@FindBy(xpath="//*[@id=\"group_1\"]")
			WebElement size;
			
			@FindBy(xpath="//*[@id=\"add_to_cart\"]/button")
			WebElement addToCartBtn;
			
			@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
			WebElement addToCartMessage;
			
			@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
			WebElement proceedToCheckOutBtn;
			

			//Initialize all web objects. use constructor for this.
			//when we create a object in other class to call a method in this class, all page objects will be initialized using this constructor.
			
			
			public AddToCartPage() {
				PageFactory.initElements(driver,this);  //this keyword initialize all the page objects.
			}
			
			public void enterQuantity(String quantity1) {		
			    Action.type(quantity, quantity1);   
				
			}
			
			public void selectSize (String size1) {
				Action.selectByVisibleText(size1,size);
				
			}
			
			public void clickOnAddToCart () {
				Action.click(driver,addToCartBtn);
				
			}
			public boolean validateAddToCart () {
				return Action.isDisplayed(driver,addToCartMessage);
				
			}
			
			public OrderPage clickOnCheckOut () throws Exception {
				Action.JSClick(driver,proceedToCheckOutBtn);
				return new OrderPage();
			}

}
