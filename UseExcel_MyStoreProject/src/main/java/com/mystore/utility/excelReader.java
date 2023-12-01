/**
 * 
 */
package com.mystore.utility;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;



/**
 * 
 */
public class excelReader {
	
	
	private FileInputStream fis;
	private FileOutputStream fileOut;
    private Workbook wb;
    private Sheet sh;
    private Row row;
    private Cell cell;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
    private Map<String, Integer> columns = new HashMap<>();
    
    
    public void setExcelFile(String ExcelPath, String SheetName) {
    	try {
    		File f = new File(ExcelPath);      //navigate to excel file path
    		if(!f.exists()) {
    			f.createNewFile();
    			System.out.println("File does not exist, So created!");
    		}
    		
    		fis=new FileInputStream(ExcelPath);
    		wb=WorkbookFactory.create(fis);     //open that workbook
    		sh=wb.getSheet(SheetName);
    		if(sh==null) {
    			sh=wb.createSheet(SheetName);
    		}
    		
    		this.excelFilePath=ExcelPath;
    		
    		sh.getRow(0).forEach(cell -> {
    			columns.put(cell.getStringCellValue(), cell.getColumnIndex() );
    		});                                                                   //adding all the column header names in row 0 to the map 'columns' and save in above map array with index.
    		
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    
    
    //get cell data using row and column index.
    public String getCellData(int rownum, int colnum) {
    	try {
    		cell = sh.getRow(rownum).getCell(colnum);
    		String CellData = null;
    		switch (cell.getCellType()) {
    		                                            //excel cell data can be integer,string, boolean, null. so relevant cell data are fetched.
    		case STRING:
    		CellData = cell.getStringCellValue();
    		break;
    		
    		case NUMERIC:
    			if(DateUtil.isCellDateFormatted(cell))     //excel numeric values can be two types like date format and long interger values.
    			{
    				CellData=String.valueOf(cell.getDateCellValue());     //get the numeric value and converted to the String. 
    			}
    			else {
    				CellData=String.valueOf((long)cell.getNumericCellValue());
    			}
    			break;
    			
    		case BOOLEAN:
    			CellData=String.valueOf(cell.getBooleanCellValue());
    			break;
    			
    		case BLANK:
    			CellData="";
    			break;
    		
    		}
    		return CellData;
    	}
    	catch(Exception e) {
    		return "";
    		}
    	
    	
    	
    	}
    
    
    
    
    
    //get cell data using column name and row index.
    public String getCellData(String columnName, int rownum) {
    	return getCellData(rownum,columns.get(columnName));
    }
    		
    	
    
    
    

}
