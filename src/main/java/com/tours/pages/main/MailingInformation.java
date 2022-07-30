package com.tours.pages.main;

import com.tours.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class MailingInformation extends AbstractComponent {

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement address;
    @FindBy(xpath = "//input[@name='city']")
    private WebElement city;
    @FindBy(xpath = "//input[@name='state']")
    private WebElement State_Province;

    @FindBy(xpath = "//input[@name='postalCode']")
    private WebElement Postal_Code;
    @FindBy(xpath = "//select[@name='country']")
    private WebElement Country;

    public MailingInformation(WebDriver driver) {
        super(driver);
    }



    public void setMailingInformation(Map<String, String> map){
        address.sendKeys(map.get("address"));
        city.sendKeys(map.get("city"));
        State_Province.sendKeys(map.get("State_Province"));
        Postal_Code.sendKeys(map.get("Postal_Code"));
        selectCountry(map.get("Country"));
    }

    public void selectCountry(String countryName){
        Select select = new Select(Country);
        select.selectByValue(countryName);
      }

    @Override
    public boolean isDisplayed() {
        return wait.until((d)->this.address.isDisplayed());
    }
}
