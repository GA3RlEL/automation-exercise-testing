package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage {

  protected WebDriver driver;

  public ContactUsPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = ".contact-form h2")
  WebElement contactUsFormHeading;
  @FindBy(css = "input[data-qa$='name']")
  WebElement nameInput;
  @FindBy(css = "input[data-qa$='email']")
  WebElement emailInput;
  @FindBy(css = "input[data-qa$='subject']")
  WebElement subjectInput;
  @FindBy(css = "textarea[data-qa$='message']")
  WebElement messageInput;
  @FindBy(css = "input[name$='upload_file']")
  WebElement uploadInput;
  @FindBy(css = "input[data-qa$='submit-button']")
  WebElement submitButton;
  @FindBy(css = ".contact-form .alert-success")
  WebElement successMessage;
  @FindBy(css = ".btn-success")
  WebElement homeButton;

  public String getContactUsHeading() {
    return contactUsFormHeading.getText();
  }

  public void fulfilForm(String name, String email, String subject, String message, String filePath) {
    nameInput.sendKeys(name);
    emailInput.sendKeys(email);
    subjectInput.sendKeys(subject);
    messageInput.sendKeys(message);
    uploadInput.sendKeys(filePath);
    submitButton.click();
  }

  public void acceptPopup() {
    driver.switchTo().alert().accept();
  }

  public String getSuccessMessage() {
    return successMessage.getText();
  }

  public String backToMainPage() {
    homeButton.click();
    return driver.getCurrentUrl();
  }

}
