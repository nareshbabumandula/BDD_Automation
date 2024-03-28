package step.definitions;

import java.time.Duration;

import com.main.WebDriverSingleton;
import com.page.objects.SwagLabsLoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SwagLabsStepDefinitions {

	WebDriverSingleton base;
	SwagLabsLoginPage slp;
	static ExtentTest test;
	static ExtentReports report;

	@Given("i access Sauce Demo portal")
	public void i_access_sauce_demo_portal() {
		base.getDriver().get("https://www.saucedemo.com/");
		base.getDriver().manage().window().maximize();
		base.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Extent Reports
		report = new ExtentReports("./target/ExtentReport/ExtentResults.html");
		test = report.startTest("TC01");
		String title=base.getDriver().getTitle();
		if (title.contains("Swag Labs")) {
			test.log(LogStatus.PASS, "Access Swag Labs portal", "Successfully accessed Swag Labs portal");
		} else {
			test.log(LogStatus.FAIL, "Access Swag Labs portal", "Failed to accessed Swag Labs portal");
		}
	}

	@Then("i should see Swag Labs login page")
	public void i_should_see_swag_labs_login_page() {
		slp = new SwagLabsLoginPage(base.getDriver());
		
		if (slp.SwagLabsLoginHeader.isDisplayed()) {
			test.log(LogStatus.PASS, "Verify Swag Labs login heading", "Swag Labs login page heading is displayed");
		} else {
			test.log(LogStatus.FAIL, "Verify Swag Labs login heading", "Swag Labs login page heading is not matching");
		}
		report.endTest(test);
		report.flush();
		base.getDriver().quit();
	}

}
