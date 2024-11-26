package com.automationexercise.tests.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automationexercise.models.UserData;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.LoginPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest {

  protected WebDriver driver;
  protected BasePage basePage;

  public WebDriver initializeDriver() throws IOException {
    Properties properties = new Properties();
    FileInputStream file = new FileInputStream(
        System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
    properties.load(file);

    String browser = properties.getProperty("browser");
    switch (browser) {
      case "chrome":
        driver = new ChromeDriver();
        break;
      case "edge":
        driver = new EdgeDriver();
        break;
      case "firefox":
        driver = new FirefoxDriver();
        break;
      default:
        driver = new ChromeDriver();
        break;
    }

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.manage().window().maximize();

    return driver;
  }

  public List<UserData> getJsonData(String filePath) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File(filePath), new TypeReference<List<UserData>>() {

      });
    } catch (IOException e) {
      throw new RuntimeException("Failed to load test data from JSON file:" + filePath, e);
    }

  }

  @BeforeMethod
  public void launchBrowser() throws IOException {
    driver = initializeDriver();
    driver.get("https://automationexercise.com/");
  }

  public LoginPage goToLoginPage() {
    basePage = new BasePage(driver);
    LoginPage loginPage = basePage.goToLoginPage();
    return loginPage;
  }

  @AfterMethod
  public void closeBrowser() {
    driver.close();
  }

}
