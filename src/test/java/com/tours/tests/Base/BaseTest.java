package com.tours.tests.Base;
import com.tours.tests.helper.BrowserTypes;
import com.tours.tests.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void getDriverInstance(String browser) throws MalformedURLException {
      this.driver= DriverFactory.getInstance().getDriver(browser);
    }

  /*  @BeforeTest
    public void getDriverInstance() throws MalformedURLException {
        this.driver= DriverFactory.getInstance().getDriver(BrowserTypes.CHROME.name());
    }*/



    @AfterTest
    public void close(){
        DriverFactory.getInstance().closeDriver();
    }
}
