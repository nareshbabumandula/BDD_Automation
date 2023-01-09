package step.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPageStepDefinitions{

	@Given("^i access amazon portal$")
	public void i_access_amazon_portal() throws Throwable {
	    System.out.println("Accessed Amazon portal");
	}

	@When("^i enter any valid product$")
	public void i_enter_any_valid_product() throws Throwable {
		System.out.println("Entered product name in search text field");
	}

	@And("^i click on search button$")
	public void i_click_on_search_button() throws Throwable {
		System.out.println("Clicked on search button");
	}

	@Then("^it should display the appropriate product details$")
	public void it_should_display_the_appropriate_product_details() throws Throwable {
		System.out.println("Successfully verified the search results..!");
	}

	@When("i enter any invalid product")
	public void i_enter_any_invalid_product() {
	    System.out.println("Entered a invalid product name");
	}



	
}
