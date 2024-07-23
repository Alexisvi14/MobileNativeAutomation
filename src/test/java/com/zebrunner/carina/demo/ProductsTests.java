package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.enums.SortingType;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductsListPageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductDetailPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductsTests implements IAbstractTest {

    LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
    @Test(description = "Sort Items by price from low to high")
    @MethodOwner(owner = "Alexis")
    public void verifyProductSortInAscendingOrder() throws InterruptedException {
        var productsListPageBase = loginPageBase.loginWithStandardCredentials();
        productsListPageBase.sortItems(SortingType.PRICE_LOW_TO_HIGH);
        Thread.sleep(3000);
        Assert.assertTrue(productsListPageBase.areItemsSortedByAscendingPrice());
    }

    @Test(description = "Change products view and select first item")
    @MethodOwner(owner = "Alexis")
    public void changeProductsViewTest() throws InterruptedException {
        var productsListPageBase = loginPageBase.loginWithStandardCredentials();
        productsListPageBase.clickChangeViewButton();
        ProductDetailPageBase sauceLabsDetailsPage = productsListPageBase.clickProductByIndex("1");
        Assert.assertTrue(sauceLabsDetailsPage.isTitlePresent());
    }
    @Test(description = "Click on first product using problem user credentials")
    @MethodOwner(owner = "Alexis")
    public void goToFirstProductDetailsPageTest(){
        var productsListPageBase = loginPageBase.loginWithStandardCredentials();
        ProductDetailPageBase sauceLabsProductsDetailsPage = productsListPageBase.clickOnFirstElement();
        Assert.assertEquals(sauceLabsProductsDetailsPage.getProductPrice(), "$9.99");
    }
}
