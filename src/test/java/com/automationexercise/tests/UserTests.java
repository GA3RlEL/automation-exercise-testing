package com.automationexercise.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTests {

  @Test
  public void test_registerUser() {
    String name = "test";
    String email = "test12321@test.com";
    String password = "Test123!";

    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    driver.get("https://automationexercise.com/");

    driver.findElement(By.cssSelector(".fc-cta-consent")).click();

    driver.findElement(By.cssSelector("a[href*='/login']")).click();

    String newUserText = driver.findElement(By.cssSelector(".signup-form h2")).getText();
    Assert.assertEquals(newUserText.split("!")[0] + "!", "New User Signup!");

    driver.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys(name);
    driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(email);
    driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();

    driver.findElement(By.id("id_gender1")).click();
    driver.findElement(By.id("password")).sendKeys(password);

    Select dayOfBirth = new Select(driver.findElement(By.id("days")));
    Select monthOfBirth = new Select(driver.findElement(By.id("months")));
    Select yearOfBirth = new Select(driver.findElement(By.id("years")));
    int randomDay = (int) (Math.random() * 28 + 1);
    int randomMonth = (int) (Math.random() * 12);
    dayOfBirth.selectByValue(String.valueOf(randomDay));
    monthOfBirth.selectByIndex(randomMonth);
    yearOfBirth.selectByValue("2000");
    driver.findElement(By.id("newsletter")).click();

    driver.findElement(By.id("first_name")).sendKeys("test");
    driver.findElement(By.id("last_name")).sendKeys("test");
    driver.findElement(By.id("address1")).sendKeys("test street 2/3");
    Select countrySelect = new Select(driver.findElement(By.id("country")));
    countrySelect.selectByVisibleText("United States");
    driver.findElement(By.name("state")).sendKeys("Montana");
    driver.findElement(By.name("city")).sendKeys("Helena");
    driver.findElement(By.name("zipcode")).sendKeys("59601");
    driver.findElement(By.name("mobile_number")).sendKeys("555000000");

    driver.findElement(By.cssSelector("form[action='/signup'] button")).click();

    String accountCreatedText = driver.findElement(By.cssSelector(".col-sm-9 h2")).getText();
    Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!");
    driver.findElement(By.xpath("//a[contains(.,'Continue')]")).click();
    ;

    String userNameVisible = driver.findElement(By.xpath("//i[@class='fa fa-user']/..")).getText();
    Assert.assertEquals(userNameVisible, "Logged in as test");

    driver.findElement(By.cssSelector("a[href*='/delete_account']")).click();
    String accountDeletionText = driver.findElement(By.cssSelector(".text-center b")).getText();
    Assert.assertEquals(accountDeletionText, "ACCOUNT DELETED!");
    driver.findElement(By.xpath("//a[contains(.,'Continue')]")).click();
    ;
  }

}
