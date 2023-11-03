package step.definitions;

import org.openqa.selenium.WebDriver;

import com.main.WebDriverSingleton;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks{


	WebDriver driver;

	@Before(order=1) 
	public void setup() {
		driver = WebDriverSingleton.getDriver();
		System.out.println("This will run before the Scenario with order one"); 
	}


	@Before(order=2) 
	public void beforeScenarioOrdertwo(){
		System.out.println("This will run before the Scenario with order two"); 
	}


	@After 
	public void afterScenario(){
		driver.quit();
		System.out.println("This will run after the Scenario"); driver.quit();
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