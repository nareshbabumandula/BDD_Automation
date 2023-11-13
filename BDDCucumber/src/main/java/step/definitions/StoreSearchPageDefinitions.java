package step.definitions;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import com.main.WebDriverSingleton;
import com.qa.util.ExplicitWaitUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreSearchPageDefinitions {

	WebDriverSingleton driver;
	ExplicitWaitUtils wait;

	static ExtentTest test;
	static ExtentReports report;

	@Given("I access EyeGlass world website")
	public void accessSite() {
		// Extent Reports
		report = new ExtentReports("./target/ExtentReport/ExtentResults.html");
		test = report.startTest("EGW_TC01");
		System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver.getDriver().get("https://www.eyeglassworld.com");
		driver.getDriver().manage().window().maximize();
		System.out.println("Accessed EyeGlassWorld website");
		test.log(LogStatus.PASS, "Accessed EyeGlassWorld website");
	}

	@When("I search for an eyeglass store based on city\\/state\\/zipcode {string}")
	public void searchStore(String string) {
		driver.getDriver().findElement(By.id("inputStoreValue")).sendKeys(string);
		driver.getDriver().findElement(By.xpath("//button[contains(text(),'Find a Store')]")).click();
		System.out.println("Searched an EyeGlass store based on city name");
		test.log(LogStatus.PASS, "Searched an EyeGlass store based on city name");
	}

	@When("I search for an eyeglass store based on different Cities")
	public void storeSearchWithMultipleCites(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> cities = dataTable.asMaps(String.class, String.class);
		for(Map<String, String> city : cities) {
			System.out.println(city.get("City"));
		}
	}

	
	  @When("I search for an eyeglass store based on {string} name") 
	  public void searchStores(String city) {
		  System.out.println("Searched an EyeGlass store based on city : " + city); 
	  }
	 

	@Then("I should see the appropriate store details in the search results page with city\\/state\\/zipcode {string}")
	public void i_should_see_the_appropriate_store_details_in_the_search_results_page(String string) {
		String errMsg;
		try {
			wait = new ExplicitWaitUtils(WebDriverSingleton.getDriver());
			wait.waitForElementToBeVisible(By.xpath("//h2[@class='show1']/span[2]"));
			
			String actStore = driver.getDriver().findElement(By.xpath("//h2[@class='show1']/span[2]")).getText();
			if (actStore.equalsIgnoreCase(string)) {
				System.out.println("Successfully verified the store search results");
				test.log(LogStatus.PASS, "Successfully verified the store search results in city/state/zipcode : " + string);
			} 
		} catch (Exception e) {
			errMsg=e.getMessage();
			test.log(LogStatus.FAIL, "No store displayed in results with the search criteria : " + string +  " since - " +errMsg);
			System.out.println("No store displayed in results with the search criteria : " + string + " since - " +errMsg);
			e.printStackTrace();
		}
		report.endTest(test);
		report.flush();
	}

}
