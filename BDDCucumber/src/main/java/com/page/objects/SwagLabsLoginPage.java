package com.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.main.WebDriverSingleton;

public class SwagLabsLoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[contains(text(),'Swag Labs123')]")
	public WebElement SwagLabsLoginHeader;
	
    public SwagLabsLoginPage(WebDriver driver) {
    	this.driver=WebDriverSingleton.getDriver();
		PageFactory.initElements(driver,this);
	}
}
