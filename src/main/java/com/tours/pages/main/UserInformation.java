package com.tours.pages.main;

import com.tours.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class UserInformation extends AbstractComponent {
    @FindBy(xpath = "//input[@name='email']")
    private WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement Confirm_password;

    public UserInformation(WebDriver driver) {
        super(driver);
    }

    public void setUserInformation(Map<String,String> map){
        userName.sendKeys(map.get("userName"));
        password.sendKeys(map.get("password"));
        Confirm_password.sendKeys(map.get("Confirm_password"));

    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d)->this.userName.isDisplayed());
    }
}
