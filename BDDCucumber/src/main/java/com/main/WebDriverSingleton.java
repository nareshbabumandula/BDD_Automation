package com.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        if (driver == null) {
            // Set the path to the driver executable depending on the browser you're using
            System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
    		options.addArguments("--remote-allow-origins=*");
    		driver = new ChromeDriver(options);
        }
        return driver;
    }
    
    public static void main(String[] args) {
    	
    }
}
