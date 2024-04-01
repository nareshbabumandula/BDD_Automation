package step.definitions;

import java.time.Duration;
import java.util.Properties;

import com.generic.actions.CommonActions;
import com.main.WebDriverSingleton;
import com.page.objects.SwagLabsLoginPage;
import com.page.objects.SwagLabsProductsPage;
import com.qa.util.ConfigReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class SwagLabsStepDefinitions {

	WebDriverSingleton base;
	SwagLabsLoginPage slp;
	SwagLabsProductsPage sp;
	Hooks hooks;
	Properties properties;

	public SwagLabsStepDefinitions() {
		properties = ConfigReader.init_prop();
		slp = new SwagLabsLoginPage(base.getDriver());
		sp = new SwagLabsProductsPage(base.getDriver());		
	}

	@Given("i access Sauce Demo portal")
	public void i_access_sauce_demo_portal() {
		base.getDriver().get((properties.get("url")).toString());
		base.getDriver().manage().window().maximize();
		base.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String title=base.getDriver().getTitle();
		if (title.contains("Swag Labs")) {
			hooks.test.log(LogStatus.PASS, "Access Swag Labs portal", "Successfully accessed Swag Labs portal");
		} else {
			hooks.test.log(LogStatus.FAIL, "Access Swag Labs portal", "Failed to accessed Swag Labs portal");
		}
	}

	@Then("i should see Swag Labs login page")
	public void i_should_see_swag_labs_login_page() {

		if (slp.SwagLabsLoginHeader.isDisplayed()) {
			hooks.test.log(LogStatus.PASS, "Verify Swag Labs login heading", "Swag Labs login page heading is displayed");
		} else {
			hooks.test.log(LogStatus.FAIL, "Verify Swag Labs login heading", "Swag Labs login page heading is not matching");
		}
	}

	@Then("^i should see username, password, login, accepted usernames and password fields in Swag Labs login page$")
	public void verifyMandatoryFieldsInLoginPage() {
		CommonActions.isElementDisplayed(slp.username, "Username field");
		CommonActions.isElementDisplayed(slp.password, "Password field");
		CommonActions.isElementDisplayed(slp.login, "Login button");
		CommonActions.isElementDisplayed(slp.acceptedusernames, "Accepted usernames");
		CommonActions.isElementDisplayed(slp.acceptedpasswords, "Accepted password");
	}

	@When("i enter username as {string}")
	public void i_enter_username_as(String string) {
		CommonActions.type(slp.username, string, "Username");
	}

	@When("i enter password as {string}")
	public void i_enter_password_as(String string) {
		CommonActions.type(slp.password, string, "Password");
	}

	@When("i click on Login button")
	public void i_click_on_login_button() {
		CommonActions.click(slp.login, "Login");
	}

	@Then("i should see the mandatory options for Swag Labs products")
	public void i_should_see_the_mandatory_options_for_swag_labs_products() {
		sp.verifyProductDetails();
	}

}
