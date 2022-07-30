package com.tours.pages.flightdeparturereturn;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tours.pages.common.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Return extends AbstractComponent {


    @FindBy(xpath = "//h1[contains(text(),'Return')]/following-sibling::table[1]")
    private WebElement returnflight;

    public Return(WebDriver driver) {
        super(driver);
    }

    public void selectAirlinesasPerclass(String flightClass, String airlines) {
        int i=0;
        for(WebElement element:returnflight.findElements(By.xpath("//h1[contains(text(),'Return')]/following-sibling::table[1]/tbody/tr/th[@scope='row']/label")))
            if (!element.getText().equalsIgnoreCase(airlines)) {
                i++;
            }
            else if(element.getText().contains(airlines)){
                i++;
                for(WebElement element1: returnflight.findElements(By.xpath("(//h1[contains(text(),'Return')]/following-sibling::table[1]/tbody/tr/th[@scope='row']/label/ancestor::tr)["+i+"]/td/input")))
                {
                    if(element1.getAttribute("value").equalsIgnoreCase(flightClass))
                    {  element1.click();
                        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
                        break;
                    }
                }
                break;
            }
    }


    @Override
    public boolean isDisplayed() {
        return false;
    }
}
