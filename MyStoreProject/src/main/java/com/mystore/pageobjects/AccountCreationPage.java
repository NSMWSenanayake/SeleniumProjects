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
public class AccountCreationPage extends BaseClass {
	
	//PAGE OBJECTS ARE WRITTEN USING PAGE FACTORY METHOD.
	//All web elements are written in the form of page objects.
	
	
	@FindBy(xpath="//*[@id=\"noSlide\"]/h1")
	WebElement formTitle;
	

	//Initialize all web objects. use constructor for this.
	//when we create a object in other class to call a method in this class, all page objects will be initialized using this constructor.
	
	
	public AccountCreationPage() {
		PageFactory.initElements(driver,this);  //this keyword initialize all the page objects.
	}
	
	public boolean validateAccountCreationPage() {		
		return Action.isDisplayed(driver, formTitle);   //new keyword is used to create object. It will return the LoginPage object.
		
	}

}
