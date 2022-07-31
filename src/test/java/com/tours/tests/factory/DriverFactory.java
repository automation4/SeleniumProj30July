package com.tours.tests.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static DriverFactory instance= new DriverFactory();
    private DriverFactory(){}

    public static DriverFactory getInstance() {
        return instance;
    }

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public WebDriver getDriver(String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                this.driver.set(new ChromeDriver(chromeOptions));
                break;
            case "firefox":
             WebDriverManager.firefoxdriver().setup();
             FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                this.driver.set(new FirefoxDriver(firefoxOptions));
                break;
            default:
                System.out.println("not a valid choice");
                break;
        }
       return this.driver.get();
    }
    /*public WebDriver getDriver(String browser) throws MalformedURLException {
        switch (browser.toLowerCase()){
            case "chrome":
               // WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
                capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Windows 10");
                //capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
                //OR
                capabilities.merge(chromeOptions);
                this.driver.set(new RemoteWebDriver(URI.create("http://172.20.240.1:4444/").toURL(),capabilities));
                break;
            case "firefox":
                //WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                DesiredCapabilities capabilities1 = new DesiredCapabilities();
                capabilities1.setCapability(CapabilityType.BROWSER_NAME,"Firefox");
                capabilities1.setCapability(CapabilityType.PLATFORM_NAME,"Windows 11");
                capabilities1.merge(firefoxOptions);
                this.driver.set(new RemoteWebDriver(URI.create("http://172.20.240.1:4444/").toURL(),capabilities1));
                break;
            default:
                System.out.println("not a valid choice");
                break;
        }
        return this.driver.get();
    }*/

    public void closeDriver(){
        this.driver.get().quit();
    }

}
