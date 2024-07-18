package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.common.*;
import org.testng.annotations.Test;


public class CompletePurchaseTests implements IAbstractTest {


    @Test(description = "add product to the cart and complete the purchase", dependsOnMethods = "loginWithStandardCredentialsTest")
    @MethodOwner(owner = "Alexis")
    public void completePurchaseTest(){
        LoginPageBase sauceLabsLoginPage = initPage(getDriver(), LoginPageBase.class);
        HomePageBase sauceLabsHomePage = sauceLabsLoginPage.loginWithStandardCredentials();
        sauceLabsHomePage.addProductToCart("1");
        CartPageBase sauceLabsCartPage = sauceLabsHomePage.clickCartButton();
        CheckoutPageBase sauceLabsCheckoutPage = sauceLabsCartPage.clickCheckoutButton();
        sauceLabsCheckoutPage.completeCredentials("Micaela", "Villamayor", "3700");
        sauceLabsCheckoutPage.clickContinueBtn();
        sauceLabsCheckoutPage.clickFinishBtn();
    }


}
