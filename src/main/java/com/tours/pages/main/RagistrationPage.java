package com.tours.pages.main;

import com.tours.pages.RegistrationConfirmationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RagistrationPage {
    private WebDriver driver;

    @FindBy(css = "#register-btn" )
    private WebElement submit;
    private ContactInformation contactInformationPage;
    private MailingInformation mailingInformation;
    private UserInformation userInformation;

    public RagistrationPage(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
       contactInformationPage = PageFactory.initElements(driver, ContactInformation.class);
       mailingInformation = PageFactory.initElements(driver,MailingInformation.class);
       userInformation = PageFactory.initElements(driver,UserInformation.class);
    }

    public void goTo(String url){
        this.driver.get(url);
    }

    public RegistrationConfirmationPage clickSubmit(){
        this.submit.click();
        return PageFactory.initElements(driver,RegistrationConfirmationPage.class);
    }

    public ContactInformation getContactInformationPage() {
        return contactInformationPage;
    }

    public MailingInformation getMailingInformation() {
        return mailingInformation;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

}
