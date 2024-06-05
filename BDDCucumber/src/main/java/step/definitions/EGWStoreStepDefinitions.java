package step.definitions;

import org.openqa.selenium.By;

import com.main.WebDriverSingleton;
import com.page.objects.SearchPage;
import com.qa.util.ExplicitWaitUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class EGWStoreStepDefinitions {

	WebDriverSingleton driver;
	ExplicitWaitUtils util;
	SearchPage sp;
	public static ExtentTest test;
	public static ExtentReports report;
	
	public EGWStoreStepDefinitions() {
		sp = new SearchPage(driver.getDriver());
	}

	@Given("I access eyeglassworld portal")
	public void i_access_eyeglassworld_portal() {
		System.out.println("Accessed EGW portal");
		driver.getDriver().get("https://www.eyeglassworld.com");
		driver.getDriver().manage().window().maximize();
		Hooks.getExtentTest().log(LogStatus.PASS, "Accessed EyeGlassWorld website");
	}

	@When("I enter a city name as {string}")
	public void i_enter_a_city_name_as(String strCity) throws InterruptedException {
		System.out.println("Entered city name as : " + strCity);
		sp.txtStoreSearch.sendKeys(strCity);
		Hooks.getExtentTest().log(LogStatus.PASS, "Entered city name as : " + strCity);
	}

	@When("I click on FIND A STORE button")
	public void i_click_on_find_a_store_button() {
		System.out.println("Clicked on FIND A STORE button");
		sp.btnFindStore.click();
		Hooks.getExtentTest().log(LogStatus.PASS, "Clicked on FIND A STORE button");
	}

	@Then("I should see the appropriate store search results")
	public void i_should_see_the_appropriate_store_search_results() throws InterruptedException {
		System.out.println("Store search results verified succcesssfully..!");
		Thread.sleep(10000);
		//util.waitForElementToBeVisible(sp.cityname);
		String actCity = driver.getDriver().findElement(By.xpath("//span[@class='nearyou']")).getText();
		org.junit.Assert.assertEquals("Appropriate search results are not displayed..!", "tampa", actCity);
		if (actCity.equals("tampa")) {
			Hooks.getExtentTest().log(LogStatus.PASS, "Appropriate search results are displayed..!");
		} else {
			Hooks.getExtentTest().log(LogStatus.FAIL, "Appropriate search results are not displayed..!");
		}
	}

}
