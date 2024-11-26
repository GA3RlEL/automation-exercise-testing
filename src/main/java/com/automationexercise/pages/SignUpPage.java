package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {
  protected WebDriver driver;

  public SignUpPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "id_gender1")
  WebElement mrCheckbox;
  @FindBy(id = "password")
  WebElement passwordInput;
  @FindBy(id = "days")
  WebElement dayOfBirthDropdown;
  @FindBy(id = "months")
  WebElement monthOfBirthDropdown;
  @FindBy(id = "years")
  WebElement yearOfBirthDropdown;
  @FindBy(id = "newsletter")
  WebElement newsletterCheckbox;
  @FindBy(id = "first_name")
  WebElement firsNameInput;
  @FindBy(id = "last_name")
  WebElement lastNameInput;
  @FindBy(id = "address1")
  WebElement addressInput;
  @FindBy(id = "state")
  WebElement stateInput;
  @FindBy(id = "city")
  WebElement cityInput;
  @FindBy(id = "zipcode")
  WebElement zipcodeInput;
  @FindBy(id = "mobile_number")
  WebElement phoneNumberInput;
  @FindBy(id = "country")
  WebElement countryDropdown;
  @FindBy(css = "form[action='/signup'] button")
  WebElement signUpButton;

  Select dayOfBirth = new Select(dayOfBirthDropdown);
  Select monthOfBirth = new Select(monthOfBirthDropdown);
  Select yearOfBirth = new Select(yearOfBirthDropdown);
  Select country = new Select(countryDropdown);

  public void enterAccountInformation(String password, String day, int month, String year) {
    mrCheckbox.click();
    passwordInput.sendKeys(password);
    dayOfBirth.selectByValue(day);
    monthOfBirth.selectByIndex(month);
    yearOfBirth.selectByValue(year);
    newsletterCheckbox.click();
  }

  public void enterAddressInformation(String firstName, String lastName, String address, String countryS, String state,
      String city,
      String zipcode, String phoneNumber) {
    firsNameInput.sendKeys(firstName);
    lastNameInput.sendKeys(lastName);
    addressInput.sendKeys(address);
    stateInput.sendKeys(state);
    cityInput.sendKeys(city);
    country.selectByVisibleText(countryS);
    zipcodeInput.sendKeys(zipcode);
    phoneNumberInput.sendKeys(phoneNumber);
  }

  public AccountCreatedPage registerAccount() {
    signUpButton.click();
    return new AccountCreatedPage(driver);
  }

}
