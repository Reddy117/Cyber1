package com.kart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kart.pages.AddKartPage;
import com.kart.pages.KartPage;
import com.kart.pages.LandPage;
import com.kart.pages.ProductsPage;
import com.kart.util.DataUtil;
import com.kart.util.TestBase;

public class Kart1 extends TestBase{

	LandPage landpage;
	ProductsPage productpage;
	AddKartPage addkartpage;
	KartPage kartpage;
	@BeforeMethod
	public void openApp(){
		initialize("chrome");
		landpage=new LandPage();
		productpage=new ProductsPage();
		addkartpage=new AddKartPage();
		kartpage=new KartPage();
	}
	
	@Test(dataProvider="getKart1Data")
	public void ValidatePriceAndQuantiry(String col1){
		try{
			landpage.clickShopLink();
			productpage.clickAndroid();
			addkartpage.quantity.clear();
			addkartpage.quantity.sendKeys(col1);
			addkartpage.clickAddToBasket();
			addkartpage.clickviewBasket();
			String actPrice=kartpage.getPrice();
			String actPrice1=actPrice.substring(1);
			double price=Double.parseDouble(actPrice1);
			String actTotal=kartpage.getTotal();
			String actTotal1=actTotal.substring(1);
			double total=Double.parseDouble(actTotal1);
			int qty=Integer.parseInt(col1);
			double actTotal0=price*qty;
			//System.out.println(actPrice1+"--"+actTotal1);
			Assert.assertEquals(actTotal0, total);
			
		}catch(Exception e){
			
		}
	}
	
	@DataProvider
	public Object[][] getKart1Data(){
		return DataUtil.getData("Sheet1", "VerifyTotal", x);
	}
	
}
