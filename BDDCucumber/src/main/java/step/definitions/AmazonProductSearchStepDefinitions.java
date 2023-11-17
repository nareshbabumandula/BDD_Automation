package step.definitions;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonProductSearchStepDefinitions {
	
	@Given("I access Amazon portal")
	public void i_access_amazon_portal() {
	    System.out.println("Accessed Amazon Portal");
	}


	@When("I search for a product")
	public void i_search_for_a_product(io.cucumber.datatable.DataTable dataTable) {
		List<String> data = dataTable.asList();
		
		for (String product : data) {
			System.out.println("Searched with the product : " + product);
		}
		
	}
	
	@Then("I should see the appropriate search results")
	public void i_should_see_the_appropriate_search_results() {
		System.out.println("Successfully verified the search results");
	}
	
	
	@When("I search for a product {string}")
	public void i_search_for_a_product(String string) {
		System.out.println("Searched the product : " + string);
	}

}
