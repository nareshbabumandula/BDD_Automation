package com.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSingleton {
	
    private static WebDriver driver;

    private WebDriverSingleton() {
        // Private constructor to prevent instantiation from outside the class
    }

    // With this implementation, you can use the getDriver() method to obtain a single instance
    // of the WebDriver object throughout your test automation framework.
    
    // To use the singleton, you can call WebDriverSingleton.getDriver() to get the instance of 
    // the driver in your test classes or methods:
    
    public static WebDriver getDriver() {

        if (driver==null) {
            ChromeOptions options = new ChromeOptions();
    		options.addArguments("--remote-allow-origins=*");
        	WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver(options);
        }else if(driver.toString().contains("(null)")) {
        	ChromeOptions options = new ChromeOptions();
    		options.addArguments("--remote-allow-origins=*");
        	WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver(options);
        }
        return driver;
    }
       
}
