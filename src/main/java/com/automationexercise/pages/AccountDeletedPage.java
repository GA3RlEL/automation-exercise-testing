package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage extends BasePage {

  protected WebDriver driver;

  public AccountDeletedPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = ".text-center b")
  WebElement accountDeletionMessage;
  @FindBy(xpath = "//a[contains(.,'Continue')]")
  WebElement continueButton;

  public String getAccountDeletionConfirmation() {
    String confirmationMessage = accountDeletionMessage.getText();
    continueButton.click();
    return confirmationMessage;
  }

}
