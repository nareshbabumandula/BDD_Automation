package step.definitions;

import java.time.Duration;
import java.util.Properties;

import com.generic.actions.CommonActions;
import com.main.WebDriverSingleton;
import com.page.objects.SwagLabsLoginPage;
import com.qa.util.ConfigReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SwagLabsStepDefinitions {

	WebDriverSingleton base;
	SwagLabsLoginPage slp;
	Hooks hooks;

	Properties properties = ConfigReader.init_prop();
	
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
		slp = new SwagLabsLoginPage(base.getDriver());
		
		if (slp.SwagLabsLoginHeader.isDisplayed()) {
			hooks.test.log(LogStatus.PASS, "Verify Swag Labs login heading", "Swag Labs login page heading is displayed");
		} else {
			hooks.test.log(LogStatus.FAIL, "Verify Swag Labs login heading", "Swag Labs login page heading is not matching");
		}
	}
	
	@Then("^i should see username, password, login, accepted usernames and password fields in Swag Labs login page$")
	public void verifyMandatoryFieldsInLoginPage() {
		
		try {
			slp = new SwagLabsLoginPage(base.getDriver());
			CommonActions.isElementDisplayed(slp.username, "Username field");
			CommonActions.isElementDisplayed(slp.password, "Password field");
			CommonActions.isElementDisplayed(slp.login, "Login button");
			CommonActions.isElementDisplayed(slp.acceptedusernames, "Accepted usernames");
			CommonActions.isElementDisplayed(slp.acceptedpasswords, "Accepted password");
		} catch (Exception e) {
			
		}
	
		
	}

}
