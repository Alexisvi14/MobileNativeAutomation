package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.common.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CompletePurchaseTests implements IAbstractTest {

    LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
    @Test(description = "add product to the cart and complete the purchase")
    @MethodOwner(owner = "Alexis")
    public void completePurchaseTest(){
        ProductsListPageBase sauceLabsHomePage = loginPageBase.loginWithStandardCredentials();
        sauceLabsHomePage.addProductToCart("1");
        CartPageBase sauceLabsCartPage = sauceLabsHomePage.clickCartButton();
        CheckoutPageBase sauceLabsCheckoutPage = sauceLabsCartPage.clickCheckoutButton();
        sauceLabsCheckoutPage.completeCredentials("Micaela", "Villamayor", "3700");
        sauceLabsCheckoutPage.clickContinueBtn();
        sauceLabsCheckoutPage.clickFinishBtn();
        Assert.assertTrue(sauceLabsCheckoutPage.isThankYouForYourOrderTextPresent());
    }


}
