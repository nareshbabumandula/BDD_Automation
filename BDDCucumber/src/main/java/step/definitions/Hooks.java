package step.definitions;

import org.junit.AfterClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {

	@Before(order=1)
	public void beforeScenarioOrderone(){
		System.out.println("This will run before the Scenario with order one");
	}

	@Before(order=2)
	public void beforeScenarioOrdertwo(){
		System.out.println("This will run before the Scenario with order two");
	}	


	@After
	public void afterScenario(){
		System.out.println("This will run after the Scenario");
	}

	@BeforeStep
	public void beforeStep(){
		System.out.println("This will run before each step in a scenario");
	}	


	@AfterStep public void afterStep(){
		System.out.println("This will run after each step in a scenario");
	}



}