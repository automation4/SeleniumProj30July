package com.rahulshetty.pages.Section3;

import com.rahulshetty.pages.common.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Section3Components extends AbstractComponent {

  @FindBy(xpath = "//legend[.='Web Table Example']/../table/tbody")
  private WebElement table;

  @FindBy(xpath = "//button[@class='btn btn-primary'][@id='mousehover']")
  private WebElement hoverBtn;

  @FindBy(xpath = "//h1[.='Practice Page']")
  private WebElement elementonTop;

    public Section3Components(WebDriver driver) {
        super(driver);
    }

    public String getotalPrice() throws InterruptedException {
      scrollToElementAC(table);
      List<WebElement> elements = table.findElements(By.xpath("//legend[.='Web Table Example']/../table/tbody/tr/td[3]"));
      return elements.stream().collect(Collectors.summingInt(ele -> Integer.parseInt(ele.getText()))).toString();
    }

    public void checkHoverWorking() throws InterruptedException {
      moveToElementAC(hoverBtn);
      List<WebElement> elements = driver.findElements(By.xpath("//button[@class='btn btn-primary'][@id='mousehover']/../div/a"));
      elements.stream().filter(elem->elem.getText().equalsIgnoreCase("Top")).forEach(WebElement::click);
      Assert.assertTrue(elementonTop.isDisplayed());
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
