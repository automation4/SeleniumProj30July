package com.tours.pages.FlightDetail;

import com.tours.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class FlightDetails extends AbstractComponent {

    @FindBy(xpath = "//input[@type='radio'][@name='tripType']")
    private List<WebElement> triptype;

    @FindBy(xpath = "//select[@id='passCount']")
    private WebElement passengers;

    @FindBy(xpath = "//select[@name='fromPort']")
    private WebElement departing_from;

    @FindBy(xpath = "//select[@name='fromMonth']")
    private WebElement on_month;

    @FindBy(xpath = "//select[@name='fromDay']")
    private WebElement on_day;

    @FindBy(xpath = "//select[@name='toPort']")
    private WebElement arriving;

    @FindBy(xpath = "//select[@name='toMonth']")
    private WebElement returning_to_month;

    @FindBy(xpath = "//select[@name='toDay']")
    private WebElement returning_to_day;

    public FlightDetails(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    public void enterTripDetails(Map<String, String> flightDetails) {
        radioSelection(triptype,flightDetails.get("trip_type"));
        dropdownselection(passengers,flightDetails.get("passengers"));
        dropdownselection(departing_from,flightDetails.get("departing_from"));
        dropdownselection(on_month,flightDetails.get("on_month"));
        dropdownselection(on_day,flightDetails.get("on_day"));
        dropdownselection(arriving,flightDetails.get("arriving"));
        dropdownselection(returning_to_month,flightDetails.get("returning_to_month"));
        dropdownselection(returning_to_day,flightDetails.get("returning_to_day"));
    }
}
