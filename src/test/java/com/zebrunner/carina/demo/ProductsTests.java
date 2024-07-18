package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.enums.SortingType;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductDetailPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductsTests implements IAbstractTest {


    @Test(description = "Sort Items by price from low to high", dependsOnGroups = "login")
    @MethodOwner(owner = "Alexis")
    public void verifyProductSortInAscendingOrder() {
        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        homePageBase.sortItems(SortingType.PRICE_LOW_TO_HIGH);
        Assert.assertTrue(homePageBase.areItemsSortedByAscendingPrice());
    }

    @Test(description = "Change products view and select first item", dependsOnGroups = "login")
    @MethodOwner(owner = "Alexis")
    public void changeProductsViewTest() throws InterruptedException {
        HomePageBase sauceLabsHomePage = initPage(getDriver(), HomePageBase.class);
        sauceLabsHomePage.clickChangeViewButton();
        ProductDetailPageBase sauceLabsDetailsPage = sauceLabsHomePage.clickProductByIndex("1");
        Assert.assertTrue(sauceLabsDetailsPage.isTitlePresent());
    }
    @Test(description = "Click on first product using problem user credentials", dependsOnGroups = "loginWithProblemCredentialsTest")
    @MethodOwner(owner = "Alexis")
    public void goToFirstProductDetailsPageTest(){
        HomePageBase sauceLabsHomePage = initPage(getDriver(), HomePageBase.class);
        ProductDetailPageBase sauceLabsProductsDetailsPage = sauceLabsHomePage.clickOnFirstElement();
        Assert.assertEquals(sauceLabsProductsDetailsPage.getProductPrice(), "$9.99");
    }
}
