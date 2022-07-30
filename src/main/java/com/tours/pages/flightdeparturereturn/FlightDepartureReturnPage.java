package com.tours.pages.flightdeparturereturn;
import com.tours.pages.billingaddress.BillingAddressPage;
import com.tours.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlightDepartureReturnPage extends AbstractComponent {

    private Departure departure;
    private Return aReturn;

    @FindBy(xpath = "//input[@id='reserveFlights']")
    private WebElement continuebutton;



    public FlightDepartureReturnPage(WebDriver driver) {
        super(driver);
    }


    public Departure getDeparture() {
        return PageFactory.initElements(driver,Departure.class);
    }

    public Return getaReturn() {
        return PageFactory.initElements(driver,Return.class);
    }

    public BillingAddressPage clickContinue(){
       continuebutton.click();
        return PageFactory.initElements(driver,BillingAddressPage.class);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
