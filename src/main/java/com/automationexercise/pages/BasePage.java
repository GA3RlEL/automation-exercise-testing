package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.AbstractComponents;

public class BasePage extends AbstractComponents {
  protected WebDriver driver;

  public BasePage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = ".fc-cta-consent")
  WebElement cta;
  @FindBy(css = "a[href*='/login']")
  WebElement loginMenuButton;
  @FindBy(xpath = "//i[@class='fa fa-user']/..")
  WebElement user;
  @FindBy(css = "a[href*='/delete_account']")
  WebElement deleteAccountButton;
  @FindBy(css = "a[href*='/logout']")
  WebElement logoutButton;
  @FindBy(css = "a[href*='/contact_us']")
  WebElement contactUsButton;
  @FindBy(css = ".nav a[href*='/test_cases']")
  WebElement testCasesButton;
  @FindBy(css = "a[href*='/products']")
  WebElement productsButton;

  public void clickCta() {
    cta.click();
  }

  public ProductsPage goToProductsPage() {
    productsButton.click();
    return new ProductsPage(driver);
  }

  public LoginPage goToLoginPage() {
    loginMenuButton.click();
    return new LoginPage(driver);
  }

  public void goToTestCasesPage() {
    testCasesButton.click();
  }

  public ContactUsPage goToContactUsPage() {
    contactUsButton.click();
    return new ContactUsPage(driver);
  }

  public String getUsername() {
    return user.getText();
  }

  public AccountDeletedPage deleteAccount() {
    deleteAccountButton.click();
    return new AccountDeletedPage(driver);
  }

  public void logoutAccount() {
    logoutButton.click();
  }

  public String getActuallPage() {
    return driver.getCurrentUrl();
  }

}
