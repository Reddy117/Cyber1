package com.kart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kart.objectrepository.OR;
import com.kart.util.TestBase;

public class AddKartPage extends TestBase{
	@FindBy(xpath=OR.quantityx)
	public WebElement quantity;
	
	@FindBy(xpath=OR.addtoBasketx)
	public WebElement AddToBasket;
	
	@FindBy(xpath=OR.viewbasketx)
	public WebElement viewBasket;
	
	public AddKartPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddToBasket(){
		AddToBasket.click();
	}
	public void clickviewBasket(){
		viewBasket.click();
	}
	
	
	
}
