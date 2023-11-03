package step.definitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.main.WebDriverSingleton;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class SearchPageStepDefinitions{

	static ExtentTest test;
	static ExtentReports report;
	WebDriver driver;
		
	@Given("^i access amazon portal$")
	public void i_access_amazon_portal() throws Throwable {
		driver = WebDriverSingleton.getDriver();
		driver.get("https://www.primefaces.org/primereact-v5/#/datatable/selection/");
		driver.manage().window().maximize();
		System.out.println("Accessed primefaces portal");

		// Extent Reports
		report = new ExtentReports("./target/ExtentReport/ExtentResults.html");
		test = report.startTest("TC01");

	}

	@When("^i enter any valid product$")
	public void i_enter_any_valid_product() throws Throwable {
		driver.findElement(By.xpath("//div[@class='p-checkbox-box p-component p-clickable']/following::td[contains(text(),'Blue Band')]/../td/div/div[2]/span")).click();
		System.out.println("Successfully selected the checkbox");
	}

	
	@And("^i click on search button$")
	public void i_click_on_search_button() throws Throwable {
		driver.findElement(By.id("nav-search-submit-button")).click();
		System.out.println("Clicked on search button");
	}

	@Then("^it should display the appropriate product details$")
	public void it_should_display_the_appropriate_product_details() throws Throwable {
		String title = driver.getTitle();
		if (title.contains("iphone")) {
			test.log(LogStatus.PASS, "Successfully verified the search results..!");
			System.out.println("Successfully verified the search results..!");
		} else {
			test.log(LogStatus.FAIL, "Failed to display the appropriate search results..!");
			System.out.println("Failed to display the appropriate search results..!");
		}
		
		report.endTest(test);
		report.flush();
		driver.quit();
		System.out.println("Closed the browser..!");
	}


	@When("i enter any invalid product")
	public void i_enter_any_invalid_product() {
		System.out.println("Entered a invalid product name");
	}

	@When("i enter any product name with a partial text {string}")
	public void i_enter_any_product_name_with_a_partial_text(String sText) {
		System.out.println("Entered the product name with the partial text : " + sText);
	}

	@When("i enter any product name with a partial text as {string}")
	public void i_enter_any_product_name_with_a_partial_text_as(String string) {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(string);
		System.out.println("Entered the product name with the partial text : " + string);
	}

	@When("i enter any product name with a partial text")
	public void i_enter_any_product_name_with_a_partial_text(io.cucumber.datatable.DataTable dataTable) {
		List<String> data = dataTable.asList();
		System.out.println("Entered the product name : "  + data.get(0));
		System.out.println("Entered the product name : "  + data.get(1));
		System.out.println("Entered the product name : "  + data.get(2));
	}
	
	@SuppressWarnings("deprecation")
	@Then("I should see amazon logo displayed")
	public void verifyLogo() {
	    try {
			boolean bFlag = driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
			Assert.assertTrue("Amazon logo image is not displayed", bFlag);
			test.log(LogStatus.PASS, "Amazon logo image is displayed..!");
			System.out.println("Amazon logo image is displayed..!");
		} catch (Exception e) {
			String asText[] = e.getMessage().split("}");
			test.log(LogStatus.FAIL, "Amazon logo image is not displayed since - " +asText[0]);
			System.out.println("Amazon logo image is not displayed..!");
			e.printStackTrace();
		}finally {
			report.endTest(test);
			report.flush();
		}
	    
	}

}


