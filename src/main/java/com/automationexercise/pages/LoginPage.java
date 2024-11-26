package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

  protected WebDriver driver;

  public LoginPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = ".signup-form h2")
  WebElement newUserText;
  @FindBy(css = "input[data-qa='signup-name']")
  WebElement nameInput;
  @FindBy(css = "input[data-qa='signup-email']")
  WebElement emailInput;
  @FindBy(css = "button[data-qa='signup-button']")
  WebElement signUpButton;

  public String getNewUserText() {
    return newUserText.getText();
  }

  public SignUpPage enterNameAndEmail(String name, String email) {
    nameInput.sendKeys(name);
    emailInput.sendKeys(email);
    signUpButton.click();
    return new SignUpPage(driver);
  }

}
