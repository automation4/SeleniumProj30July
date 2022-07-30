package com.tours.pages.main;

import com.tours.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class ContactInformation extends AbstractComponent {
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lasttName;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phone;
    @FindBy(xpath = "//input[@name='userName']")
    private WebElement email;

    public ContactInformation(WebDriver driver) {
        super(driver);
    }

     public void setContactInformation(Map<String, String> map){
        firstName.sendKeys(map.get("firstName"));
         lasttName.sendKeys(map.get("lasttName"));
         phone.sendKeys(map.get("phone"));
         email.sendKeys(map.get("email"));
     }

    @Override
    public boolean isDisplayed() {
        return wait.until((d)->this.firstName.isDisplayed());
    }
}
