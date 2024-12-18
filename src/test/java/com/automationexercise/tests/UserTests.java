package com.automationexercise.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.models.UserData;
import com.automationexercise.pages.AccountCreatedPage;
import com.automationexercise.pages.AccountDeletedPage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.SignUpPage;
import com.automationexercise.tests.testComponents.BaseTest;

public class UserTests extends BaseTest {

  @Test(dataProvider = "userDataProvider")
  public void test_registerUser(UserData userData) {
    LoginPage loginPage = goToLoginPage();
    String newUserText = loginPage.getNewUserHeading();
    Assert.assertEquals(newUserText.split("!")[0] + "!", "New User Signup!");
    SignUpPage signUpPage = loginPage.enterNameAndEmailSignUp(userData.name, userData.email);
    signUpPage.enterAccountInformation(userData.password, "28", 5, "2002");
    signUpPage.enterAddressInformation(userData.firstName, userData.lastName, userData.address, userData.country,
        userData.state, userData.city, userData.zipcode, userData.mobileNumber);
    AccountCreatedPage accountCreated = signUpPage.registerAccount();

    String accountCreatedText = accountCreated.getAccountCreatedConfirmation();
    Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!");

    String userNameVisible = accountCreated.getUsername();
    Assert.assertEquals(userNameVisible, ("Logged in as " + userData.name));

    AccountDeletedPage accountDeletedPage = accountCreated.deleteAccount();
    String accountDeletionText = accountDeletedPage.getAccountDeletionConfirmation();
    Assert.assertEquals(accountDeletionText, "ACCOUNT DELETED!");
  }

  @Test()
  public void test_logoutUser() {
    String email = "test121311@test.com";
    String password = "Test123!";

    LoginPage loginPage = goToLoginPage();
    String loginHeading = loginPage.getLoginHeading();
    Assert.assertEquals(loginHeading, "Login to your account");
    loginPage.enterNameAndEmailLogin(password, email);
    loginPage.logoutAccount();
    String url = loginPage.getActuallPage();
    Assert.assertEquals(url, "https://automationexercise.com/login");
  }

  @Test
  public void test_loginCorrectCred() {
    String email = "test121311@test.com";
    String password = "Test123!";
    String name = "test";

    LoginPage loginPage = goToLoginPage();
    String loginHeading = loginPage.getLoginHeading();
    Assert.assertEquals(loginHeading, "Login to your account");
    loginPage.enterNameAndEmailLogin(password, email);
    String username = loginPage.getUsername();
    Assert.assertEquals(username, ("Logged in as " + name));
  }

  @Test
  public void test_loginIncorrectCred() {
    String email = "test121311@test.com";
    String password = "incorrectPassword";
    LoginPage loginPage = goToLoginPage();
    loginPage.enterNameAndEmailLogin(password, email);
    String loginHeading = loginPage.getLoginHeading();
    Assert.assertEquals(loginHeading, "Login to your account");
    String errorMessage = loginPage.getLoginErrorMessage();
    Assert.assertEquals(errorMessage, "Your email or password is incorrect!");
  }

  @Test
  public void test_resigserWithExistingEmail() {
    String email = "test121311@test.com";
    String name = "test";

    LoginPage loginPage = goToLoginPage();
    String signupHeading = loginPage.getNewUserHeading();
    Assert.assertEquals(signupHeading, "New User Signup!");
    loginPage.enterNameAndEmailSignUpVoid(name, email);
    String errorMessage = loginPage.getSignupErrorMessage();
    Assert.assertEquals(errorMessage, "Email Address already exist!");
  }

  @DataProvider(name = "userDataProvider")
  public Object[][] getData() {
    List<UserData> users = getJsonData(
        System.getProperty("user.dir") + "\\src\\test\\java\\resources\\registerData.json");
    Object[][] data = new Object[users.size()][1];
    for (int i = 0; i < users.size(); i++) {
      data[i][0] = users.get(i);
    }
    return data;
  }

}
