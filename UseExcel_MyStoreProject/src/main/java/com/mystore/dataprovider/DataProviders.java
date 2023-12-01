/**
 * 
 */
package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;

/**
 * 
 */
public class DataProviders {
	
	//create a object of NewExcelLibrary
	NewExcelLibrary obj = new NewExcelLibrary();
	
	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("credentials");   //worksheet name is provided here.
		// Total Columns
		int column = obj.getColumnCount("credentials");   //worksheet name is provided here.
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("credentials", j, i + 2);  //worksheet name is provided here.
			}
		}
		return data;
	}

}
