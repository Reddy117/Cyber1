package com.kart.util;

public class DataUtil {

	public static Object[][] getData(String sheetName,String tcName,XlReader x){
		
		int tcStartRow=0;
		
		while(!x.getCellData(sheetName, 0, tcStartRow).equals(tcName)){
			tcStartRow++;
		}
		System.out.println(tcStartRow);
		
		int cols=0;
		int colStartRow=tcStartRow+1;
		while(!x.getCellData(sheetName, cols, colStartRow).equals("N")){
			cols++;
		}
		System.out.println(cols);
		int rows=0;
		int dataStartRow=tcStartRow+2;
		while(!x.getCellData(sheetName, 0, dataStartRow+rows).equals("N")){
			rows++;
		}
		System.out.println(rows);
		Object[][] data=new Object[rows][cols];
		int index=0;
		for(int rNum=dataStartRow;rNum<dataStartRow+rows;rNum++){
			for(int cNum=0;cNum<cols;cNum++){
				//System.out.print(x.getCellData(sheetName, cNum, rNum)+"  ");
				data[index][cNum]=x.getCellData(sheetName, cNum, rNum);
			}
			index++;
			System.out.println();
		}
		return data;
	}
}
