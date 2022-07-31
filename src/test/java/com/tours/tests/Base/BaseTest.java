package com.tours.tests.Base;
import com.tours.tests.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BaseTest {

    public WebDriver getDriverInstance(String browser) {
      return DriverFactory.getInstance().getDriver(browser);
    }

    @AfterTest
    public void close(){
        DriverFactory.getInstance().closeDriver();
    }
}
