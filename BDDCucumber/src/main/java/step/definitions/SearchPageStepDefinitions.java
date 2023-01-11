package step.definitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPageStepDefinitions{
	
	
WebDriver driver;
	
	@Given("^i access amazon portal$")
	public void i_access_amazon_portal() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	    System.out.println("Accessed Amazon portal");
	}

	@When("^i enter any valid product$")
	public void i_enter_any_valid_product() throws Throwable {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("umbrella");
		System.out.println("Entered product name in search text field");
	}

	@And("^i click on search button$")
	public void i_click_on_search_button() throws Throwable {
		driver.findElement(By.id("nav-search-submit-button")).click();
		System.out.println("Clicked on search button");
	}

	@Then("^it should display the appropriate product details$")
	public void it_should_display_the_appropriate_product_details() throws Throwable {
		String title = driver.getTitle();
		if (title.contains("umbrella")) {
			System.out.println("Successfully verified the search results..!");
		} else {
			System.out.println("Failed to display the appropriate search results..!");
		}
		driver.quit();
		
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
		System.out.println("Entered the product name with the partial text : " + string);
	}
	
	@When("i enter any product name with a partial text")
	public void i_enter_any_product_name_with_a_partial_text(io.cucumber.datatable.DataTable dataTable) {
	   List<String> data = dataTable.asList();
	   System.out.println("Entered the product name : "  + data.get(0));
	   System.out.println("Entered the product name : "  + data.get(1));
	   System.out.println("Entered the product name : "  + data.get(2));
	}


}
