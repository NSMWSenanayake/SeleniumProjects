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
public class PaymentPage extends BaseClass {
	
	//PAGE OBJECTS ARE WRITTEN USING PAGE FACTORY METHOD.
		//All web elements are written in the form of page objects.
		

	    @FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	    WebElement payByCheckMethod;
	    
		
		//Initialize all web objects. use constructor for this.
		//when we create a object in other class to call a method in this class, all page objects will be initialized using this constructor.
		
		public PaymentPage() {
			PageFactory.initElements(driver,this);  //this keyword initialize all the page objects.
		}
		
		public OrderSummaryPage clickOnPaymentMethod() {
			Action.click(driver, payByCheckMethod);
			return new OrderSummaryPage();	
		}

}
