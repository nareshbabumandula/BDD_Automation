package step.definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EGWStoreSearchStepDefinitions {
	WebDriver driver;
	
	@Given("I access EGW website")
	public void i_access_egw_website() {
		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.eyeglassworld.com/");
		driver.manage().window().maximize();
	}

	@When("I search a Store by State, City, and Zipcode")
	public void i_search_a_store_by_state_city_and_zipcode() {
		driver.findElement(By.id("inputStoreValue")).sendKeys("tampa");
		driver.findElement(By.xpath("//button[contains(@class,'a-btn--is-slim m-store-finder__submit')]")).click();
	}
	
	@Then("I can see the store details")
	public void i_can_see_the_store_details() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
