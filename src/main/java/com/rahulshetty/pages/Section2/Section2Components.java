package com.rahulshetty.pages.Section2;

import com.rahulshetty.pages.common.AbstractComponent;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.util.Strings;

import java.util.Set;
import java.util.function.Predicate;

public class Section2Components extends AbstractComponent {


    @FindBy(xpath="//input[@id= 'name']")
    private WebElement alerttextbox;

    @FindBy(xpath="//input[@id= 'alertbtn']")
    private WebElement Alertbutton;

    @FindBy(xpath="//input[@id= 'confirmbtn']")
    private WebElement alertconfirm;

    @FindBy(xpath="//button[@id='openwindow']")
    private WebElement openwindow;


    public Section2Components(WebDriver driver) {
        super(driver);
    }


    public Section2Components enterName(String name){
        alerttextbox.sendKeys(name);
        return this;
    }
    public Section2Components clicAlertButton(){
        Alertbutton.click();
        return this;
    }

    public String getTextfromAlert(){
        Alert alert = driver.switchTo().alert();
       String textfromAlter = alert.getText();
       alert.accept();
       return textfromAlter;
    }

    public void switchBetweenWindows(){
        String parentwindow = driver.getWindowHandle();
        String childwhandel=null;
         openwindow.click();
        System.out.println("I am in new window");
        Set<String> allwindows = driver.getWindowHandles();
        for(String window : allwindows){
            if(!parentwindow.equalsIgnoreCase(window)){
                childwhandel = window;
            }
        }
        driver.switchTo().window(childwhandel);
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),learn)]")).isDisplayed());
        driver.switchTo().window(parentwindow);
        Assert.assertTrue(Alertbutton.isDisplayed());
        System.out.println("Alert is present hence in Old window");


    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
