package com.tours.pages.billingaddress;

import com.tours.pages.common.AbstractComponent;
import com.tours.pages.flightItinerarypage.FlightItineraryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class BillingAddressPage extends AbstractComponent {

    @FindBy(xpath = "//input[@id='input_53_addr_line1']")
    private WebElement streetAddress1;

    @FindBy(xpath = "//input[@id='input_53_addr_line2']")
    private WebElement streetAddress2;

    @FindBy(xpath = "//input[@id='input_53_city']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='input_53_state']")
    private WebElement state;

    @FindBy(xpath = "//input[@id='input_53_postal']")
    private WebElement postal;

    @FindBy(xpath = "//input[@id='buyFlights']")
    private WebElement continuebutton;

    private FlightItineraryPage flightItIneraryPage;

    public BillingAddressPage(WebDriver driver) {
        super(driver);
    }


   public void enterBillingDetails(Map<String,String> billingdetails){
        streetAddress1.sendKeys(billingdetails.get("streetAddress1"));
       streetAddress2.sendKeys(billingdetails.get("streetAddress2"));
       city.sendKeys(billingdetails.get("city"));
       state.sendKeys(billingdetails.get("state"));
       postal.sendKeys(billingdetails.get("postal"));
   }

   public FlightItineraryPage gotoflightItinearyPage(){
        continuebutton.click();
        return PageFactory.initElements(driver,FlightItineraryPage.class);
   }

    @Override
    public boolean isDisplayed() {
        return wait.until(d->this.streetAddress1.isDisplayed());
    }


}
