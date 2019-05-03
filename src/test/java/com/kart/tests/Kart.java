package com.kart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kart.pages.AddKartPage;
import com.kart.pages.KartPage;
import com.kart.pages.LandPage;
import com.kart.pages.ProductsPage;
import com.kart.util.DataUtil;
import com.kart.util.TestBase;

public class Kart extends TestBase{
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
	
	
	@Test(dataProvider="getKartData")
	public void addProductToKartVeridy(String col1,String col2){
		try{
			landpage.clickShopLink();
			productpage.clickAndroid();
			addkartpage.clickAddToBasket();
			addkartpage.clickviewBasket();
			String actEle=kartpage.getEleText();
			Assert.assertEquals(actEle, "Test");
		}catch(Exception e){
			Assert.fail("addProductToKartVeridy failed due to "+e);
		}
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getKartData(){
		return DataUtil.getData("Sheet1", "AddProductToKart", x);
	}
}
