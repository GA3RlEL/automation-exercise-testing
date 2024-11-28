package com.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.pages.DetailPage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.tests.testComponents.BaseTest;

public class VerifyTests extends BaseTest {

  @Test
  public void test_verifyTestCasesPage() {
    goToTestCasePage();
    String url2 = basePage.getActuallPage();
    Assert.assertEquals(url2, "https://automationexercise.com/test_cases");
  }

  @Test
  public void test_verifyAllProductsAndProductDetailPage() {
    ProductsPage productsPage = goToProductsPage();
    String headingText = productsPage.getHeadingText();
    Assert.assertEquals(headingText.split("PRODUCTS")[0] + "PRODUCTS", "ALL PRODUCTS");
    Assert.assertTrue(productsPage.isListVisible());
    DetailPage detailPage = productsPage.selectFirstElementOfList();
    Assert.assertTrue(detailPage.checkDisplayingOfDetails());
  }

}
