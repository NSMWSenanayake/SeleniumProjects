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
public class OrderPage extends BaseClass{
	
	//PAGE OBJECTS ARE WRITTEN USING PAGE FACTORY METHOD.
		//All web elements are written in the form of page objects.
		
		
		@FindBy(xpath="//*[@id=\"product_price_1_3_0\"]/li")
		WebElement unitPrice;
		
		@FindBy(xpath="//*[@id=\"total_price\"]")
		WebElement totalPrice;
		
		@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]")
		WebElement proceedToCheckoutBtn;
		
		
		

		//Initialize all web objects. use constructor for this.
		//when we create a object in other class to call a method in this class, all page objects will be initialized using this constructor.
		
		
		public OrderPage() {
			PageFactory.initElements(driver,this);  //this keyword initialize all the page objects.
		}
		
		public double getUnitPrice() {
			
			String unitPrice1=unitPrice.getText();
			String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
			double finalUnitPrice=Double.parseDouble(unit);
			//return finalUnitPrice/100;
			return finalUnitPrice;
			
		}
		
		public double getTotalPrice() {	
			
			String totalPrice1=totalPrice.getText();
			String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
			double finalTotalPrice=Double.parseDouble(tot);
			//return finalTotalPrice/100;
			return finalTotalPrice;
			
		}
		
		public LoginPage clickOnCheckOut() {
			Action.click(driver, proceedToCheckoutBtn);
			return new LoginPage();
			
		}

}
