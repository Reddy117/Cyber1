package com.kart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kart.objectrepository.OR;
import com.kart.util.TestBase;

public class ProductsPage extends TestBase{

	@FindBy(xpath=OR.andriodImgx)
	public WebElement androidX;
	
	public ProductsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickAndroid(){
		androidX.click();
	}
}
