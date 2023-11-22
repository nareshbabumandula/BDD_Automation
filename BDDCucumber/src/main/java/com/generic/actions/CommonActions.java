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

}
