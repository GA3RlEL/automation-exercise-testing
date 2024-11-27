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
  WebElement nameInputSignUp;
  @FindBy(css = "input[data-qa='signup-email']")
  WebElement emailInputSignUp;
  @FindBy(css = "button[data-qa='signup-button']")
  WebElement signUpButton;

  @FindBy(css = "input[data-qa='login-password']")
  WebElement passwordInputLogin;
  @FindBy(css = "input[data-qa='login-email']")
  WebElement emailInputLogin;
  @FindBy(css = "button[data-qa='login-button']")
  WebElement loginButton;
  @FindBy(css = "form[action*='/login'] p")
  WebElement errorLoginMessage;
  @FindBy(css = ".login-form h2")
  WebElement loginHeading;

  @FindBy(css = "form[action*='/signup'] p")
  WebElement errorSignupMessage;

  public String getNewUserHeading() {
    return newUserText.getText();
  }

  public SignUpPage enterNameAndEmailSignUp(String name, String email) {
    nameInputSignUp.sendKeys(name);
    emailInputSignUp.sendKeys(email);
    signUpButton.click();
    return new SignUpPage(driver);
  }

  public void enterNameAndEmailSignUpVoid(String name, String email) {
    nameInputSignUp.sendKeys(name);
    emailInputSignUp.sendKeys(email);
    signUpButton.click();
  }

  public void enterNameAndEmailLogin(String password, String email) {
    passwordInputLogin.sendKeys(password);
    emailInputLogin.sendKeys(email);
    loginButton.click();
  }

  public String getLoginErrorMessage() {
    return errorLoginMessage.getText();
  }

  public String getSignupErrorMessage() {
    return errorSignupMessage.getText();
  }

  public String getLoginHeading() {
    return loginHeading.getText();
  }

}
