package com.tours.pages.common;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public abstract class AbstractComponent {
    protected static WebDriverWait wait;
    protected static WebDriver driver;

    public AbstractComponent(final WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void scrolltoElement(WebElement element) throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) this.driver;
        executor.executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(1000);
    }

    public  void dropdownselection(WebElement element ,String value){
        Select select = new Select(element);
        List<WebElement> ls = select.getOptions();
        ls.stream().filter(e ->e.getText().equalsIgnoreCase(value)).forEach(WebElement::click);
    }

    public void radioSelection(List<WebElement> element,String value){
            element.stream().filter(d -> d.getAttribute("value").equalsIgnoreCase(value)).forEach(WebElement::click);
    }

    public static String  getScreenshotPath(String methodname) throws IOException {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("screenshot\\"+methodname+new Date().getTime()+".png");
        String filepath = destination.getAbsolutePath();
        FileUtils.copyFile(source, destination);
        return filepath;
    }
    public abstract boolean isDisplayed();
}
