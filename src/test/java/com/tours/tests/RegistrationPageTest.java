package com.tours.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tours.pages.billingaddress.BillingAddressPage;
import com.tours.pages.flightItinerarypage.FlightItineraryPage;
import com.tours.pages.flightdeparturereturn.FlightDepartureReturnPage;
import com.tours.pages.FlightDetail.FlightDetailPage;
import com.tours.pages.RegistrationConfirmationPage;
import com.tours.pages.main.RagistrationPage;
import com.tours.tests.Base.BaseTest;
import com.tours.tests.factory.DataFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Map;

public class RegistrationPageTest extends BaseTest {

    private RagistrationPage ragistrationPage;
    private RegistrationConfirmationPage registrationConfirmationPage;
    private FlightDetailPage flightDetailPage;
    private FlightDepartureReturnPage flightDepartureReturnPage;
    private BillingAddressPage billingAddressPage;
    private FlightItineraryPage flightItineraryPage;

    @BeforeTest
    @Parameters("browser")
    public void initializePage(String browser) {
        ragistrationPage = new RagistrationPage(getDriverInstance(browser));
        ragistrationPage.goTo("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        System.out.println("initializing browser on the go");
    }

/*
    @BeforeMethod
    public void sleepbeforemethod(){
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void sleepaftermethod(){
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }
*/

    @Test
    public void enterContactInformation(){
        try {
            Assert.assertTrue(ragistrationPage.getContactInformationPage().isDisplayed());
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
        ragistrationPage.getContactInformationPage().setContactInformation(DataFactory.getInfo("CI"));
    }


    @Test
    public void enterMailingInformation(){
        try {
            Assert.assertTrue(ragistrationPage.getMailingInformation().isDisplayed());
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
        ragistrationPage.getMailingInformation().setMailingInformation(DataFactory.getInfo("MI"));

    }

    @Test
    public void enterUserInformation(){
        try {
            Assert.assertTrue(ragistrationPage.getUserInformation().isDisplayed());
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
        ragistrationPage.getUserInformation().setUserInformation(DataFactory.getInfo("UI"));
    }

    @Test(dependsOnMethods = {"enterContactInformation","enterUserInformation","enterMailingInformation"})
    public void enterSubmit(){
        registrationConfirmationPage = ragistrationPage.clickSubmit();
    }

    @Test(dependsOnMethods = "enterSubmit")
    public void confirmregistrationTest(){
        try {
            Assert.assertTrue(registrationConfirmationPage.isDisplayed());
        }catch (Exception e){
            e.getMessage();
        }
        registrationConfirmationPage.registrationCheck();
        flightDetailPage = registrationConfirmationPage.goToFlightsPage();
        Uninterruptibles.sleepUninterruptibly( Duration.ofSeconds(2));
    }

    @Test(dependsOnMethods = "confirmregistrationTest")
    public void enterFlightDetails(){
        flightDetailPage.getFlightDetails().enterTripDetails(DataFactory.getInfo("FD"));
        Uninterruptibles.sleepUninterruptibly( Duration.ofSeconds(2));

        flightDetailPage.getPrefrences().selectFlightPreference(DataFactory.getInfo("prefrences"));
        Uninterruptibles.sleepUninterruptibly( Duration.ofSeconds(2));

        flightDepartureReturnPage = flightDetailPage.clickContinue();

    }

    @Test(dependsOnMethods = "enterFlightDetails")
    public void selectDepartureandReturn(){
        flightDepartureReturnPage.getDeparture().selectAirlinesasPerclass("First Class","Emirates");
        flightDepartureReturnPage.getaReturn().selectAirlinesasPerclass("Economy Class","Qatar");
        billingAddressPage = flightDepartureReturnPage.clickContinue();
        Uninterruptibles.sleepUninterruptibly( Duration.ofSeconds(4));
    }

    @Test(dependsOnMethods = "selectDepartureandReturn")
    public void enterBillingAddress(){
        Assert.assertTrue(billingAddressPage.isDisplayed());
     billingAddressPage.enterBillingDetails(DataFactory.getInfo("BA"));
     flightItineraryPage = billingAddressPage.gotoflightItinearyPage();

        }

        @Test(dependsOnMethods = "enterBillingAddress")
        public void FightconfirmationDetails(){
           Map<String,String> flightsummary = flightItineraryPage.getFlightSummary();
            for(Map.Entry<String,String> map : flightsummary.entrySet()){
                System.out.println(map.getKey() + " :: " + map.getValue());
            }

    }

}
