package com.tours.pages.common;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public abstract class AbstractComponent {
    protected WebDriverWait wait;
    protected WebDriver driver;

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
    public abstract boolean isDisplayed();
}
