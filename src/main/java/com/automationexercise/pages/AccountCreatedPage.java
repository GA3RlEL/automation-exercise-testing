package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends BasePage {

  protected WebDriver driver;

  public AccountCreatedPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = ".col-sm-9 h2")
  WebElement accountCreatedText;

  @FindBy(xpath = "//a[contains(.,'Continue')]")
  WebElement contiueButton;

  public String getAccountCreatedConfirmation() {
    String confirmationMessage = accountCreatedText.getText();
    contiueButton.click();
    return confirmationMessage;
  }

}
