package com.tours.pages.flightItinerarypage;

import com.github.dockerjava.api.model.Link;
import com.tours.pages.common.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.*;

public class FlightItineraryPage extends AbstractComponent {

    @FindBy(xpath = "//form[@name='nothing']//tr/td/font")
    private List<WebElement> flightsummary;


    public FlightItineraryPage(WebDriver driver) {
        super(driver);
    }

    public LinkedList<String> getList(List<WebElement> elements){
        LinkedList<String> templist = new LinkedList<>();
        for(WebElement element : elements){
            if(element.getText().contains("#")){
                templist.add(element.getText().split("#")[1]);
            }
            else{
                templist.add(element.getText());
            }
        }
    return templist;
    }
    public Map<String, String> getFlightSummary() {
       LinkedList<String> templist = getList(flightsummary);
        Map<String, String> map = new HashMap<>();
         map.put("Flight Confirmation",templist.get(0));
         map.put("Tax",templist.get(1));
         map.put("Total Price",templist.get(2));
         return map;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}