package com.generic.actions;

import java.util.List;

import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.LogStatus;
import step.definitions.Hooks;

public class CommonActions {
	
	public static void isElementsDisplayed(List<WebElement> elements, String objectName) {
		int nObjects = elements.size();
		if (nObjects>0) {
			Hooks.getExtentTest().log(LogStatus.PASS, "'" + objectName+ "' is displayed");
		} else {
			Hooks.getExtentTest().log(LogStatus.FAIL, "'" + objectName + "' is not displayed");
		}
	}
	
	public static void isElementDisplayed(WebElement element, String objectName) {
		boolean bFlag=false;
		String errMsg="";
		try {
			boolean displayFlag = element.isDisplayed();
			bFlag=true;
		} catch (Exception e) {
			errMsg=e.getMessage();
		}finally {
			if (bFlag) {
				Hooks.getExtentTest().log(LogStatus.PASS, "'" + objectName+ "' is displayed");
			} else {
				Hooks.getExtentTest().log(LogStatus.FAIL, "'" + objectName + "' is not displayed since : " + errMsg);
			}
		}
	}
	
	public static void type(WebElement element, String data, String objectName) {
		boolean bFlag=false;
		String errMsg="";
		try {
			element.sendKeys(data);
			bFlag=true;
		} catch (Exception e) {
			errMsg=e.getMessage();
		}finally {
			if (bFlag) {
				Hooks.getExtentTest().log(LogStatus.PASS, "Data entered in '" + objectName+ "' as " + data);
			} else {
				Hooks.getExtentTest().log(LogStatus.FAIL, "Failed to enter the data in '" + objectName + "' since : " + errMsg);
			}
		}
	}
	
	public static void click(WebElement element, String objectName) {
		boolean bFlag=false;
		String errMsg="";
		try {
			element.click();
			bFlag=true;
		} catch (Exception e) {
			errMsg=e.getMessage();
		}finally {
			if (bFlag) {
				Hooks.getExtentTest().log(LogStatus.PASS, "Clicked on '" + objectName);
			} else {
				Hooks.getExtentTest().log(LogStatus.FAIL, "Failed to click on '" + objectName + "' since : " + errMsg);
			}
		}
	}

}
