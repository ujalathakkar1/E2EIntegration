package com.w2a.automation.DataGeneration;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Datagen {

	@DataProvider(name="dp")
	public static Object[][] getdata(Method m) throws IOException
	{
		System.out.println("*********************"+m);
		if(m.getName().equalsIgnoreCase("doLogin"))
		{
			FileInputStream fis=new FileInputStream("./TestData/Data.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet loginsheet=workbook.getSheet("login");
			int numberofData=loginsheet.getPhysicalNumberOfRows();
			Object[][] testData=new Object[numberofData][2];
			
			for(int i=0;i<numberofData;i++)
			{
				XSSFRow row=loginsheet.getRow(i);
				XSSFCell uname=row.getCell(0);
				XSSFCell pwd=row.getCell(1);
				testData[i][0]=uname.getStringCellValue();
				testData[i][1]=pwd.getStringCellValue();
				
			}
			return testData;
		}
		else if(m.getName().equalsIgnoreCase("doRegistration"))
		{
			FileInputStream fis=new FileInputStream("./TestData/Data.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet loginsheet=workbook.getSheet("Registration");
			int numberofData=loginsheet.getPhysicalNumberOfRows();
			Object[][] testData=new Object[numberofData][9];
			
			for(int i=0;i<numberofData;i++)
			{
				XSSFRow row=loginsheet.getRow(i);
				XSSFCell email=row.getCell(0);
				XSSFCell fname=row.getCell(1);
				XSSFCell lname=row.getCell(2);
				XSSFCell pass=row.getCell(3);
				XSSFCell address=row.getCell(4);
				XSSFCell city=row.getCell(5);
				XSSFCell state=row.getCell(6);
				XSSFCell postcode=row.getCell(7);
				XSSFCell phone=row.getCell(8);
				testData[i][0]=email.getStringCellValue();
				testData[i][1]=fname.getStringCellValue();
				testData[i][2]=lname.getStringCellValue();
				
				testData[i][3]=pass.getStringCellValue();
				testData[i][4]=address.getStringCellValue();
				testData[i][5]=city.getStringCellValue();
				
				testData[i][6]=state.getStringCellValue();
				testData[i][7]=postcode.getStringCellValue();
				testData[i][8]=phone.getStringCellValue();
				
			}
			return testData;
		}
		else
		{
			Object[][] testData=new Object[2][3];
			return testData;
		}
		
		
	}

	
	
	
}
