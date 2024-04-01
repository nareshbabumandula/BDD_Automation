package com.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.actions.CommonActions;
import com.main.WebDriverSingleton;

public class SwagLabsProductsPage {
	
	WebDriver driver;
			
	@FindBy(xpath="//div[@class='inventory_item_name ']")
	public WebElement productName;
	
	@FindBy(className = "inventory_item_img")
	public WebElement productImage;
	
	@FindBy(className = "inventory_item_desc")
	public WebElement productDescription;
	
	@FindBy(className = "inventory_item_price")
	public WebElement productPrice;
	
	@FindBy(xpath = "//button[contains(text(), 'Add to cart')]")
	public WebElement productAddToCart;
	
	/**
	 *@Desc Verifies all the mandatory options to be displayed for a product
	 *@author naresh
	 *
	 */
	public void verifyProductDetails() {
		CommonActions.isElementDisplayed(productName, "Product Name");
		CommonActions.isElementDisplayed(productImage, "Product Image");
		CommonActions.isElementDisplayed(productDescription, "Product Description");
		CommonActions.isElementDisplayed(productPrice, "Product Price");
		CommonActions.isElementDisplayed(productAddToCart, "Add To Cart");
	}
	
		
    public SwagLabsProductsPage(WebDriver driver) {
    	this.driver=WebDriverSingleton.getDriver();
		PageFactory.initElements(driver,this);
	}
}
