package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
   //path of feature file
   features = {"src/test/resources/features/Search.feature"},
   //path of step definition file
   glue = {"step.definitions"},plugin = {
	        "pretty:target/prettyReport.txt", "html:target/cucumber.html", "json:target/cucumber.json", "rerun:target/rerun.txt",
	        "junit:target/junit-report.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
   			monochrome = true, publish=true,tags="@smoke or @regression"
   )
public class TestRunner{

	
	
}
