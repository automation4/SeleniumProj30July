package com.rahulshetty.tests;

import Utils.ExcelUtil;
import Utils.PropertiesUtil;
import com.google.common.util.concurrent.Uninterruptibles;
import com.rahulshetty.pages.RahulShettyHomePage;
import com.rahulshetty.tests.Base.BaseTest;
import helper.DBUtils;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Utils.RahulShettyTestDataEnum.RADIOBUTTON1;

public class RahulShettyPageTest extends BaseTest {

    private RahulShettyHomePage rahulShettyHomePage;
    private SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    @Parameters("browser")
    public void initializePage(String browser) throws IOException {
        rahulShettyHomePage = new RahulShettyHomePage(getDriverInstance(browser));
        rahulShettyHomePage.goTo(PropertiesUtil.getProperty("url"));
    }


    @AfterMethod
    public void letsWait(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @Test
    public void radioButtonTest(){
        rahulShettyHomePage.getSection1Components().isDisplayed();
        rahulShettyHomePage.getSection1Components().selectRadios(RADIOBUTTON1.getEnum());

    }

    @Test(dataProvider = "getData")
    public void selectCountry(String country){
        rahulShettyHomePage.getSection1Components().selectCountry(country);
    }

@Test
    public void checkAlertusingSQL() throws SQLException, ClassNotFoundException {
        List<String> namelist = DBUtils.getDataFromDB("select Name from EmployeeName;");
        String message = rahulShettyHomePage.getSection2Components().enterName(namelist.get(0)).clicAlertButton().getTextfromAlert();
        softAssert.assertTrue(message.contains(namelist.get(0)),"alert message doesn't contain expected name");
    }

    @Test
    public void switchingBetweenWindows(){
        rahulShettyHomePage.getSection2Components().switchBetweenWindows();
    }

    @Test
    public void getpriceFromTable() throws InterruptedException, IOException {
        String expected = PropertiesUtil.getProperty("expectedprice");
        String actual = rahulShettyHomePage.getSection3Components().getotalPrice();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void checkHoverFunctionality() throws InterruptedException {
        rahulShettyHomePage.getSection3Components().checkHoverWorking();
    }


    /*@DataProvider
    public Object[][] getData(){
        return new Object[][] {{"India"}};
    }*/

    @DataProvider
    public Object[][] getData() throws IOException {
        return  ExcelUtil.getDatafromExcel();
    }


}
