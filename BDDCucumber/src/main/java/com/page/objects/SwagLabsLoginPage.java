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
	
	@FindBy(id = "user-name")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="login-button")
	public WebElement login;
	
	@FindBy(xpath = "//h4[contains(text(),'Accepted usernames are:')]")
	public WebElement acceptedusernames;
	
	@FindBy(xpath="//h4[contains(text(),'Password for all users123:')]")
	public WebElement acceptedpasswords;
	
	
    public SwagLabsLoginPage(WebDriver driver) {
    	this.driver=WebDriverSingleton.getDriver();
		PageFactory.initElements(driver,this);
	}
}
