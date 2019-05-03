package com.kart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kart.objectrepository.OR;
import com.kart.util.TestBase;

public class LandPage extends TestBase	{

	@FindBy(xpath=OR.shopx)
	public WebElement shopLinkx;
	
	@FindBy(xpath="//*[@id='menu-item-50']/a")
	public WebElement myAccountx;
	
	public LandPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickShopLink(){
		shopLinkx.click();
	}
}
