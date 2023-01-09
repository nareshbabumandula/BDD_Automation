package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
   //path of feature file
   features = {"src/test/resources/features/Search.feature"},
   //path of step definition file
   glue = {"step.definitions"},tags = "@smoke",plugin = { "pretty", "html:target/cucumber-reports" },
	monochrome = true
   )
public class TestRunner {
}
