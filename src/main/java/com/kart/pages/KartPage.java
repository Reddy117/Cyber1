package com.kart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kart.objectrepository.OR;
import com.kart.util.TestBase;

public class KartPage extends TestBase	{

	@FindBy(xpath=OR.productinkartx)
	public WebElement productInKart;
	
	@FindBy(xpath=OR.prodPricex)
	public WebElement productPrice;
	
	@FindBy(xpath=OR.prodtotalx)
	public WebElement producttotal;
	
	public KartPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getEleText(){
		return productInKart.getText();
	}
	
	public String getPrice(){
		return productPrice.getText();
	}
	
	public String getTotal(){
		return producttotal.getText();
	}
	
	
}
