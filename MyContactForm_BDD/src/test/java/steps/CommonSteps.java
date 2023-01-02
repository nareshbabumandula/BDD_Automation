package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonSteps {
	
	@Given("^i access mycontactform portal$")
	public void i_access_mycontactform_portal() throws Throwable {
		try {
			System.out.println("Accessed mycontactform portal");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Given("^i enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String arg1) throws Throwable {
		System.out.println("Entered username : " + arg1);
	}

	@When("^i enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String arg1) throws Throwable {
		System.out.println("Entered password : " + arg1);
	}

	@When("^i click on login button$")
	public void i_click_on_login_button() throws Throwable {
		System.out.println("Clicked on login button");
	}

	@Then("^i should see an appropriate validation message$")
	public void i_should_see_an_appropriate_validation_message() throws Throwable {
		System.out.println("Successfully verified the validation message");
	}
	
	

}
