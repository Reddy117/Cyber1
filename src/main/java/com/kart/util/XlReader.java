package com.kart.util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlReader {
	
	public FileInputStream f=null;
	public XSSFWorkbook w=null;
	public XSSFSheet s=null;
	public XSSFRow r=null;
	public XSSFCell c=null;
	
	public String getCellData(String sheetName,int colNum,int rowNum){
		try{
			f=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/kart/testdata/TData.xlsx");
			w=new XSSFWorkbook(f);
			s=w.getSheet(sheetName);
			r=s.getRow(rowNum);
			c=r.getCell(colNum);
			
			return c.getStringCellValue();
		}catch(Exception e){
			return r+"row not exist"+c+"cell not exist";
		}
	}

}
