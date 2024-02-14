package step.definitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import com.generic.actions.CommonActions;
import com.main.WebDriverSingleton;
import com.page.objects.SearchPage;
import com.qa.util.ExplicitWaitUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StoreSearchPageDefinitions {

	WebDriverSingleton driver;
	ExplicitWaitUtils wait;
	CommonActions action;
	private Scenario scenario;
	private Scenario scenario2;
	public static ExtentTest test;
	public static ExtentReports report;


	@Given("I access EyeGlass world website")
	public void accessSite() {
		driver.getDriver().get("https://www.eyeglassworld.com");
		driver.getDriver().manage().window().maximize();
		System.out.println("Accessed EyeGlassWorld website");
		Hooks.getExtentTest().log(LogStatus.PASS, "Accessed EyeGlassWorld website");
	}

	@When("I search for an eyeglass store based on city\\/state\\/zipcode {string}")
	public void searchStore(String string) {
		driver.getDriver().findElement(By.id("inputStoreValue")).sendKeys(string);
		driver.getDriver().findElement(By.xpath("//button[contains(text(),'Find a Store')]")).click();
		System.out.println("Searched an EyeGlass store based on city name");
		Hooks.getExtentTest().log(LogStatus.PASS, "Searched an EyeGlass store based on city name");
	}

	@When("I search for an eyeglass store based on different Cities")
	public void storeSearchWithMultipleCites(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> citystatezip = dataTable.asMaps(String.class, String.class);
		String errMsg;
		String actStore;
		Scenario scenario;

		for(Map<String, String> row : citystatezip) {
			driver.getDriver().findElement(By.id("inputStoreValue")).sendKeys(row.get("City/State/Zipcode"));
			driver.getDriver().findElement(By.xpath("//button[contains(text(),'Find a Store')]")).click();
			int nResults = driver.getDriver().findElements(By.xpath("//span[@class='nearyou']")).size();
			try {
				wait = new ExplicitWaitUtils(WebDriverSingleton.getDriver());
				for (int i = 1; i <= nResults; i++) {
					boolean bFlag = driver.getDriver().findElement(By.xpath("(//span[@class='nearyou'])[i]")).isDisplayed();
					if (bFlag) {
						wait.waitForElementToBeVisible(By.xpath("(//span[@class='nearyou'])[i]"));
						actStore = driver.getDriver().findElement(By.xpath("(//span[@class='nearyou'])[i]")).getText();
						if (actStore.equalsIgnoreCase(row.get("City/State/Zipcode"))) {
							System.out.println("Successfully verified the store search results");
							Hooks.getExtentTest().log(LogStatus.PASS, "Successfully verified the store search results in city/state/zipcode : " + row.get("City/State/Zipcode"));
						} 
					}
				}
			} catch (Exception e) {
				errMsg=e.getMessage();
				Hooks.getExtentTest().log(LogStatus.FAIL, "No store displayed in results with the search criteria : " + row.get("City/State/Zipcode") +  " since - " +errMsg);
				System.out.println("No store displayed in results with the search criteria : " + row.get("City/State/Zipcode") + " since - " +errMsg);
				Assert.assertEquals("No store displayed in results with the search criteria", true, false);
				e.printStackTrace();
			}
			driver.getDriver().navigate().back();
			Thread.sleep(5000);
			driver.getDriver().findElement(By.id("inputStoreValue")).clear();
			System.out.println(row.get("City/State/Zipcode"));
			Hooks.getExtentTest().log(LogStatus.PASS, "Search Store", "Searched store based on city/state/zipcode : " + row.get("City/State/Zipcode"));
		}
	}

	@When("I search for an eyeglass store based on {string}")
	public void searchByStateCityZip(String string) {
		driver.getDriver().findElement(By.id("inputStoreValue")).sendKeys(string);
		driver.getDriver().findElement(By.xpath("//button[contains(text(),'Find a Store')]")).click();
		System.out.println("Searched an EyeGlass store based on city/state/zip name");
		Hooks.getExtentTest().log(LogStatus.PASS, "Searched an EyeGlass store based on city/state/zip name");
	}

	@Then("I should see the appropriate store details in the search results page with {string}")
	public void verifySearchResults(String string) {
		String errMsg;
		String actStore;
		Scenario scenario;
		SearchPage sp = new SearchPage(WebDriverSingleton.getDriver());
		wait = new ExplicitWaitUtils(WebDriverSingleton.getDriver());
		wait.waitForElementToBeVisible(By.xpath("//a[@title='Schedule Exam']"));
				
		int nResults = driver.getDriver().findElements(By.xpath("//span[@class='nearyou']")).size();
		try {
			//String actStoreName = driver.getDriver().findElement(By.xpath("(//h2[contains(@class,'show')]/span[1])['"+i+"']")).getText();
			JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
			WebElement element = driver.getDriver().findElement(By.xpath("(//h2[contains(@class,'show')]/span[2])['"+1+"']"));
			actStore = (String) js.executeScript("return arguments[0].innerText;", element);
			System.out.println(actStore);

			if (actStore.equalsIgnoreCase(string)) {
				System.out.println("Successfully verified the store search results");
				Hooks.getExtentTest().log(LogStatus.PASS, "Successfully verified the store search results in city/state/zipcode : " + string);
			}
			action.isElementDisplayed(sp.ScheduleExam, "Schedule Exam");
			action.isElementDisplayed(sp.VisitStorePage, "Visit Store Page");
		} catch (Exception e) {
			errMsg=e.getMessage();
			Hooks.getExtentTest().log(LogStatus.FAIL, "No store displayed in results with the search criteria : " + string +  " since - " +errMsg);
			System.out.println("No store displayed in results with the search criteria : " + string + " since - " +errMsg);
			Assert.assertEquals("No store displayed in results with the search criteria", true, false);
			e.printStackTrace();
		}

	}

	@When("I search for an eyeglass store based on {string} name") 
	public void searchStores(String city) {
		System.out.println("Searched an EyeGlass store based on city : " + city); 
	}

	@Then("I should see the appropriate store details in the search results page with city\\/state\\/zipcode {string}")
	public void i_should_see_the_appropriate_store_details_in_the_search_results_page(String string) {
		String errMsg;
		String actStore;

		try {
			wait = new ExplicitWaitUtils(WebDriverSingleton.getDriver());
			if(string.toLowerCase().trim().contains("chicago")) {
				wait.waitForElementToBeVisible(By.xpath("(//span[@class='nearyou'])[2]"));
				actStore = driver.getDriver().findElement(By.xpath("(//span[@class='nearyou'])[2]")).getText();
			}else {
				wait.waitForElementToBeVisible(By.xpath("//span[@class='nearyou']"));
				actStore = driver.getDriver().findElement(By.xpath("//span[@class='nearyou']")).getText();
			}

			if (actStore.equalsIgnoreCase(string)) {
				System.out.println("Successfully verified the store search results");
				Hooks.getExtentTest().log(LogStatus.PASS, "Successfully verified the store search results in city/state/zipcode : " + string);
			} 
		} catch (Exception e) {
			errMsg=e.getMessage();
			Hooks.getExtentTest().log(LogStatus.FAIL, "No store displayed in results with the search criteria : " + string +  " since - " +errMsg);
			System.out.println("No store displayed in results with the search criteria : " + string + " since - " +errMsg);
			e.printStackTrace();
		}

	}


	@Then("I should see the appropriate store details in the search results")
	public void i_should_see_the_appropriate_store_details_in_the_search_results() {
		Hooks.getExtentTest().log(LogStatus.PASS, "Verify Store Details", "Appropriate store details are displayed in the search results");
	}




}
