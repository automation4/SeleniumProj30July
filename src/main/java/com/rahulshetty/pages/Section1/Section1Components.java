package com.rahulshetty.pages.Section1;

import com.rahulshetty.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

public class Section1Components extends AbstractComponent {


    @FindBy(xpath ="//input[@name= 'radioButton']")
    private List<WebElement> radios;

    @FindBy(xpath ="//input[@type= 'checkbox']")
    private List<WebElement> checkbox;

    @FindBy(xpath ="//input[@id='autocomplete']")
    private WebElement country;

    @FindBy(xpath ="//select[@id='dropdown-class-example']")
    private List<WebElement> dropdown;

    @FindBy(xpath = "//ul[@id='ui-id-1']/li")
    private List<WebElement> countrysuggestions;


    public Section1Components(WebDriver driver) {
        super(driver);
    }

    public void selectRadios(String radiobutton) {
        radios.stream().filter(element -> element.getAttribute("value").equalsIgnoreCase(radiobutton)).forEach(WebElement::click);
    }

    public void selectCountry(String countrytoselect){
      country.sendKeys(countrytoselect);
      wait.until(d-> countrysuggestions.size()>0);
      countrysuggestions.stream().filter(element -> element.getText().equalsIgnoreCase(countrytoselect)).forEach(WebElement::click);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
