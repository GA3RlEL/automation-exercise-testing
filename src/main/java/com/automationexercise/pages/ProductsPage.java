package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage {
  protected WebDriver driver;

  public ProductsPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = ".title")
  WebElement heading;
  @FindBy(css = ".features_items")
  WebElement list;

  public String getHeadingText() {
    return heading.getText();
  }

  public boolean isListVisible() {
    return list.isDisplayed();
  }

  public DetailPage selectFirstElementOfList() {
    WebElement firstElement = list.findElement(By.xpath("//div[@class='col-sm-4'][1]"));
    scrollByOffset(0, 250);
    firstElement.findElement(By.xpath("//div[@class='choose']//a")).click();
    return new DetailPage(driver);
  }
}
