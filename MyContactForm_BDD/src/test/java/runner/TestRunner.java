package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import managers.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/java/features",
	glue= {"classpath:src/test/java/steps"},tags = {"@smoke","~@regression"},
	plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
	monochrome = true,
	dryRun=true
	)
 

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		//Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	}
}

