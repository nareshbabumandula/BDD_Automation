package step.definitions;

import org.openqa.selenium.WebDriver;

import com.main.WebDriverSingleton;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks{


	WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;
	private static boolean isReportGenerated = false;


	@Before(order=1) 
	public void setup() {
		driver = WebDriverSingleton.getDriver();
		System.out.println("This will run before the Scenario with order one"); 
		if (!isReportGenerated) {
            // Code to initialize and start the Extent Report
            // This will run before the first scenario outline execution
			// Extent Reports
			report = new ExtentReports("./target/ExtentReport/ExtentResults.html");
			test = report.startTest("EGW_TC01");
            isReportGenerated = true;
        }
	}

	@Before(order=2) 
	public void beforeScenarioOrdertwo(Scenario scenario){
		System.out.println("This will run before the Scenario with order two"); 
	}

	@After 
	public void afterScenario(){
		driver.quit();
		System.out.println("This will run after the Scenario");
		report.endTest(test);
		report.flush();
	}

	@BeforeStep 
	public void beforeStep(){
		System.out.println("This will run before each step in a scenario");
	}


	@AfterStep 
	public void afterStep(){
		System.out.println("This will run after each step in a scenario"); 
	}


}