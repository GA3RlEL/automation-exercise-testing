package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
  protected WebDriver driver;

  public BasePage(WebDriver driver) {
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

  public LoginPage goToLoginPage() {
    cta.click();
    loginMenuButton.click();
    return new LoginPage(driver);
  }

  public ContactUsPage goToContactUsPage() {
    cta.click();
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
