package com.automationexercise.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.pages.AccountCreatedPage;
import com.automationexercise.pages.AccountDeletedPage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.SignUpPage;
import com.automationexercise.tests.testComponents.BaseTest;

public class UserTests extends BaseTest {
  @Test
  public void test_registerUser() {
    String name = "test";
    String email = "test12321@test.com";
    String password = "Test123!";
    String firstName = "Test";
    String lastName = "Test";
    String address = "Test street 2/3";
    String state = "Montana";
    String city = "Helena";
    String zipcode = "59601";
    String mobileNumber = "555000000";
    String country = "United States";

    LoginPage loginPage = goToLoginPage();
    String newUserText = loginPage.getNewUserText();
    Assert.assertEquals(newUserText.split("!")[0] + "!", "New User Signup!");
    SignUpPage signUpPage = loginPage.enterNameAndEmail(name, email);
    signUpPage.enterAccountInformation(password, "28", 5, "2002");
    signUpPage.enterAddressInformation(firstName, lastName, address, country, state, city, zipcode, mobileNumber);
    AccountCreatedPage accountCreated = signUpPage.registerAccount();

    String accountCreatedText = accountCreated.getAccountCreatedConfirmation();
    Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!");

    String userNameVisible = accountCreated.getUsername();
    Assert.assertEquals(userNameVisible, ("Logged in as " + name));

    AccountDeletedPage accountDeletedPage = accountCreated.deleteAccount();
    String accountDeletionText = accountDeletedPage.getAccountDeletionConfirmation();
    Assert.assertEquals(accountDeletionText, "ACCOUNT DELETED!");
    ;
  }

}
