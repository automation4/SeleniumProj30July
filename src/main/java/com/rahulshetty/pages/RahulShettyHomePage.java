package com.rahulshetty.pages;

import com.rahulshetty.pages.Section1.Section1Components;
import com.rahulshetty.pages.Section2.Section2Components;
import com.rahulshetty.pages.Section3.Section3Components;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RahulShettyHomePage {
    private WebDriver driver;
    private Section1Components section1Components;
    private Section2Components section2Components;
    private Section3Components section3Components;


    public RahulShettyHomePage(final WebDriver driver) {
        this.driver= driver;
        section1Components = PageFactory.initElements(driver, Section1Components.class);
        section2Components = PageFactory.initElements(driver, Section2Components.class);
        section3Components = PageFactory.initElements(driver, Section3Components.class);
    }

    public void goTo(String url){
        this.driver.get(url);
    }

    public Section1Components getSection1Components() {
        return section1Components;
    }

    public Section2Components getSection2Components() {
        return section2Components;
    }

    public Section3Components getSection3Components() {
        return section3Components;
    }
}
