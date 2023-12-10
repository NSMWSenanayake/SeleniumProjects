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
	
	@FindBy(id = "uniform-id_gender1")
	private WebElement mr;
	
	@FindBy(id = "id_gender2")
	private WebElement mrs;

	@FindBy(name = "customer_firstname")
	private WebElement firstName;

	@FindBy(name = "customer_lastname")
	private WebElement lastName;

	@FindBy(name = "passwd")
	private WebElement passWord;

	@FindBy(name = "days")
	private WebElement days;

	@FindBy(name = "months")
	private WebElement months;

	@FindBy(name = "years")
	private WebElement years;
	
	@FindBy(xpath = "//*[@id=\"submitAccount\"]/span")
	private WebElement registerBtn;
	
	
	

	//Initialize all web objects. use constructor for this.
	//when we create a object in other class to call a method in this class, all page objects will be initialized using this constructor.
	
	
	public AccountCreationPage() {
		PageFactory.initElements(driver,this);  //this keyword initialize all the page objects.
	}
	
	public boolean validateAccountCreationPage() {		
		return Action.isDisplayed(driver, formTitle);   //new keyword is used to create object. It will return the LoginPage object.
		
	}
	
	public void createAccount(String gender, String fname, String lname,
			String pswd,
			String day,
			String month,
			String year) {
		
		if(gender.equalsIgnoreCase("Mr")) {
			Action.click(driver, mr);
		}
		else {
			Action.click(driver, mrs);
		}
		Action.type(firstName, fname);
		Action.type(lastName, lname);
		Action.type(passWord, lname);
		Action.selectByValue(days, day);
		Action.selectByValue(months, month);
		Action.selectByValue(years, year);
		
	}
	
	public HomePage validateRegistration() {
		registerBtn.click();
		return new HomePage();
	}

	
	

}
