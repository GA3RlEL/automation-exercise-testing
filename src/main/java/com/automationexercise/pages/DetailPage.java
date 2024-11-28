package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailPage extends BasePage {

  protected WebDriver driver;

  public DetailPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = ".product-information h2")
  WebElement productName;
  @FindBy(css = ".product-information p:first-of-type")
  WebElement productCategory;
  @FindBy(css = ".product-information span span")
  WebElement productPrice;
  @FindBy(css = ".product-information p:nth-of-type(2)")
  WebElement productAvailability;
  @FindBy(css = ".product-information p:nth-of-type(3)")
  WebElement productCondition;
  @FindBy(css = ".product-information p:nth-of-type(4)")
  WebElement productBrand;

  public boolean checkDisplayingOfDetails() {
    return productName.isDisplayed() && productCategory.isDisplayed() && productPrice.isDisplayed()
        && productAvailability.isDisplayed() && productCondition.isDisplayed() && productBrand.isDisplayed();
  }

}
