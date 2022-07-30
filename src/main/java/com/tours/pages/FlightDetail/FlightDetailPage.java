package com.tours.pages.FlightDetail;
import com.tours.pages.flightdeparturereturn.FlightDepartureReturnPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightDetailPage{

private Preferences preferences;
private WebDriver driver;

   @FindBy(xpath = "//input[@id='findFlights']")
   private WebElement continuebutton;
    private FlightDetails flightDetails;

    public FlightDetailPage(WebDriver driver) {
        this.driver = driver;
        flightDetails = PageFactory.initElements(driver,FlightDetails.class);
        preferences = PageFactory.initElements(driver,Preferences.class);
    }

    public FlightDetails getFlightDetails(){
        return  flightDetails;
    }
    public Preferences getPrefrences(){
        return preferences;
    }

    public FlightDepartureReturnPage clickContinue(){
        continuebutton.click();
        return PageFactory.initElements(driver,FlightDepartureReturnPage.class);
    }
}
