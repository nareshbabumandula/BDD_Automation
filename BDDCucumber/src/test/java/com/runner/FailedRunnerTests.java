package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(tags = "", features = {"@target/rerun.txt"}, glue = {"step.definitions"},
                 plugin = {})
@RunWith(Cucumber.class)    
public class FailedRunnerTests {
    
}