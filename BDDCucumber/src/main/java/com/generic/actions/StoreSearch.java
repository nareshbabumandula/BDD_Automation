package com.generic.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StoreSearch {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.eyeglassworld.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("inputStoreValue")).sendKeys("tampa");
		driver.findElement(By.xpath("//button[contains(@class,'a-btn--is-slim m-store-finder__submit')]")).click();
		Thread.sleep(30000);
		driver.quit();
	}
}
