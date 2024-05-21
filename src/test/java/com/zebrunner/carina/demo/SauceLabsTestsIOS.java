package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.common.*;
import com.zebrunner.carina.demo.utils.MobileContextUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceLabsTestsIOS implements IAbstractTest {
    @Test(description = "Login with Standard credentials")
    @MethodOwner(owner = "Alexis")
    public void loginWithStandardCredentialsTest() throws InterruptedException {
        LoginPageBase sauceLabsLoginPage = initPage(getDriver(), LoginPageBase.class);
        //change context
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        sauceLabsLoginPage.clickStandardUser();
        var homePage = sauceLabsLoginPage.clickLoginButton();
        Thread.sleep(3000);
    }

    @Test(description = "Change products view and select first item")
    @MethodOwner(owner = "Alexis")
    public void changeProductsViewTest() throws InterruptedException {
        LoginPageBase sauceLabsLoginPage = initPage(getDriver(), LoginPageBase.class);
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        HomePageBase sauceLabsHomePage = sauceLabsLoginPage.loginWithStandardCredentials();
        sauceLabsHomePage.clickChangeViewButton();
        ProductDetailPageBase sauceLabsDetailsPage = sauceLabsHomePage.clickProductByIndex("1");
        Assert.assertTrue(sauceLabsDetailsPage.isTitlePresent());
//        Assert.assertTrue();
    }
    @Test(description = "Add first product to the cart")
    @MethodOwner(owner = "Alexis")
    public void addElementToCartTest(){
        LoginPageBase sauceLabsLoginPage = initPage(getDriver(), LoginPageBase.class);
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        HomePageBase sauceLabsHomePage = sauceLabsLoginPage.loginWithStandardCredentials();
        sauceLabsHomePage.addProductToCart("1");
        CartPageBase sauceLabsCartPage = sauceLabsHomePage.clickCartButton();
        Assert.assertTrue(sauceLabsCartPage.isDescriptionDisplayed());
        sauceLabsCartPage.clickContinueShoppingButton();
    }
    @Test(description = "add product to the cart and complete the purchase")
    @MethodOwner(owner = "Alexis")
    public void completePurchaseTest(){
        LoginPageBase sauceLabsLoginPage = initPage(getDriver(), LoginPageBase.class);
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        HomePageBase sauceLabsHomePage = sauceLabsLoginPage.loginWithStandardCredentials();
        sauceLabsHomePage.addProductToCart("1");
        CartPageBase sauceLabsCartPage = sauceLabsHomePage.clickCartButton();
        CheckoutPageBase sauceLabsCheckoutPage = sauceLabsCartPage.clickCheckoutButton();
        sauceLabsCheckoutPage.completeCredentials("Micaela", "Villamayor", "3700");
        sauceLabsCheckoutPage.clickContinueBtn();
        sauceLabsCheckoutPage.clickFinishBtn();
    }
}
