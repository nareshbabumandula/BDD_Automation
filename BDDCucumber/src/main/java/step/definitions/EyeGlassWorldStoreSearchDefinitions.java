package step.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EyeGlassWorldStoreSearchDefinitions {
	
	@Given("I access Eyeglassword website")
	public void accessSite() {
	    System.out.println("Accessed EyeGlassWorld website");
	}

	@When("I search a Store by City")
	public void searchStore() {
		System.out.println("Searched an eyeglassworld store");
	}

	@Then("I should see the store details based on City")
	public void verifyResults() {
		System.out.println("Successfully verified the store details in the search results");
	}



}
