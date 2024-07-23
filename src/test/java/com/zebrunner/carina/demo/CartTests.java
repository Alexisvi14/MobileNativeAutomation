package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductDetailPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CartTests implements IAbstractTest {
    LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
    @Test(description = "Add first product to the cart")
    @MethodOwner(owner = "Alexis")
    public void addElementToCartTest(){
        var productsListPage = loginPageBase.loginWithStandardCredentials();
        productsListPage.addProductToCart("1");
        CartPageBase sauceLabsCartPage = productsListPage.clickCartButton();
        Assert.assertTrue(sauceLabsCartPage.isDescriptionDisplayed());
        Assert.assertTrue(sauceLabsCartPage.clickContinueShoppingButton().isProductsListPresent());

    }
    @Test(description = "Add product from Product Details Page")
    @MethodOwner(owner = "Alexis")
    public void addToCartFromProductDetailsPageTest(){
        var productsListPage = loginPageBase.loginWithStandardCredentials();
        ProductDetailPageBase sauceLabsProductsDetailsPage = productsListPage.clickOnFirstElement();
        sauceLabsProductsDetailsPage.clickAddToCartBtn();
        Assert.assertTrue(sauceLabsProductsDetailsPage.validateNumberOfElementsInCartIconIsPresent("1"));
    }
    @Test(description = "Remove product from the cart")
    @MethodOwner(owner = "Alexis")
    public void removeProductfromTheCartTest(){
        var productsListPage = loginPageBase.loginWithStandardCredentials();
        productsListPage.addProductToCart("1");
        CartPageBase sauceLabsCartPage = productsListPage.clickCartButton();
        Assert.assertTrue(sauceLabsCartPage.isYourCartTitleDisplayed());
        sauceLabsCartPage.clickRemoveButton();
        Assert.assertTrue(sauceLabsCartPage.isYourCartTitleDisplayed());

    }
    @Test(description = "Add the 4th product from the list to the cart and click on continue shopping")
    @MethodOwner(owner = "Alexis")
    public void addFourthProductToTheCartTest(){
        var productsListPage = loginPageBase.loginWithStandardCredentials();
        ProductDetailPageBase productDetailPageBase = productsListPage.clickProductByIndex("4");
        productDetailPageBase.clickAddToCartBtn();
        Assert.assertTrue(productDetailPageBase.validateNumberOfElementsInCartIconIsPresent("1"));
        CartPageBase cartPageBase = productDetailPageBase.clickOnCartBtn();
        Assert.assertTrue(cartPageBase.clickContinueShoppingButton().isProductsListPresent());
    }
    @Test(description = "Add multiple items to the cart")
    @MethodOwner(owner = "Alexis")
    public void addMultipleItemsToCartTest() throws InterruptedException {
        var productsListPageBase = loginPageBase.loginWithStandardCredentials();
        productsListPageBase.addProductsToCartByTitle(Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light"));
        var cartPage = productsListPageBase.clickCartButton();
        Assert.assertTrue(cartPage.isYourCartTitleDisplayed());
    }
}
