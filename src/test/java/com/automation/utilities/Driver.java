package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;
    private Driver(){}               // used Singleton design here to prevent instantiation of Driver and have only one Driver instance in a session

    public static WebDriver getDriver(){
        if(driver == null) {
            String browser = ConfigurationReader.getProperty("browser");
            switch(browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Please use Chrome or Firefox browser!");
            }
        }


        return driver;
    }


    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }












/*

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver(){ }


    public static WebDriver getDriver() {
        if (driverPool.get() == null) {

            synchronized (Driver.class) {
                String browser = ConfigurationReader.getProperty("browser");

                if (System.getProperty("browser") != null) {
                    System.out.println("Browser is changed to " + System.getProperty("browser"));
                    browser = System.getProperty("browser");
                }

                switch (browser.toLowerCase()) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        break;
                    case "remote-chrome":
                        try {
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName("chrome");
                            URL seleniumGridURL = new URL("http://3.82.5.142:4444/wd/hub");
                            driverPool.set(new RemoteWebDriver(seleniumGridURL, desiredCapabilities));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case "remote-firefox":
                        try {

                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName("firefox");
                            URL seleniumGridURL = new URL("http://3.82.5.142:4444/wd/hub");
                            driverPool.set(new RemoteWebDriver(seleniumGridURL, desiredCapabilities));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    default:
                        throw new RuntimeException("No such browser is available yet!");
                }
            }
        }

        return driverPool.get();
    }


    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }


*/



}
