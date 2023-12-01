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
public class LoginPage extends BaseClass {
	
	//PAGE OBJECTS ARE WRITTEN USING PAGE FACTORY METHOD.
			//All web elements are written in the form of page objects.
			
			
			@FindBy(xpath="//*[@id=\"email\"]")
			WebElement userName;
			
			@FindBy(xpath="//*[@id=\"passwd\"]")
			WebElement password;
			
			@FindBy(xpath="//span[normalize-space()='Sign in']")
			WebElement signInBtn;
			
			@FindBy(xpath="//*[@id=\"email_create\"]")
			WebElement emailForNewAccount;
			
			@FindBy(xpath="//*[@id=\"SubmitCreate\"]")
			WebElement createNewAccountBtn;
			
			//Initialize all web objects. use constructor for this.
			//when we create a object in other class to call a method in this class, all page objects will be initialized using this constructor.
			
			
			public LoginPage() {
				PageFactory.initElements(driver,this);  //this keyword initialize all the page objects.
			}
			
			public HomePage login(String uname,String pswd) {
				Action.type(userName, uname);
				Action.type(password, pswd);
				Action.click(driver, signInBtn);
				return new HomePage();   //new keyword is used to create object. It will return the HomePage object.			
			}
			
			public AddressPage login1(String uname,String pswd) {
				Action.type(userName, uname);
				Action.type(password, pswd);
				Action.click(driver, signInBtn);
				return new AddressPage();   //new keyword is used to create object. It will return the AddressPage object.			
			}
			

			
			public AccountCreationPage createNewAccount(String newEmail) {
				Action.type(emailForNewAccount, newEmail);
				Action.click(driver, createNewAccountBtn);
				return new AccountCreationPage();		
			}

}
