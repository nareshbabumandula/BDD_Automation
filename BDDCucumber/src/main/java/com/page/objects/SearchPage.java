package com.page.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.main.WebDriverSingleton;

public class SearchPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[@title='Schedule Exam123']")
	public List<WebElement> btnScheduleExam;
	
	@FindBy(xpath = "//a[@title='Visit Store Page']")
	public List<WebElement> btnVisitStorePage;
	
	@FindBy(xpath = "//a[@title='Schedule Exam']")
	public WebElement ScheduleExam;
	
	@FindBy(xpath = "//a[@title='Visit Store Page']")
	public WebElement VisitStorePage;
	
	public SearchPage(WebDriver driver){
		this.driver=WebDriverSingleton.getDriver();
		PageFactory.initElements(driver,this);
	}

}
