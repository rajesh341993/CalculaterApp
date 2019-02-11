package com.rm;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import javafx.scene.control.Cell;

@RunWith(Suite.class)
@SuiteClasses({ TestApp.class, TestApp2.class, TestApp3.class, TestApp4.class })
public class AllTests {
	public static void main(String[] args) {
		 int rowid;
		 int i=0;
		 int cellid = 0;
		Result result=JUnitCore.runClasses(AllTests.class);
		for (Failure failure : result.getFailures()) {
			//System.out.println(failure);
	         System.out.println(failure.toString());
	      }
			System.out.println(result.getFailureCount());
			System.out.println(result.getRunCount());
			System.out.println(result.getIgnoreCount());
	      System.out.println(result.wasSuccessful());
	      try {
	    	  List Fail=result.getFailures();
	            String filename = "NewExcelFile1.xls" ;
	            HSSFWorkbook workbook = new HSSFWorkbook();
	            HSSFSheet sheet = workbook.createSheet("FirstSheet");  
	            

	            HSSFRow rowhead = sheet.createRow((short)0);
	            rowhead.createCell(0).setCellValue("Run Date");
	            rowhead.createCell(1).setCellValue(new Date().toGMTString());
	           
	            HSSFRow row = sheet.createRow((short)1);
	            row.createCell(0).setCellValue("Total Case");
	            row.createCell(1).setCellValue(result.getRunCount());
	            
	            HSSFRow row1 = sheet.createRow((short)2);
	            row1.createCell(0).setCellValue("Failure Count");
	            row1.createCell(1).setCellValue(result.getFailureCount());
	            
	            HSSFRow row2 = sheet.createRow((short)3);
	            row2.createCell(0).setCellValue("Ignore Count");
	            row2.createCell(1).setCellValue(result.getIgnoreCount());
	            
	            HSSFSheet sheet1 = workbook.createSheet("SecondSheet"); 
	            		 HSSFRow row3;
	            		
	            	         
	            	         

	            	         for (Failure failure : result.getFailures()) {
	            	        	 
	            	        	 row3 = sheet1.createRow((short)4);
	            	        	
								row3 = sheet1.createRow(i++);
	            	        	 
	            	            HSSFCell cell = row3.createCell(cellid);
	            	            cell.setCellValue(failure.toString());
	            	         }
	            	      
	            FileOutputStream fileOut = new FileOutputStream(filename);
	            workbook.write(fileOut);
	            fileOut.close();
	            workbook.close();
	            System.out.println("Your excel file has been generated!");

	        } catch ( Exception ex ) {
	            System.out.println(ex);
	        }
	      
	}
}
