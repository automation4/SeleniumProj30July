package com.tours.pages.FlightDetail;

import com.tours.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;
import java.util.Map;

public class Preferences extends AbstractComponent {

       @FindBy(xpath = "//input[@name='servClass'][@type='radio']")
        private List<WebElement> serviceclass;

        @FindBy(xpath = "//select[@name='airline']")
        private WebElement airline;

        public Preferences(WebDriver driver) {
        super(driver);
    }

    public void selectFlightPreference(Map<String,String> preference){
        radioSelection(serviceclass,preference.get("serviceclasss"));
        dropdownselection(airline,preference.get("Airline"));
    }


    @Override
    public boolean isDisplayed() {
        return false;
    }
}
