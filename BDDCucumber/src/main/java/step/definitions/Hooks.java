package step.definitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.main.WebDriverSingleton;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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


	@Before(order=0) 
	public void setup() {
		driver = WebDriverSingleton.getDriver();
		System.out.println("This will run before the Scenario with order one"); 
		if (report == null) {
			report = new ExtentReports("./target/ExtentReport/ExtentResults.html");
			isReportGenerated = true;
		}
	}

	@Before(order=1) 
	public void beforeScenarioOrdertwo(Scenario scenario){
		test = report.startTest("TC01");
		//System.out.println("This will run before the Scenario with order two"); 
	}

	@After(order=999) 
	public void afterScenario(Scenario scenario){
				
		if (scenario.isFailed()) {
			try {
				System.out.println(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) WebDriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", scenario.getName()); 
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				System.out.println(scenario.getName() + " is pass");
				//log.info(scenario.getName() + " is pass");
				//scenario.embed(((TakesScreenshot) WebDriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//System.out.println("This will run after the Scenario");
		if (report != null) {
			report.endTest(test);
			report.flush();
		}
	
		driver.quit();
		
	}
	
	// Getter method for ExtentTest object to be used in step definitions
    public static ExtentTest getExtentTest() {
        return test;
    }

	@BeforeStep 
	public void beforeStep(){
		System.out.println("This will run before each step in a scenario");
	}


	@AfterStep 
	public void afterStep(){
		System.out.println("This will run after each step in a scenario"); 
	}

	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if(!scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

}