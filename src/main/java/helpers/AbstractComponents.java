package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AbstractComponents {

  protected WebDriver driver;

  public AbstractComponents(WebDriver driver) {
    this.driver = driver;
  }

  public void scrollToElement(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", element);
  }

  public void scrollByOffset(int x, int y) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript(String.format("javascript:window.scrollBy(%s,%s)", x, y));
  }

}
