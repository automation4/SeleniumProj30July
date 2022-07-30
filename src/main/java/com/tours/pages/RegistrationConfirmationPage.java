package com.tours.pages;

import com.tours.pages.FlightDetail.FlightDetailPage;
import com.tours.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationConfirmationPage extends AbstractComponent{

    @FindBy(xpath = "//a[normalize-space(text()=sign-in)]/parent::font")
    private WebElement confirmation;

    @FindBy(xpath = "//a[text()='Flights']/parent::b/a")
    private WebElement flightlink;

    public RegistrationConfirmationPage(final WebDriver driver) {
        super(driver);

    }

    public void registrationCheck(){
        System.out.println(confirmation.getText());

    }

    public FlightDetailPage goToFlightsPage(){
        flightlink.click();
        return PageFactory.initElements(driver, FlightDetailPage.class);
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> this.flightlink.isDisplayed());
    }
}
