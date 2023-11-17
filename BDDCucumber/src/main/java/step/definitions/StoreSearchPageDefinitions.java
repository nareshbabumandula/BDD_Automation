package step.definitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import com.main.WebDriverSingleton;
import com.qa.util.ExplicitWaitUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreSearchPageDefinitions {

	WebDriverSingleton driver;
	ExplicitWaitUtils wait;
	private Scenario scenario;
	public static ExtentTest test;
	public static ExtentReports report;

	
	@Given("I access EyeGlass world website")
	public void accessSite() {
		System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
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
	public void storeSearchWithMultipleCites(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> cities = dataTable.asMaps(String.class, String.class);
		for(Map<String, String> city : cities) {
			System.out.println(city.get("City"));
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




}
