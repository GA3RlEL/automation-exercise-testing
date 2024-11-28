package com.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.tests.testComponents.BaseTest;

public class ContactUsTests extends BaseTest {

  @Test
  public void test_validateContactUsForm() {
    String name = "test";
    String email = "test@test.com";
    String subject = "subject";
    String message = "message";
    String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\sisyphus.webp";

    ContactUsPage contactUsPage = goToContactUsPage();
    String contactUsHeading = contactUsPage.getContactUsHeading();
    Assert.assertEquals(contactUsHeading, "GET IN TOUCH");
    contactUsPage.fulfilForm(name, email, subject, message, filePath);
    contactUsPage.acceptPopup();
    String successMessage = contactUsPage.getSuccessMessage();
    Assert.assertEquals(successMessage, "Success! Your details have been submitted successfully.");
    contactUsPage.backToMainPage();
    String url = contactUsPage.getActuallPage();
    Assert.assertEquals(url, "https://automationexercise.com/");
  }

}
