package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductDetailPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests implements IAbstractTest {
    @Test(description = "Add first product to the cart", dependsOnGroups = "login")
    @MethodOwner(owner = "Alexis")
    public void addElementToCartTest(){
        HomePageBase sauceLabsHomePage = initPage(getDriver(), HomePageBase.class);
        sauceLabsHomePage.addProductToCart("1");
        CartPageBase sauceLabsCartPage = sauceLabsHomePage.clickCartButton();
        Assert.assertTrue(sauceLabsCartPage.isDescriptionDisplayed());
        sauceLabsCartPage.clickContinueShoppingButton();
    }
    @Test(description = "Add product from Product Details Page", dependsOnGroups = "login")
    @MethodOwner(owner = "Alexis")
    public void addToCartFromProductDetailsPageTest(){
        HomePageBase sauceLabsHomePage = initPage(getDriver(), HomePageBase.class);
        ProductDetailPageBase sauceLabsProductsDetailsPage = sauceLabsHomePage.clickOnFirstElement();
        sauceLabsProductsDetailsPage.clickAddToCartBtn();
    }
    @Test(description = "Remove product from the cart", dependsOnGroups = {"login", "addElementToCartTest"})
    @MethodOwner(owner = "Alexis")
    public void removeProductfromTheCartTest(){
        CartPageBase sauceLabsCartPage = initPage(getDriver(), CartPageBase.class);
        sauceLabsCartPage.clickRemoveButton();
    }
    @Test(description = "Add last product from the list to the cart and click on continue shopping", dependsOnMethods = "loginWithStandardCredentialsTest")
    @MethodOwner(owner = "Alexis")
    public void addLastProductToTheCartTest(){
        HomePageBase sauceLabsHomePage = initPage(getDriver(), HomePageBase.class);
        sauceLabsHomePage.clickProductByIndex("6");
    }
    @Test(description = "Add multiple items to the cart", dependsOnGroups = "login")
    @MethodOwner(owner = "Alexis")
    public void addMultipleItemsToCartTest() throws InterruptedException {
        HomePageBase sauceLabsHomePage = initPage(getDriver(), HomePageBase.class);
        sauceLabsHomePage.addProductToCart("1");
        sauceLabsHomePage.addProductToCart("2");
        Thread.sleep(3000);
        sauceLabsHomePage.clickCartButton();
    }

}
